package ru.nabokov.docservice.service.title;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.TitlePatternDto;
import ru.nabokov.docservice.dto.title.BranchDto;
import ru.nabokov.docservice.dto.title.ObjectDataDto;
import ru.nabokov.docservice.exceptions.BadRequestException;
import ru.nabokov.docservice.model.*;
import ru.nabokov.docservice.repository.TitleRepository;
import ru.nabokov.docservice.service.LicenseService;

@Service
@RequiredArgsConstructor
public class TitleServiceImpl implements TitleService {

    private final TitleRepository repository;
    private final TitleHeaderService titleHeaderService;
    private final LicenseService licenseService;
    private final TextCenteredService textCenteredService;
    private final FooterService footerService;


    @Override
    public Title save(ObjectDataDto objectData, BranchDto branch, TitlePatternDto titlePattern) {
        Title title = new Title();
        License license = licenseService.save(branch);
        if (license == null) {
            throw new BadRequestException(
                    String.format("branch data for license should not be null, branch=%s", branch)
            );
        }
        TitleHeader header = titleHeaderService.save(branch);
        if (header == null) {
            throw new BadRequestException(
                    String.format("branch data title header should not be null, branch=%s", branch)
            );
        }
        title.setHeader(header);
        title.setLicense(license);
        TextCentered textCentered = textCenteredService.save(objectData,titlePattern.getTextCentered());
        if (textCentered == null) {
            throw new BadRequestException(
                    String.format("object data and text centered data should not be null, objectData=%s, " +
                                                                           "textCentered=%s",
                                                                           objectData,
                                                                           titlePattern.getTextCentered())
            );
        }
        title.setText(textCentered);
        Footer footer = footerService.save(titlePattern.getTextCentered());
        if (footer == null) {
            throw new BadRequestException(
                 String.format("text centered data should not be null, textCentered=%s", titlePattern.getTextCentered())
            );
        }
        title.setFooter(footer);
        return repository.save(title);
    }
}
