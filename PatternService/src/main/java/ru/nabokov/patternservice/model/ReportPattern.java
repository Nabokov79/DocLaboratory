package ru.nabokov.patternservice.model;

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
@Table(name = "report_patterns")
public class ReportPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type_id")
    private Long typeId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "title_pattern_id", referencedColumnName = "id")
    private TitlePattern titlePattern;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_section_one_id", referencedColumnName = "id")
    private PatternSectionOne patternSectionOne;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_section_two_id", referencedColumnName = "id")
    private PatternSectionTwo patternSectionTwo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_section_three_id", referencedColumnName = "id")
    private PatternSectionThree patternSectionThree;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_section_four_id", referencedColumnName = "id")
    private PatternSectionFour patternSectionFour;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_section_five_id", referencedColumnName = "id")
    private PatternSectionFive patternSectionFive;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_section_six_id", referencedColumnName = "id")
    private PatternSectionSix patternSectionSix;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_section_seven_id", referencedColumnName = "id")
    private PatternSectionSeven patternSectionSeven;
}
