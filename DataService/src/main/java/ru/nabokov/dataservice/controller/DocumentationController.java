package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.documentation.DocumentationDto;
import ru.nabokov.dataservice.dto.documentation.NewDocumentationDto;
import ru.nabokov.dataservice.dto.documentation.UpdateDocumentationDto;
import ru.nabokov.dataservice.service.DocumentationService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/data/documentations",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Нормативная документация",
     description="API для работы с данными нормативной документации")
public class DocumentationController {

    private final DocumentationService service;

    @Operation(summary = "Добавление нового нормативного документа")
    @PostMapping
    public ResponseEntity<List<DocumentationDto>> save(
                   @RequestBody @Parameter(description = "Нормативный документ") List<NewDocumentationDto> documentationsDto) {
        return ResponseEntity.ok().body(service.save(documentationsDto));
    }

    @Operation(summary = "Изменение данных нормативного документа")
    @PatchMapping
    public ResponseEntity<List<DocumentationDto>> update(
                @RequestBody @Parameter(description = "Нормативный документ") List<UpdateDocumentationDto> documentationsDto) {
        return ResponseEntity.ok().body(service.update(documentationsDto));
    }

    @Operation(summary = "Получение данных нормативного документа")
    @GetMapping
    public ResponseEntity<List<DocumentationDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данных нормативного документа")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok(service.delete(id) + " - удален.");
    }
}
