package ru.nabokov.docservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.data_service.ObjectDataDto;
import ru.nabokov.docservice.dto.client.passport_service.PassportDto;
import ru.nabokov.docservice.dto.ApplicationDto;
import ru.nabokov.docservice.dto.client.data_service.BranchDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.ReportPatternDto;

@Service
@RequiredArgsConstructor
public class DocClient {

    private final DataClient dataClient;
    private final PatternClient patternClient;
    private final PassportClient passportClient;
    public ApplicationDto getApplication(Long id) {
        return dataClient.getApplication("/data/applications/" + id);
    }

    public BranchDto getBranch() {
        return dataClient.getBranch("/data/branch");
    }

    public ReportPatternDto getReportPatternDto(Long typeId) {
        return patternClient.getReportPatternDto("/pattern/report/", typeId);
    }

    public PassportDto getPassport(Long id) {
        return passportClient.getPassport("/passport/" + id);
    }

    public ObjectDataDto getObjectData(Long id) {
        return dataClient.getObjectData("/data/object/" + id);
    }
}
