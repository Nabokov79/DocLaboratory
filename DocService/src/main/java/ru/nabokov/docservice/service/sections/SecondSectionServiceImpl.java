package ru.nabokov.docservice.service.sections;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.passport_service.CharacteristicDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.PatternSectionTwoDto;
import ru.nabokov.docservice.model.SecondSection;
import ru.nabokov.docservice.repository.SecondSectionRepository;
import ru.nabokov.docservice.service.CharacteristicService;
import ru.nabokov.docservice.service.StringBuilderServiceImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecondSectionServiceImpl implements  SecondSectionService {

    private final SecondSectionRepository repository;
    private final StringBuilderServiceImpl stringBuilder;
    private final CharacteristicService characteristicService;

    @Override
    public SecondSection save(PatternSectionTwoDto pattern, List<CharacteristicDto> characteristics) {
        SecondSection section = new SecondSection();
        section.setHeading(stringBuilder.toStringHeader(pattern.getHeader()));
        repository.save(section);
        section.setCharacteristics(characteristicService.save(section, pattern.getSubheadings() , characteristics));
        return section;
    }
}
