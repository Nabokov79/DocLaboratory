package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.subheading.NewSubheadingDto;
import ru.nabokov.patternservice.dto.subheading.ShortSubheadingDto;
import ru.nabokov.patternservice.dto.subheading.UpdateSubheadingDto;
import ru.nabokov.patternservice.model.Subheading;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SubheadingMapper {

    List<Subheading> mapToNewSubheadings(List<NewSubheadingDto> subheadings);

    List<Subheading> mapToUpdateSubheadings(List<UpdateSubheadingDto> subheadings);

    List<ShortSubheadingDto> mapToShortSubheadingDto(List<Subheading> subheadings);
}
