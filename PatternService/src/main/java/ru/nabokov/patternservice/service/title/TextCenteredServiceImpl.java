package ru.nabokov.patternservice.service.title;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.TextCentered;
import ru.nabokov.patternservice.repository.TextCenteredRepository;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TextCenteredServiceImpl implements TextCenteredService {

    private final TextCenteredRepository repository;

    @Override
    public TextCentered save(TextCentered textCentered) {
        textCentered.setReportName(textCentered.getReportName().toUpperCase());
        textCentered.setYear(String.valueOf(LocalDate.now().getYear()));
        return repository.save(textCentered);
    }

    @Override
    public TextCentered update(TextCentered textCentered) {
        if (!repository.existsById(textCentered.getId())) {
            throw new NotFoundException(String.format("Text centered witch id=%s not found", textCentered.getId()));
        }
        return repository.save(textCentered);
    }
}
