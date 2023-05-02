package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.ColumnHeader;
import ru.nabokov.patternservice.repository.ColumnHeaderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColumnHeaderServiceImpl implements ColumnHeaderService {

    private final ColumnHeaderRepository repository;

    @Override
    public List<ColumnHeader> save(List<ColumnHeader> columnHeaders) {
        for (ColumnHeader header : columnHeaders) {
            validate(header);
        }
        return repository.saveAll(columnHeaders);
    }

    @Override
    public List<ColumnHeader> update(List<ColumnHeader> columnHeaders) {
        validateIds(columnHeaders.stream().map(ColumnHeader::getId).toList());
        for (ColumnHeader header : columnHeaders) {
            validate(header);
        }
        return repository.saveAll(columnHeaders);
    }

    private void validate(ColumnHeader columnHeader) {
        if (columnHeader.getHeading() == null) {
            throw new BadRequestException("column header cannot be blank");
        }
        if (columnHeader.getHeading().length() < 1) {
            throw new BadRequestException("length of the header cannot be less than one");
        }
        if (columnHeader.getNumber() == null) {
            throw new BadRequestException("number column cannot be blank");
        }
        if (columnHeader.getHeading().length() <= 0) {
            throw new BadRequestException("column number cannot be less than or equal to zero");
        }
    }

    private void validateIds(List<Long> ids) {
        Map<Long, ColumnHeader> columnHeaders = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(ColumnHeader::getId, d -> d));
        if (columnHeaders.size() != ids.size() || columnHeaders.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(columnHeaders.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("columnHeaders with ids= %s not found", ids));
        }
    }
}
