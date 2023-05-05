package ru.nabokov.patternservice.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {

    private Long id;
    private String branch;
    private String division;
    private Address address;
    private Integer index;
    private String phone;
    private String fax;
    private String email;
    private License license;
}
