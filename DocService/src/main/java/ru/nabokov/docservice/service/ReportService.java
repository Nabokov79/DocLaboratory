package ru.nabokov.docservice.service;

import ru.nabokov.docservice.model.Report;

public interface ReportService {

    Report save(Long applicationId);
}
