package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.norms.pipline.NewPipelineNormDto;
import ru.nabokov.passportservice.dto.norms.pipline.PipelineNormDto;
import ru.nabokov.passportservice.dto.norms.pipline.UpdatePipelineNormDto;
import ru.nabokov.passportservice.model.pipeline.PipelineNorm;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PipelineNormMapper {

    List<PipelineNormDto> mapToPipelineNormsDto(List<PipelineNorm> norm);

    List<PipelineNorm> mapToUpdatePipelineNormsDto(List<UpdatePipelineNormDto> normsDto);

    List<PipelineNorm> mapToNewPipelineNormsDto(List<NewPipelineNormDto> normsDto);
}
