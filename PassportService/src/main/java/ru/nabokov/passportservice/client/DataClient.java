package ru.nabokov.passportservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import java.util.List;

@Component
public class DataClient {

    private final WebClient webClient;

    @Autowired
    public DataClient(@Qualifier("webDataClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ObjectDataDto> getObjectData(String uri) {
        return webClient.get()
                        .uri(uri)
                        .retrieve()
                        .bodyToMono(ObjectDataDto.class);
    }

    public Mono<ResponseEntity<List<OrganizationDto>>> getOrganizations(String path, String ids) {
        return webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(path)
                                .queryParam("ids", ids)
                                .build())
                        .retrieve()
                        .toEntityList(OrganizationDto.class);
    }
}
