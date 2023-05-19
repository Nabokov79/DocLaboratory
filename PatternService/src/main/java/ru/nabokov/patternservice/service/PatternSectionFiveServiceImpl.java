package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionFiveDto;
import ru.nabokov.patternservice.dto.section.PatternSectionFiveDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionFiveDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternSectionFiveMapper;
import ru.nabokov.patternservice.model.PatternSectionFive;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionFiveRepository;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatternSectionFiveServiceImpl implements PatternSectionFiveService {

    private final PatternSectionFiveRepository repository;
    private final PatternSectionFiveMapper mapper;
    private final ReportPatternRepository reportPatternRepository;
    private final SubheadingService subheadingService;
    private final HeaderService headerService;

    @Override
    public PatternSectionFiveDto save(NewPatternSectionFiveDto patternDto) {
        log.info(patternDto.toString());
        if (!reportPatternRepository.existsById(patternDto.getReportPatternId())) {
            throw new NotFoundException(String.format("report pattern witch id=%s not found for section one",
                    patternDto.getReportPatternId())
            );
        }
        PatternSectionFive pattern = mapper.mapToNewPatternSectionFive(patternDto);
        pattern.setHeader(headerService.save(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.saveAll(patternDto.getSubheadings()));
        updateReportPattern(patternDto.getReportPatternId(), pattern);
        PatternSectionFiveDto patternSectionFiveDto =  mapper.mapToPatternSectionFiveDto(repository.save(pattern));
        log.info(patternSectionFiveDto.toString());
        return patternSectionFiveDto;
    }

    @Override
    public PatternSectionFiveDto update(UpdatePatternSectionFiveDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section one witch id=%s not found for update", patternDto.getId())
            );
        }
        PatternSectionFive pattern = mapper.mapToUpdatePatternSectionFive(patternDto);
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
