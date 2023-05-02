package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.HardnessProtocolPatternDto;
import ru.nabokov.patternservice.dto.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.HardnessProtocolMapper;
import ru.nabokov.patternservice.model.HardnessProtocolPattern;
import ru.nabokov.patternservice.model.PatternSectionFour;
import ru.nabokov.patternservice.repository.HardnessProtocolPatternRepository;
import ru.nabokov.patternservice.repository.PatternSectionFourRepository;

@Service
@RequiredArgsConstructor
public class HardnessProtocolPatternServiceImpl implements HardnessProtocolPatternService {

    private final HardnessProtocolPatternRepository repository;
    private final HardnessProtocolMapper mapper;
    private final ProtocolHeaderService protocolHeaderService;
    private final PatternTableService tableService;
    private final PatternConclusionService conclusionService;
    private final PatternSectionFourRepository sectionFourRepository;

    @Override
    public HardnessProtocolPatternDto save(NewProtocolPatternDto protocolDto) {
        if (!sectionFourRepository.existsById(protocolDto.getSectionPatternId())) {
            throw new NotFoundException(
                    String.format("Pattern section four with id=%s not found for save visual protocol pattern",
                            protocolDto.getSectionPatternId())
            );
        }
        HardnessProtocolPattern protocol = mapper.mapToNewHardnessProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.save(protocol.getProtocolHeader()));
        protocol.setPatternTable(tableService.save(protocol.getPatternTable()));
        protocol.setPatternConclusion(conclusionService.save(protocol.getPatternConclusion()));
        return mapper.mapFromHardnessProtocolPattern(updatePatternSectionFour(protocolDto.getSectionPatternId(),
                repository.save(protocol)));
    }

    @Override
    public HardnessProtocolPatternDto update(UpdateProtocolPatternDto protocolDto) {
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
        HardnessProtocolPattern protocol = mapper.mapToUpdateHardnessProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.update(protocol.getProtocolHeader()));
        protocol.setPatternTable(tableService.update(protocol.getPatternTable()));
        protocol.setPatternConclusion(conclusionService.update(protocol.getPatternConclusion()));
        return mapper.mapFromHardnessProtocolPattern(updatePatternSectionFour(protocolDto.getSectionPatternId(),
                repository.save(protocol)));
    }

    @Override
    public HardnessProtocolPatternDto get(Long proId) {
        return mapper.mapFromHardnessProtocolPattern(
                repository.findById(proId)
                        .orElseThrow(() -> new NotFoundException(
                                String.format("Hardness protocol pattern with id=%s not found for update", proId)))
        );
    }

    private HardnessProtocolPattern updatePatternSectionFour(Long id, HardnessProtocolPattern protocol) {
        PatternSectionFour pattern = sectionFourRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Pattern section four with id=%s not found for update", id))
                );
        pattern.setHardnessProtocolPattern(protocol);
        sectionFourRepository.save(pattern);
        return protocol;
    }
}
