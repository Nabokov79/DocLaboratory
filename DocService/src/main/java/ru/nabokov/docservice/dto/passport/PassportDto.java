package ru.nabokov.docservice.dto.passport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.dto.ObjectDataDto;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PassportDto {

    private Long id;
    private ObjectDataDto objectData;
    private List<CharacteristicDto> characteristics;
    private List<SurveyDto> surveys;
    private List<RepairDto> repairs;
}
