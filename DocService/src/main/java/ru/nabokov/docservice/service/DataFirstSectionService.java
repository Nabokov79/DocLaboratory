package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.ReportDataBuilder;
import ru.nabokov.docservice.model.FirstSection;

public interface DataFirstSectionService {

    void save(FirstSection section, ReportDataBuilder builder);
}
