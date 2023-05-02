package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.PatternTable;

public interface PatternTableService {

    PatternTable save(PatternTable table);

    PatternTable update(PatternTable table);
}
