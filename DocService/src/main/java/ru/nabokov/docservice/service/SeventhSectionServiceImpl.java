package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.NewSeventhSectionDto;
import ru.nabokov.docservice.dto.SeventhSectionDto;
import ru.nabokov.docservice.mapper.SeventhSectionMapper;
import ru.nabokov.docservice.model.Report;
import ru.nabokov.docservice.model.seventhSection.SeventhSection;
import ru.nabokov.docservice.repository.SeventhSectionRepository;

@Service
@RequiredArgsConstructor
public class SeventhSectionServiceImpl implements SeventhSectionService {

    private final SeventhSectionRepository repository;
    private final SeventhSectionMapper mapper;
    private final StringBuilderService stringBuilder;
    private final DrawingService drawingService;
    private final ReportService reportService;

    @Override
    public SeventhSectionDto save(NewSeventhSectionDto sectionDto) {
        SeventhSection section = new SeventhSection();
        section.setHeading(stringBuilder.toStringHeader(mapper.mapToHeaderDto(sectionDto.getSectionHeaderDto())));
        section.setDrawings(drawingService.save(repository.save(section)
                                              , mapper.mapToDrawingDto(sectionDto.getDrawings())));
        addSectionToReport(sectionDto.getReportId(), section);
        return mapper.mapToSeventhSectionDto(section);
    }

    private void addSectionToReport(Long reportId, SeventhSection section) {
        Report report = reportService.get(reportId);
        report.setSeventhSection(section);
        reportService.update(report);
    }
}
