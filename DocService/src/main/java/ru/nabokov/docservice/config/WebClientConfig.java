package ru.nabokov.docservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${pattern-service.url}")
    private String patternUrl;
    @Value("${data-service.url}")
    private String dataUrl;

    @Value("${passport-service.url}")
    private String passportUrl;

    @Bean
    public WebClient webPatternClient() {
        return WebClient.builder()
                .baseUrl(patternUrl)
                .build();
    }

    @Bean
    public WebClient webDataClient() {
        return WebClient.builder()
                .baseUrl(dataUrl)
                .build();
    }

    @Bean
    public WebClient webPassportClient() {
        return WebClient.builder()
                .baseUrl(passportUrl)
                .build();
    }
}
