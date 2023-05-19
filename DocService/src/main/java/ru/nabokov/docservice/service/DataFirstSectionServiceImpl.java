package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.*;
import ru.nabokov.docservice.dto.client.pattern.*;
import ru.nabokov.docservice.dto.client.title.BranchDto;
import ru.nabokov.docservice.dto.OrganizationDto;
import ru.nabokov.docservice.model.DataFirstSection;
import ru.nabokov.docservice.model.Document;
import ru.nabokov.docservice.model.FirstSection;
import ru.nabokov.docservice.repository.DataFirstSectionRepository;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataFirstSectionServiceImpl implements DataFirstSectionService {

    private static final String FROM = "от";
    private static final String ISSUED = "выдано";
    private static final String LEVEL_TEXT = "уровень квалификации по";
    private final DataFirstSectionRepository repository;
    private final StringBuilderService stringBuilder;

    @Override
    public void save(FirstSection section, ReportDataBuilder builder) {
        List<DataFirstSection> dataFirstSections = new ArrayList<>();
        Map<Double, SubheadingDto> subheadings = builder.getPattern().getSubheadings().stream()
                                                           .collect(Collectors.toMap(SubheadingDto::getNumber, s -> s));
        for (SubheadingDto subheadingDto : subheadings.values()) {
            DataFirstSection data = new DataFirstSection();
            data.setHeading(stringBuilder.toStringSubheading(subheadingDto.getNumber(), subheadingDto.getHeading()));
            if (data.getText() != null) {
                data.setText(subheadingDto.getText());
            } else {
                if (data.getDocumentations() == null) {
                    data.setLaboratoryData(toStringLaboratoryData(builder.getBranch(), builder.getLicense()));
                    String employeeFirst = "";
                    String employeeSecond = "";
                    for (EmployeeDto employee : builder.getEmployees()) {
                        if (employeeFirst.isBlank()) {
                            employeeFirst = toStringEmployees(employee);
                        } else {
                            employeeSecond = toStringEmployees(employee);
                        }
                    }
                    data.setEmployeeFirst(employeeFirst);
                    data.setEmployeeSecond(employeeSecond);
                } else {
                    data.setDocumentations(toStringDocumentation(subheadingDto.getDocumentations()));
                }
            }
            data.setSection(section);
            dataFirstSections.add(data);
        }
        repository.saveAll(dataFirstSections);
    }

    private List<Document> toStringDocumentation(List<DocumentationDto> documentationsDto) {
        List<Document> documentations = new ArrayList<>();
        for (DocumentationDto documentation : documentationsDto) {
            Document document = new Document();
            document.setDocument(String.join(" "," - ", documentation.getTypeDocument()
                    , documentation.getNumberDocument()
                    , documentation.getTitle()));
            documentations.add(document);
        }
        return documentations;
    }

    private String toStringEmployees(EmployeeDto employee) {
        String initials = String.join(". ", String.valueOf(employee.getName().charAt(0))
                , String.valueOf(employee.getPatronymic().charAt(0)));
        return String.join(" - ", " ", employee.getPost()
                , String.join(", "
                        , String.join(" ", employee.getSurname(), initials)
                        , toStringCertificateEmployee(employee.getCertificate())));
    }

    private String toStringLaboratoryData(BranchDto branchDto, String license) {
        return String.join(" ", branchDto.getDivision()
                                      , String.join(" ", branchDto.getBranch()
                                                               , toStringType(branchDto.getOrganization().getType())
                                                               , branchDto.getOrganization().getName()
                                                               , branchDto.getDivision())
                                      , String.valueOf(branchDto.getIndex())
                                      , branchDto.getAddress().getCity().getName().split(" ")[1]
                                      , branchDto.getAddress().getStreet()
                                      , stringBuilder.toStringAddress(branchDto.getAddress())
                                      , license);
    }

    private String toStringType(String type) {
        String[] typeString = type.split(" ");
        for (int i = 0; i < typeString.length; i++) {
            typeString[i] = String.valueOf(typeString[i].charAt(0)).toUpperCase();
        }
        return Arrays.toString(typeString);
    }

    private String toStringCertificateEmployee(List<CertificateDto> certificateDto) {
        List<Integer> levels = certificateDto.stream()
                                             .map(CertificateDto::getLevel)
                                             .distinct()
                                             .toList();
        List<String> organizations = certificateDto.stream()
                                                   .map(CertificateDto::getOrganization)
                                                   .map(OrganizationDto::getName)
                                                   .distinct()
                                                   .toList();
        List<String> numbers = certificateDto.stream()
                                             .map(CertificateDto::getNumber)
                                             .distinct()
                                             .toList();
        if (levels.size() == 1 && organizations.size() == 1 && numbers.size() == 1) {
            OrganizationDto organization = certificateDto.stream()
                                                    .map(CertificateDto::getOrganization)
                                                    .distinct()
                                                    .toList().get(0);
            String documentType = certificateDto.stream()
                                                .map(CertificateDto::getDocumentType)
                                                .distinct()
                                                .toList().get(0);
            return String.join(" ", String.valueOf(levels.get(0))
                    , LEVEL_TEXT, String.join(",", certificateDto.stream()
                                                                         .map(CertificateDto::getType)
                                                                         .map(ControlTypeDto::getName)
                                                                         .toList()).toUpperCase()
                    , documentType, String.join(" ", String.valueOf(certificateDto.stream()
                                                                                         .map(CertificateDto::getNumber)
                                                                                         .distinct()
                                                                                         .toList())
                    , FROM, String.valueOf(certificateDto.stream()
                                                          .map(CertificateDto::getStart)
                                                          .distinct()
                                                          .toList())
                    , ISSUED, organization.getType().toUpperCase(), organization.getName())
            );
        } else {
            List<String> certificates = new ArrayList<>();
            for (CertificateDto certificate : certificateDto) {
                certificates.add(String.join(" ", String.valueOf(certificate.getLevel())
                        , LEVEL_TEXT, certificate.getType().getName().toUpperCase()
                        , certificate.getDocumentType(), certificate.getNumber()
                        , ISSUED, certificate.getOrganization().getType(), certificate.getOrganization().getName()));
            }
            return String.join("; ", certificates);
        }
    }
}
