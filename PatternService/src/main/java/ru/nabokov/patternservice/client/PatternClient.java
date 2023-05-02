package ru.nabokov.patternservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.client.DivisionDto;
import ru.nabokov.patternservice.dto.client.TypeDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatternClient {

    private final DataClient client;

    public DivisionDto getDivision() {
        return client.getDivision("/data/divisions/1");
    }

    public List<TypeDto> getType(String ids) {
        return client.getType("/data/type/", ids);
    }
}
