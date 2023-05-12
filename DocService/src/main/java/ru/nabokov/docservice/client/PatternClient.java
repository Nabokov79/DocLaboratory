package ru.nabokov.docservice.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokov.docservice.dto.pattern.ReportPatternDto;

import java.util.Objects;

@Component
public class PatternClient {

    private final WebClient webClient;

    public PatternClient(@Qualifier("webPatternClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public ReportPatternDto getReportPatternDto(String path, Long typeId) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(path)
                                .queryParam("typeId", typeId)
                                .build())
                        .retrieve()
                        .toEntity(ReportPatternDto.class)
                        .block())
                .getBody();
    }
}
