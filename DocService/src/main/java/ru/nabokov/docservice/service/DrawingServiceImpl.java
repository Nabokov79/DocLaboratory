package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.pattern.DrawingDto;
import ru.nabokov.docservice.model.seventhSection.Drawing;
import ru.nabokov.docservice.model.seventhSection.SeventhSection;
import ru.nabokov.docservice.repository.DrawingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DrawingServiceImpl implements DrawingService {

    private final DrawingRepository repository;
    private final StringBuilderService stringBuilder;

    @Override
    public List<Drawing> save(SeventhSection section, List<DrawingDto> drawingsDto) {
        List<Drawing> drawings = new ArrayList<>();
        for (DrawingDto drawingDto : drawingsDto) {
            Drawing drawing = new Drawing();
            drawing.setDrawing(stringBuilder.toStringDrawing(drawingDto));
            if (drawingDto.getCount() > 1) {
                drawing.setList(stringBuilder.toStringCountList(drawingDto.getCount()));
            }
            drawings.add(drawing);
        }
        return repository.saveAll(drawings);
    }
}
