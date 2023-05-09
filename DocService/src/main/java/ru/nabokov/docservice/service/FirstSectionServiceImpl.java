package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.EmployeeDto;
import ru.nabokov.docservice.dto.PatternSectionOneDto;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.model.FirstSection;
import ru.nabokov.docservice.repository.FirstSectionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstSectionServiceImpl implements FirstSectionService {

    private final FirstSectionRepository repository;
    private final DataFirstSectionService dataFirstSectionService;

    @Override
    public FirstSection save(BranchDto branch, PatternSectionOneDto pattern, List<EmployeeDto> employees, String license) {
        FirstSection section = new FirstSection();
        section.setHeading(String.join(". ", String.valueOf(pattern.getHeader().getNumber()),
                                                      pattern.getHeader().getHeading()));
        dataFirstSectionService.save(repository.save(section), pattern.getSubheadings(), branch, employees, license);
        return null;
    }
}
