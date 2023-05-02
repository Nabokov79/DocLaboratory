package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.NewPatternSectionSixDto;
import ru.nabokov.patternservice.dto.PatternSectionSixDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionSixDto;
import ru.nabokov.patternservice.service.PatternSectionSixService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/pattern/sections/six",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон шестого раздела отчета",
        description="API для работы с данными шаблона шестого раздела отчета")
public class PatternSectionSixController {

    private final PatternSectionSixService service;

    @Operation(summary = "Добавление данных нового шаблона")
    @PostMapping
    public ResponseEntity<PatternSectionSixDto> save(
            @RequestBody @Validated @Parameter(description = "Данные раздела") NewPatternSectionSixDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона")
    @PatchMapping
    public ResponseEntity<PatternSectionSixDto> update(
            @RequestBody @Validated @Parameter(description = "Данные раздела") UpdatePatternSectionSixDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }

    @Operation(summary = "Получение шаблона")
    @GetMapping("/{patId}")
    public ResponseEntity<PatternSectionSixDto> get(@PathVariable @NotNull @Positive Long patId) {
        return ResponseEntity.ok().body(service.get(patId));
    }
}
