package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.combinedColumns.NewCombinedColumnsDto;
import ru.nabokov.patternservice.dto.combinedColumns.UpdateCombinedColumnsDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.CombinedColumnsMapper;
import ru.nabokov.patternservice.model.CombinedColumns;
import ru.nabokov.patternservice.repository.CombinedColumnsRepository;

@Service
@RequiredArgsConstructor
public class CombinedColumnsServiceImpl implements CombinedColumnsService {

    private final CombinedColumnsRepository repository;
    private final CombinedColumnsMapper mapper;

    @Override
    public CombinedColumns save(NewCombinedColumnsDto columnsDto) {
        return repository.save(mapper.mapToNewCombinedColumns(columnsDto));
    }

    @Override
    public CombinedColumns update(UpdateCombinedColumnsDto columnsDto) {
        if (!repository.existsById(columnsDto.getId())) {
            throw new NotFoundException(
                    String.format("CombinedColumn with id=%s not found for update", columnsDto.getId())
            );
        }
        return repository.save(mapper.mapToUpdateCombinedColumns(columnsDto));
    }
}
