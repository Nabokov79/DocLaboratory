package ru.nabokov.patternservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subheadings")
public class Subheading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private Double number;
    @Column(name = "heading")
    private String heading;
    @Column(name = "text")
    private String text;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "subheadings_column_headers",
            joinColumns = {@JoinColumn(name = "subheading_id")},
            inverseJoinColumns = {@JoinColumn(name = "column_header_id")})
    @ToString.Exclude
    private List<ColumnHeader> columnHeaders;
    @OneToMany(mappedBy = "subheading", fetch = FetchType.LAZY)
    private List<Documentation> documentations;
}
