package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.TitlePatternDto;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.dto.title.ObjectDataDto;
import ru.nabokov.docservice.model.Title;

public interface TitleService {

    Title save(ObjectDataDto objectData, BranchDto branch, TitlePatternDto titlePattern);
}
