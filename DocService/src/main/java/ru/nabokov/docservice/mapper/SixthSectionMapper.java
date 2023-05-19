package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.docservice.dto.sixthSection.NewSixthSectionDto;
import ru.nabokov.docservice.dto.sixthSection.SixthSectionDto;
import ru.nabokov.docservice.dto.sixthSection.UpdateSixthSectionDto;
import ru.nabokov.docservice.model.sixthSection.SixthSection;

@Mapper(componentModel = "spring")
public interface SixthSectionMapper {

    SixthSection mapToNewSixthSection(NewSixthSectionDto sectionDto);

    SixthSection mapToUpdateSixthSection(UpdateSixthSectionDto sectionDto);

    SixthSectionDto mapToSixthSectionDto(SixthSection section);
}
