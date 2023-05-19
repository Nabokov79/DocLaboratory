package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.sixthSection.NewSixthSectionDto;
import ru.nabokov.docservice.dto.sixthSection.SixthSectionDto;
import ru.nabokov.docservice.dto.sixthSection.UpdateSixthSectionDto;

public interface SixthSectionService {

    SixthSectionDto save(NewSixthSectionDto sectionDto);

   SixthSectionDto update(UpdateSixthSectionDto sectionDto);
}
