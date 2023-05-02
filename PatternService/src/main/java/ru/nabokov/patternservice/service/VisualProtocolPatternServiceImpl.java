package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.dto.VisualProtocolPatternDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.VisualProtocolPatternMapper;
import ru.nabokov.patternservice.model.PatternSectionFour;
import ru.nabokov.patternservice.model.VisualProtocolPattern;
import ru.nabokov.patternservice.repository.PatternSectionFourRepository;
import ru.nabokov.patternservice.repository.VisualProtocolPatternRepository;

@Service
@RequiredArgsConstructor
public class VisualProtocolPatternServiceImpl implements VisualProtocolPatternService {

    private final VisualProtocolPatternRepository repository;
    private final VisualProtocolPatternMapper mapper;
    private final ProtocolHeaderService protocolHeaderService;
    private final PatternTableService tableService;
    private final PatternConclusionService conclusionService;
    private final PatternSectionFourRepository sectionFourRepository;

    @Override
    public VisualProtocolPatternDto save(NewProtocolPatternDto protocolDto) {
        if (!sectionFourRepository.existsById(protocolDto.getSectionPatternId())) {
            throw new NotFoundException(
                    String.format("Pattern section four with id=%s not found for save visual protocol pattern",
                                                                                protocolDto.getSectionPatternId())
            );
        }
        VisualProtocolPattern protocol = mapper.mapToNewVisualProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.save(protocol.getProtocolHeader()));
        protocol.setPatternTable(tableService.save(protocol.getPatternTable()));
        protocol.setPatternConclusion(conclusionService.save(protocol.getPatternConclusion()));
        return mapper.mapToVisualProtocolPatternDto(updatePatternSectionFour(protocolDto.getSectionPatternId(),
                                                                             repository.save(protocol)));
    }

    @Override
    public VisualProtocolPatternDto update(UpdateProtocolPatternDto protocolDto) {
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
        VisualProtocolPattern protocol = mapper.mapToUpdateVisualProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.update(protocol.getProtocolHeader()));
        protocol.setPatternTable(tableService.update(protocol.getPatternTable()));
        protocol.setPatternConclusion(conclusionService.update(protocol.getPatternConclusion()));
        return mapper.mapToVisualProtocolPatternDto(updatePatternSectionFour(protocolDto.getSectionPatternId(),
                                                                             repository.save(protocol)));
    }

    @Override
    public VisualProtocolPatternDto get(Long proId) {
        return mapper.mapToVisualProtocolPatternDto(
                repository.findById(proId)
                          .orElseThrow(() -> new NotFoundException(
                                  String.format("Visual protocol pattern with id=%s not found for update", proId)))
        );
    }

    private VisualProtocolPattern updatePatternSectionFour(Long id, VisualProtocolPattern protocol) {
        PatternSectionFour pattern = sectionFourRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Pattern section four with id=%s not found for update", id))
                );
        pattern.setVisualProtocolPattern(protocol);
        sectionFourRepository.save(pattern);
        return protocol;
    }
}
