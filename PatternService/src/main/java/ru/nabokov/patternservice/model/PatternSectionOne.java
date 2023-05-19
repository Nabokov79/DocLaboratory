package ru.nabokov.patternservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pattern_section_one")
public class PatternSectionOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "header_id", referencedColumnName = "id")
    private Header header;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "pattern_section_one_subheadings",
            joinColumns = {@JoinColumn(name = "pattern_section_one_id")},
            inverseJoinColumns = {@JoinColumn(name = "subheading_id")})
    @ToString.Exclude
    private List<Subheading> subheadings;

    @Override
    public String toString() {
        return "PatternSectionOne{" +
                "id=" + id +
                ", header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
