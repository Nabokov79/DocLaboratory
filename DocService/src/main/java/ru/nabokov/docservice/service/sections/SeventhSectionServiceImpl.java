package ru.nabokov.docservice.service.sections;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.pattern_servicce.DrawingDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.HeaderDto;
import ru.nabokov.docservice.model.seventhSection.SeventhSection;
import ru.nabokov.docservice.repository.SeventhSectionRepository;
import ru.nabokov.docservice.service.DrawingService;
import ru.nabokov.docservice.service.StringBuilderServiceImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeventhSectionServiceImpl implements SeventhSectionService {

    private final SeventhSectionRepository repository;
    private final StringBuilderServiceImpl stringBuilder;
    private final DrawingService drawingService;

    @Override
    public SeventhSection save(HeaderDto headerDto, List<DrawingDto> drawings) {
        SeventhSection section = new SeventhSection();
        section.setHeading(stringBuilder.toStringHeader(headerDto));
        section.setDrawings(drawingService.save(repository.save(section)
                                              , drawings));
        return section;
    }
}
