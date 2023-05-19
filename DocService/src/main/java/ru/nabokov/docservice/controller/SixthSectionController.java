package ru.nabokov.docservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.docservice.dto.sixthSection.NewSixthSectionDto;
import ru.nabokov.docservice.dto.sixthSection.SixthSectionDto;
import ru.nabokov.docservice.dto.sixthSection.UpdateSixthSectionDto;
import ru.nabokov.docservice.service.SixthSectionService;

@RestController
@RequestMapping(
        value = "/report/section/seven",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шестой раздел отчета",
        description="API для работы с данными шестого раздела отчета")
public class SixthSectionController {

    private final SixthSectionService service;

    @Operation(summary = "Добавление новых данных раздела")
    @PostMapping
    public ResponseEntity<SixthSectionDto> save(@RequestBody @Validated
                                          @Parameter(description = "Шестой раздел") NewSixthSectionDto sectionDto) {
        return ResponseEntity.ok().body(service.save(sectionDto));
    }

    @Operation(summary = "Изменение данных раздела")
    @PatchMapping
    public ResponseEntity<SixthSectionDto> update(@RequestBody @Validated
                                          @Parameter(description = "Шестой раздел") UpdateSixthSectionDto sectionDto) {
        return ResponseEntity.ok().body(service.update(sectionDto));
    }
}
