package ru.nabokov.patternservice.service.section;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.PatternSectionSix;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionSixRepository;
import ru.nabokov.patternservice.service.HeaderService;
import ru.nabokov.patternservice.service.ReportPatternService;
import ru.nabokov.patternservice.service.SubheadingService;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatternSectionSixServiceImpl implements PatternSectionSixService {

    private final PatternSectionSixRepository repository;
    private final ReportPatternService reportPatternService;
    private final ReportPatternForSectionsService sectionsService;
    private final SubheadingService subheadingService;
    private final HeaderService headerService;

    @Override
    public ReportPatternDto save(NewPatternSectionDto patternDto) {
        ReportPattern pattern = sectionsService.get(patternDto.getReportPatternId());
        PatternSectionSix section = new PatternSectionSix();
        section.setHeader(headerService.save(patternDto.getHeader()));
        section.setSubheadings(subheadingService.save(patternDto.getSubheadings()));
        pattern.setPatternSectionSix(repository.save(section));
        return reportPatternService.save(pattern);
    }

    @Override
    public ReportPatternDto update(UpdatePatternSectionDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section six witch id=%s not found for update", patternDto.getId())
            );
        }
        ReportPattern pattern = sectionsService.get(patternDto.getReportPatternId());
        PatternSectionSix section = new PatternSectionSix();
        section.setHeader(headerService.update(patternDto.getHeader()));
        section.setSubheadings(subheadingService.update(patternDto.getSubheadings()));
        pattern.setPatternSectionSix(repository.save(section));
        return reportPatternService.save(pattern);
    }
}
