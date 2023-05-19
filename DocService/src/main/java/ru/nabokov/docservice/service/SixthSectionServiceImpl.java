package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.client.DocClient;
import ru.nabokov.docservice.dto.sixthSection.NewSixthSectionDto;
import ru.nabokov.docservice.dto.sixthSection.SixthSectionDto;
import ru.nabokov.docservice.dto.sixthSection.UpdateSixthSectionDto;
import ru.nabokov.docservice.exceptions.BadRequestException;
import ru.nabokov.docservice.mapper.SixthSectionMapper;
import ru.nabokov.docservice.model.Report;
import ru.nabokov.docservice.model.sixthSection.SixthSection;
import ru.nabokov.docservice.repository.SixthSectionRepository;

@Service
@RequiredArgsConstructor
public class SixthSectionServiceImpl implements SixthSectionService {

    private final SixthSectionRepository repository;
    private final SixthSectionMapper mapper;
    private final SubheadingsService subheadingsService;
    private final DocClient client;
    private final ReportService reportService;

    @Override
    public SixthSectionDto save(NewSixthSectionDto sectionDto) {
        SixthSection section = mapper.mapToNewSixthSection(sectionDto);
        subheadingsService.save(repository.save(section)
                              , client.getObjectData(sectionDto.getReportId())
                              , sectionDto.getSubheadings());
        addSectionToReport(sectionDto.getReportId(), section);
        return mapper.mapToSixthSectionDto(section);
    }

    @Override
    public SixthSectionDto update(UpdateSixthSectionDto sectionDto) {
        if (repository.existsById(sectionDto.getId())) {
            throw new BadRequestException(
                    String.format("Sixth section with id=%s not found for update", sectionDto.getId())
            );
        }
        SixthSection section = mapper.mapToUpdateSixthSection(sectionDto);
        subheadingsService.update(repository.save(section)
                                , client.getObjectData(sectionDto.getReportId())
                                , sectionDto.getSubheadings());
        addSectionToReport(sectionDto.getReportId(), section);
        return mapper.mapToSixthSectionDto(section);
    }

    private void addSectionToReport(Long reportId, SixthSection section) {
        Report report = reportService.get(reportId);
        report.setSixthSection(section);
        reportService.update(report);
    }
}
