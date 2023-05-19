package ru.nabokov.patternservice.service.title;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.NewTitlePageDataDto;
import ru.nabokov.patternservice.dto.TitlePatternDto;
import ru.nabokov.patternservice.dto.UpdateTitlePatternDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.TitlePatternMapper;
import ru.nabokov.patternservice.model.TitlePattern;
import ru.nabokov.patternservice.repository.TitlePatternRepository;
import ru.nabokov.patternservice.service.ReportPatternService;

@Service
@RequiredArgsConstructor
public class TitlePatternServiceImpl implements TitlePatternService {

    private final TitlePatternRepository repository;
    private final TextCenteredService textCenteredService;
    private final TitlePatternMapper mapper;
    private final ReportPatternService reportPatternService;

    @Override
    public TitlePatternDto save(NewTitlePageDataDto textCenteredDto) {
        TitlePattern pattern = new TitlePattern();
        pattern.setTitlePageData(textCenteredService.save(mapper.mapToTextCentered(textCenteredDto)));
        TitlePattern titlePatternDb = repository.save(pattern);
        reportPatternService.save(textCenteredDto.getTypeId(), titlePatternDb);
        return mapper.mapToTitlePatternDto(titlePatternDb);
    }

    @Override
    public TitlePatternDto update(UpdateTitlePatternDto titlePatternDto) {
        if (!repository.existsById(titlePatternDto.getId())) {
            throw new NotFoundException(
                             String.format("Report pattern witch id=%s not found for update", titlePatternDto.getId())
            );
        }
        TitlePattern pattern = new TitlePattern();
        pattern.setTitlePageData(textCenteredService.update(titlePatternDto.getTitlePageData()));
        return mapper.mapToTitlePatternDto(repository.save(pattern));
    }
}
