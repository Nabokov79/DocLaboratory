package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.CombinedColumns;
import ru.nabokov.patternservice.repository.CombinedColumnsRepository;

@Service
@RequiredArgsConstructor
public class CombinedColumnsServiceImpl implements CombinedColumnsService {

    private final CombinedColumnsRepository repository;

    @Override
    public CombinedColumns save(CombinedColumns columns) {
        validate(columns);
        return repository.save(columns);
    }

    @Override
    public CombinedColumns update(CombinedColumns columns) {
        if (!repository.existsById(columns.getId())) {
            throw new NotFoundException(
                    String.format("CombinedColumn with id=%s not found for update", columns.getId())
            );
        }
        validate(columns);
        return repository.save(columns);
    }

    private void validate(CombinedColumns columns) {
        if (columns.getNumberFirst() == null) {
            throw new BadRequestException("number first should not be blank");
        }
        if (columns.getNumberFirst() <= 0) {
            throw new BadRequestException("number first can only be positive");
        }
        if (columns.getNumberSecond() == null) {
            throw new BadRequestException("number second should not be blank");
        }
        if (columns.getNumberSecond() <= 0) {
            throw new BadRequestException("number second can only be positive");
        }
        if (columns.getName() == null) {
            throw new BadRequestException("column name should not be blank");
        }
    }
}
