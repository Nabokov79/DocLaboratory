package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.Documentation;
import ru.nabokov.patternservice.model.Subheading;
import java.util.List;

public interface DocumentationService {

    void save(Subheading subheading, List<Documentation> documentations);

    void update(List<Documentation> documentations);
}
