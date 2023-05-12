package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PipelinePatternTableDto {

    private long id;
    private String name;
    private List<ColumnHeaderDto> columnHeaders;
    private List<PipelineTableDto> pipelineTables;

    @Override
    public String toString() {
        return "PipelinePatternTableDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", columnHeaders=" + columnHeaders +
                ", pipelineTables=" + pipelineTables +
                '}';
    }
}
