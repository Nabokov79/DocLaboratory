package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.GeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.NewGeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateGeodesyProtocolPatternDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.GeodesyProtocolMapper;
import ru.nabokov.patternservice.model.GeodesyProtocolPattern;
import ru.nabokov.patternservice.model.PatternSectionFour;
import ru.nabokov.patternservice.model.PatternTable;
import ru.nabokov.patternservice.repository.GeodesyProtocolPatternRepository;
import ru.nabokov.patternservice.repository.PatternSectionFourRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GeodesyProtocolPatternServiceImpl implements GeodesyProtocolPatternService {

    private final GeodesyProtocolPatternRepository repository;
    private final GeodesyProtocolMapper mapper;
    private final ProtocolHeaderService protocolHeaderService;
    private final PatternTableService tableService;
    private final PatternConclusionService conclusionService;
    private final PatternSectionFourRepository sectionFourRepository;

    @Override
    public GeodesyProtocolPatternDto save(NewGeodesyProtocolPatternDto protocolDto) {
        if (!sectionFourRepository.existsById(protocolDto.getSectionPatternId())) {
            throw new NotFoundException(
                    String.format("Pattern section four with id=%s not found for save visual protocol pattern",
                            protocolDto.getSectionPatternId())
            );
        }
        GeodesyProtocolPattern protocol = mapper.mapToNewGeodesyProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.save(protocol.getProtocolHeader()));
        protocol.setPatternConclusion(conclusionService.save(protocol.getPatternConclusion()));
        List<PatternTable> tables = new ArrayList<>();
        for (PatternTable  table : protocol.getPatternTables()) {
           tables.add(tableService.save(table));
        }
        protocol.setPatternTables(tables);
        return mapper.mapToGeodesyProtocolPattern(updatePatternSectionFour(protocolDto.getSectionPatternId(),
                repository.save(protocol)));
    }

    @Override
    public GeodesyProtocolPatternDto update(UpdateGeodesyProtocolPatternDto protocolDto) {
        if (!sectionFourRepository.existsById(protocolDto.getSectionPatternId())) {
            throw new NotFoundException(
                    String.format("Pattern section four with id=%s not found for save visual protocol pattern",
                            protocolDto.getSectionPatternId())
            );
        }
        if (!repository.existsById(protocolDto.getId())) {
            throw new NotFoundException(
                    String.format("Visual protocol pattern with id=%s not found for update", protocolDto.getId())
            );
        }
        GeodesyProtocolPattern protocol = mapper.mapToUpdateGeodesyProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.update(protocol.getProtocolHeader()));
        protocol.setPatternConclusion(conclusionService.update(protocol.getPatternConclusion()));
        List<PatternTable> tables = new ArrayList<>();
        for (PatternTable  table : protocol.getPatternTables()) {
            tables.add(tableService.update(table));
        }
        protocol.setPatternTables(tables);
        return mapper.mapToGeodesyProtocolPattern(updatePatternSectionFour(protocolDto.getSectionPatternId(),
                repository.save(protocol)));
    }

    @Override
    public GeodesyProtocolPatternDto get(Long id) {
        return mapper.mapToGeodesyProtocolPattern(
                repository.findById(id)
                        .orElseThrow(() -> new NotFoundException(
                                String.format("Visual protocol pattern with id=%s not found for update", id)))
        );
    }

    private GeodesyProtocolPattern updatePatternSectionFour(Long id, GeodesyProtocolPattern protocol) {
        PatternSectionFour pattern = sectionFourRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Pattern section four with id=%s not found for update", id))
                );
        pattern.setGeodesyProtocolPattern(protocol);
        sectionFourRepository.save(pattern);
        return protocol;
    }
}
