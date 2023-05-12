package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.ObjectDataDto;
import ru.nabokov.docservice.dto.pattern.TextCenteredDto;
import ru.nabokov.docservice.model.TextCentered;

public interface TextCenteredService {

    TextCentered save(ObjectDataDto objectData, TextCenteredDto textCentered);
}
