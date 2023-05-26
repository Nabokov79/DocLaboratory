package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.VisualProtocolPatternMapper;
import ru.nabokov.patternservice.model.PatternSectionFour;
import ru.nabokov.patternservice.model.VisualProtocolPattern;
import ru.nabokov.patternservice.repository.VisualProtocolPatternRepository;
import ru.nabokov.patternservice.service.section.PatternSectionFourService;

@Service
@RequiredArgsConstructor
public class VisualProtocolPatternServiceImpl implements VisualProtocolPatternService {

    private final VisualProtocolPatternRepository repository;
    private final VisualProtocolPatternMapper mapper;
    private final ProtocolHeaderService protocolHeaderService;
    private final PatternTableService tableService;
    private final PatternConclusionService conclusionService;
    private final PatternSectionFourService patternSectionFourService;

    @Override
    public ReportPatternDto save(NewProtocolPatternDto protocolDto) {
        validateCountPatternTables(protocolDto.getPatternTables().size());
        PatternSectionFour section = patternSectionFourService.get(protocolDto.getSectionId());
        VisualProtocolPattern protocol = mapper.mapToNewVisualProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.save(protocolDto.getProtocolHeader()));
        protocol.setPatternTable(tableService.save(protocolDto.getPatternTables().get(0)));
        protocol.setPatternConclusion(conclusionService.save(protocolDto.getPatternConclusion()));
        section.setVisualProtocolPattern(protocol);
        return patternSectionFourService.addProtocol(protocolDto.getReportPatternId(), section);
    }

    @Override
    public ReportPatternDto update(UpdateProtocolPatternDto protocolDto) {
        if (!repository.existsById(protocolDto.getId())) {
            throw new NotFoundException(
                    String.format("Visual protocol pattern with id=%s not found for update", protocolDto.getId())
            );
        }
        validateCountPatternTables(protocolDto.getPatternTables().size());
        PatternSectionFour section = patternSectionFourService.get(protocolDto.getSectionId());
        VisualProtocolPattern protocol = mapper.mapToUpdateVisualProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.update(protocolDto.getProtocolHeader()));
        protocol.setPatternTable(tableService.update(protocolDto.getPatternTables().get(0)));
        protocol.setPatternConclusion(conclusionService.update(protocolDto.getPatternConclusion()));
        section.setVisualProtocolPattern(protocol);
        return patternSectionFourService.addProtocol(protocolDto.getReportPatternId(), section);
    }

    private void validateCountPatternTables(Integer size) {
        if (size > 1) {
            throw new BadRequestException(String.format("number of tables exceeds one for visual protocol, count=%s", size));
        }
    }
}
