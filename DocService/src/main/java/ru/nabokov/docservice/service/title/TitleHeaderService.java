package ru.nabokov.docservice.service.title;

import ru.nabokov.docservice.dto.client.data_service.BranchDto;
import ru.nabokov.docservice.model.title.TitleHeader;

public interface TitleHeaderService {

    TitleHeader save(BranchDto branch);
}
