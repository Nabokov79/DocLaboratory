package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.docservice.dto.client.pattern_servicce.PatternSectionSixDto;
import ru.nabokov.docservice.model.sixthSection.SixthSection;

@Mapper(componentModel = "spring")
public interface SixthSectionMapper {

    SixthSection mapToNewSixthSection(PatternSectionSixDto pattern);
}
