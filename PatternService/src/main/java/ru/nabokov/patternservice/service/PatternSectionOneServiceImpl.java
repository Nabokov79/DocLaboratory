package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionOneDto;
import ru.nabokov.patternservice.dto.section.PatternSectionOneDto;
import ru.nabokov.patternservice.dto.subheading.SubheadingSectionOneDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionOneDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternSectionOneMapper;
import ru.nabokov.patternservice.model.PatternSectionOne;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionOneRepository;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatternSectionOneServiceImpl implements PatternSectionOneService {

    private final PatternSectionOneRepository repository;
    private final PatternSectionOneMapper mapper;
    private final ReportPatternRepository reportPatternRepository;
    private final SubheadingService subheadingService;
    private final HeaderService headerService;

    @Override
    public PatternSectionOneDto save(NewPatternSectionOneDto patternDto) {
        log.info(patternDto.toString());
        if (!reportPatternRepository.existsById(patternDto.getReportPatternId())) {
            throw new NotFoundException(String.format("report pattern witch id=%s not found for section one",
                                                                            patternDto.getReportPatternId())
            );
        }
        PatternSectionOne pattern = new PatternSectionOne();
        pattern.setHeader(headerService.save(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.saveAll(patternDto.getSubheadings()));
        PatternSectionOne patternDb = repository.save(pattern);
        log.info(patternDb.toString());
        updateReportPattern(patternDto.getReportPatternId(), patternDb);
        PatternSectionOneDto patternSectionOneDto = mapper.mapToPatternSectionOneDto(patternDb);
        log.info(patternSectionOneDto.toString());
        patternSectionOneDto.setSubheadings(patternSectionOneDto.getSubheadings().stream()
                                      .sorted(Comparator.comparing(SubheadingSectionOneDto::getNumber)).toList());
        return patternSectionOneDto;
    }

    @Override
    public PatternSectionOneDto update(UpdatePatternSectionOneDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section one witch id=%s not found for update", patternDto.getId())
            );
        }
        PatternSectionOne pattern = mapper.mapToPatternSectionOne(patternDto);
        pattern.setHeader(headerService.update(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.updateAll(patternDto.getSubheadings()));
        return mapper.mapToPatternSectionOneDto(repository.save(pattern));
    }

    @Override
    public PatternSectionOneDto get(Long patId) {
        return mapper.mapToPatternSectionOneDto(
                repository.findById(patId).orElseThrow(() -> new NotFoundException(
                        String.format("pattern section one witch id=%s not found", patId)))
        );
    }

    private void updateReportPattern(Long id, PatternSectionOne patternDb) {
        ReportPattern pattern = reportPatternRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("report pattern witch id=%s not found for update", id))
                );
        pattern.setPatternSectionOne(patternDb);
        reportPatternRepository.save(pattern);
    }
}
