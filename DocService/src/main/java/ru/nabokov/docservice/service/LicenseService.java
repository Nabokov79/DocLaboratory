package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.title.LicenseDto;
import ru.nabokov.docservice.model.License;

public interface LicenseService {

    License save(LicenseDto licenseDto, String division);
}
