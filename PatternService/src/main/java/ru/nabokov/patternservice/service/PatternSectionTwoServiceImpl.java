package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionTwoDto;
import ru.nabokov.patternservice.dto.section.PatternSectionTwoDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionTwoDto;
import ru.nabokov.patternservice.dto.subheading.SubheadingDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternSectionTwoMapper;
import ru.nabokov.patternservice.model.PatternSectionTwo;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionTwoRepository;
import ru.nabokov.patternservice.repository.ReportPatternRepository;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatternSectionTwoServiceImpl implements PatternSectionTwoService {

    private final PatternSectionTwoRepository repository;
    private final PatternSectionTwoMapper mapper;
    private final ReportPatternRepository reportPatternRepository;
    private final SubheadingService subheadingService;
    private final HeaderService headerService;

    @Override
    public PatternSectionTwoDto save(NewPatternSectionTwoDto patternDto) {
        log.info(patternDto.toString());
        if (!reportPatternRepository.existsById(patternDto.getReportPatternId())) {
            throw new NotFoundException(String.format("report pattern witch id=%s not found for section two",
                    patternDto.getReportPatternId())
            );
        }
        PatternSectionTwo pattern = new  PatternSectionTwo();
        pattern.setHeader(headerService.save(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.saveAll(patternDto.getSubheadings()));
        PatternSectionTwo patternDb = repository.save(pattern);
        updateReportPattern(patternDto.getReportPatternId(), patternDb);
        PatternSectionTwoDto patternSectionTwoDto = mapper.mapToPatternSectionTwoDto(patternDb);
        patternSectionTwoDto.setSubheadings(patternSectionTwoDto.getSubheadings()
                                             .stream().sorted(Comparator.comparing(SubheadingDto::getNumber)).toList());
        log.info(patternSectionTwoDto.toString());
        return patternSectionTwoDto;
    }

    @Override
    public PatternSectionTwoDto update(UpdatePatternSectionTwoDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section two witch id=%s not found for update", patternDto.getId())
            );
        }
        PatternSectionTwo pattern = mapper.mapToPatternSectionTwo(patternDto);
        pattern.setHeader(headerService.update(patternDto.getHeader()));
        pattern.setSubheadings(subheadingService.updateAll(patternDto.getSubheadings()));
        PatternSectionTwoDto patternSectionTwoDto = mapper.mapToPatternSectionTwoDto(repository.save(pattern));
        patternSectionTwoDto.setSubheadings(patternSectionTwoDto.getSubheadings()
                                             .stream().sorted(Comparator.comparing(SubheadingDto::getNumber)).toList());
        return patternSectionTwoDto;
    }

    @Override
    public PatternSectionTwoDto get(Long patId) {
        return mapper.mapToPatternSectionTwoDto(
                repository.findById(patId).orElseThrow(() -> new NotFoundException(
                        String.format("pattern section two witch id=%s not found", patId)))
        );
    }

    private void updateReportPattern(Long id, PatternSectionTwo patternDb) {
        ReportPattern pattern = reportPatternRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("report pattern witch id=%s not found for update", id))
                );
        pattern.setPatternSectionTwo(patternDb);
        reportPatternRepository.save(pattern);
    }
}
