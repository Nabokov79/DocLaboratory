package ru.nabokov.docservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.docservice.model.Title;
import ru.nabokov.docservice.service.DocumentService;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping(
        value = "/report",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Отчет/протокол",
        description="API для работы с данными отчета/протокола")
public class DocumentController {

    private final DocumentService service;

    @Operation(summary = "Добавление нового отчета/протокола")
    @PostMapping
    public ResponseEntity<Title> save(@RequestParam @Positive
                                   @Parameter(description = "Индентификатор объекта обследования") Long applicationId) {
        return ResponseEntity.ok().body(service.save(applicationId));
    }

    @Operation(summary = "Изменение отчета/протокола")
    @PatchMapping
    public void update() {

    }

    @Operation(summary = "Получение отчета/протокола")
    @GetMapping("/{id}")
    public void get() {

    }
}
