package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.passport.CharacteristicDto;
import ru.nabokov.docservice.model.SecondSection;
import ru.nabokov.docservice.model.SecondSectionData;
import ru.nabokov.docservice.repository.SecondSectionDataRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SecondSectionDataServiceImpl implements SecondSectionDataService {

    private final SecondSectionDataRepository repository;

    @Override
    public List<SecondSectionData> save(SecondSection section, List<CharacteristicDto> characteristics) {
        List<SecondSectionData> sectionData = new ArrayList<>();
        for (CharacteristicDto characteristic : characteristics) {
            SecondSectionData data = new SecondSectionData();
            data.setHeading(String.join(" ", String.valueOf(characteristic.getNumber()),
                                                                    characteristic.getHeading())
            );
            data.setMeaning(characteristic.getMeaning());
            data.setSection(section);
            sectionData.add(data);
        }
        return repository.saveAll(sectionData);
    }
}
