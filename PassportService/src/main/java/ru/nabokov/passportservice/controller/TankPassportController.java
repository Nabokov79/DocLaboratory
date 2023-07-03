package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.passport.*;
import ru.nabokov.passportservice.dto.passport.tank.NewTankPassportDto;
import ru.nabokov.passportservice.dto.passport.tank.TankPassportDto;
import ru.nabokov.passportservice.dto.passport.tank.UpdateTankPassportDto;
import ru.nabokov.passportservice.service.passport.TankPassportService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/passport",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Паспорт объекта обследования",
        description="API для работы с данными паспорта")
public class TankPassportController {

    private final TankPassportService service;

    @Operation(summary = "Добавление новых данных паспорта")
    @PostMapping
    public ResponseEntity<TankPassportDto> save(@RequestBody
                                            @Parameter(description = "Данные паспорта") NewTankPassportDto passportDto) {
        return ResponseEntity.ok().body(service.save(passportDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<TankPassportDto> update(@RequestBody
                                            @Parameter(description = "Данные паспорта") UpdateTankPassportDto passportDto) {
        return ResponseEntity.ok().body(service.update(passportDto));
    }

    @Operation(summary = "Получить паспорт бака")
    @GetMapping("/{id}")
    public ResponseEntity<TankPassportDto> get(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Operation(summary = "Получение данные паспортов")
    @GetMapping
    public ResponseEntity<List<ShortPassportDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление данные паспорта")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Значения удалены.");
    }
}
