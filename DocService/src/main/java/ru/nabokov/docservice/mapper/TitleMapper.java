package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.docservice.dto.title.OrganizationDto;
import ru.nabokov.docservice.dto.TextCenteredDto;
import ru.nabokov.docservice.model.Footer;
import ru.nabokov.docservice.model.TextCentered;
import ru.nabokov.docservice.model.TitleHeader;

@Mapper(componentModel = "spring")
public interface TitleMapper {

    TitleHeader mapToTitleHeader(OrganizationDto organization);

    TextCentered mapToTextCentered(TextCenteredDto textCenteredDto);

    Footer mapToFooter(TextCenteredDto textCenteredDto);
}
