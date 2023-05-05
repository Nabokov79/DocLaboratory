package ru.nabokov.docservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.ApplicationDto;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.dto.ReportPatternDto;

@Service
@RequiredArgsConstructor
public class DocClient {

    private final DataClient dataClient;
    private final PatternClient patternClient;
    public ApplicationDto getApplication(Long id) {
        return dataClient.getApplication("/data/applications" + id);
    }

    public BranchDto getBranch() {
        return dataClient.getBranch("/data/branch");
    }

    public ReportPatternDto getReportPatternDto(Long typeId) {
        return patternClient.getReportPatternDto("/pattern/report/", typeId);
    }
}
