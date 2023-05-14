package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.NewSeventhSectionDto;
import ru.nabokov.docservice.dto.SeventhSectionDto;

public interface SeventhSectionService {

    SeventhSectionDto save(NewSeventhSectionDto sectionDto);
}
