package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.documentation.DocumentationDto;
import ru.nabokov.dataservice.dto.documentation.NewDocumentationDto;
import ru.nabokov.dataservice.dto.documentation.UpdateDocumentationDto;
import ru.nabokov.dataservice.model.Documentation;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentationMapper {

    List<Documentation> mapToNewDocumentation(List<NewDocumentationDto> documentationsDto);

    List<DocumentationDto> mapToDocumentationDto(List<Documentation> documentations);

    List<Documentation> mapToUpdateDocumentation(List<UpdateDocumentationDto> documentationsDto);
}
