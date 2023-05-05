package ru.nabokov.docservice.service.title;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.TextCenteredDto;
import ru.nabokov.docservice.exceptions.BadRequestException;
import ru.nabokov.docservice.mapper.TitleMapper;
import ru.nabokov.docservice.model.Footer;
import ru.nabokov.docservice.repository.FooterRepository;

@Service
@RequiredArgsConstructor
public class FooterServiceImpl implements FooterService {

    private final FooterRepository repository;
    private final TitleMapper mapper;

    @Override
    public Footer save(TextCenteredDto textCentered) {
        if (textCentered != null) {
            return repository.save(mapper.mapToFooter(textCentered));
        }
       return  null;
    }
}
