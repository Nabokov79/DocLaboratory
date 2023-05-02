package ru.nabokov.patternservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pattern_section_five")
public class PatternSectionFive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "header_id", referencedColumnName = "id")
    private Header header;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "pattern_section_five_subheadings",
            joinColumns = {@JoinColumn(name = "pattern_section_five_id")},
            inverseJoinColumns = {@JoinColumn(name = "subheading_id")})
    @ToString.Exclude
    private List<Subheading> subheadings;
}
