package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.client.DocClient;
import ru.nabokov.docservice.dto.NewReportDto;
import ru.nabokov.docservice.dto.client.passport_service.PassportDto;
import ru.nabokov.docservice.dto.ApplicationDto;
import ru.nabokov.docservice.dto.ReportDataBuilder;
import ru.nabokov.docservice.dto.client.data_service.BranchDto;
import ru.nabokov.docservice.dto.ReportDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.ReportPatternDto;
import ru.nabokov.docservice.exceptions.NotFoundException;
import ru.nabokov.docservice.mapper.SectionMapper;
import ru.nabokov.docservice.model.Report;
import ru.nabokov.docservice.repository.ReportRepository;
import ru.nabokov.docservice.service.title.TitleService;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {


    private final ReportRepository repository;
    private final SectionMapper mapper;
    private final DocClient client;
    private final TitleService titleService;
    private final FirstSectionService firstSectionService;
    private final SecondSectionService secondSectionService;
    private final ThirdSectionService thirdSectionService;
    private final SeventhSectionService seventhSectionService;

    @Override
    public ReportDto save(NewReportDto reportDto) {
        Report report = new Report();
        ApplicationDto application = client.getApplication(reportDto.getApplicationId());
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
                                                                   .documentations(application.getObjectData()
                                                                                        .getType().getDocumentations())
                                                                   .license(report.getTitle().getLicense().getLicense())
                                                                   .build()));
        report.setSecondSection(secondSectionService.save(pattern.getPatternSectionTwo().getHeader(),
                                                                                    passport.getCharacteristics()));
        report.setThirdSection(thirdSectionService.save(pattern.getPatternSectionThree(), passport));
        report.setSeventhSection(seventhSectionService.save(pattern.getPatternSectionSeven().getHeader(), reportDto.getDrawings()));
        return mapper.mapToReportDto(report);
    }

    @Override
    public ReportDto update(Report report) {
        return mapper.mapToReportDto(repository.save(report));
    }


    @Override
    public Report get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Report with id=%s not found", id)));
    }
}
