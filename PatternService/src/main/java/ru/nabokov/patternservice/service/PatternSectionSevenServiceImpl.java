package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.NewPatternSectionSevenDto;
import ru.nabokov.patternservice.dto.PatternSectionSevenDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionSevenDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternSectionSevenMapper;
import ru.nabokov.patternservice.model.PatternSectionSeven;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionSevenRepository;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

@Service
@RequiredArgsConstructor
public class PatternSectionSevenServiceImpl implements PatternSectionSevenService {

    private final PatternSectionSevenRepository repository;
    private final PatternSectionSevenMapper mapper;
    private final ReportPatternRepository reportPatternRepository;
    private final DrawingService drawingService;
    private final HeaderService headerService;

    @Override
    public PatternSectionSevenDto save(NewPatternSectionSevenDto patternDto) {
        if (!reportPatternRepository.existsById(patternDto.getReportPatternId())) {
            throw new NotFoundException(String.format("report pattern witch id=%s not found for section seven",
                    patternDto.getReportPatternId())
            );
        }
        PatternSectionSeven pattern = mapper.mapToNewPatternSectionSeven(patternDto);
        pattern.setHeader(headerService.save(patternDto.getHeader()));
        PatternSectionSeven patternDb = repository.save(pattern);
        drawingService.save(patternDb, patternDto.getDrawings());
        updateReportPattern(patternDto.getReportPatternId(), pattern);
        return get(pattern.getId());
    }

    @Override
    public PatternSectionSevenDto update(UpdatePatternSectionSevenDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section seven witch id=%s not found for update", patternDto.getId())
            );
        }
        PatternSectionSeven pattern = mapper.mapToUpdatePatternSectionSeven(patternDto);
        pattern.setHeader(headerService.update(patternDto.getHeader()));
        PatternSectionSeven patternDb = repository.save(pattern);
        drawingService.update(patternDb, patternDto.getDrawings());
        return get(pattern.getId());
    }

    @Override
    public PatternSectionSevenDto get(Long patId) {
        return mapper.mapToPatternSectionSevenDto(
                repository.findById(patId).orElseThrow(() -> new NotFoundException(
                        String.format("pattern section seven witch id=%s not found", patId)))
        );
    }

    private void updateReportPattern(Long id, PatternSectionSeven patternDb) {
        ReportPattern pattern = reportPatternRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("report pattern section seven witch id=%s not found for update", id))
                );
        pattern.setPatternSectionSeven(patternDb);
        reportPatternRepository.save(pattern);
    }
}
