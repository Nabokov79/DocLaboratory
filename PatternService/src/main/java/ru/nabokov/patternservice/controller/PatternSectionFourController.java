package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.section.NewPatternSectionFourDto;
import ru.nabokov.patternservice.dto.section.PatternSectionFourDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionFourDto;
import ru.nabokov.patternservice.service.PatternSectionFourService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/pattern/sections/four",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон четвертого раздела отчета",
        description="API для работы с данными шаблона четвертого раздела отчета")
public class PatternSectionFourController {

    private final PatternSectionFourService service;

    @Operation(summary = "Добавление данных нового шаблона отчета")
    @PostMapping
    public ResponseEntity<PatternSectionFourDto> save(
            @RequestBody @Validated @Parameter(description = "Данные раздела") NewPatternSectionFourDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона")
    @PatchMapping
    public ResponseEntity<PatternSectionFourDto> update(
            @RequestBody @Validated @Parameter(description = "Данные раздела") UpdatePatternSectionFourDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }

    @Operation(summary = "Получение шаблона отчета")
    @GetMapping("/{patId}")
    public ResponseEntity<PatternSectionFourDto> get(@PathVariable @NotNull @Positive Long patId) {
        return ResponseEntity.ok().body(service.get(patId));
    }
}
