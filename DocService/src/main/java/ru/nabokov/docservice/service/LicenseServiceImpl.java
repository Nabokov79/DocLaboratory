package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.title.LicenseDto;
import ru.nabokov.docservice.model.License;
import ru.nabokov.docservice.repository.LicenseRepository;

@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository repository;

    @Override
    public License save(LicenseDto licenseDto, String division) {
       if (licenseDto != null) {
           License license = new License();
           String[] date = licenseDto.getDate().toString().split("-") ;
           license.setDivision(division);
           license.setLicense(String.join(" ",
                   licenseDto.getDocument(),
                   licenseDto.getNumber(),
                   "от", String.join(".", date[2], date[1], date[0])));
           return repository.save(license);
       }
       return null;
    }
}
