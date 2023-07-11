package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.element.ElementDto;
import ru.nabokov.dataservice.dto.element.NewElementDto;
import ru.nabokov.dataservice.dto.element.UpdateElementDto;
import ru.nabokov.dataservice.model.Element;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ElementMapper {

    List<Element> mapToNewElements(List<NewElementDto> elementDto);

    List<Element> mapToUpdateElements(List<UpdateElementDto> elementDto);

    List<ElementDto> mapToElementsDto(List<Element> elements);
}
