package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionSixDto;
import ru.nabokov.patternservice.dto.section.PatternSectionSixDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionSixDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternSectionSixMapper;
import ru.nabokov.patternservice.model.PatternSectionSix;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionSixRepository;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatternSectionSixServiceImpl implements PatternSectionSixService {

    private final PatternSectionSixRepository repository;
    private final PatternSectionSixMapper mapper;
    private final ReportPatternRepository reportPatternRepository;
    private final SubheadingService subheadingService;
    private final HeaderService headerService;

    @Override
    public PatternSectionSixDto save(NewPatternSectionSixDto patternDto) {
        log.info(patternDto.toString());
        if (!reportPatternRepository.existsById(patternDto.getReportPatternId())) {
            throw new NotFoundException(String.format("report pattern witch id=%s not found for section six",
                    patternDto.getReportPatternId())
            );
        }
        PatternSectionSix pattern = mapper.mapToNewPatternSectionSix(patternDto);
        pattern.setHeader(headerService.save(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.saveAll(patternDto.getSubheadings()));
        PatternSectionSix patternDb = repository.save(pattern);
        updateReportPattern(patternDto.getReportPatternId(), pattern);
        PatternSectionSixDto patternSectionSixDto =  mapper.mapToPatternSectionSixDto(patternDb);
        log.info(patternSectionSixDto.toString());
        return patternSectionSixDto;
    }

    @Override
    public PatternSectionSixDto update(UpdatePatternSectionSixDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section six witch id=%s not found for update", patternDto.getId())
            );
        }
        PatternSectionSix pattern = mapper.mapToUpdatePatternSectionSix(patternDto);
        pattern.setHeader(headerService.update(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.updateAll(patternDto.getSubheadings()));
        return mapper.mapToPatternSectionSixDto(repository.save(pattern));
    }

    @Override
    public PatternSectionSixDto get(Long patId) {
        return mapper.mapToPatternSectionSixDto(
                repository.findById(patId).orElseThrow(() -> new NotFoundException(
                        String.format("pattern section six witch id=%s not found", patId)))
        );
    }

    private void updateReportPattern(Long id, PatternSectionSix patternDb) {
        ReportPattern pattern = reportPatternRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("report pattern section five witch id=%s not found for update", id))
                );
        pattern.setPatternSectionSix(patternDb);
        reportPatternRepository.save(pattern);
    }
}
