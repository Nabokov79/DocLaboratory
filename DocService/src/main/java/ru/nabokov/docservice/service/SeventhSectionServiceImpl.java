package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.NewSeventhSectionDto;
import ru.nabokov.docservice.dto.SeventhSectionDto;
import ru.nabokov.docservice.mapper.SeventhSectionMapper;
import ru.nabokov.docservice.model.SeventhSection;
import ru.nabokov.docservice.repository.SeventhSectionRepository;

@Service
@RequiredArgsConstructor
public class SeventhSectionServiceImpl implements SeventhSectionService {

    private final SeventhSectionRepository repository;
    private final SeventhSectionMapper mapper;
    private final StringBuilderService stringBuilder;
    private final DrawingService drawingService;

    @Override
    public SeventhSectionDto save(NewSeventhSectionDto sectionDto) {
        SeventhSection section = new SeventhSection();
        section.setHeading(stringBuilder.toStringHeader(mapper.mapToHeaderDto(sectionDto.getSectionHeaderDto())));
        section.setDrawings(drawingService.save(repository.save(section)
                                              , mapper.mapToDrawingDto(sectionDto.getDrawings())));
        return mapper.mapToSeventhSectionDto(section);
    }
}
