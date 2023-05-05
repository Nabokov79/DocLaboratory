package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.model.TitleHeader;

public interface TitleHeaderService {

    TitleHeader save(BranchDto branch);
}
