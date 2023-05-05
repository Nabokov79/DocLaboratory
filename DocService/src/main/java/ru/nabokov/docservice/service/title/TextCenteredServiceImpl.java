package ru.nabokov.docservice.service.title;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.title.AddressDto;
import ru.nabokov.docservice.dto.title.ObjectDataDto;
import ru.nabokov.docservice.dto.TextCenteredDto;
import ru.nabokov.docservice.mapper.TitleMapper;
import ru.nabokov.docservice.model.TextCentered;
import ru.nabokov.docservice.repository.TextCenteredRepository;

@Service
@RequiredArgsConstructor
public class TextCenteredServiceImpl implements TextCenteredService {

    private final TextCenteredRepository repository;
    private final TitleMapper mapper;
    private static final String HOUSE = "д.";
    private static final String BUILDING = "к.";
    private static final String LETTER = "лит.";
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
            text.setAddress(getStringAddress(objectData.getBuilding().getAddress()));
            return repository.save(text);
        }
        return null;
    }

    private String getStringAddress(AddressDto addressDto) {
        if (addressDto.getBuildingNumber() != null) {
            return String.join(", ", addressDto.getStreet(),
                    String.join("", HOUSE, String.valueOf(addressDto.getHouseNumber())),
                    String.join("",BUILDING, String.valueOf(addressDto.getBuildingNumber())));
        }
        if (addressDto.getLetter() != null) {
            return String.join(", ", addressDto.getStreet(),
                   String.join("", HOUSE, String.valueOf(addressDto.getHouseNumber())),
                   String.join("",LETTER, addressDto.getLetter()));
        }
        if (addressDto.getBuildingNumber() != null && addressDto.getLetter() != null) {
            return String.join(", ", addressDto.getStreet(),
                   String.join("", HOUSE, String.valueOf(addressDto.getHouseNumber())),
                   String.join("",BUILDING, String.valueOf(addressDto.getBuildingNumber())),
                   String.join("",LETTER, addressDto.getLetter()));
        } else {
            return String.join(", ", addressDto.getStreet(),
                   String.join("", HOUSE, String.valueOf(addressDto.getHouseNumber())));
        }
    }
}
