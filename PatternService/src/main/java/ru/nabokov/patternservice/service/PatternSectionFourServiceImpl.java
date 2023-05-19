package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionFourDto;
import ru.nabokov.patternservice.dto.section.PatternSectionFourDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionFourDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternSectionFourMapper;
import ru.nabokov.patternservice.model.PatternSectionFour;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionFourRepository;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatternSectionFourServiceImpl implements PatternSectionFourService {

    private final PatternSectionFourRepository repository;
    private final PatternSectionFourMapper mapper;
    private final ReportPatternRepository reportPatternRepository;

    @Override
    public PatternSectionFourDto save(NewPatternSectionFourDto patternDto) {
        log.info(patternDto.toString());
        PatternSectionFour pattern = repository.save(mapper.mapToNewPatternSectionFourDto(patternDto));
        updateReportPattern(patternDto.getReportPatternId(), pattern);
        PatternSectionFourDto patternSectionFourDto = mapper.mapToPatternSectionFourDto((pattern));
        log.info(patternSectionFourDto.toString());
        return patternSectionFourDto;
    }

    @Override
    public PatternSectionFourDto update(UpdatePatternSectionFourDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                            String.format("Pattern section four witch id=%s not found for update", patternDto.getId()));
        }
        PatternSectionFour pattern = mapper.mapToUpdatePatternSectionFourDto(patternDto);
        return mapper.mapToPatternSectionFourDto(repository.save(pattern));
    }

    @Override
    public PatternSectionFourDto get(Long patId) {
        return mapper.mapToPatternSectionFourDto(
                repository.findById(patId)
                          .orElseThrow(() ->  new NotFoundException(
                                  String.format("Pattern section four witch id=%s not found",patId)))
        );
    }

    private void updateReportPattern(Long id, PatternSectionFour patternDb) {
        ReportPattern pattern = reportPatternRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("report pattern witch id=%s not found for update", id))
                );
        pattern.setPatternSectionFour(patternDb);
        reportPatternRepository.save(pattern);
    }
}
