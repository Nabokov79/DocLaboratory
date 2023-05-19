package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.section.NewPatternSectionSevenDto;
import ru.nabokov.patternservice.dto.section.PatternSectionSevenDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionSevenDto;
import ru.nabokov.patternservice.service.PatternSectionSevenService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/pattern/sections/seven",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон седьмого раздела отчета",
        description="API для работы с данными шаблона седьмого раздела отчета")
public class PatternSectionSevenController {

    private final PatternSectionSevenService service;

    @Operation(summary = "Добавление данных нового шаблона")
    @PostMapping
    public ResponseEntity<PatternSectionSevenDto> save(
            @RequestBody @Validated @Parameter(description = "Данные раздела") NewPatternSectionSevenDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона")
    @PatchMapping
    public ResponseEntity<PatternSectionSevenDto> update(
            @RequestBody @Validated @Parameter(description = "Данные раздела") UpdatePatternSectionSevenDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }

    @Operation(summary = "Получение шаблона")
    @GetMapping("/{patId}")
    public ResponseEntity<PatternSectionSevenDto> get(@PathVariable @NotNull @Positive Long patId) {
        return ResponseEntity.ok().body(service.get(patId));
    }
}
