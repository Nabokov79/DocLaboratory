package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.license.LicenseDto;
import ru.nabokov.dataservice.dto.license.NewLicenseDto;
import ru.nabokov.dataservice.dto.license.UpdateLicenseDto;
import ru.nabokov.dataservice.mapper.LicenseMapper;
import ru.nabokov.dataservice.service.LicenseService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(
        value = "/data/licenses",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Лицензия",
        description="API для работы с данными лицензии")
public class LicenseController {

    private final LicenseService service;
    private final LicenseMapper mapper;

    @Operation(summary = "Добавление данных лицензии")
    @PostMapping
    public ResponseEntity<LicenseDto> save(@RequestBody @Parameter(description = "Лицензия") NewLicenseDto licenseDto) {
        return ResponseEntity.ok().body(service.save(licenseDto));
    }

    @Operation(summary = "Изменение данных лицензии")
    @PatchMapping
    public ResponseEntity<LicenseDto> update(
                                        @RequestBody @Parameter(description = "Лицензия") UpdateLicenseDto licenseDto) {
        return ResponseEntity.ok().body(service.update(licenseDto));
    }

    @Operation(summary = "Получение данных лицензии")
    @GetMapping("/{id}")
    public ResponseEntity<LicenseDto> get(
            @PathVariable @NotNull @Positive @Parameter(description = "Индентификатор лицензии") Long id) {
        return ResponseEntity.ok().body(mapper.mapToLicenseDto(service.get(id)));
    }

    @Operation(summary = "Получение данных всех лицензий подразделения")
    @GetMapping
    public ResponseEntity<List<LicenseDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}
