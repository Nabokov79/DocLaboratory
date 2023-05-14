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
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "title_id", referencedColumnName = "id")
    private Title title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "first_section_id", referencedColumnName = "id")
    private FirstSection firstSection;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "second_section_id", referencedColumnName = "id")
    private SecondSection secondSection;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "third_section_id", referencedColumnName = "id")
    private ThirdSection thirdSection;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seventh_section_id", referencedColumnName = "id")
    private SeventhSection seventhSection;
}
