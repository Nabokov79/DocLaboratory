package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.documentation.NewDocumentationDto;
import ru.nabokov.patternservice.dto.documentation.UpdateDocumentationDto;
import ru.nabokov.patternservice.model.Subheading;
import java.util.List;

public interface DocumentationService {

    void save(Subheading subheading, List<NewDocumentationDto> documentationsDto);

    void update(Subheading subheading, List<UpdateDocumentationDto> documentationsDto);
}
