package ru.nabokov.passportservice.service.tank;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.client.PassportClient;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.norms.NewTanksNormsDto;
import ru.nabokov.passportservice.dto.norms.TanksNormsDto;
import ru.nabokov.passportservice.dto.norms.UpdateTanksNormsDto;
import ru.nabokov.passportservice.exceptions.BadRequestException;
import ru.nabokov.passportservice.mapper.TankNormsMapper;
import ru.nabokov.passportservice.model.passport.Belt;
import ru.nabokov.passportservice.model.passport.Bottom;
import ru.nabokov.passportservice.model.norms.TankNorm;
import ru.nabokov.passportservice.repository.NormsRepository;
import ru.nabokov.passportservice.service.passport.BeltService;
import ru.nabokov.passportservice.service.passport.BottomService;
import ru.nabokov.passportservice.service.pipeline.PipelineNormService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TankNormsServiceImpl implements TankNormsService {

    private final NormsRepository repository;
    private final TankNormsMapper mapper;
    private final PassportClient client;
    private final BeltService beltService;
    private final BottomService bottomService;
    private final PipelineNormService pipelineNormService;

    @Override
    public TanksNormsDto save(NewTanksNormsDto normsDto) {
        ObjectDataDto objectData = client.getObjectData(normsDto.getObjectDataId());
        TankNorm norms = setValues(new TankNorm(), objectData);
        List<Belt> belts;
        List<Bottom> bottoms;
        if (normsDto.getBelts() != null && normsDto.getBottoms() != null) {
            belts = beltService.save(objectData.getType().getId(), normsDto.getBelts());
            bottoms = bottomService.save(objectData.getType().getId(), normsDto.getBottoms());
        } else {
            belts = beltService.getAll(objectData.getVolume(), objectData.getType().getId());
            bottoms = bottomService.getAll(objectData.getVolume(), objectData.getType().getId());
        }
        return mapper.mapToNormsDto(repository.save(setNorm(norms,belts, bottoms)));
    }

    @Override
    public TanksNormsDto update(UpdateTanksNormsDto normsDto) {
        ObjectDataDto objectData = client.getObjectData(normsDto.getObjectDataId());
        TankNorm norms = setValues(mapper.mapToUpdateNormsDto(normsDto), objectData);
        List<Belt> belts;
        List<Bottom> bottoms;
        if (normsDto.getBelts() != null && normsDto.getBottoms() != null) {
            belts = beltService.update(objectData.getType().getId(), normsDto.getBelts());
            bottoms = bottomService.update(objectData.getType().getId(), normsDto.getBottoms());
        } else {
            belts = beltService.getAll(objectData.getVolume(), objectData.getType().getId());
            bottoms = bottomService.getAll(objectData.getVolume(), objectData.getType().getId());
        }
        return mapper.mapToNormsDto(repository.save(setNorm(norms,belts, bottoms)));
    }

    private TankNorm setValues(TankNorm norms, ObjectDataDto objectData) {
        norms.setObjectDataId(objectData.getId());
        norms.setTypeId(objectData.getType().getId());
        return norms;
    }

    private TankNorm setNorm(TankNorm norms, List<Belt> belts, List<Bottom> bottoms) {
        if ((belts.isEmpty() && bottoms.isEmpty())) {
            throw new BadRequestException(String.format("Norms for type with id=%s not found", norms.getTypeId()));
        } else {
            if (!belts.isEmpty() && !bottoms.isEmpty()) {
                norms.setBelts(belts);
                norms.setBottoms(bottoms);
            }
        }
        return norms;
    }
}
