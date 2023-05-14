package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.passport.RepairDto;
import ru.nabokov.docservice.dto.pattern.SubheadingThreeDto;
import ru.nabokov.docservice.model.RepairsTable;
import ru.nabokov.docservice.repository.RepairsTableRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairsTableServiceImpl implements RepairsTableService {

    private final RepairsTableRepository repository;
    private final RepairsService repairsService;
    private final ColumnsHeadersService columnsHeadersService;
    private final StringBuilderService stringBuilder;

    @Override
    public RepairsTable save(SubheadingThreeDto subheadingDto, List<RepairDto> repairs) {
        RepairsTable repairsTable = new RepairsTable();
        repairsTable.setHeading(stringBuilder.toStringSubheading(subheadingDto.getNumber(), subheadingDto.getHeading()));
        repairsTable.setColumnHeaders(columnsHeadersService.save(subheadingDto.getColumnHeaders()));
        repairsTable.setRepairs(repairsService.save(repository.save(repairsTable), repairs));
        return repairsTable;
    }
}
