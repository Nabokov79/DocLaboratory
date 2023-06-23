package ru.nabokov.passportservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import ru.nabokov.passportservice.dto.client.ShortSubheadingDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportClient {

    private final DataClient dataClient;
    private final PatternClient patternClient;

    public ObjectDataDto getObjectData(Long id) {
        return dataClient.getObjectData("/data/object/" + id);
    }

    public List<OrganizationDto> getOrganizations(String ids) {
        return dataClient.getOrganizations("/data/organizations", ids);
    }

    public List<ShortSubheadingDto> getSubheadings(String ids) {
        return patternClient.getSubheadings("/pattern/subheadings", ids);
    }
}
