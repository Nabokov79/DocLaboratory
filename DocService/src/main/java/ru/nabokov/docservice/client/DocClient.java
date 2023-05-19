package ru.nabokov.docservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.ObjectDataDto;
import ru.nabokov.docservice.dto.client.passport.PassportDto;
import ru.nabokov.docservice.dto.client.pattern.ApplicationDto;
import ru.nabokov.docservice.dto.client.title.BranchDto;
import ru.nabokov.docservice.dto.client.pattern.ReportPatternDto;

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
