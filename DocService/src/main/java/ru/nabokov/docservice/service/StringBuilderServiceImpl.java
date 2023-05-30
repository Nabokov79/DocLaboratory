package ru.nabokov.docservice.service;

import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.data_service.*;
import ru.nabokov.docservice.dto.client.pattern_servicce.DrawingDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.HeaderDto;
import ru.nabokov.docservice.model.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class StringBuilderServiceImpl implements StringBuilderService {

    private static final String HOUSE = "д.";
    private static final String BUILDING = "к.";
    private static final String LETTER = "лит.";
    private static final CharSequence WHITESPACE = " ";
    private static final CharSequence WHITESPACE_NULL = "";
    private static final CharSequence COMMA = ", ";
    private static final CharSequence POINT = ". ";
    private static final CharSequence NUMBER = "№ ";
    private static final String FROM = "от";
    private static final String ISSUED = "выдано";
    private static final String LEVEL_TEXT = "уровень квалификации по";

    @Override
    public String toStringAddress(AddressDto addressDto) {
        String address = String.join(COMMA
                                   , addressDto.getStreet()
                                   , String.join(WHITESPACE_NULL
                                               , HOUSE
                                               , String.valueOf(addressDto.getHouseNumber()))
        );
        if (addressDto.getBuildingNumber() != null) {
            return String.join(COMMA
                             , address
                             , String.join(WHITESPACE_NULL
                                         , BUILDING
                                         , String.valueOf(addressDto.getBuildingNumber())));
        }
        if (addressDto.getLetter() != null) {
            return String.join(COMMA
                             , address
                             , String.join(WHITESPACE_NULL
                                         , LETTER
                                         , addressDto.getLetter()));
        }
        if (addressDto.getBuildingNumber() != null && addressDto.getLetter() != null) {
            return String.join(COMMA
                             , address
                             , String.join(WHITESPACE_NULL
                                         , BUILDING
                                         , String.valueOf(addressDto.getBuildingNumber()))
                                         , String.join(WHITESPACE_NULL
                                                     , LETTER
                                                     , addressDto.getLetter())
                             );
        } else {
            return address;
        }
    }

    @Override
    public String toStringHeader(HeaderDto header) {
        return String.join(POINT
                         , String.valueOf(header.getNumber())
                         , header.getHeading());
    }

    @Override
    public String toStringSubheading(Double number, String heading) {
        return String.join(WHITESPACE
                         , String.valueOf(number)
                         , heading);
    }

    @Override
    public String toStringDrawing(DrawingDto drawingDto) {
        return String.join(WHITESPACE
                , drawingDto.getType()
                , NUMBER
                , String.join(WHITESPACE_NULL
                        , String.valueOf(drawingDto.getNumber())
                        , POINT )
                , drawingDto.getName());
    }

    @Override
    public String toStringCountList(Integer count) {
        List<String> counts = new LinkedList<>();
        for (int i = 1; i == count; i++) {
            counts.add(String.valueOf(i));
        }
        return String.join(COMMA, counts);
    }

    @Override
    public String toStringConclusion(TypeDto type , Integer number, String conclusion) {
        return String.join(WHITESPACE
                , type.getName()
                , NUMBER
                , String.valueOf(number)
                , conclusion);
    }

    @Override
    public List<Document> toStringDocumentation(List<DocumentationDto> documentationsDto) {
        List<Document> documentations = new ArrayList<>();
        for (DocumentationDto documentation : documentationsDto) {
            Document document = new Document();
            document.setDocument(String.join(" "," - ", documentation.getView()
                    , documentation.getNumber()
                    , documentation.getTitle()));
            documentations.add(document);
        }
        return documentations;
    }

    @Override
    public String toStringEmployees(EmployeeDto employee) {
        String initials = String.join(". ", String.valueOf(employee.getName().charAt(0))
                , String.valueOf(employee.getPatronymic().charAt(0)));
        return String.join(" - ", " ", employee.getPost()
                , String.join(", "
                        , String.join(" ", employee.getSurname(), initials)
                        , toStringCertificateEmployee(employee.getCertificate())));
    }

    @Override
    public String toStringLaboratoryData(BranchDto branchDto, String license) {
        return String.join(" ", branchDto.getDivision()
                , String.join(" ", branchDto.getBranch()
                        , toStringType(branchDto.getOrganization().getType())
                        , branchDto.getOrganization().getName()
                        , branchDto.getDivision())
                , String.valueOf(branchDto.getIndex())
                , branchDto.getAddress().getCity().getName().split(" ")[1]
                , branchDto.getAddress().getStreet()
                , toStringAddress(branchDto.getAddress())
                , license);
    }

    @Override
    public String toStringType(String type) {
        String[] typeString = type.split(" ");
        for (int i = 0; i < typeString.length; i++) {
            typeString[i] = String.valueOf(typeString[i].charAt(0)).toUpperCase();
        }
        return Arrays.toString(typeString);
    }

    @Override
    public String toStringCertificateEmployee(List<CertificateDto> certificateDto) {
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
