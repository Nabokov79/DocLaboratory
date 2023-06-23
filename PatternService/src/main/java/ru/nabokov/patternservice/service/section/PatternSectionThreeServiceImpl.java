package ru.nabokov.patternservice.service.section;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.PatternSectionThree;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionThreeRepository;
import ru.nabokov.patternservice.service.HeaderService;
import ru.nabokov.patternservice.service.ReportPatternService;
import ru.nabokov.patternservice.service.SubheadingService;

@Service
@RequiredArgsConstructor
public class PatternSectionThreeServiceImpl implements PatternSectionThreeService {

    private final PatternSectionThreeRepository repository;
    private final ReportPatternService reportPatternService;
    private final ReportPatternForSectionsService sectionsService;
    private final HeaderService headerService;
    private final SubheadingService subheadingService;

    @Override
    public ReportPatternDto save(NewPatternSectionDto patternDto) {
        ReportPattern pattern = sectionsService.get(patternDto.getReportPatternId());
        PatternSectionThree section = new PatternSectionThree();
        section.setHeader(headerService.save(patternDto.getHeader()));
        section.setSubheadings(subheadingService.save(patternDto.getSubheadings()));
        pattern.setPatternSectionThree(repository.save(section));
        return reportPatternService.save(pattern);
    }

    @Override
    public ReportPatternDto update(UpdatePatternSectionDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section three witch id=%s not found for update", patternDto.getId())
            );
        }
        ReportPattern pattern = sectionsService.get(patternDto.getReportPatternId());
        PatternSectionThree section = new PatternSectionThree();
        section.setHeader(headerService.update(patternDto.getHeader()));
        section.setSubheadings(subheadingService.update(patternDto.getSubheadings()));
        pattern.setPatternSectionThree(repository.save(section));
        return reportPatternService.save(pattern);
    }
}
