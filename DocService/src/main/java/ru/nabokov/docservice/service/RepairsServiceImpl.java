package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.passport.RepairDto;
import ru.nabokov.docservice.mapper.SectionMapper;
import ru.nabokov.docservice.model.Repair;
import ru.nabokov.docservice.model.RepairsTable;
import ru.nabokov.docservice.repository.RepairsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairsServiceImpl implements RepairsService {

    private final RepairsRepository repository;
    private final SectionMapper sectionMapper;

    @Override
    public List<Repair> save(RepairsTable repairsTable, List<RepairDto> repairsDto) {
        List<Repair> repairs = new ArrayList<>();
        for (RepairDto repairDto : repairsDto) {
            Repair repair = sectionMapper.mapToRepairs(repairDto);
            repair.setRepairsTable(repairsTable);
            repairs.add(repair);
        }
        return repository.saveAll(repairs);
    }
}
