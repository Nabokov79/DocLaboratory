package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.passport.CharacteristicDto;
import ru.nabokov.docservice.dto.pattern.HeaderDto;
import ru.nabokov.docservice.model.SecondSection;
import ru.nabokov.docservice.repository.SecondSectionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecondSectionServiceImpl implements  SecondSectionService {

    private final SecondSectionRepository repository;
    private final StringBuilderService stringBuilder;
    private final SecondSectionDataService secondSectionDataService;

    @Override
    public SecondSection save(HeaderDto header,  List<CharacteristicDto> characteristics) {
        SecondSection section = new SecondSection();
        section.setHeading(stringBuilder.toStringHeader(header));
        repository.save(section);
        section.setSecondSectionData(secondSectionDataService.save(section, characteristics));
        return section;
    }
}
