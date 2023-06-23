package ru.nabokov.patternservice.service.section;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.PatternSectionSeven;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionSevenRepository;
import ru.nabokov.patternservice.service.DrawingService;
import ru.nabokov.patternservice.service.HeaderService;
import ru.nabokov.patternservice.service.ReportPatternService;

@Service
@RequiredArgsConstructor
public class PatternSectionSevenServiceImpl implements PatternSectionSevenService {

    private final PatternSectionSevenRepository repository;
    private final ReportPatternService reportPatternService;
    private final ReportPatternForSectionsService sectionsService;
    private final DrawingService drawingService;
    private final HeaderService headerService;

    @Override
    public ReportPatternDto save(NewPatternSectionDto patternDto) {
        ReportPattern pattern = sectionsService.get(patternDto.getReportPatternId());
        PatternSectionSeven section = new PatternSectionSeven();
        section.setHeader(headerService.save(patternDto.getHeader()));
        pattern.setPatternSectionSeven(repository.save(section));
        section.setDrawings(drawingService.save(section, patternDto.getDrawings()));
        return reportPatternService.save(pattern);
    }

    @Override
    public ReportPatternDto update(UpdatePatternSectionDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("pattern section seven witch id=%s not found for update", patternDto.getId())
            );
        }
        ReportPattern pattern = sectionsService.get(patternDto.getReportPatternId());
        PatternSectionSeven section = new PatternSectionSeven();
        section.setHeader(headerService.update(patternDto.getHeader()));
        pattern.setPatternSectionSeven(repository.save(section));
        section.setDrawings(drawingService.update(section, patternDto.getDrawings()));
        return reportPatternService.save(pattern);
    }
}
