package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.element.NewElementDto;
import ru.nabokov.patternservice.dto.element.UpdateElementDto;
import ru.nabokov.patternservice.model.Element;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ElementMapper {

    List<Element> mapToNewElements(List<NewElementDto> elementsDto);

    List<Element> mapToUpdateElements(List<UpdateElementDto> elementsDto);
}
