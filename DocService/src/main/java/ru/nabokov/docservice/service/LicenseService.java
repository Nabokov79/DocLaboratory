package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.model.License;

public interface LicenseService {

    License save(BranchDto branchDto);
}
