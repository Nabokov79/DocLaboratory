package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.EmployeeDto;
import ru.nabokov.docservice.dto.SubheadingDto;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.model.FirstSection;
import java.util.List;

public interface DataFirstSectionService {

    void save(FirstSection section, List<SubheadingDto> subheadingsDto, BranchDto branch, List<EmployeeDto> employeesDto, String license);
}
