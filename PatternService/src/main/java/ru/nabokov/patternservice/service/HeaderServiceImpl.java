package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.header.NewHeaderDto;
import ru.nabokov.patternservice.dto.header.UpdateHeaderDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.HeaderMapper;
import ru.nabokov.patternservice.model.Header;
import ru.nabokov.patternservice.repository.HeaderRepository;

@Service
@RequiredArgsConstructor
public class HeaderServiceImpl implements HeaderService {

    private final HeaderRepository repository;
    private final HeaderMapper mapper;

    @Override
    public Header save(NewHeaderDto headerDto) {
        return repository.save(mapper.mapToNewHeader(headerDto));
    }

    @Override
    public Header update(UpdateHeaderDto headerDto) {
        if (!repository.existsById(headerDto.getId())) {
            throw new NotFoundException(String.format("header witch id=%s not found for update", headerDto.getId()));
        }
        return repository.save(mapper.mapToUpdateHeader(headerDto));
    }
}
