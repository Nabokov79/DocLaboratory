package ru.nabokov.passportservice.service.passport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.repair.UpdateRepairDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.RepairMapper;
import ru.nabokov.passportservice.model.passport.Repair;
import ru.nabokov.passportservice.repository.RepairRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repository;
    private final RepairMapper mapper;

    @Override
    public List<Repair> save(List<NewRepairDto> repairsDto) {
        return repository.saveAll(mapper.mapToNewRepairs(repairsDto));
    }

    @Override
    public List<Repair> update(List<UpdateRepairDto> repairsDto) {
        validateIds(repairsDto.stream().map(UpdateRepairDto::getId).toList());
        return repository.saveAll(mapper.mapToUpdateRepairs(repairsDto));
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Repair> repairs = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Repair::getId, d -> d));
        if (repairs.size() != ids.size() || repairs.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(repairs.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("repairs with ids= %s not found", ids));
        }
    }
}
