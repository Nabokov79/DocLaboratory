package ru.nabokov.dataservice.dto.measuringTool;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.model.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Измерительный инструмент(прибор)")
public class MeasuringToolDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название")
    private String name;
    @Schema(description = "Модель")
    private String model;
    @Schema(description = "Заводской номер")
    private Integer workNumber;
    @Schema(description = "Назначение")
    private String purpose;
    @Schema(description = "Дата изготовления")
    private LocalDate manufacturing;
    @Schema(description = "Дата начала эксплуатации")
    private LocalDate exploitation;
    @Schema(description = "Организация-изготовитель")
    private Manufacturer manufacturer;
    @Schema(description = "Диапазон измерений")
    private String  measuringRange;
    @Schema(description = "Характеристики")
    private String characteristics;
    @Schema(description = "Владелец средства(прибора)")
    private Branch branch;
    @Schema(description = "Дата поверки")
    private LocalDate verificationDate;
    @Schema(description = "Дата следующей поверки")
    private LocalDate nextVerificationDate;
    @Schema(description = "Метрологическая организация")
    private Organization organization;
    @Schema(description = "Номер свидетельства о поверке")
    private String certificateNumber;
    @Schema(description = "Номер госреестра")
    private String registry;
    @Schema(description = "Примечание")
    private String note;
    @Schema(description = "Вид контроля")
    private ControlType type;
    @Schema(description = "Сотрудник")
    private Employee employee;
}
