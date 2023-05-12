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
@Table(name = "second_section_data")
public class SecondSectionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "heading")
    private String heading;
    @Column(name = "meaning")
    private String meaning;
    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonIgnore
    private SecondSection section;
}
