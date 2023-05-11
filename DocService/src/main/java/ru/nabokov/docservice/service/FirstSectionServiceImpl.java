package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.ReportDataBuilder;
import ru.nabokov.docservice.model.FirstSection;
import ru.nabokov.docservice.repository.FirstSectionRepository;

@Service
@RequiredArgsConstructor
public class FirstSectionServiceImpl implements FirstSectionService {

    private final FirstSectionRepository repository;
    private final DataFirstSectionService dataFirstSectionService;

    @Override
    public FirstSection save(ReportDataBuilder builder) {
        FirstSection section = new FirstSection();
        section.setHeading(String.join(". ", String.valueOf(builder.getPattern().getHeader().getNumber()),
                builder.getPattern().getHeader().getHeading()));
        dataFirstSectionService.save(repository.save(section), builder);
        return section;
    }
}
