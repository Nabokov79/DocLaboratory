package ru.nabokov.dataservice.dto.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.model.Address;
import ru.nabokov.dataservice.model.Employee;
import ru.nabokov.dataservice.model.ObjectData;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ApplicationDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Адреса местонахождения котельной")
    private Address address;
    @Schema(description = "Проводимые работы")
    private String work;
    @Schema(description = "Объект обследования")
    private ObjectData objectData;
    @Schema(description = "Первичное обсдедование")
    private LocalDate primaryData;
    @Schema(description = "Повторное обследование")
    private LocalDate repeatData;
    @Schema(description = "Оформить отчет")
    private Boolean report;
    @Schema(description = "Оформить протокол визуального и измерительного контроля")
    private Boolean visual;
    @Schema(description = "Оформить протокол ультразвуковой толщинометрии")
    private Boolean ultrasonic;
    @Schema(description = "Оформить протокол геодезической съемки")
    private Boolean geodesy;
    @Schema(description = "Оформить протокол измерения твердости металла")
    private Boolean hardness;
    @Schema(description = "Примечание")
    private String note;
    @Schema(description = "Сотрудники, проводившие обследование")
    private List<Employee> employees;
}
