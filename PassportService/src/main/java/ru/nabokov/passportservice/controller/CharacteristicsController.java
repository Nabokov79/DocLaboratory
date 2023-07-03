package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.сharacteristic.CharacteristicDto;
import ru.nabokov.passportservice.dto.сharacteristic.NewCharacteristicDto;
import ru.nabokov.passportservice.dto.сharacteristic.UpdateCharacteristicDto;
import ru.nabokov.passportservice.service.passport.CharacteristicService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/passport/characteristics",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Характеристики объекта",
        description="API для работы с данными характеристиками объекта")
public class CharacteristicsController {

    private final CharacteristicService service;

    @Operation(summary = "Добавление новых данных паспорта")
    @PostMapping
    public ResponseEntity<List<CharacteristicDto>> save(
                @RequestBody @Parameter(description = "Характеристики") List<NewCharacteristicDto> characteristicsDto) {
        return ResponseEntity.ok().body(service.save(characteristicsDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<List<CharacteristicDto>> update(
              @RequestBody @Parameter(description = "Характеристики") List<UpdateCharacteristicDto> characteristicDto) {
        return ResponseEntity.ok().body(service.update(characteristicDto));
    }
}
