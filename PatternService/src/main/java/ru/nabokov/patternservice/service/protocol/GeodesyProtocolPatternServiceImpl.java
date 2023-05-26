package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.dto.table.NewPatternTableDto;
import ru.nabokov.patternservice.dto.table.UpdatePatternTableDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.GeodesyProtocolMapper;
import ru.nabokov.patternservice.model.GeodesyProtocolPattern;
import ru.nabokov.patternservice.model.PatternSectionFour;
import ru.nabokov.patternservice.model.PatternTable;
import ru.nabokov.patternservice.repository.GeodesyProtocolPatternRepository;
import ru.nabokov.patternservice.service.section.PatternSectionFourService;

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
    private final PatternSectionFourService patternSectionFourService;

    @Override
    public ReportPatternDto save(NewProtocolPatternDto protocolDto) {
        PatternSectionFour section = patternSectionFourService.get(protocolDto.getSectionId());
        GeodesyProtocolPattern protocol = mapper.mapToNewGeodesyProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.save(protocolDto.getProtocolHeader()));
        protocol.setPatternConclusion(conclusionService.save(protocolDto.getPatternConclusion()));
        List<PatternTable> tables = new ArrayList<>();
        for (NewPatternTableDto table : protocolDto.getPatternTables()) {
           tables.add(tableService.save(table));
        }
        protocol.setPatternTables(tables);
        section.setGeodesyProtocolPattern(protocol);
        return patternSectionFourService.addProtocol(protocolDto.getReportPatternId(), section);
    }

    @Override
    public ReportPatternDto update(UpdateProtocolPatternDto protocolDto) {
        if (!repository.existsById(protocolDto.getId())) {
            throw new NotFoundException(
                    String.format("Visual protocol pattern with id=%s not found for update", protocolDto.getId())
            );
        }
        PatternSectionFour section = patternSectionFourService.get(protocolDto.getSectionId());
        GeodesyProtocolPattern protocol = mapper.mapToUpdateGeodesyProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.update(protocolDto.getProtocolHeader()));
        protocol.setPatternConclusion(conclusionService.update(protocolDto.getPatternConclusion()));
        List<PatternTable> tables = new ArrayList<>();
        for (UpdatePatternTableDto table : protocolDto.getPatternTables()) {
            tables.add(tableService.update(table));
        }
        protocol.setPatternTables(tables);
        section.setGeodesyProtocolPattern(protocol);
        return patternSectionFourService.addProtocol(protocolDto.getReportPatternId(), section);
    }
}
