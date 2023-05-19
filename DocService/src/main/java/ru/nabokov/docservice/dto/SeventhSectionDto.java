package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.dto.client.pattern.DrawingDto;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные раздела № 7")
public class SeventhSectionDto {

    private SectionHeaderDto sectionHeader;
    private List<DrawingDto> drawings;
}
