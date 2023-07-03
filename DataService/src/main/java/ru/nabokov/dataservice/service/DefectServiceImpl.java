package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.defect.NewDefectDto;
import ru.nabokov.dataservice.dto.defect.UpdateDefectDto;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.DefectMapper;
import ru.nabokov.dataservice.model.Defect;
import ru.nabokov.dataservice.repository.DefectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefectServiceImpl implements DefectService {

    private final DefectRepository repository;
    private final DefectMapper mapper;

    @Override
    public List<Defect> save(List<NewDefectDto> defectsDto) {
        return repository.saveAll(mapper.mapToNewDefects(defectsDto));
    }

    @Override
    public List<Defect> update(List<UpdateDefectDto> defectsDto) {
        validateIds(defectsDto.stream().map(UpdateDefectDto::getId).toList());
        return repository.saveAll(mapper.mapToUpdateDefects(defectsDto));
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Defect> defects = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Defect::getId, d -> d));
        if (defects.size() != ids.size() || defects.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(defects.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("defects with ids= %s not found", ids));
        }
    }
}
