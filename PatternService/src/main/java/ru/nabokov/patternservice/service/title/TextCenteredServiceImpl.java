package ru.nabokov.patternservice.service.title;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.TitlePageData;
import ru.nabokov.patternservice.repository.TextCenteredRepository;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TextCenteredServiceImpl implements TextCenteredService {

    private final TextCenteredRepository repository;

    @Override
    public TitlePageData save(TitlePageData textCentered) {
        textCentered.setReportName(textCentered.getReportName().toUpperCase());
        textCentered.setYear(String.valueOf(LocalDate.now().getYear()));
        return repository.save(textCentered);
    }

    @Override
    public TitlePageData update(TitlePageData textCentered) {
        if (!repository.existsById(textCentered.getId())) {
            throw new NotFoundException(String.format("Text centered witch id=%s not found", textCentered.getId()));
        }
        return repository.save(textCentered);
    }
}
