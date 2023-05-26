package ru.nabokov.patternservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "elements")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "item")
    private Integer item;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
    private List<Place> places;
    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
    private List<Defect> defects;
    @ManyToOne
    @JoinColumn(name = "pattern_table_id")
    @JsonIgnore
    private PatternTable patternTable;

}
