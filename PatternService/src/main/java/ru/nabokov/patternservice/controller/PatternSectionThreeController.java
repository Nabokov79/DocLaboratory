package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.section.NewPatternSectionThreeDto;
import ru.nabokov.patternservice.dto.section.PatternSectionThreeDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionThreeDto;
import ru.nabokov.patternservice.service.PatternSectionThreeService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/pattern/sections/three",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон третьего раздела отчета",
        description="API для работы с данными шаблона третьего раздела отчета")
public class PatternSectionThreeController {

    private final PatternSectionThreeService service;

    @Operation(summary = "Добавление данных нового шаблона раздела № 3")
    @PostMapping
    public ResponseEntity<PatternSectionThreeDto> save(
            @RequestBody @Validated
            @Parameter(description = "Данные шаблона раздела № 3") NewPatternSectionThreeDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона раздела № 3")
    @PatchMapping
    public ResponseEntity<PatternSectionThreeDto> update(
            @RequestBody @Validated
            @Parameter(description = "Данные шаблона раздела № 3") UpdatePatternSectionThreeDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }

    @Operation(summary = "Получение данных шаблона раздела № 3")
    @GetMapping("/{patId}")
    public ResponseEntity<PatternSectionThreeDto> get(@PathVariable @NotNull @Positive Long patId) {
        return ResponseEntity.ok().body(service.get(patId));
    }
}
