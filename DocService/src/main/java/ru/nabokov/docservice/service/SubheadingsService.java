package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.data_service.ObjectDataDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.SubheadingDto;
import ru.nabokov.docservice.dto.sixthSection.NewSubheadingsSixDto;
import ru.nabokov.docservice.model.sixthSection.SixthSection;
import java.util.List;

public interface SubheadingsService {

    void save( ObjectDataDto objectData, SixthSection section, List<SubheadingDto> subheadings, List<NewSubheadingsSixDto> subheadingsDto);
}
