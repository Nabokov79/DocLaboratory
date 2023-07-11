package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.objectCharacteristics.NewObjectCharacteristicsDto;
import ru.nabokov.passportservice.dto.objectCharacteristics.UpdateObjectCharacteristicsDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.ObjectCharacteristicsMapper;
import ru.nabokov.passportservice.model.Characteristic;
import ru.nabokov.passportservice.model.ObjectCharacteristics;
import ru.nabokov.passportservice.model.Passport;
import ru.nabokov.passportservice.repository.ObjectCharacteristicsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObjectCharacteristicsServiceImpl implements ObjectCharacteristicsService {

    private final ObjectCharacteristicsRepository repository;
    private final ObjectCharacteristicsMapper mapper;
    private final CharacteristicService characteristicService;

    @Override
    public List<ObjectCharacteristics> save(Passport passport, List<NewObjectCharacteristicsDto> characteristicsDto) {
        Map<Long, Characteristic> characteristics = characteristicService.getAllById(
                                                                    characteristicsDto.stream()
                                                                    .map(NewObjectCharacteristicsDto::getCharacteristicId)
                                                                    .toList())
                                                              .stream()
                                                              .collect(Collectors.toMap(Characteristic::getId, c -> c));
        List<ObjectCharacteristics> objectCharacteristics = new ArrayList<>();
        for (NewObjectCharacteristicsDto characteristic : characteristicsDto) {
            ObjectCharacteristics objectCharacteristic = mapper.mapFromNewObjectCharacteristics(characteristic);
            objectCharacteristic.setCharacteristic(characteristics.get(characteristic.getCharacteristicId()));
            objectCharacteristic.setMeaning(characteristic.getMeaning());
            objectCharacteristics.add(objectCharacteristic);
            objectCharacteristic.setPassport(passport);
        }
        return repository.saveAll(objectCharacteristics);
    }

    @Override
    public List<ObjectCharacteristics> update(Passport passport, List<UpdateObjectCharacteristicsDto> characteristicsDto) {
        validateIds(characteristicsDto.stream().map(UpdateObjectCharacteristicsDto::getId).toList());
        Map<Long, Characteristic> characteristics = characteristicService.getAllById(
                        characteristicsDto.stream()
                                .map(UpdateObjectCharacteristicsDto::getCharacteristicId)
                                .toList())
                .stream()
                .collect(Collectors.toMap(Characteristic::getId, c -> c));
        List<ObjectCharacteristics> objectCharacteristics = new ArrayList<>();
        for (UpdateObjectCharacteristicsDto characteristic : characteristicsDto) {
            ObjectCharacteristics objectCharacteristic = mapper.mapFromUpdateObjectCharacteristics(characteristic);
            objectCharacteristic.setCharacteristic(characteristics.get(characteristic.getCharacteristicId()));
            objectCharacteristic.setMeaning(characteristic.getMeaning());
            objectCharacteristics.add(objectCharacteristic);
            objectCharacteristic.setPassport(passport);
        }
        return repository.saveAll(objectCharacteristics);
    }

    private void validateIds(List<Long> ids) {
        Map<Long, ObjectCharacteristics> characteristics = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(ObjectCharacteristics::getId, d -> d));
        if (characteristics.size() != ids.size() || characteristics.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(characteristics.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("object characteristics with ids= %s not found", ids));
        }
    }
}
