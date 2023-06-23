package ru.nabokov.patternservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subheadings")
public class Subheading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private String number;
    @Column(name = "heading")
    private String heading;
    @Column(name = "text")
    private String text;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conclusion_id", referencedColumnName = "id")
    private PatternConclusion conclusion;
    @OneToMany(mappedBy = "subheading", fetch = FetchType.LAZY)
    private List<Recommendation> recommendations;

    @Override
    public String toString() {
        return "Subheading{" +
                "id=" + id +
                ", number=" + number +
                ", heading='" + heading + '\'' +
                ", text='" + text + '\'' +
                ", recommendations=" + recommendations +
                '}';
    }
}
