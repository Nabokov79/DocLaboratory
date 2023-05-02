package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.Drawing;
import ru.nabokov.patternservice.model.PatternSectionSeven;
import ru.nabokov.patternservice.repository.DrawingRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrawingServiceImpl implements DrawingService {

    private final DrawingRepository repository;

    @Override
    public void save(PatternSectionSeven pattern, List<Drawing> drawings) {
        if (drawings != null) {
            for (Drawing drawing : drawings) {
                drawing.setPatternSectionSeven(pattern);
            }
            repository.saveAll(drawings);
        }
    }

    @Override
    public void update(PatternSectionSeven pattern, List<Drawing> drawings) {
        validateIds(drawings.stream().map(Drawing::getId).toList());
        for (Drawing drawing : drawings) {
            drawing.setPatternSectionSeven(pattern);
        }
        repository.saveAll(drawings);
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Drawing> drawings = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Drawing::getId, d -> d));
        if (drawings.size() != ids.size() || drawings.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(drawings.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("drawings with ids= %s not found", ids));
        }
    }
}
