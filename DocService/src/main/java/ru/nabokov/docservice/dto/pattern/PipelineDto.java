package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PipelineDto {

    private String name;

    @Override
    public String toString() {
        return "PipelineDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
