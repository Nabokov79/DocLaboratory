package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.NewDrawingDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.HeaderDto;
import ru.nabokov.docservice.mapper.SeventhSectionMapper;
import ru.nabokov.docservice.model.seventhSection.SeventhSection;
import ru.nabokov.docservice.repository.SeventhSectionRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeventhSectionServiceImpl implements SeventhSectionService {

    private final SeventhSectionRepository repository;
    private final SeventhSectionMapper mapper;
    private final StringBuilderServiceImpl stringBuilder;
    private final DrawingService drawingService;

    @Override
    public SeventhSection save(HeaderDto headerDto, List<NewDrawingDto> drawings) {
        SeventhSection section = new SeventhSection();
        section.setHeading(stringBuilder.toStringHeader(headerDto));
        section.setDrawings(drawingService.save(repository.save(section)
                                              , mapper.mapToDrawingDto(drawings)));
        return section;
    }
}
