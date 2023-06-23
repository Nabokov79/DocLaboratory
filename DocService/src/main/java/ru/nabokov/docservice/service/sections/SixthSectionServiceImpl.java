package ru.nabokov.docservice.service.sections;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.data_service.ObjectDataDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.PatternSectionSixDto;
import ru.nabokov.docservice.dto.sixthSection.NewSubheadingsSixDto;
import ru.nabokov.docservice.mapper.SixthSectionMapper;
import ru.nabokov.docservice.model.sixthSection.SixthSection;
import ru.nabokov.docservice.repository.SixthSectionRepository;
import ru.nabokov.docservice.service.SubheadingsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SixthSectionServiceImpl implements SixthSectionService {

    private final SixthSectionRepository repository;
    private final SixthSectionMapper mapper;
    private final SubheadingsService subheadingsService;

    @Override
    public SixthSection save(ObjectDataDto objectData,PatternSectionSixDto patternSectionSix, List<NewSubheadingsSixDto> subheadingsSixDto) {
        SixthSection section = mapper.mapToNewSixthSection(patternSectionSix);
        subheadingsService.save(objectData
                              , repository.save(section)
                              , patternSectionSix.getSubheadings()
                              , subheadingsSixDto);
        return section;
    }
}
