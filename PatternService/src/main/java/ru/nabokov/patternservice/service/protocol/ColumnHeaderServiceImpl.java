package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.columnHeader.NewColumnHeaderDto;
import ru.nabokov.patternservice.dto.columnHeader.UpdateColumnHeaderDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.ColumnHeaderMapper;
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
    private final ColumnHeaderMapper mapper;

    @Override
    public List<ColumnHeader> save(List<NewColumnHeaderDto> columnHeadersDto) {
        return repository.saveAll(mapper.mapToNewColumnHeader(columnHeadersDto));
    }

    @Override
    public List<ColumnHeader> update(List<UpdateColumnHeaderDto> columnHeadersDto) {
        validateIds(columnHeadersDto.stream().map(UpdateColumnHeaderDto::getId).toList());
        return repository.saveAll(mapper.mapToUpdateColumnHeader(columnHeadersDto));
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
