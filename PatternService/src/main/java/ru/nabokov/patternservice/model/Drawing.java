package ru.nabokov.patternservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drawings")
public class Drawing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type")
    private String type;
    @Column(name = "number")
    private Integer number;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "pattern_section_seven_id")
    @JsonIgnore
    private PatternSectionSeven patternSectionSeven;

    @Override
    public String toString() {
        return "Drawing{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", patternSectionSeven=" + patternSectionSeven +
                '}';
    }
}
