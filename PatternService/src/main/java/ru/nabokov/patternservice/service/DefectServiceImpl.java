package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.Defect;
import ru.nabokov.patternservice.repository.DefectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefectServiceImpl implements DefectService {

    private final DefectRepository repository;

    @Override
    public void save(List<Defect> defects) {
        validate(defects);
        repository.saveAll(defects);
    }

    @Override
    public void update(List<Defect> defects) {
        validateIds(defects.stream().map(Defect::getId).toList());
        repository.saveAll(defects);
    }

    private void validate(List<Defect> defects) {
        for (Defect defect : defects) {
            if (defect.getName() == null) {
                throw new BadRequestException("defect name cannot be blank");
            }
        }
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
