package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.passport_service.CharacteristicDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.HeaderDto;
import ru.nabokov.docservice.model.SecondSection;
import ru.nabokov.docservice.repository.SecondSectionRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SecondSectionServiceImpl implements  SecondSectionService {

    private final SecondSectionRepository repository;
    private final StringBuilderServiceImpl stringBuilder;
    private final SecondSectionDataService secondSectionDataService;

    @Override
    public SecondSection save(HeaderDto header, List<CharacteristicDto> characteristics) {
        SecondSection section = new SecondSection();
        section.setHeading(stringBuilder.toStringHeader(header));
        repository.save(section);
        section.setSecondSectionData(secondSectionDataService.save(section, characteristics));
        return section;
    }
}
