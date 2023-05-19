package ru.nabokov.patternservice.dto.element;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PipelineElement {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return "PipelineElement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
