package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.NewPatternSectionTwoDto;
import ru.nabokov.patternservice.dto.PatternSectionTwoDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionTwoDto;
import ru.nabokov.patternservice.service.PatternSectionTwoService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/pattern/sections/two",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон второго раздела отчета",
        description="API для работы с данными шаблона второго раздела отчета")
public class PatternSectionTwoController {

    private final PatternSectionTwoService service;

    @Operation(summary = "Добавление данных нового шаблона раздела № 2")
    @PostMapping
    public ResponseEntity<PatternSectionTwoDto> save(
            @RequestBody @Validated
            @Parameter(description = "Данные шаблона раздела № 2") NewPatternSectionTwoDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона раздела № 2")
    @PatchMapping
    public ResponseEntity<PatternSectionTwoDto> update(
            @RequestBody @Validated
            @Parameter(description = "Данные шаблона раздела № 2") UpdatePatternSectionTwoDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }

    @Operation(summary = "Получение данных шаблона раздела № 2")
    @GetMapping("/{patId}")
    public ResponseEntity<PatternSectionTwoDto> get(@PathVariable @NotNull @Positive Long patId) {
        return ResponseEntity.ok().body(service.get(patId));
    }
}
