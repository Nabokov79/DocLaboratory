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
import ru.nabokov.patternservice.service.section.PatternSectionThreeService;

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
    public ResponseEntity<ReportPatternDto> save(
            @RequestBody @Validated
            @Parameter(description = "Данные шаблона раздела № 3") NewPatternSectionDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона раздела № 3")
    @PatchMapping
    public ResponseEntity<ReportPatternDto> update(
            @RequestBody @Validated
            @Parameter(description = "Данные шаблона раздела № 3") UpdatePatternSectionDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }
}
