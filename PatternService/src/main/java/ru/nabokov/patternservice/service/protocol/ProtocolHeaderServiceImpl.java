package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.protocolHeader.NewProtocolHeaderDto;
import ru.nabokov.patternservice.dto.protocolHeader.UpdateProtocolHeaderDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.ProtocolHeaderMapper;
import ru.nabokov.patternservice.model.ProtocolHeader;
import ru.nabokov.patternservice.repository.ProtocolHeaderRepository;

@Service
@RequiredArgsConstructor
public class ProtocolHeaderServiceImpl implements ProtocolHeaderService {

    private final ProtocolHeaderRepository repository;
    private final ProtocolHeaderMapper mapper;

    @Override
    public ProtocolHeader save(NewProtocolHeaderDto headerDto) {
        if (repository.existsByNumber(headerDto.getNumber())) {
            throw new NotFoundException(
                    String.format("pattern header with protocol number=%s found", headerDto.getNumber()));
        }
        return repository.save(mapper.mapToNewProtocolHeader(headerDto));
    }

    @Override
    public ProtocolHeader update(UpdateProtocolHeaderDto headerDto) {
        if (!repository.existsById(headerDto.getId())) {
            throw new NotFoundException(
                                      String.format("Protocol header with id=%s not found for update", headerDto.getId()));
        }
        return repository.save(mapper.mapToUpdateProtocolHeader(headerDto));
    }
}
