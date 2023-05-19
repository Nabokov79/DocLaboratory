package ru.nabokov.docservice.dto.client.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.dto.OrganizationDto;

@Setter
@Getter
@NoArgsConstructor
public class BranchDto {
    
    private Long id;    
    private String branch;    
    private String division;   
    private AddressDto address;    
    private Integer index;    
    private String phone;   
    private String fax;   
    private String email;    
    private LicenseDto license;
    private OrganizationDto organization;
}
