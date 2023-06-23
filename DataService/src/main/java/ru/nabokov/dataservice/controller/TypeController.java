package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.type.NewTypeDto;
import ru.nabokov.dataservice.dto.type.TypeDto;
import ru.nabokov.dataservice.dto.type.UpdateTypeDto;
import ru.nabokov.dataservice.mapper.TypeMapper;
import ru.nabokov.dataservice.service.TypeService;
import java.util.List;

@RestController
@RequestMapping(
        value = "/data/types",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Тип объекта",
        description="API для работы с данными типа объекта")
public class TypeController {

    private final TypeService service;
    private final TypeMapper mapper;

    @Operation(summary = "Добавление данных типа объекта")
    @PostMapping
    public ResponseEntity<TypeDto> save(@RequestBody @Parameter(description = "Тип объекта") NewTypeDto typeDto) {
        return ResponseEntity.ok().body(service.save(typeDto));
    }

    @Operation(summary = "Изменение данных типа объекта")
    @PatchMapping
    public ResponseEntity<TypeDto> update(@RequestBody @Parameter(description = "Тип объекта") UpdateTypeDto typeDto) {
        return ResponseEntity.ok().body(service.update(typeDto));
    }

    @Operation(summary = "Получение данных типа объекта")
    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> get(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(mapper.mapToTypeDto(service.get(id)));
    }

    @Operation(summary = "Получение данных типа объекта")
    @GetMapping
    public ResponseEntity<List<TypeDto>> getAll(
            @RequestParam(required = false) @Parameter(description = "список индентификаторов") String ids) {
        return ResponseEntity.ok().body(service.getAll(ids));
    }
}
