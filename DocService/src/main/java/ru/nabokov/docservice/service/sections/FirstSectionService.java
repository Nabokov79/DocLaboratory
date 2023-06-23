package ru.nabokov.docservice.service.sections;

import ru.nabokov.docservice.dto.ReportDataBuilder;
import ru.nabokov.docservice.model.FirstSection;

public interface FirstSectionService {

    FirstSection save(ReportDataBuilder builder);
}
