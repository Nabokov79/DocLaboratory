package ru.nabokov.docservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.model.seventhSection.SeventhSection;
import ru.nabokov.docservice.model.sixthSection.SixthSection;
import ru.nabokov.docservice.model.thirdSection.ThirdSection;
import ru.nabokov.docservice.model.title.Title;

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
    @Column(name = "odject_data_id")
    private Long objectDataId;
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
    @JoinColumn(name = "sixth_section_id", referencedColumnName = "id")
    private SixthSection sixthSection;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seventh_section_id", referencedColumnName = "id")
    private SeventhSection seventhSection;
}
