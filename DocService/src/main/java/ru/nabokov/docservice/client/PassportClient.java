package ru.nabokov.docservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokov.docservice.dto.client.passport.PassportDto;
import java.util.Objects;

@Component
public class PassportClient {

    private final WebClient webClient;

    @Autowired
    public PassportClient(@Qualifier("webPassportClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public PassportDto getPassport(String uri) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uri)
                        .retrieve()
                        .toEntity(PassportDto.class)
                        .block())
                .getBody();
    }
}
