package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.pattern.ColumnHeaderDto;
import ru.nabokov.docservice.mapper.SectionMapper;
import ru.nabokov.docservice.model.ColumnsHeaders;
import ru.nabokov.docservice.repository.ColumnsHeadersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColumnsHeadersServiceImpl implements ColumnsHeadersService {

    private final ColumnsHeadersRepository repository;
    private final SectionMapper sectionMapper;

    @Override
    public List<ColumnsHeaders> save(List<ColumnHeaderDto> columnHeadersDto) {
        return repository.saveAll(sectionMapper.mapToColumnsHeaders(columnHeadersDto));
    }
}
