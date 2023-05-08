package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.NewPatternSectionOneDto;
import ru.nabokov.patternservice.dto.PatternSectionOneDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionOneDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternSectionOneMapper;
import ru.nabokov.patternservice.model.PatternSectionOne;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionOneRepository;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

@Service
@RequiredArgsConstructor
public class PatternSectionOneServiceImpl implements PatternSectionOneService {

    private final PatternSectionOneRepository repository;
    private final PatternSectionOneMapper mapper;
    private final ReportPatternRepository reportPatternRepository;
    private final SubheadingService subheadingService;
    private final HeaderService headerService;

    @Override
    public PatternSectionOneDto save(NewPatternSectionOneDto patternDto) {
        if (!reportPatternRepository.existsById(patternDto.getReportPatternId())) {
            throw new NotFoundException(String.format("report pattern witch id=%s not found for section one",
                                                                            patternDto.getReportPatternId())
            );
        }
        PatternSectionOne pattern = new PatternSectionOne();
        pattern.setHeader(headerService.save(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.saveAll(pattern.getSubheadings()));
        PatternSectionOne patternDb = repository.save(pattern);
        updateReportPattern(patternDto.getReportPatternId(), patternDb);
        return mapper.mapToPatternSectionOneDto(patternDb);
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
        pattern.setSubheadings(subheadingService.updateAll(pattern.getSubheadings()));
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
