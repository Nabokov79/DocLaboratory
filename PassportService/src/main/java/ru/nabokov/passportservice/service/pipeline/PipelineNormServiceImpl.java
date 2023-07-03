package ru.nabokov.passportservice.service.pipeline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.norms.pipline.NewPipelineNormDto;
import ru.nabokov.passportservice.dto.norms.pipline.PipelineNormDto;
import ru.nabokov.passportservice.dto.norms.pipline.UpdatePipelineNormDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.PipelineNormMapper;
import ru.nabokov.passportservice.model.pipeline.PipelineNorm;
import ru.nabokov.passportservice.repository.PipelineNormRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PipelineNormServiceImpl implements PipelineNormService {

    private final PipelineNormRepository repository;
    private final PipelineNormMapper mapper;

    @Override
    public List<PipelineNormDto> save(List<NewPipelineNormDto> pipesDto) {
        return mapper.mapToPipelineNormsDto(repository.saveAll(mapper.mapToNewPipelineNormsDto(pipesDto)));
    }

    @Override
    public List<PipelineNormDto> update(List<UpdatePipelineNormDto> pipesDto) {
        validateIds(pipesDto.stream().map(UpdatePipelineNormDto:: getId).toList());
        return mapper.mapToPipelineNormsDto(repository.saveAll(mapper.mapToUpdatePipelineNormsDto(pipesDto)));
    }

    private void validateIds(List<Long> ids) {
        Map<Long, PipelineNorm> pipelineNorms = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(PipelineNorm::getId, d -> d));
        if (pipelineNorms.size() != ids.size() ||  pipelineNorms.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(pipelineNorms.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("pipeline norms with ids= %s not found", ids));
        }
    }
}
