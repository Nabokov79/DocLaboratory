package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.*;
import ru.nabokov.docservice.dto.pattern.*;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.dto.OrganizationDto;
import ru.nabokov.docservice.mapper.SectionMapper;
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
    private final SectionMapper mapper;
    private final StringBuilderService stringService;

    @Override
    public void save(FirstSection section, ReportDataBuilder builder) {
        Map<Double, DataFirstSection> dataSections = mapper.mapToDataFirstSection(builder.getPattern().getSubheadings())
                                                        .stream()
                                                        .collect(Collectors.toMap(DataFirstSection::getNumber, d -> d));
        Map<Double, SubheadingDto> subheadings = builder.getPattern().getSubheadings().stream()
                                                           .collect(Collectors.toMap(SubheadingDto::getNumber, s -> s));
        for (Double number : dataSections.keySet()) {
            DataFirstSection data = dataSections.get(number);
            if (data.getText() == null && data.getDocumentations() == null) {
                data.setLaboratoryData(setLaboratoryData(builder.getBranch(), builder.getLicense()));
                String employeeFirst = "";
                String employeeSecond = "";
                for (EmployeeDto employee : builder.getEmployees()) {
                    if (employeeFirst.isBlank()) {
                        employeeFirst = getStringEmployees(employee);
                    } else {
                        employeeSecond = getStringEmployees(employee);
                    }
                }
                data.setEmployeeFirst(employeeFirst);
                data.setEmployeeSecond(employeeSecond);
            }
            if (data.getDocumentations() != null) {
                data.setDocumentations(toStringDocumentation(subheadings.get(number).getDocumentations()));
            }
            data.setSection(section);
            dataSections.put(number, data);
        }
        repository.saveAll(new ArrayList<>(dataSections.values()));
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

    private String getStringEmployees(EmployeeDto employee) {
        String initials = String.join(". ", String.valueOf(employee.getName().charAt(0))
                , String.valueOf(employee.getPatronymic().charAt(0)));
        return String.join(" - ", " ", employee.getPost()
                , String.join(", "
                        , String.join(" ", employee.getSurname(), initials)
                        , toStringCertificateEmployee(employee.getCertificate())));
    }

    private String setLaboratoryData(BranchDto branchDto, String license) {
        return String.join(" ", branchDto.getDivision()
                                      , String.join(" ", branchDto.getBranch()
                                                               , toStringType(branchDto.getOrganization().getType())
                                                               , branchDto.getOrganization().getName()
                                                               , branchDto.getDivision())
                                      , String.valueOf(branchDto.getIndex())
                                      , branchDto.getAddress().getCity().getName().split(" ")[1]
                                      , branchDto.getAddress().getStreet()
                                      , stringService.getStringAddress(branchDto.getAddress())
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
