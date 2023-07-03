package ru.nabokov.passportservice.service.pipeline;

import ru.nabokov.passportservice.dto.norms.pipline.NewPipelineNormDto;
import ru.nabokov.passportservice.dto.norms.pipline.PipelineNormDto;
import ru.nabokov.passportservice.dto.norms.pipline.UpdatePipelineNormDto;

import java.util.List;

public interface PipelineNormService {

    List<PipelineNormDto> save(List<NewPipelineNormDto> pipesDto);

    List<PipelineNormDto> update(List<UpdatePipelineNormDto> pipesDto);

}
