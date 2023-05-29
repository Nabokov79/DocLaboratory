package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.docservice.dto.client.data_service.OrganizationDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.TitlePatternDto;
import ru.nabokov.docservice.model.title.Footer;
import ru.nabokov.docservice.model.title.TextCentered;
import ru.nabokov.docservice.model.title.TitleHeader;

@Mapper(componentModel = "spring")
public interface TitleMapper {

    TitleHeader mapToTitleHeader(OrganizationDto organization);

    TextCentered mapToTextCentered(TitlePatternDto textCenteredDto);

    Footer mapToFooter(TitlePatternDto textCenteredDto);
}
