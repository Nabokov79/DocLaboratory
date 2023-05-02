package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.NewPatternSectionFiveDto;
import ru.nabokov.patternservice.dto.PatternSectionFiveDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionFiveDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternSectionFiveMapper;
import ru.nabokov.patternservice.model.PatternSectionFive;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionFiveRepository;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

@Service
@RequiredArgsConstructor
public class PatternSectionFiveServiceImpl implements PatternSectionFiveService {

    private final PatternSectionFiveRepository repository;
    private final PatternSectionFiveMapper mapper;
    private final ReportPatternRepository reportPatternRepository;
    private final SubheadingService subheadingService;
    private final HeaderService headerService;

    @Override
    public PatternSectionFiveDto save(NewPatternSectionFiveDto patternDto) {
        if (!reportPatternRepository.existsById(patternDto.getReportPatternId())) {
            throw new NotFoundException(String.format("report pattern witch id=%s not found for section one",
                    patternDto.getReportPatternId())
            );
        }
        PatternSectionFive pattern = new PatternSectionFive();
        pattern.setHeader(headerService.save(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.saveAll(patternDto.getSubheadings()));
        PatternSectionFive patternDb = repository.save(pattern);
        updateReportPattern(patternDto.getReportPatternId(), patternDb);
        return mapper.mapToPatternSectionFiveDto(patternDb);
    }

    @Override
    public PatternSectionFiveDto update(UpdatePatternSectionFiveDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section one witch id=%s not found for update", patternDto.getId())
            );
        }
        PatternSectionFive pattern = mapper.mapToPatternSectionFive(patternDto);
        pattern.setHeader(headerService.update(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.updateAll(patternDto.getSubheadings()));
        return mapper.mapToPatternSectionFiveDto(repository.save(pattern));
    }

    @Override
    public PatternSectionFiveDto get(Long patId) {
        return mapper.mapToPatternSectionFiveDto(
                repository.findById(patId).orElseThrow(() -> new NotFoundException(
                        String.format("pattern section five witch id=%s not found", patId)))
        );
    }

    private void updateReportPattern(Long id, PatternSectionFive patternDb) {
        ReportPattern pattern = reportPatternRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("report pattern section five witch id=%s not found for update", id))
                );
        pattern.setPatternSectionFive(patternDb);
        reportPatternRepository.save(pattern);
    }
}
