package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.title.ObjectDataDto;
import ru.nabokov.docservice.dto.TextCenteredDto;
import ru.nabokov.docservice.model.TextCentered;

public interface TextCenteredService {

    TextCentered save(ObjectDataDto objectData, TextCenteredDto textCentered);
}
