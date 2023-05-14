package ru.nabokov.docservice.model;

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
@Table(name = "seventh_sections")
public class SeventhSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "heading")
    private String heading;
    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
    private List<Drawing> drawings;
}
