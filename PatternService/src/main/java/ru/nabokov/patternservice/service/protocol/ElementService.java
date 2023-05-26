package ru.nabokov.patternservice.service.protocol;

import ru.nabokov.patternservice.dto.element.NewElementDto;
import ru.nabokov.patternservice.dto.element.UpdateElementDto;
import java.util.List;

public interface ElementService {

    void save(List<NewElementDto> elementsDto);

    void update(List<UpdateElementDto> elementsDto);
}
