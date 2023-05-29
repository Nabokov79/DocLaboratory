package ru.nabokov.docservice.service.title;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.ReportDataBuilder;
import ru.nabokov.docservice.exceptions.BadRequestException;
import ru.nabokov.docservice.model.*;
import ru.nabokov.docservice.model.title.Footer;
import ru.nabokov.docservice.model.title.TextCentered;
import ru.nabokov.docservice.model.title.Title;
import ru.nabokov.docservice.model.title.TitleHeader;
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
    public Title save(ReportDataBuilder builder) {
        Title title = new Title();
        License license = licenseService.save(builder.getBranch().getLicense(), builder.getBranch().getDivision());
        if (license == null) {
            throw new BadRequestException(
                    String.format("branch data for license should not be null, branch=%s", builder.getBranch())
            );
        }
        TitleHeader header = titleHeaderService.save(builder.getBranch());
        if (header == null) {
            throw new BadRequestException(
                    String.format("branch data title header should not be null, branch=%s", builder.getBranch())
            );
        }
        title.setHeader(header);
        title.setLicense(license);
        TextCentered textCentered = textCenteredService.save(builder.getObjectData()
                                                                         , builder.getTitlePattern());
        if (textCentered == null) {
            throw new BadRequestException(
                    String.format("object data and text centered data should not be null, objectData=%s, " +
                                                                                                     "textCentered=%s",
                                                                            builder.getObjectData(),
                                                                            builder.getTitlePattern())
            );
        }
        title.setText(textCentered);
        Footer footer = footerService.save(builder.getTitlePattern());
        if (footer == null) {
            throw new BadRequestException(
                 String.format("text centered data should not be null, textCentered=%s", builder.getTitlePattern())
            );
        }
        title.setFooter(footer);
        return repository.save(title);
    }
}
