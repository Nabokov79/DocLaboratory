package ru.nabokov.docservice.dto.client.passport_service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.dto.client.data_service.ObjectDataDto;
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
