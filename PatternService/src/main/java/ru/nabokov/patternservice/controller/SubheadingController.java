package ru.nabokov.patternservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nabokov.patternservice.dto.subheading.ShortSubheadingDto;
import ru.nabokov.patternservice.service.SubheadingService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(
        value = "/pattern/subheadings",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Подразделы раздела",
        description="API для работы с данными подраздела разделов")
public class SubheadingController {

    private final SubheadingService service;

    @Operation(summary = "Получить краткие данные подразделов")
    @GetMapping
    public ResponseEntity<List<ShortSubheadingDto>> getAll(@RequestParam String ids) {
        return ResponseEntity.ok().body(service.getAll(Arrays.stream(ids.split(",")).map(Long::parseLong).toList()));
    }
}
