package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.ReportDto;
import ru.nabokov.docservice.model.Report;

public interface ReportService {

    ReportDto save(Long applicationId);

    void update(Report report);

    Report get(Long id);
}
