package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.standardSizePipeDto.NewStandardSizePipeDto;
import ru.nabokov.passportservice.dto.standardSizePipeDto.StandardSizePipeDto;
import ru.nabokov.passportservice.dto.standardSizePipeDto.UpdateStandardSizePipeDto;
import ru.nabokov.passportservice.model.StandardSizePipe;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StandardSizePipeMapper {

    List<StandardSizePipe> mapToNewStandardSizePipe(List<NewStandardSizePipeDto> standardSizePipeDto);

    List<StandardSizePipe> mapToUpdateStandardSizePipe(List<UpdateStandardSizePipeDto> standardSizePipeDto);

    List<StandardSizePipeDto> mapToStandardSizePipeDto(List<StandardSizePipe> standardSizePipe);
}
