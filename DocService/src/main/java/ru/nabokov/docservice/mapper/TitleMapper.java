package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.docservice.dto.OrganizationDto;
import ru.nabokov.docservice.dto.client.pattern.TextCenteredDto;
import ru.nabokov.docservice.model.title.Footer;
import ru.nabokov.docservice.model.title.TextCentered;
import ru.nabokov.docservice.model.title.TitleHeader;

@Mapper(componentModel = "spring")
public interface TitleMapper {

    TitleHeader mapToTitleHeader(OrganizationDto organization);

    TextCentered mapToTextCentered(TextCenteredDto textCenteredDto);

    Footer mapToFooter(TextCenteredDto textCenteredDto);
}
