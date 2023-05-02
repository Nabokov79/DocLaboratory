package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.Drawing;
import ru.nabokov.patternservice.model.PatternSectionSeven;
import java.util.List;

public interface DrawingService {

    void save(PatternSectionSeven pattern, List<Drawing> drawings);

    void update(PatternSectionSeven pattern, List<Drawing> drawings);
}
