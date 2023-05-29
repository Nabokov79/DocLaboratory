package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.data_service.LicenseDto;
import ru.nabokov.docservice.model.License;

public interface LicenseService {

    License save(LicenseDto licenseDto, String division);
}
