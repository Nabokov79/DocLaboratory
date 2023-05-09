package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.EmployeeDto;
import ru.nabokov.docservice.dto.PatternSectionOneDto;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.model.FirstSection;

import java.util.List;

public interface FirstSectionService {

    FirstSection save(BranchDto branch, PatternSectionOneDto pattern, List<EmployeeDto> employees, String license);
}
