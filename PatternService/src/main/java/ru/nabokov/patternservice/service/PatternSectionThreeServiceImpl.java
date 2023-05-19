package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionThreeDto;
import ru.nabokov.patternservice.dto.section.PatternSectionThreeDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionThreeDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternSectionThreeMapper;
import ru.nabokov.patternservice.model.PatternSectionThree;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionThreeRepository;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatternSectionThreeServiceImpl implements PatternSectionThreeService {

    private final PatternSectionThreeRepository repository;
    private final PatternSectionThreeMapper mapper;
    private final ReportPatternRepository reportPatternRepository;
    private final HeaderService headerService;
    private final SubheadingService subheadingService;

    @Override
    public PatternSectionThreeDto save(NewPatternSectionThreeDto patternDto) {
        log.info(patternDto.toString());
        if (!reportPatternRepository.existsById(patternDto.getReportPatternId())) {
            throw new NotFoundException(String.format("report pattern witch id=%s not found for section three",
                    patternDto.getReportPatternId())
            );
        }
        PatternSectionThree pattern = mapper.mapToNewPatternSectionThree(patternDto);
        pattern.setHeader(headerService.save(pattern.getHeader()));
        pattern.setSubheadings(subheadingService.saveAll(patternDto.getSubheadings()));
        PatternSectionThree patternDb = repository.save(pattern);
        updateReportPattern(patternDto.getReportPatternId(), patternDb);
        PatternSectionThreeDto patternSectionThreeDto = mapper.mapToPatternSectionThreeDto(patternDb);
        log.info(patternSectionThreeDto.toString());
        return patternSectionThreeDto;
    }

    @Override
    public PatternSectionThreeDto update(UpdatePatternSectionThreeDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section three witch id=%s not found for update", patternDto.getId())
            );
        }
        PatternSectionThree pattern = mapper.mapToUpdatePatternSectionThree(patternDto);
        pattern.setHeader(headerService.update(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.updateAll(patternDto.getSubheadings()));
        return mapper.mapToPatternSectionThreeDto(repository.save(pattern));
    }

    @Override
    public PatternSectionThreeDto get(Long patId) {
        return mapper.mapToPatternSectionThreeDto(
                repository.findById(patId).orElseThrow(() -> new NotFoundException(
                        String.format("pattern section three witch id=%s not found", patId)))
        );
    }

    private void updateReportPattern(Long id, PatternSectionThree patternDb) {
        ReportPattern pattern = reportPatternRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("report pattern witch id=%s not found for update", id))
                );
        pattern.setPatternSectionThree(patternDb);
        reportPatternRepository.save(pattern);
    }
}
