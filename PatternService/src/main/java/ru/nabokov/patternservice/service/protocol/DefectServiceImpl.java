package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.defect.NewDefectDto;
import ru.nabokov.patternservice.dto.defect.UpdateDefectDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.DefectMapper;
import ru.nabokov.patternservice.model.Defect;
import ru.nabokov.patternservice.model.Element;
import ru.nabokov.patternservice.repository.DefectRepository;
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
    public void save(Element element, List<NewDefectDto> defectsDto) {
        List<Defect> defects = mapper.mapToNewDefects(defectsDto);
        repository.saveAll(setElement(element, defects));
    }

    @Override
    public void update(Element element, List<UpdateDefectDto> defectsDto) {
        validateIds(defectsDto.stream().map(UpdateDefectDto::getId).toList());
        List<Defect> defects = mapper.mapToUpdateDefects(defectsDto);
        repository.saveAll(setElement(element, defects));
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

    private List<Defect> setElement(Element element,  List<Defect> defects) {
        for (Defect defect : defects) {
            defect.setElement(element);
        }
        return defects;
    }
}
