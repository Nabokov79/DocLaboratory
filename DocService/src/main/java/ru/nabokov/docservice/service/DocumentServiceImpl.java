package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.client.DocClient;
import ru.nabokov.docservice.dto.ApplicationDto;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.dto.ReportPatternDto;
import ru.nabokov.docservice.model.Title;
import ru.nabokov.docservice.service.title.TitleService;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final TitleService titleService;
    private final FirstSectionService firstSectionService;
    private final DocClient client;

    @Override
    public Title save(Long applicationId) {
        ApplicationDto application = client.getApplication(applicationId);
        BranchDto branch = client.getBranch();
        ReportPatternDto pattern = client.getReportPatternDto(application.getObjectData().getType().getId());
        Title title = titleService.save(application.getObjectData(), branch, pattern.getTitlePattern());
        firstSectionService.save(branch, pattern.getPatternSectionOne(), application.getEmployees(), title.getLicense().getLicense());
        return title;
    }
}
