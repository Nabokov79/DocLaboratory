package ru.nabokov.docservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.docservice.dto.NewReportDto;
import ru.nabokov.docservice.dto.ReportDto;
import ru.nabokov.docservice.service.ReportService;

@RestController
@RequestMapping(
        value = "/report",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Отчет",
     description="API для работы с данными отчета")
public class ReportController {

    private final ReportService service;

    @Operation(summary = "Добавление нового отчета")
    @PostMapping
    public ResponseEntity<ReportDto> save(@RequestBody NewReportDto reportDto) {
        return ResponseEntity.ok().body(service.save(reportDto));
    }

    @Operation(summary = "Изменение отчета/протокола")
    @PatchMapping
    public void update() {

    }

    @Operation(summary = "Получение отчета/протокола")
    @GetMapping("/{id}")
    public void get() {

    }
}
