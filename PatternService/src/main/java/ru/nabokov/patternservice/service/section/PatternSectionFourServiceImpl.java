package ru.nabokov.patternservice.service.section;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.section.NewPatternSectionDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.PatternSectionFour;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.PatternSectionFourRepository;
import ru.nabokov.patternservice.service.HeaderService;
import ru.nabokov.patternservice.service.ReportPatternService;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatternSectionFourServiceImpl implements PatternSectionFourService {

    private final PatternSectionFourRepository repository;
    private final HeaderService headerService;
    private final ReportPatternService reportPatternService;
    private final ReportPatternForSectionsService sectionsService;

    @Override
    public ReportPatternDto save(NewPatternSectionDto patternDto) {
        ReportPattern pattern = sectionsService.get(patternDto.getReportPatternId());
        PatternSectionFour section = new PatternSectionFour();
        section.setHeader(headerService.save(patternDto.getHeader()));
        pattern.setPatternSectionFour(repository.save(section));
        return reportPatternService.save(pattern);
    }

    @Override
    public ReportPatternDto update(UpdatePatternSectionDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                            String.format("Pattern section four witch id=%s not found for update", patternDto.getId()));
        }
        ReportPattern pattern = sectionsService.get(patternDto.getReportPatternId());
        PatternSectionFour section = new PatternSectionFour();
        section.setHeader(headerService.update(patternDto.getHeader()));
        pattern.setPatternSectionFour(repository.save(section));
        return reportPatternService.save(pattern);
    }

    @Override
    public PatternSectionFour get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Pattern section four with id=%s not found", id)));
    }

    @Override
    public ReportPatternDto addProtocol(Long patternId, PatternSectionFour section) {
        ReportPattern pattern = sectionsService.get(patternId);
        pattern.setPatternSectionFour(section);
        return reportPatternService.save(pattern);
    }
}
