package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.conclusion.NewPatternConclusionDto;
import ru.nabokov.patternservice.dto.conclusion.UpdatePatternConclusionDto;
import ru.nabokov.patternservice.model.PatternConclusion;

@Mapper(componentModel = "spring")
public interface PatternConclusionMapper {


    PatternConclusion mapToNewPatternConclusion(NewPatternConclusionDto conclusionDto);

    PatternConclusion mapToUpdatePatternConclusion(UpdatePatternConclusionDto conclusionDto);
}
