package ru.nabokov.dataservice.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о сотруднике")
public class UpdateEmployeeDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id user should not be blank")
    @Positive(message = "id user must be positive")
    private Long id;
    @Schema(description = "Имя")
    @NotBlank(message = "name should not be blank")
    private String name;
    @Schema(description = "Отчество")
    @NotBlank(message = "patronymic should not be blank")
    private String patronymic;
    @Schema(description = "Фамилия")
    @NotBlank(message = "surname should not be blank")
    private String surname;
    @Schema(description = "Должность")
    @NotBlank(message = "post should not be blank")
    private String post;
    @Schema(description = "Табельный номер")
    @NotNull(message = "service number should not be blank")
    private Integer serviceNumber;
}
