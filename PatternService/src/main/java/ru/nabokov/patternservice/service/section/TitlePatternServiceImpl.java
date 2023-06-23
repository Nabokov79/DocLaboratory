package ru.nabokov.patternservice.service.section;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.title.NewTitlePageDataDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.title.UpdateTitlePageDataDto;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.TitlePatternMapper;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.repository.TitlePatternRepository;
import ru.nabokov.patternservice.service.ReportPatternService;

@Service
@RequiredArgsConstructor
public class TitlePatternServiceImpl implements TitlePatternService {

    private final TitlePatternRepository repository;
    private final TitlePatternMapper mapper;
    private final ReportPatternService reportPatternService;
    private final ReportPatternForSectionsService sectionsService;

    @Override
    public ReportPatternDto save(NewTitlePageDataDto titlePageDataDto) {
        ReportPattern pattern = new ReportPattern();
        if (repository.existsByTypeId(titlePageDataDto.getTypeId())) {
            throw new BadRequestException(
                    String.format("title page data for typeId=%s found", titlePageDataDto.getTypeId())
            );
        }
        pattern.setTypeId(titlePageDataDto.getTypeId());
        pattern.setTitlePattern(repository.save(mapper.mapToNewTitlePageData(titlePageDataDto)));
        return reportPatternService.save(pattern);
    }

    @Override
    public ReportPatternDto update(UpdateTitlePageDataDto  titlePageDataDto) {
        ReportPattern pattern = sectionsService.get(titlePageDataDto.getReportPatternId());
        if (!repository.existsById(titlePageDataDto.getId())) {
            throw new NotFoundException(
                             String.format("Report pattern witch id=%s not found for update",  titlePageDataDto.getId())
            );
        }
        pattern.setTitlePattern(repository.save(mapper.mapToUpdateTitlePageData(titlePageDataDto)));
        return reportPatternService.save(pattern);
    }
}
