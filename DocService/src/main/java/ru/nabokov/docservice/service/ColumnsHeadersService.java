package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.pattern.ColumnHeaderDto;
import ru.nabokov.docservice.model.ColumnsHeaders;

import java.util.List;

public interface ColumnsHeadersService {

    List<ColumnsHeaders> save(List<ColumnHeaderDto> columnHeadersDto);
}
