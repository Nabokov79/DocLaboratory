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
@Table(name = "drawings")
public class Drawing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "drawing")
    private String drawing;
    @Column(name = "list")
    private String list;
    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonIgnore
    private SeventhSection section;
}
