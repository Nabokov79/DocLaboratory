package ru.nabokov.docservice.service.title;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.ObjectDataDto;
import ru.nabokov.docservice.dto.client.pattern.TextCenteredDto;
import ru.nabokov.docservice.mapper.TitleMapper;
import ru.nabokov.docservice.model.title.TextCentered;
import ru.nabokov.docservice.repository.TextCenteredRepository;
import ru.nabokov.docservice.service.StringBuilderService;

@Service
@RequiredArgsConstructor
public class TextCenteredServiceImpl implements TextCenteredService {

    private final TextCenteredRepository repository;
    private final TitleMapper mapper;
    private final StringBuilderService stringService;
    private static final String NUMBER = "№";
    private static final String VOLUME = "V=";
    private static final String UNIT = "м3";

    @Override
    public TextCentered save(ObjectDataDto objectData, TextCenteredDto textCentered) {
        if (objectData != null && textCentered != null) {
            TextCentered text = mapper.mapToTextCentered(textCentered);
            text.setObject(String.join(" ", text.getObject(),
                    NUMBER,
                    String.valueOf(objectData.getNumber()),
                    VOLUME,
                    String.valueOf( objectData.getVolume()),
                    UNIT));
            text.setAddress(stringService.toStringAddress(objectData.getBuilding().getAddress()));
            return repository.save(text);
        }
        return null;
    }
}
