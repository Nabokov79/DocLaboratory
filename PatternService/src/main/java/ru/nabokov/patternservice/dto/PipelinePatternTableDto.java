package ru.nabokov.patternservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.model.ColumnHeader;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PipelinePatternTableDto {

    private long id;
    private String name;
    private List<ColumnHeader> columnHeaders;
    private List<PipelineTableDto> pipelineTables;
}
