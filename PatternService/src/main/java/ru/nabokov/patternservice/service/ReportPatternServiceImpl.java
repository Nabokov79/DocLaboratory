package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.client.PatternClient;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.ShortReportPatternDto;
import ru.nabokov.patternservice.dto.client.TypeDto;
import ru.nabokov.patternservice.dto.header.HeaderDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.HeaderMapper;
import ru.nabokov.patternservice.mapper.ReportPatternMapper;
import ru.nabokov.patternservice.model.*;
import ru.nabokov.patternservice.repository.ReportPatternRepository;
import ru.nabokov.patternservice.service.section.ReportPatternForSectionsService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportPatternServiceImpl implements ReportPatternService {

    private final ReportPatternRepository repository;
    private final ReportPatternMapper mapper;
    private final PatternClient client;
    private final HeaderMapper headerMapper;
    private final ReportPatternForSectionsService service;

    @Override
    public ReportPatternDto save(ReportPattern pattern) {
        ReportPatternDto patternDto = mapper.mapToReportPatternDto(repository.save(pattern));
        patternDto.setType(client.getType(pattern.getTypeId()));
        return patternDto;
    }

    @Override
    public ReportPatternDto update(ReportPattern pattern) {
        if (repository.existsById(pattern.getId())) {
            throw new NotFoundException(
                    String.format("report pattern witch id=%s not found for update", pattern.getId()));
        }
        ReportPatternDto patternDto = mapper.mapToReportPatternDto(repository.save(pattern));
        patternDto.setType(client.getType(pattern.getTypeId()));
        return patternDto;
    }

    @Override
    public ReportPatternDto get(Long id) {
        ReportPattern pattern = service.get(id);
        ReportPatternDto patternDto = mapper.mapToReportPatternDto(pattern);
        patternDto.setType(client.getType(pattern.getTypeId()));
        return patternDto;
    }
    @Override
    public List<ShortReportPatternDto> getAll() {
        List<ReportPattern> reportsDb = repository.findAll();
        String ids = String.valueOf(reportsDb.stream().map(ReportPattern::getTypeId).map(String::valueOf).toList());
        Map<Long, TypeDto> types = client.getTypes(String.join(",", ids))
                                         .stream().collect(Collectors.toMap(TypeDto::getId, t -> t));
        Map<Long, ReportPattern> reports = reportsDb.stream().collect(Collectors.toMap(ReportPattern::getId, r -> r));
        List<ShortReportPatternDto> reportsDto = new ArrayList<>();
        for (ReportPattern pattern : reportsDb) {
            ShortReportPatternDto reportPattern = mapper.mapToShortReportPatternsDto(pattern);
            List<Header> headers = new ArrayList<>();
            headers.add(reports.get(pattern.getId()).getPatternSectionOne().getHeader());
            headers.add(reports.get(pattern.getId()).getPatternSectionTwo().getHeader());
            headers.add(reports.get(pattern.getId()).getPatternSectionThree().getHeader());
            headers.add(reports.get(pattern.getId()).getPatternSectionFour().getHeader());
            headers.add(reports.get(pattern.getId()).getPatternSectionFive().getHeader());
            headers.add(reports.get(pattern.getId()).getPatternSectionSix().getHeader());
            headers.add(reports.get(pattern.getId()).getPatternSectionSeven().getHeader());
            reportPattern.setType(types.get(pattern.getTypeId()));
            reportPattern.setHeaders(headerMapper.mapToHeadersDto(headers)
                                                 .stream()
                                                 .sorted(Comparator.comparingLong(HeaderDto::getNumber))
                                                 .toList());
            reportsDto.add(reportPattern);
        }
        return reportsDto.stream().sorted(Comparator.comparing(s -> s.getType().getName())).toList();
    }
}
