package ru.nabokov.passportservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokov.passportservice.dto.client.ShortSubheadingDto;

import java.util.List;
import java.util.Objects;

@Component
public class PatternClient {

    private final WebClient webClient;

    @Autowired
    public PatternClient(@Qualifier("webPatternClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public List<ShortSubheadingDto> getSubheadings(String path, String ids) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(path)
                                .queryParam("ids", ids)
                                .build())
                        .retrieve()
                        .toEntityList(ShortSubheadingDto.class)
                        .block())
                .getBody();
    }
}
