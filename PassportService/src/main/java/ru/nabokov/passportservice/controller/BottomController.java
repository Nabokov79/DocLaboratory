package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.bottom.BottomDto;
import ru.nabokov.passportservice.dto.bottom.NewBottomDto;
import ru.nabokov.passportservice.dto.bottom.UpdateBottomDto;
import ru.nabokov.passportservice.service.passport.BottomService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/passport/bottom",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Днища бака, деаэратора, фильтра, крышка фильтра",
        description="API для работы с данными: днища бака, деаэратора, фильтра, крышка фильтра")
public class BottomController {

    private final BottomService service;

    @Operation(summary = "Добавление новых данных паспорта")
    @PostMapping
    public ResponseEntity<List<BottomDto>> save(
            @RequestBody @Parameter(description = "Данные днища") List<NewBottomDto> bottomsDto) {
        return ResponseEntity.ok().body(service.save(bottomsDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<List<BottomDto>> update(
            @RequestBody @Parameter(description = "Данные днища") List<UpdateBottomDto> bottomsDto) {
        return ResponseEntity.ok().body(service.update(bottomsDto));
    }

    @Operation(summary = "Получение данных днищ(а)")
    @GetMapping("/all")
    public ResponseEntity<List<BottomDto>> getAll(
            @RequestParam(required = false) @Parameter(description = "Название днища") String name) {
        return ResponseEntity.ok().body(service.getAll(name));
    }
}
