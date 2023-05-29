package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.client.pattern_servicce.TitlePatternDto;
import ru.nabokov.docservice.model.title.Footer;

public interface FooterService {

    Footer save(TitlePatternDto textCentered);
}
