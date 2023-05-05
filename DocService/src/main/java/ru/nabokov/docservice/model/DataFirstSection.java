package ru.nabokov.docservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "data_first_sections")
public class DataFirstSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private Double number;
    @Column(name = "heading")
    private String heading;
    @Column(name = "text")
    private String text;
    @Column(name = "laboratory_data")
    private String laboratoryData;
    @Column(name = "chief")
    private String chief;
    @Column(name = "employee_first")
    private String employeeFirst;
    @Column(name = "employee_second")
    private String employeeSecond;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "data_first_sections_documents",
            joinColumns = {@JoinColumn(name = "data_first_section_id")},
            inverseJoinColumns = {@JoinColumn(name = "document_id")})
    @ToString.Exclude
    private List<Document> documents;
    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonIgnore
    private FirstSection section;
}
