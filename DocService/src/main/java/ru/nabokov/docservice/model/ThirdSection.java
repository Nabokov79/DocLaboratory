package ru.nabokov.docservice.model;

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
@Table(name = "third_sections")
public class ThirdSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "heading")
    private String heading;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "repairs_table_id", referencedColumnName = "id")
    private RepairsTable repairsTable;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "surveys_table_id", referencedColumnName = "id")
    private SurveysTable surveysTable;
}
