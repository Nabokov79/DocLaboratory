package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.NewPatternSectionOneDto;
import ru.nabokov.patternservice.dto.PatternSectionOneDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionOneDto;
import ru.nabokov.patternservice.service.PatternSectionOneService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/pattern/sections/one",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон первого раздела отчета",
        description="API для работы с данными шаблона первого раздела отчета")
public class PatternSectionOneController {

    private final PatternSectionOneService service;

    @Operation(summary = "Добавление данных нового шаблона отчета")
    @PostMapping
    public ResponseEntity<PatternSectionOneDto> save(
            @RequestBody @Validated @Parameter(description = "Данные раздела") NewPatternSectionOneDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона")
    @PatchMapping
    public ResponseEntity<PatternSectionOneDto> update(
            @RequestBody @Validated @Parameter(description = "Данные раздела") UpdatePatternSectionOneDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }

    @Operation(summary = "Получение шаблона отчета")
    @GetMapping("/{patId}")
    public ResponseEntity<PatternSectionOneDto> get(@PathVariable @NotNull @Positive Long patId) {
        return ResponseEntity.ok().body(service.get(patId));
    }
}
