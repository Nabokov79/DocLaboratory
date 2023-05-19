package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.ObjectDataDto;
import ru.nabokov.docservice.dto.client.pattern.TextCenteredDto;
import ru.nabokov.docservice.model.title.TextCentered;

public interface TextCenteredService {

    TextCentered save(ObjectDataDto objectData, TextCenteredDto textCentered);
}
