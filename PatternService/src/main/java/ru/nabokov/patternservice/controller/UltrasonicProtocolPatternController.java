package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.PipelineProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.TankProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.mapper.UltrasonicProtocolPatternMapper;
import ru.nabokov.patternservice.service.UltrasonicProtocolPatternService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
    private final UltrasonicProtocolPatternMapper mapper;

    @Operation(summary = "Добавление данных нового шаблона протокола")
    @PostMapping("/tank")
    public ResponseEntity<TankProtocolPatternDto> saveTankProtocol(
               @RequestBody @Validated @Parameter(description = "Данные протокола") NewProtocolPatternDto protocolDto) {
        return ResponseEntity.ok().body(mapper.mapToTankProtocolPatternDto(service.save(protocolDto)));
    }

    @Operation(summary = "Изменение данных шаблона протокола")
    @PatchMapping("/tank")
    public ResponseEntity<TankProtocolPatternDto> updateTankProtocol(
            @RequestBody @Validated @Parameter(description = "Данные протокола") UpdateProtocolPatternDto protocolDto) {
        return ResponseEntity.ok().body(mapper.mapToTankProtocolPatternDto(service.update(protocolDto)));
    }

    @Operation(summary = "Получение шаблона протокола")
    @GetMapping("/{id}/tank")
    public ResponseEntity<TankProtocolPatternDto> getTankProtocol(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok().body(mapper.mapToTankProtocolPatternDto(service.get(id)));
    }

    @Operation(summary = "Добавление данных нового шаблона протокола")
    @PostMapping("/pipeline")
    public ResponseEntity<PipelineProtocolPatternDto> savePipelineProtocol(
               @RequestBody @Validated @Parameter(description = "Данные протокола") NewProtocolPatternDto protocolDto) {
        return ResponseEntity.ok().body(mapper.mapToPipelineProtocolPatternDto(service.save(protocolDto)));
    }

    @Operation(summary = "Изменение данных шаблона протокола")
    @PatchMapping("/pipeline")
    public ResponseEntity<PipelineProtocolPatternDto> updatePipelineProtocol(
            @RequestBody @Validated @Parameter(description = "Данные протокола") UpdateProtocolPatternDto protocolDto) {
        return ResponseEntity.ok().body(mapper.mapToPipelineProtocolPatternDto(service.update(protocolDto)));
    }

    @Operation(summary = "Получение шаблона протокола")
    @GetMapping("/{id}/pipeline")
    public ResponseEntity<PipelineProtocolPatternDto> getPipelineProtocol(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok().body(mapper.mapToPipelineProtocolPatternDto(service.get(id)));
    }
}
