package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.pattern.TextCenteredDto;
import ru.nabokov.docservice.model.Footer;

public interface FooterService {

    Footer save(TextCenteredDto textCentered);
}
