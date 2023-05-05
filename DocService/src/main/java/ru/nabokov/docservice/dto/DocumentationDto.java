package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DocumentationDto {

    private String typeDocument;
    private String numberDocument;
    private String title;

    @Override
    public String toString() {
        return "DocumentationDto{" +
                "typeDocument='" + typeDocument + '\'' +
                ", numberDocument='" + numberDocument + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
