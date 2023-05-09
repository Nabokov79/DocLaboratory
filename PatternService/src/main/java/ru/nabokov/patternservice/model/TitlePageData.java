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
@Table(name = "title_page_data")
public class TitlePageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "report_name")
    private String reportName;
    @Column(name = "text_first")
    private String textFirst;
    @Column(name = "object")
    private String object;
    @Column(name = "text_second")
    private String textSecond;
    @Column(name = "post")
    private String post;
    @Column(name = "city")
    private String city;
    @Column(name = "year")
    private String year;
}
