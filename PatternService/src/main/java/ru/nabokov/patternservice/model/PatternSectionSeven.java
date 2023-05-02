package ru.nabokov.patternservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pattern_section_seven")
public class PatternSectionSeven {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "header_id", referencedColumnName = "id")
    private Header header;
    @OneToMany(mappedBy = "patternSectionSeven", fetch = FetchType.LAZY)
    private List<Drawing> drawings;
}
