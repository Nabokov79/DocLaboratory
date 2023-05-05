package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.model.License;
import ru.nabokov.docservice.repository.LicenseRepository;

@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository repository;

    @Override
    public License save(BranchDto branchDto) {
       if (branchDto != null) {
           License license = new License();
           String[] date =  branchDto.getLicense().getDate().toString().split("-") ;
           license.setDivision(branchDto.getDivision());
           license.setLicense(String.join(" ",
                   branchDto.getLicense().getDocument(),
                   branchDto.getLicense().getNumber(),
                   "от", String.join(".", date[2], date[1], date[0])));
           return repository.save(license);
       }
       return null;
    }
}
