package ru.nabokov.docservice.model.sixthSection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subheading_sections")
public class SubheadingSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "subheading")
    private String subheading;
    @Column(name = "conclusion")
    private String conclusion;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "subheading_sections_recommendations",
            joinColumns =  {@JoinColumn(name = "subheading_id")},
            inverseJoinColumns = {@JoinColumn(name = "recommendation_id")})
    @ToString.Exclude
    private List<Recommendations> recommendations;
    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonIgnore
    private SixthSection sixthSection;
}
