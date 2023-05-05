package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.license.LicenseDto;
import ru.nabokov.dataservice.dto.license.NewLicenseDto;
import ru.nabokov.dataservice.dto.license.UpdateLicenseDto;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.LicenseMapper;
import ru.nabokov.dataservice.model.Licenses;
import ru.nabokov.dataservice.repository.LicenseRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository repository;
    private final LicenseMapper mapper;
    private final OrganizationService organizationService;


    @Override
    public LicenseDto save(NewLicenseDto licenseDto) {
        if (repository.existsByDate(licenseDto.getDate())) {
            throw new NotFoundException(String.format("license with date=%s found", licenseDto.getDate()));
        }
        Licenses license = mapper.mapToNewLicense(licenseDto);
        license.setOrganization(organizationService.get(licenseDto.getOrganizationId()));
        return mapper.mapToLicenseDto(repository.save(license));
    }

    @Override
    public LicenseDto update(UpdateLicenseDto licenseDto) {
        if (!repository.existsById(licenseDto.getId())) {
            throw new NotFoundException(String.format("license with id=%s not found for update", licenseDto.getId()));
        }
        Licenses license = mapper.mapToUpdateLicense(licenseDto);
        license.setOrganization(organizationService.get(licenseDto.getOrganizationId()));
        return mapper.mapToLicenseDto(repository.save(license));
    }

    @Override
    public Licenses get(Long lisId) {
        return repository.findById(lisId).orElseThrow(() -> new NotFoundException(
                                                                 String.format("license with id=%s not found", lisId)));
    }

    @Override
    public List<LicenseDto> getAll() {
        return mapper.mapToLicensesDto(repository.findAll());
    }
}
