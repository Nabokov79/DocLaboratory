package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.norm.NewNormsDto;
import ru.nabokov.dataservice.dto.norm.NormsDto;
import ru.nabokov.dataservice.dto.norm.UpdateNormsDto;
import ru.nabokov.dataservice.service.NormsService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/data/norms",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Нормы браковки объектов",
        description="API для работы с нормами браковки")
public class NormController {

    private final NormsService service;

    @Operation(summary = "Добавление новых норм")
    @PostMapping
    public ResponseEntity<List<NormsDto>> save(@RequestBody @Parameter(description = "Нормы") List<NewNormsDto> normsDto) {
        return ResponseEntity.ok().body(service.save(normsDto));
    }

    @Operation(summary = "Изменение данных норм")
    @PatchMapping
    public ResponseEntity<List<NormsDto>> update(
                                           @RequestBody @Parameter(description = "Нормы") List<UpdateNormsDto> normsDto) {
        return ResponseEntity.ok().body(service.update(normsDto));
    }
}
