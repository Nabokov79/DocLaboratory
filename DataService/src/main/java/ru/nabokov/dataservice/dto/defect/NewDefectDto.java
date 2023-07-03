package ru.nabokov.dataservice.dto.defect;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового дефекта")
public class NewDefectDto {

    @Schema(description = "Название дефекта")
    @NotBlank(message = "defect name should not be blank")
    private String name;
}
