package ru.nabokov.docservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokov.docservice.dto.pattern.ApplicationDto;
import ru.nabokov.docservice.dto.title.BranchDto;
import java.util.Objects;

@Component
public class DataClient {

    private final WebClient webClient;

    @Autowired
    public DataClient(@Qualifier("webDataClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public ApplicationDto getApplication(String uri) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uri)
                        .retrieve()
                        .toEntity(ApplicationDto.class)
                        .block())
                .getBody();
    }

    public BranchDto getBranch(String uri) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uri)
                        .retrieve()
                        .toEntity(BranchDto.class)
                        .block())
                .getBody();
    }
}
