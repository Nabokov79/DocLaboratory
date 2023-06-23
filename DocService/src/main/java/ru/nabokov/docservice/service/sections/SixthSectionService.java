package ru.nabokov.docservice.service.sections;

import ru.nabokov.docservice.dto.client.data_service.ObjectDataDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.PatternSectionSixDto;
import ru.nabokov.docservice.dto.sixthSection.NewSubheadingsSixDto;
import ru.nabokov.docservice.model.sixthSection.SixthSection;

import java.util.List;

public interface SixthSectionService {

    SixthSection save(ObjectDataDto objectData, PatternSectionSixDto patternSectionSix, List<NewSubheadingsSixDto> subheadingsSixDto);

}
