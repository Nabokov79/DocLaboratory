package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.patternservice.dto.protocol.GeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.NewGeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateGeodesyProtocolPatternDto;
import ru.nabokov.patternservice.service.GeodesyProtocolPatternService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/pattern/sections/four/protocol/geodesy",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон протокола геодезической съемки",
        description="API для работы с данными протокола геодезической съемки")
public class GeodesyProtocolPatternController {

    private final GeodesyProtocolPatternService service;

    @Operation(summary = "Добавление данных нового шаблона протокола")
    @PostMapping
    public ResponseEntity<GeodesyProtocolPatternDto> save(
            @RequestBody @Validated
            @Parameter(description = "Данные протокола") NewGeodesyProtocolPatternDto protocolDto) {
        return ResponseEntity.ok().body(service.save(protocolDto));
    }

    @Operation(summary = "Изменение данных шаблона протокола")
    @PatchMapping
    public ResponseEntity<GeodesyProtocolPatternDto> update(
            @RequestBody @Validated
            @Parameter(description = "Данные протокола") UpdateGeodesyProtocolPatternDto protocolDto) {
        return ResponseEntity.ok().body(service.update(protocolDto));
    }

    @Operation(summary = "Получение шаблона протокола")
    @GetMapping("/{id}")
    public ResponseEntity<GeodesyProtocolPatternDto> get(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }
}
