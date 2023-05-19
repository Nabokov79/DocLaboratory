package ru.nabokov.patternservice.dto.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.dto.element.PipelineElement;
import ru.nabokov.patternservice.model.Pipeline;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PipelineTableDto {

    private Long id;
    private Pipeline pipeline;
    private List<PipelineElement> elements;
}
