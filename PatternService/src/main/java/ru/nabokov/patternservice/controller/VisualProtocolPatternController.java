package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.dto.VisualProtocolPatternDto;
import ru.nabokov.patternservice.service.VisualProtocolPatternService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/pattern/sections/four/protocol/visual",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон протокола визуального и измерительного контроля",
        description="API для работы с данными протокола визуального и измерительного контроля")
public class VisualProtocolPatternController {

    private final VisualProtocolPatternService service;

    @Operation(summary = "Добавление данных нового шаблона протокола")
    @PostMapping
    public ResponseEntity<VisualProtocolPatternDto> save(
              @RequestBody @Validated @Parameter(description = "Данные протокола") NewProtocolPatternDto protocolDto) {
        return ResponseEntity.ok().body(service.save(protocolDto));
    }

    @Operation(summary = "Изменение данных шаблона протокола")
    @PatchMapping
    public ResponseEntity<VisualProtocolPatternDto> update(
            @RequestBody @Validated @Parameter(description = "Данные протокола") UpdateProtocolPatternDto protocolDto) {
        return ResponseEntity.ok().body(service.update(protocolDto));
    }

    @Operation(summary = "Получение шаблона протокола")
    @GetMapping("/{proId}")
    public ResponseEntity<VisualProtocolPatternDto> get(@PathVariable @NotNull @Positive Long proId) {
        return ResponseEntity.ok().body(service.get(proId));
    }
}
