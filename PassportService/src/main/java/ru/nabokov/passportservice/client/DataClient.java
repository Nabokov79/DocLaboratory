package ru.nabokov.passportservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import java.util.List;
import java.util.Objects;

@Component
public class DataClient {

    private final WebClient webClient;

    @Autowired
    public DataClient(@Qualifier("webDataClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public ObjectDataDto getObjectData(String uri) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uri)
                        .retrieve()
                        .toEntity(ObjectDataDto.class)
                        .block())
                .getBody();
    }

    public List<OrganizationDto> getOrganizations(String path, String ids) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(path)
                                .queryParam("ids", ids)
                                .build())
                        .retrieve()
                        .toEntityList(OrganizationDto.class)
                        .block())
                .getBody();
    }
}
