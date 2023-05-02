package ru.nabokov.patternservice.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokov.patternservice.dto.client.DivisionDto;
import ru.nabokov.patternservice.dto.client.TypeDto;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class DataClient {

    private final WebClient webClient;

    public DivisionDto getDivision(String uri) {
        return Objects.requireNonNull(webClient.get()
                                                .uri(uri)
                                                .retrieve()
                                                .toEntity(DivisionDto.class)
                                                .block())
                                                .getBody();
    }

    public List<TypeDto> getType(String path, String ids) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(path)
                                .queryParam("ids", ids)
                                .build())
                        .retrieve()
                        .toEntityList(TypeDto.class)
                        .block())
                .getBody();
    }
}
