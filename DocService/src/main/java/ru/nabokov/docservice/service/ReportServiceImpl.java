package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.client.DocClient;
import ru.nabokov.docservice.dto.passport.PassportDto;
import ru.nabokov.docservice.dto.pattern.ApplicationDto;
import ru.nabokov.docservice.dto.ReportDataBuilder;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.dto.pattern.ReportPatternDto;
import ru.nabokov.docservice.model.Report;
import ru.nabokov.docservice.service.title.TitleService;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final TitleService titleService;
    private final FirstSectionService firstSectionService;
    private final DocClient client;
    private final SecondSectionService secondSectionService;
    private final ThirdSectionService thirdSectionService;

    @Override
    public Report save(Long applicationId) {
        Report report = new Report();
        ApplicationDto application = client.getApplication(applicationId);
        BranchDto branch = client.getBranch();
        ReportPatternDto pattern = client.getReportPatternDto(application.getObjectData().getType().getId());
        PassportDto passport = client.getPassport(application.getObjectData().getId());
        report.setTitle(titleService.save(new ReportDataBuilder.DataBuilder().objectData(application.getObjectData())
                                                                                .branch(branch)
                                                                                .titlePattern(pattern.getTitlePattern())
                                                                                .build()));
        report.setFirstSection(firstSectionService.save(new ReportDataBuilder.DataBuilder()
                                                                   .branch(branch)
                                                                   .pattern(pattern.getPatternSectionOne())
                                                                   .employees(application.getEmployees())
                                                                   .license(report.getTitle().getLicense().getLicense())
                                                                   .build()));
        report.setSecondSection(secondSectionService.save(pattern.getPatternSectionTwo().getHeader(),
                                                          passport.getCharacteristics()));
        return report;
    }
}
