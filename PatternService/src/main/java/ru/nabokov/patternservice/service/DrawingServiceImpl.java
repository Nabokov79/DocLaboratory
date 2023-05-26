package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.drawing.NewDrawingDto;
import ru.nabokov.patternservice.dto.drawing.UpdateDrawingDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.DrawingMapper;
import ru.nabokov.patternservice.model.Drawing;
import ru.nabokov.patternservice.model.PatternSectionSeven;
import ru.nabokov.patternservice.repository.DrawingRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrawingServiceImpl implements DrawingService {

    private final DrawingRepository repository;
    private final DrawingMapper mapper;

    @Override
    public List<Drawing> save(PatternSectionSeven section, List<NewDrawingDto> drawingsDto) {
        List<Drawing> drawings;
        if (drawingsDto != null) {
             drawings = mapper.mapToNewDrawing(drawingsDto);
            for (Drawing drawing : drawings) {
                drawing.setPatternSectionSeven(section);
            }
            return repository.saveAll(drawings);
        }
        return mapper.mapToNewDrawing(null);
    }

    @Override
    public List<Drawing> update(PatternSectionSeven section, List<UpdateDrawingDto> drawingsDto) {
        validateIds(drawingsDto.stream().map(UpdateDrawingDto::getId).toList());
        List<Drawing> drawings = mapper.mapToUpdateDrawing(drawingsDto);
        for (Drawing drawing : drawings) {
            drawing.setPatternSectionSeven(section);
        }
        return repository.saveAll(drawings);
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Drawing> drawings = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Drawing::getId, d -> d));
        if (drawings.size() != ids.size() || drawings.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(drawings.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("drawings with ids= %s not found", ids));
        }
    }
}
