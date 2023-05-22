package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.documentation.DocumentationDto;
import ru.nabokov.dataservice.dto.documentation.NewDocumentationDto;
import ru.nabokov.dataservice.dto.documentation.UpdateDocumentationDto;
import java.util.List;

public interface DocumentationService {

    List<DocumentationDto> save(List<NewDocumentationDto> documentationsDto);

    List<DocumentationDto> update(List<UpdateDocumentationDto> documentationsDto);

    List<DocumentationDto> getAll();

    String delete(Long id);
}
