package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.section.NewPatternSectionFiveDto;
import ru.nabokov.patternservice.dto.section.PatternSectionFiveDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionFiveDto;
import ru.nabokov.patternservice.service.PatternSectionFiveService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/pattern/sections/five",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон пятого раздела отчета",
        description="API для работы с данными шаблона пятого раздела отчета")
public class PatternSectionFiveController {

    private final PatternSectionFiveService service;

    @Operation(summary = "Добавление данных нового шаблона отчета")
    @PostMapping
    public ResponseEntity<PatternSectionFiveDto> save(
            @RequestBody @Validated @Parameter(description = "Данные раздела") NewPatternSectionFiveDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона")
    @PatchMapping
    public ResponseEntity<PatternSectionFiveDto> update(
            @RequestBody @Validated @Parameter(description = "Данные раздела") UpdatePatternSectionFiveDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }

    @Operation(summary = "Получение шаблона отчета")
    @GetMapping("/{patId}")
    public ResponseEntity<PatternSectionFiveDto> get(@PathVariable @NotNull @Positive Long patId) {
        return ResponseEntity.ok().body(service.get(patId));
    }
}
