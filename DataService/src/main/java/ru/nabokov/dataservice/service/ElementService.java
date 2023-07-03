package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.element.ElementDto;
import ru.nabokov.dataservice.dto.element.NewElementDto;
import ru.nabokov.dataservice.dto.element.UpdateElementDto;
import java.util.List;

public interface ElementService {

    List<ElementDto> save(List<NewElementDto> elementsDto);

    List<ElementDto> update(List<UpdateElementDto> elementsDto);
}
