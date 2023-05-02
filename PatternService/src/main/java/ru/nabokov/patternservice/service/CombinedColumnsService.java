package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.CombinedColumns;

public interface CombinedColumnsService {

    CombinedColumns save(CombinedColumns columns);

    CombinedColumns update(CombinedColumns columns);
}
