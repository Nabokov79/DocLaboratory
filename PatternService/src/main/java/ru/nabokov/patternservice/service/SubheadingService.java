package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.Subheading;
import java.util.List;

public interface SubheadingService {

    List<Subheading> saveAll(List<Subheading> subheadings);

    List<Subheading> updateAll(List<Subheading> subheadings);
}
