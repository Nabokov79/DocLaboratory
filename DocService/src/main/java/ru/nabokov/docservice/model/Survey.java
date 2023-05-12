package ru.nabokov.docservice.model;

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
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date")
    private String date;
    @Column(name = "survey")
    private String survey;
    @Column(name = "number_document")
    private String numberDocument;
    @Column(name = "organization")
    private String organization;
    @ManyToOne
    @JoinColumn(name = "surveys_table_id")
    @JsonIgnore
    private SurveysTable surveysTable;
}
