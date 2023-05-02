package ru.nabokov.patternservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "title_page_data")
public class TitlePageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "organization_type")
    private String organizationType;
    @Column(name = "organization_name")
    private String organizationName;
    @Column(name = "organization_branch")
    private String organizationBranch;
    @Column(name = "organization_division")
    private String organizationDivision;
    @Column(name = "division_license")
    private String divisionLicense;
    @Column(name = "date")
    private LocalDate date;
}
