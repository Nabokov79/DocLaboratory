package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.Element;
import java.util.List;

public interface ElementService {

    void save(List<Element> elements);

    void update(List<Element> elements);
}
