package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.norm.NewNormsDto;
import ru.nabokov.dataservice.dto.norm.NormsDto;
import ru.nabokov.dataservice.dto.norm.UpdateNormsDto;

import java.util.List;

public interface NormsService {

    List<NormsDto> save(List<NewNormsDto> normsDto);

    List<NormsDto> update(List<UpdateNormsDto> normsDto);
}
