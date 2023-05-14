package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokov.docservice.dto.passport.RepairDto;
import ru.nabokov.docservice.dto.passport.SurveyDto;
import ru.nabokov.docservice.dto.pattern.ColumnHeaderDto;
import ru.nabokov.docservice.model.ColumnsHeaders;
import ru.nabokov.docservice.model.Repair;
import ru.nabokov.docservice.model.Survey;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectionMapper {

    @Mapping(source = "organization.name", target = "organization")
    Survey mapToSurveys(SurveyDto surveys);

    @Mapping(source = "organization.name", target = "organization")
    Repair mapToRepairs(RepairDto repairs);

    List<ColumnsHeaders> mapToColumnsHeaders(List<ColumnHeaderDto> columnHeaders);
}
