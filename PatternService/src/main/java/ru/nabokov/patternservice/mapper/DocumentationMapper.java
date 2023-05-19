package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.documentation.NewDocumentationDto;
import ru.nabokov.patternservice.dto.documentation.UpdateDocumentationDto;
import ru.nabokov.patternservice.model.Documentation;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentationMapper {

    List<Documentation> mapToNewDocumentations(List<NewDocumentationDto> documentations);

    List<Documentation> mapToUpdateDocumentations(List<UpdateDocumentationDto> documentations);
}
