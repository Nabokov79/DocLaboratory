package ru.nabokov.patternservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.Header;
import ru.nabokov.patternservice.repository.HeaderRepository;

@Service
@RequiredArgsConstructor
public class HeaderServiceImpl implements HeaderService {

    private final HeaderRepository repository;

    @Override
    public Header save(Header header) {
        validate(header);
        return repository.save(header);
    }

    @Override
    public Header update(Header header) {
        if (!repository.existsById(header.getId())) {
            throw new NotFoundException(String.format("header witch id=%s not found for update", header.getId()));
        }
        validate(header);
        return repository.save(header);
    }

    private void validate(Header header) {
        if (header.getNumber() <= 0) {
            throw new BadRequestException("header subheading can only be positive");
        }
        if (header.getHeading().length() < 1) {
            throw new BadRequestException("length header should not be less than one");
        }
    }
}
