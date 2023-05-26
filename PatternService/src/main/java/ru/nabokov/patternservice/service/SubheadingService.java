package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.subheading.NewSubheadingDto;
import ru.nabokov.patternservice.dto.subheading.UpdateSubheadingDto;
import ru.nabokov.patternservice.model.Subheading;
import java.util.List;

public interface SubheadingService {

    List<Subheading> save(List<NewSubheadingDto> subheadingsDto);

    List<Subheading> update(List<UpdateSubheadingDto> subheadingsDto);
}
