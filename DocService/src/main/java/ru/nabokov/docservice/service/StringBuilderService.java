package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.data_service.*;
import ru.nabokov.docservice.dto.client.pattern_servicce.DrawingDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.HeaderDto;
import ru.nabokov.docservice.model.Document;
import java.util.List;

public interface StringBuilderService {

    String toStringAddress(AddressDto addressDto);

    String toStringHeader(HeaderDto header);

    String toStringSubheading(Double number, String heading);

    String toStringDrawing(DrawingDto drawingDto);

    String toStringCountList(Integer count);

    String toStringConclusion(TypeDto type , Integer number, String conclusion);

    List<Document> toStringDocumentation(List<DocumentationDto> documentationsDto);

    String toStringEmployees(EmployeeDto employee);

    String toStringLaboratoryData(BranchDto branchDto, String license);

    String toStringType(String type);

    String toStringCertificateEmployee(List<CertificateDto> certificateDto);
}
