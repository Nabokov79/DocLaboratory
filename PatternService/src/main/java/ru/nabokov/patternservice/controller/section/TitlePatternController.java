package ru.nabokov.patternservice.controller.section;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.title.NewTitlePageDataDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.title.UpdateTitlePageDataDto;
import ru.nabokov.patternservice.service.section.TitlePatternService;

@RestController
@RequestMapping(
        value = "/pattern/report/title",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон отчета",
        description="API для работы с данными шаблона отчета")
public class TitlePatternController {

    private final TitlePatternService service;

    @Operation(summary = "Добавление данных нового шаблона отчета")
    @PostMapping
    public ResponseEntity<ReportPatternDto> save(
            @RequestBody @Validated
            @Parameter(description = "Текст по центру титульного листа") NewTitlePageDataDto titlePageDataDto) {
        return ResponseEntity.ok().body(service.save(titlePageDataDto));
    }

    @Operation(summary = "Изменение данных шаблона")
    @PatchMapping
    public ResponseEntity<ReportPatternDto> update(
            @RequestBody @Validated
            @Parameter(description = "Текст по центру титульного листа") UpdateTitlePageDataDto titlePatternDto) {
        return ResponseEntity.ok().body(service.update(titlePatternDto));
    }
}
