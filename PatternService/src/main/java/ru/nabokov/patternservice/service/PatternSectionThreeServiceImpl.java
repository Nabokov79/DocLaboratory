package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.NewPatternSectionThreeDto;
import ru.nabokov.patternservice.dto.PatternSectionThreeDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionThreeDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternSectionThreeMapper;
import ru.nabokov.patternservice.model.PatternSectionThree;
import ru.nabokov.patternservice.model.PatternTable;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionThreeRepository;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatternSectionThreeServiceImpl implements PatternSectionThreeService {

    private final PatternSectionThreeRepository repository;
    private final PatternSectionThreeMapper mapper;
    private final ReportPatternRepository reportPatternRepository;
    private final PatternTableService patternTableService;
    private final HeaderService headerService;

    @Override
    public PatternSectionThreeDto save(NewPatternSectionThreeDto patternDto) {
        if (!reportPatternRepository.existsById(patternDto.getReportPatternId())) {
            throw new NotFoundException(String.format("report pattern witch id=%s not found for section three",
                    patternDto.getReportPatternId())
            );
        }
        PatternSectionThree pattern = new PatternSectionThree();
        pattern.setHeader(headerService.save(patternDto.getHeader()));
        List<PatternTable> tables = new ArrayList<>();
        for (PatternTable table : patternDto.getPatternTables()) {
            tables.add(patternTableService.save(table));
        }
        pattern.setPatternTables(tables);
        PatternSectionThree patternDb = repository.save(pattern);
        updateReportPattern(patternDto.getReportPatternId(), patternDb);
        return mapper.mapToPatternSectionThreeDto(patternDb);
    }

    @Override
    public PatternSectionThreeDto update(UpdatePatternSectionThreeDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section three witch id=%s not found for update", patternDto.getId())
            );
        }
        PatternSectionThree pattern = mapper.mapToPatternSectionThree(patternDto);
        pattern.setHeader(headerService.update(patternDto.getHeader()));
        List<PatternTable> tables = new ArrayList<>();
        for (PatternTable table : patternDto.getPatternTables()) {
            tables.add(patternTableService.update(table));
        }
        pattern.setPatternTables(tables);
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
