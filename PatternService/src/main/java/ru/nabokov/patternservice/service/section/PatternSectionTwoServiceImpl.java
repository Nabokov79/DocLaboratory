package ru.nabokov.patternservice.service.section;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.PatternSectionTwo;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionTwoRepository;
import ru.nabokov.patternservice.service.HeaderService;
import ru.nabokov.patternservice.service.ReportPatternService;
import ru.nabokov.patternservice.service.SubheadingService;

@Service
@RequiredArgsConstructor
public class PatternSectionTwoServiceImpl implements PatternSectionTwoService {

    private final PatternSectionTwoRepository repository;
    private final ReportPatternService reportPatternService;
    private final SubheadingService subheadingService;
    private final HeaderService headerService;

    @Override
    public ReportPatternDto save(NewPatternSectionDto patternDto) {
        ReportPattern pattern = reportPatternService.get(patternDto.getReportPatternId());
        PatternSectionTwo section = new PatternSectionTwo();
        section.setHeader(headerService.save(patternDto.getHeader()));
        section.setSubheadings(subheadingService.save(patternDto.getSubheadings()));
        pattern.setPatternSectionTwo(repository.save(section));
        return reportPatternService.save(pattern);
    }

    @Override
    public ReportPatternDto update(UpdatePatternSectionDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section two witch id=%s not found for update", patternDto.getId())
            );
        }
        ReportPattern pattern = reportPatternService.get(patternDto.getReportPatternId());
        PatternSectionTwo section = new PatternSectionTwo();
        section.setHeader(headerService.update(patternDto.getHeader()));
        section.setSubheadings(subheadingService.update(patternDto.getSubheadings()));
        pattern.setPatternSectionTwo(repository.save(section));
        return reportPatternService.update(pattern);
    }
}
