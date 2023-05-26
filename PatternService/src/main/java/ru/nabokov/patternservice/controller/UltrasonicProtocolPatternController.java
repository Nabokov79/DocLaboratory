package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.service.protocol.UltrasonicProtocolPatternService;

@RestController
@RequestMapping(
        value = "/pattern/sections/four/protocol/ultrasonic",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон протокола ультразвуковой толщинометрии",
        description="API для работы с данными протокола ультразвуковой толщинометрии")
public class UltrasonicProtocolPatternController {

    private final UltrasonicProtocolPatternService service;

    @Operation(summary = "Добавление данных нового шаблона протокола")
    @PostMapping
    public ResponseEntity<ReportPatternDto> save(
               @RequestBody @Validated @Parameter(description = "Данные протокола") NewProtocolPatternDto protocolDto) {
        return ResponseEntity.ok().body(service.save(protocolDto));
    }

    @Operation(summary = "Изменение данных шаблона протокола")
    @PatchMapping
    public ResponseEntity<ReportPatternDto> update(
            @RequestBody @Validated @Parameter(description = "Данные протокола") UpdateProtocolPatternDto protocolDto) {
        return ResponseEntity.ok().body(service.update(protocolDto));
    }
}
