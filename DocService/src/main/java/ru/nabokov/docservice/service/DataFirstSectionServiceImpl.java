package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.*;
import ru.nabokov.docservice.dto.client.data_service.*;
import ru.nabokov.docservice.dto.client.pattern_servicce.*;
import ru.nabokov.docservice.model.DataFirstSection;
import ru.nabokov.docservice.model.FirstSection;
import ru.nabokov.docservice.repository.DataFirstSectionRepository;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataFirstSectionServiceImpl implements DataFirstSectionService {

    private final DataFirstSectionRepository repository;
    private final StringBuilderService stringBuilder;

    @Override
    public void save(FirstSection section, ReportDataBuilder builder) {
        List<DataFirstSection> dataFirstSections = new ArrayList<>();
        Map<Double, SubheadingSectionOneDto> subheadings = builder.getPattern().getSubheadings().stream()
                                                           .collect(Collectors.toMap(SubheadingSectionOneDto::getNumber, s -> s));
        for (SubheadingSectionOneDto subheadingDto : subheadings.values()) {
            DataFirstSection data = new DataFirstSection();
            data.setHeading(stringBuilder.toStringSubheading(subheadingDto.getNumber(), subheadingDto.getHeading()));
            if (data.getText() != null) {
                data.setText(subheadingDto.getText());
            } else {
                if (data.getDocumentations() == null) {
                    data.setLaboratoryData(stringBuilder.toStringLaboratoryData(builder.getBranch(), builder.getLicense()));
                    String employeeFirst = "";
                    String employeeSecond = "";
                    for (EmployeeDto employee : builder.getEmployees()) {
                        if (employeeFirst.isBlank()) {
                            employeeFirst = stringBuilder.toStringEmployees(employee);
                        } else {
                            employeeSecond = stringBuilder.toStringEmployees(employee);
                        }
                    }
                    data.setEmployeeFirst(employeeFirst);
                    data.setEmployeeSecond(employeeSecond);
                } else {
                    data.setDocumentations(stringBuilder.toStringDocumentation(builder.getDocumentations()));
                }
            }
            data.setSection(section);
            dataFirstSections.add(data);
        }
        repository.saveAll(dataFirstSections);
    }


}
