package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.passport_service.CharacteristicDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.ShortSubheadingDto;
import ru.nabokov.docservice.model.SecondSection;
import ru.nabokov.docservice.model.Characteristic;
import ru.nabokov.docservice.repository.SecondSectionDataRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {

    private final SecondSectionDataRepository repository;

    @Override
    public List<Characteristic> save(SecondSection section
                                   , List<ShortSubheadingDto> subheadings
                                   , List<CharacteristicDto> characteristics) {
        List<Characteristic> sectionData = new ArrayList<>();
        Map<Long, ShortSubheadingDto> subheadingDto = subheadings.stream()
                                                           .collect(Collectors.toMap(ShortSubheadingDto::getId,s -> s));
        for (CharacteristicDto characteristicDto : characteristics) {
            Characteristic characteristic = new Characteristic();
            characteristic.setHeading
                    (String.join(" ", String.valueOf(subheadingDto.get(characteristicDto.getId()).getNumber()),
                                                             subheadingDto.get(characteristicDto.getId()).getHeading())
            );
            characteristic.setMeaning(characteristicDto.getMeaning());
            characteristic.setSection(section);
            sectionData.add(characteristic);
        }
        return repository.saveAll(sectionData);
    }
}
