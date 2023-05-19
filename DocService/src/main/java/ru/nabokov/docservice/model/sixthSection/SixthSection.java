package ru.nabokov.docservice.model.sixthSection;

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
@Table(name = "sixth_sections")
public class SixthSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "heading")
    private String heading;
    @OneToMany(mappedBy = "sixthSection", fetch = FetchType.LAZY)
    private List<SubheadingSection> subheadings;
}
