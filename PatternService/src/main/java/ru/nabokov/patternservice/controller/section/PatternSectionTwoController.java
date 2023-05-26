package ru.nabokov.patternservice.controller.section;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.section.NewPatternSectionDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionDto;
import ru.nabokov.patternservice.service.section.PatternSectionTwoService;

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
    public ResponseEntity<ReportPatternDto> save(
            @RequestBody @Validated
            @Parameter(description = "Данные шаблона раздела № 2") NewPatternSectionDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона раздела № 2")
    @PatchMapping
    public ResponseEntity<ReportPatternDto> update(
            @RequestBody @Validated
            @Parameter(description = "Данные шаблона раздела № 2") UpdatePatternSectionDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }
}
