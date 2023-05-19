package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.ReportDataBuilder;
import ru.nabokov.docservice.model.title.Title;

public interface TitleService {

    Title save(ReportDataBuilder builder);
}
