package ru.nabokov.docservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.docservice.dto.NewSeventhSectionDto;
import ru.nabokov.docservice.dto.SeventhSectionDto;
import ru.nabokov.docservice.service.SeventhSectionService;

@RestController
@RequestMapping(
        value = "/report/seventh",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Раздел № 7 отчета",
        description="API для работы с данными раздела № 7 отчета")
public class SeventhSectionController {

    private final SeventhSectionService service;

    @Operation(summary = "Добавление нового раздела отчета")
    @PostMapping
    public ResponseEntity<SeventhSectionDto> save(
            @RequestBody @Validated @Parameter(description = "Данные раздела") NewSeventhSectionDto sectionDto) {
        return ResponseEntity.ok().body(service.save(sectionDto));
    }
}
