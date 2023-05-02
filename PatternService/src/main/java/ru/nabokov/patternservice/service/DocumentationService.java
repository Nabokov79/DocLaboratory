package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.Documentation;
import ru.nabokov.patternservice.model.Subheading;
import java.util.List;
import java.util.Map;

public interface DocumentationService {

    void save(List<Subheading> subheadings, Map<String, Subheading> subheadingsDb);

    void update(List<Documentation> documentations);
}
