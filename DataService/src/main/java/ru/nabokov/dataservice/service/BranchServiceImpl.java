package ru.nabokov.dataservice.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.branch.BranchDto;
import ru.nabokov.dataservice.dto.branch.NewBranchDto;
import ru.nabokov.dataservice.dto.branch.UpdateBranchDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.mapper.BranchMapper;
import ru.nabokov.dataservice.model.*;
import ru.nabokov.dataservice.repository.BranchRepository;
import javax.persistence.EntityManager;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository repository;
    private final BranchMapper mapper;
    private final AddressService addressService;
    private final LicenseService licenseService;
    private final OrganizationService organizationService;
    private final EntityManager entityManager;

    @Override
    public BranchDto save(NewBranchDto branchDto) {
        Branch branch = mapper.mapToNewBranch(branchDto);
        branch.setAddress(addressService.get(branchDto.getAddressId()));
        branch.setLicense(licenseService.get(branchDto.getLicenseId()));
        branch.setOrganization(organizationService.get(branchDto.getOrganizationId()));
        return mapper.mapToBranchDto(repository.save(branch));
    }

    @Override
    public BranchDto update(UpdateBranchDto branchDto) {
        if (!repository.existsById(branchDto.getId())) {
            throw new BadRequestException(String.format("Branch wth id=%s not found for update", branchDto.getId()));
        }
        Branch branch = mapper.mapToUpdateBranch(branchDto);
        branch.setAddress(addressService.get(branchDto.getAddressId()));
        branch.setLicense(licenseService.get(branchDto.getLicenseId()));
        branch.setOrganization(organizationService.get(branchDto.getOrganizationId()));
        return mapper.mapToBranchDto(repository.save(branch));
    }

    @Override
    public BranchDto get() {
        QBranch branch = QBranch.branch1;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        return mapper.mapToBranchDto(qf.from(branch)
                .select(branch)
                .where(branch.license.date.before(LocalDate.now().plusYears(3))).fetchOne());
    }
}
