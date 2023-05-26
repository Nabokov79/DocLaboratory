package ru.nabokov.patternservice.service.section;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.title.NewTitlePageDataDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.title.UpdateTitlePageDataDto;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.TitlePatternMapper;
import ru.nabokov.patternservice.repository.TitlePatternRepository;
import ru.nabokov.patternservice.service.ReportPatternService;

@Service
@RequiredArgsConstructor
public class TitlePatternServiceImpl implements TitlePatternService {

    private final TitlePatternRepository repository;
    private final TitlePatternMapper mapper;
    private final ReportPatternService reportPatternService;

    @Override
    public ReportPatternDto save(NewTitlePageDataDto titlePageDataDto) {
        if (repository.existsByTypeId(titlePageDataDto.getTypeId())) {
            throw new BadRequestException(
                    String.format("title page data for typeId=%s found", titlePageDataDto.getTypeId())
            );
        }
        return reportPatternService.addTitlePattern(titlePageDataDto.getTypeId()
                                       , repository.save(mapper.mapToNewTitlePageData(titlePageDataDto)));
    }

    @Override
    public ReportPatternDto update(UpdateTitlePageDataDto  titlePageDataDto) {
        if (!repository.existsById(titlePageDataDto.getId())) {
            throw new NotFoundException(
                             String.format("Report pattern witch id=%s not found for update",  titlePageDataDto.getId())
            );
        }
        return  reportPatternService.addTitlePattern(titlePageDataDto.getTypeId()
                                                  , repository.save(mapper.mapToUpdateTitlePageData(titlePageDataDto)));
    }
}
