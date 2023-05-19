package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TitlePatternDto {

    private Long id;
    private TextCenteredDto textCentered;

    @Override
    public String toString() {
        return "TitlePatternDto{" +
                "id=" + id +
                ", textCentered=" + textCentered +
                '}';
    }
}
