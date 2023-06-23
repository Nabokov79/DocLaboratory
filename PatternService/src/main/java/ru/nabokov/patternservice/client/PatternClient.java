package ru.nabokov.patternservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.client.TypeDto;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatternClient {

    private final DataClient client;

    public TypeDto getType(Long id) {
        return client.getType("/data/types/" + id);
    }

    public List<TypeDto> getTypes(String ids) {
        return client.getTypes("/data/types/", ids);
    }
}
