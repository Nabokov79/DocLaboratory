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
import ru.nabokov.patternservice.service.section.PatternSectionSevenService;

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
    public ResponseEntity<ReportPatternDto> save(
            @RequestBody @Validated @Parameter(description = "Данные раздела") NewPatternSectionDto patternDto) {
        return ResponseEntity.ok().body(service.save(patternDto));
    }

    @Operation(summary = "Изменение данных шаблона")
    @PatchMapping
    public ResponseEntity<ReportPatternDto> update(
            @RequestBody @Validated @Parameter(description = "Данные раздела") UpdatePatternSectionDto patternDto) {
        return ResponseEntity.ok().body(service.update(patternDto));
    }
}
