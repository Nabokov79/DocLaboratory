package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.standardSizePipeDto.NewStandardSizePipeDto;
import ru.nabokov.passportservice.dto.standardSizePipeDto.StandardSizePipeDto;
import ru.nabokov.passportservice.dto.standardSizePipeDto.UpdateStandardSizePipeDto;
import ru.nabokov.passportservice.service.StandardSizePipeService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/passport/standard_size_pipe",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Днища бака, деаэратора, фильтра, крышка фильтра",
        description="API для работы с данными: днища бака, деаэратора, фильтра, крышка фильтра")
public class StandardSizePipeController {

    private final StandardSizePipeService service;

    @Operation(summary = "Добавление новых данных паспорта")
    @PostMapping
    public ResponseEntity<List<StandardSizePipeDto>> save(
            @RequestBody @Parameter(description = "Данные днища") List<NewStandardSizePipeDto> standardSizePipeDto) {
        return ResponseEntity.ok().body(service.save(standardSizePipeDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<List<StandardSizePipeDto>> update(
            @RequestBody @Parameter(description = "Данные днища") List<UpdateStandardSizePipeDto> standardSizePipeDto) {
        return ResponseEntity.ok().body(service.update(standardSizePipeDto));
    }

    @Operation(summary = "Получение данных днищ(а)")
    @GetMapping("/all")
    public ResponseEntity<List<StandardSizePipeDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}
