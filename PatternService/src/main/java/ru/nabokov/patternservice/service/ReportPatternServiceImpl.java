package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.ReportPatternMapper;
import ru.nabokov.patternservice.model.*;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

@Service
@RequiredArgsConstructor
public class ReportPatternServiceImpl implements ReportPatternService {

    private final ReportPatternRepository repository;
    private final ReportPatternMapper mapper;

    @Override
    public ReportPatternDto addTitlePattern(Long typeId, TitlePattern titlePattern) {
        ReportPattern pattern = new ReportPattern();
        pattern.setTypeId(typeId);
        pattern.setTitlePattern(titlePattern);
        return mapper.mapToReportPatternDto(repository.save(pattern));
    }
    @Override
   public ReportPattern get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("report pattern section five witch id=%s not found for update", id))
                );
    }

    @Override
    public ReportPatternDto save(ReportPattern pattern) {
        return mapper.mapToReportPatternDto(repository.save(pattern));
    }

    @Override
    public ReportPatternDto update(ReportPattern pattern) {
        return mapper.mapToReportPatternDto(repository.save(pattern));
    }
}
