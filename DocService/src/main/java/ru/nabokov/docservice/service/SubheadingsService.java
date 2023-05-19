package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.ObjectDataDto;
import ru.nabokov.docservice.dto.sixthSection.NewSubheadingsSixDto;
import ru.nabokov.docservice.dto.sixthSection.UpdateSubheadingsSixDto;
import ru.nabokov.docservice.model.sixthSection.SixthSection;
import java.util.List;

public interface SubheadingsService {

    void save(SixthSection section, ObjectDataDto objectData, List<NewSubheadingsSixDto> subheadingsDto);

    void update(SixthSection section, ObjectDataDto objectData,List<UpdateSubheadingsSixDto> subheadingsDto);
}
