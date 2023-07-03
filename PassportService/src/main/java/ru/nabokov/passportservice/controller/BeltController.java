package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.belt.BeltDto;
import ru.nabokov.passportservice.dto.belt.NewBeltDto;
import ru.nabokov.passportservice.dto.belt.UpdateBeltDto;
import ru.nabokov.passportservice.service.passport.BeltService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/passport/belt",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Пояса и обечайки бака, обечайки деаэратора, корпус фильтра",
        description="API для работы с данными: поясов и обечаек бака, обечаек деаэратора, корпуса фильтра")
public class BeltController {

    private final BeltService service;

    @Operation(summary = "Добавление новых данных паспорта")
    @PostMapping
    public ResponseEntity<List<BeltDto>> save(
                                     @RequestBody @Parameter(description = "Данные поясов") List<NewBeltDto> beltsDto) {
        return ResponseEntity.ok().body(service.save(beltsDto));
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public ResponseEntity<List<BeltDto>> update(
                                  @RequestBody @Parameter(description = "Данные поясов") List<UpdateBeltDto> beltsDto) {
        return ResponseEntity.ok().body(service.update(beltsDto));
    }

    @Operation(summary = "Получение данных поясов")
    @GetMapping("/all")
    public ResponseEntity<List<BeltDto>> getAll(
                               @RequestParam(required = false) @Parameter(description = "Номер пояса") Integer number) {
        return ResponseEntity.ok().body(service.getAll(number));
    }
}
