package ru.nabokov.docservice.dto.client.data_service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TypeDto {

    private long id;
    private String name;
    private List<DocumentationDto> documentations;

    @Override
    public String toString() {
        return "TypeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
