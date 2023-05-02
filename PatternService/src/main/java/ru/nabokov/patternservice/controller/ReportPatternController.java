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
        value = "/pattern/report",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон отчета",
        description="API для работы с данными шаблона отчета")
public class ReportPatternController {

    private final ReportPatternService service;

    @Operation(summary = "Получение шаблона отчета")
    @GetMapping("/{patId}")
    public ResponseEntity<ReportPatternDto> get(@PathVariable @NotNull @Positive Long patId) {
        return ResponseEntity.ok().body(service.get(patId));
    }

    @Operation(summary = "Получение шаблонов титульных листов всех отчетов")
    @GetMapping("/title")
    public ResponseEntity<List<ShortReportPatternDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление шаблона отчета")
    @DeleteMapping("/{patId}")
    public ResponseEntity<String> delete(@PathVariable @NotNull @Positive Long patId) {
        service.delete(patId);
        return ResponseEntity.ok("Шаблон отчета удален");
    }
}
