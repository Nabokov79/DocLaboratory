package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.client.PatternClient;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.client.Type;
import ru.nabokov.patternservice.dto.ShortReportPatternDto;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.ReportPatternMapper;
import ru.nabokov.patternservice.model.ReportPattern;
import ru.nabokov.patternservice.model.TitlePattern;
import ru.nabokov.patternservice.repository.ReportPatternRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportPatternServiceImpl implements ReportPatternService {

    private final ReportPatternRepository repository;
    private final ReportPatternMapper mapper;
    private final PatternClient client;

    @Override
    public void save(Long typeId, TitlePattern titlePattern) {
        ReportPattern pattern = new ReportPattern();
        pattern.setTypeId(typeId);
        pattern.setTitlePattern(titlePattern);
        repository.save(pattern);
    }

    @Override
    public ReportPatternDto get(Long id, Long typeId) {
        ReportPatternDto reportPatternDto;
       if (id != null && id > 0) {
           reportPatternDto = mapper.mapToReportPatternDto(repository.findById(id)
                   .orElseThrow(() -> new NotFoundException(String.format("Pattern witch id=%s not found", id)))
           );
       } else {
           reportPatternDto = mapper.mapToReportPatternDto(repository.findByTypeId(typeId));
       }
       if (reportPatternDto == null) {
           throw new BadRequestException(String.format("id=%s and typeId=%s not correct", id, typeId));
       }
       return reportPatternDto;
    }

    @Override
    public List<ShortReportPatternDto> getAll() {
        Map<Long, ReportPattern> patterns = repository.findAll()
                                                  .stream().collect(Collectors.toMap(ReportPattern::getTypeId, r -> r));
        if (patterns.isEmpty()) {
            throw new NotFoundException(String.format("reports patterns not found, patterns=%s", patterns));
        }
        Map<Long, Type> types = client.getType(patterns.keySet().toString())
                                                            .stream().collect(Collectors.toMap(Type::getId, t -> t));
        if (types.isEmpty()) {
            throw new NotFoundException(String.format("types reports patterns with ids=%s not found", patterns.keySet()));
        }
        List<ShortReportPatternDto> reportPatterns = new ArrayList<>();
        for (Long id : patterns.keySet()) {
            ShortReportPatternDto shortPatterns = mapper.mapToShortReportPatternDto(patterns.get(id));
            shortPatterns.setType(types.get(id));
        }
        return reportPatterns;
    }

    @Override
    public void delete(Long patId) {
        if (repository.existsById(patId)) {
            repository.deleteById(patId);
            return;
        }
        throw new BadRequestException(String.format("Report pattern with id=%s not found for delete", patId));
    }
}
