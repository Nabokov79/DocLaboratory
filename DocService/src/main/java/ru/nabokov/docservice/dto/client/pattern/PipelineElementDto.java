package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PipelineElementDto {

    private String name;

    @Override
    public String toString() {
        return "PipelineElementDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
