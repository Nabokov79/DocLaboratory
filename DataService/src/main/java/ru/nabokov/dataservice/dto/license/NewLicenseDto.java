package ru.nabokov.dataservice.dto.license;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные новой лицензии")
public class NewLicenseDto {

    @Schema(description = "Вид документа")
    @NotBlank(message = "document should not be blank")
    private String document;
    @Schema(description = "Индентификатор организации")
    @NotNull(message = "organization id should not be blank")
    @Positive(message = "organization id can only be positive")
    private Long organizationId;
    @Schema(description = "Номер лицензии")
    @NotBlank(message = "number license should not be blank")
    private String number;
    @Schema(description = "Дата выдачи лицензии")
    @NotNull(message = "date license should not be blank")
    private LocalDate date;
}
