package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.passport.*;
import ru.nabokov.passportservice.dto.passport.NewPassportDto;
import ru.nabokov.passportservice.dto.passport.PassportDto;
import ru.nabokov.passportservice.dto.passport.UpdatePassportDto;

import java.util.List;

public interface PassportService {

    PassportDto save(NewPassportDto passportDto);

    PassportDto update(UpdatePassportDto passportDto);

    PassportDto get(Long id);

    List<ShortPassportDto> getAll();

   void delete(Long id);
}
