package ru.nabokov.patternservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.client.TypeDto;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatternClient {

    private final DataClient client;

    public List<TypeDto> getType(String ids) {
        return client.getType("/data/types", ids);
    }
}
