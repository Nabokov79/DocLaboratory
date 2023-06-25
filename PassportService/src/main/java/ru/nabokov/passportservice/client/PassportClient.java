package ru.nabokov.passportservice.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import ru.nabokov.passportservice.dto.client.ShortSubheadingDto;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PassportClient {

    private final DataClient dataClient;
    private final PatternClient patternClient;

    public ObjectDataDto getObjectData(Long id) {
        return dataClient.getObjectData("/data/object/" + id).block();
    }

    public List<OrganizationDto> getOrganizations(String ids) {
        return Objects.requireNonNull(dataClient.getOrganizations("/data/organizations", ids).block()).getBody();
    }

    public List<ShortSubheadingDto> getSubheadings(String ids) {
        return patternClient.getSubheadings("/pattern/subheadings", ids);
    }
}
