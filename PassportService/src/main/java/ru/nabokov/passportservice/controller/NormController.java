package ru.nabokov.passportservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokov.passportservice.dto.norms.NewTanksNormsDto;
import ru.nabokov.passportservice.dto.norms.TanksNormsDto;
import ru.nabokov.passportservice.dto.norms.UpdateTanksNormsDto;
import ru.nabokov.passportservice.dto.norms.pipline.NewPipelineNormDto;
import ru.nabokov.passportservice.dto.norms.pipline.PipelineNormDto;
import ru.nabokov.passportservice.dto.norms.pipline.UpdatePipelineNormDto;
import ru.nabokov.passportservice.service.pipeline.PipelineNormService;
import ru.nabokov.passportservice.service.tank.TankNormsService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/passport/norms",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Нормы выявления брака",
        description="API для работы с нормами выявления брака в объекте обследования")
public class NormController {

    private final TankNormsService service;
    private final PipelineNormService pipelineNormsService;

    @Operation(summary = "Добавление новых норм")
    @PostMapping("/tanks")
    public ResponseEntity<TanksNormsDto> saveTanksNorms(@RequestBody @Parameter(description = "Нормы") NewTanksNormsDto normsDto) {
        return ResponseEntity.ok().body(service.save(normsDto));
    }

    @Operation(summary = "Изменение данных норм")
    @PatchMapping("/tanks")
    public ResponseEntity<TanksNormsDto> updateTanksNorms(@RequestBody @Parameter(description = "Нормы") UpdateTanksNormsDto normsDto) {
        return ResponseEntity.ok().body(service.update(normsDto));
    }

    @Operation(summary = "Добавление новых норм")
    @PostMapping("/pipeline")
    public ResponseEntity<List<PipelineNormDto>> savePipelineNorms(@RequestBody @Parameter(description = "Нормы") List<NewPipelineNormDto> normsDto) {
        return ResponseEntity.ok().body(pipelineNormsService.save(normsDto));
    }

    @Operation(summary = "Изменение данных норм")
    @PatchMapping("/pipeline")
    public ResponseEntity<List<PipelineNormDto>> updatePipelineNorms(@RequestBody @Parameter(description = "Нормы") List<UpdatePipelineNormDto> normsDto) {
        return ResponseEntity.ok().body(pipelineNormsService.update(normsDto));
    }
}
