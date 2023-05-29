package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.client.data_service.ObjectDataDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.TitlePatternDto;
import ru.nabokov.docservice.model.title.TextCentered;

public interface TextCenteredService {

    TextCentered save(ObjectDataDto objectData, TitlePatternDto textCentered);
}
