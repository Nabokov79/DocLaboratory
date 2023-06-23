package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.ShortReportPatternDto;
import ru.nabokov.patternservice.service.ReportPatternService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(
        value = "/pattern/reports",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон отчета",
        description="API для работы с данными шаблона отчета")
public class ReportPatternController {

    private final ReportPatternService service;

    @Operation(summary = "Получить полные данные шаблона")
    @GetMapping("/{id}")
    public ResponseEntity<ReportPatternDto> get(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Operation(summary = "Получить краткие данные шаблононов")
    @GetMapping
    public ResponseEntity<List<ShortReportPatternDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}
