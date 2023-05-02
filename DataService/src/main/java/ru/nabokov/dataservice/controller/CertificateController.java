package ru.nabokov.dataservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.dataservice.dto.certificate.CertificateDto;
import ru.nabokov.dataservice.dto.certificate.NewCertificateDto;
import ru.nabokov.dataservice.dto.certificate.UpdateCertificateDto;
import ru.nabokov.dataservice.service.CertificateService;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(
        value = "/data/certificates",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Сертификаты сотрудников",
     description="API для работы с данными сертификатов сотруднаков")
public class CertificateController {

    private final CertificateService service;

    @Operation(summary = "Добавление данных сертификатов сотрудника")
    @PostMapping
    public ResponseEntity<List<CertificateDto>> save(@RequestBody
                                                     @Parameter(description = "Список сертификатов сотрудника")
                                                     List<NewCertificateDto> newCertificates) {
        return ResponseEntity.ok().body(service.save(newCertificates));
    }

    @Operation(summary = "Изменение данных аттестации сотрудника")
    @PatchMapping
    public ResponseEntity<List<CertificateDto>> update(@RequestBody
                                                       @Parameter(description = "Список сертификатов сотрудника")
                                                       List<UpdateCertificateDto> updateCertificates) {
        return ResponseEntity.ok().body(service.update(updateCertificates));
    }

    @Operation(summary = "Получение данных сертификатов сотрудников")
    @GetMapping
    public ResponseEntity<List<CertificateDto>> getAll(@RequestParam(required = false)
                                                      @Parameter(description = "Индентификатор сотрудника") Long employeeId,
                                                      @RequestParam(required = false)
                                                      @Parameter(description = "Дата") LocalDate date) {
        return ResponseEntity.ok().body(service.getAll(employeeId, date));
    }

    @Operation(summary = "Удаление данных сертификата сотрудника")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable
                                         @Parameter(description = "Индентификатор сертификата") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Аттестация сотрудника удалена.");
    }
}
