package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.UltrasonicProtocolPatternMapper;
import ru.nabokov.patternservice.model.PatternSectionFour;
import ru.nabokov.patternservice.model.UltrasonicProtocolPattern;
import ru.nabokov.patternservice.repository.PatternSectionFourRepository;
import ru.nabokov.patternservice.repository.UltrasonicProtocolPatternRepository;

@Service
@RequiredArgsConstructor
public class UltrasonicProtocolPatternServiceImpl implements UltrasonicProtocolPatternService {

    private final UltrasonicProtocolPatternRepository repository;
    private final UltrasonicProtocolPatternMapper mapper;
    private final ProtocolHeaderService protocolHeaderService;
    private final PatternTableService tableService;
    private final PatternConclusionService conclusionService;
    private final PatternSectionFourRepository sectionFourRepository;

    @Override
    public UltrasonicProtocolPattern save(NewProtocolPatternDto protocolDto) {
        if (!sectionFourRepository.existsById(protocolDto.getSectionPatternId())) {
            throw new NotFoundException(
                    String.format("Pattern section four with id=%s not found for save visual protocol pattern",
                            protocolDto.getSectionPatternId())
            );
        }
        UltrasonicProtocolPattern protocol = mapper.mapToNewUltrasonicProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.save(protocol.getProtocolHeader()));
        protocol.setPatternTable(tableService.save(protocol.getPatternTable()));
        protocol.setPatternConclusion(conclusionService.save(protocol.getPatternConclusion()));
        return updatePatternSectionFour(protocolDto.getSectionPatternId(), repository.save(protocol));
    }

    @Override
    public UltrasonicProtocolPattern update(UpdateProtocolPatternDto protocolDto) {
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
        UltrasonicProtocolPattern protocol = mapper.mapToUpdateUltrasonicProtocolPattern(protocolDto);
        protocol.setProtocolHeader(protocolHeaderService.update(protocol.getProtocolHeader()));
        protocol.setPatternTable(tableService.update(protocol.getPatternTable()));
        protocol.setPatternConclusion(conclusionService.update(protocol.getPatternConclusion()));
        return updatePatternSectionFour(protocolDto.getSectionPatternId(), repository.save(protocol));
    }

    @Override
    public UltrasonicProtocolPattern get(Long proId) {
        return repository.findById(proId).orElseThrow(() -> new NotFoundException(
                                    String.format("Ultrasonic protocol pattern with id=%s not found for update", proId))
        );
    }

    private UltrasonicProtocolPattern updatePatternSectionFour(Long id, UltrasonicProtocolPattern protocol) {
        PatternSectionFour pattern = sectionFourRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Pattern section four with id=%s not found for update", id))
                );
        pattern.setUltrasonicProtocolPattern(protocol);
        sectionFourRepository.save(pattern);
        return protocol;
    }
}
