package ru.nabokov.passportservice.service.passport;

import ru.nabokov.passportservice.dto.standardSizePipeDto.NewStandardSizePipeDto;
import ru.nabokov.passportservice.dto.standardSizePipeDto.StandardSizePipeDto;
import ru.nabokov.passportservice.dto.standardSizePipeDto.UpdateStandardSizePipeDto;

import java.util.List;

public interface StandardSizePipeService {

    List<StandardSizePipeDto> save(List<NewStandardSizePipeDto> standardSizePipeDto);

    List<StandardSizePipeDto> update(List<UpdateStandardSizePipeDto> standardSizePipeDto);

    List<StandardSizePipeDto> getAll();
}
