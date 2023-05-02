package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.ColumnHeader;
import java.util.List;

public interface ColumnHeaderService {

    List<ColumnHeader> save(List<ColumnHeader> columnHeaders);

    List<ColumnHeader> update(List<ColumnHeader> columnHeaders);
}
