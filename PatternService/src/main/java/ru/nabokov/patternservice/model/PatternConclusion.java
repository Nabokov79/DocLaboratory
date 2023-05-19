package ru.nabokov.patternservice.model;

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
@Table(name = "pattern_conclusions")
public class PatternConclusion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "is_not_defect")
    private String isNotDefect;
    @Column(name = "is_defect")
    private String isDefect;

    @Override
    public String toString() {
        return "PatternConclusion{" +
                "id=" + id +
                ", isNotDefect='" + isNotDefect + '\'' +
                ", isDefect='" + isDefect + '\'' +
                '}';
    }
}
