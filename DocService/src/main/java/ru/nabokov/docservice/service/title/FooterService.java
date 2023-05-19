package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.client.pattern.TextCenteredDto;
import ru.nabokov.docservice.model.title.Footer;

public interface FooterService {

    Footer save(TextCenteredDto textCentered);
}
