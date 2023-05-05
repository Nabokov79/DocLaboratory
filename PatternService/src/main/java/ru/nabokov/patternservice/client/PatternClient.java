package ru.nabokov.patternservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.client.BranchDto;
import ru.nabokov.patternservice.dto.client.Type;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatternClient {

    private final DataClient client;

    public BranchDto getBranch() {
        return client.getBranch("/data/branch/1");
    }

    public List<Type> getType(String ids) {
        return client.getType("/data/type/", ids);
    }
}
