package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PipelineTableDto {

    private Long id;
    private PipelineDto pipeline;
    private List<PipelineElementDto> elements;

    @Override
    public String toString() {
        return "PipelineTableDto{" +
                "id=" + id +
                ", pipeline=" + pipeline +
                ", elements=" + elements +
                '}';
    }
}
