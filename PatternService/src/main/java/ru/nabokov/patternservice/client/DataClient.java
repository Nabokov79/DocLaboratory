package ru.nabokov.patternservice.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokov.patternservice.dto.client.BranchDto;
import ru.nabokov.patternservice.dto.client.Type;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class DataClient {

    private final WebClient webClient;

    public List<Type> getType(String path, String ids) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(path)
                                .queryParam("ids", ids)
                                .build())
                        .retrieve()
                        .toEntityList(Type.class)
                        .block())
                .getBody();
    }
}
