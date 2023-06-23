package ru.nabokov.patternservice.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokov.patternservice.dto.client.TypeDto;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class DataClient {

    private final WebClient webClient;

    public TypeDto getType(String path) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(path)
                                .build())
                        .retrieve()
                        .toEntity(TypeDto.class)
                        .block())
                .getBody();
    }

    public List<TypeDto> getTypes(String path, String ids) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(path)
                                .queryParam(ids)
                                .build())
                        .retrieve()
                        .toEntityList(TypeDto.class)
                        .block())
                .getBody();
    }
}
