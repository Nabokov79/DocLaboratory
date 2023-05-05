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
@Table(name = "titles")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "header_id", referencedColumnName = "id")
    private TitleHeader header;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "license_id", referencedColumnName = "id")
    private License license;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "text_id", referencedColumnName = "id")
    private TextCentered text;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "footer_id", referencedColumnName = "id")
    private Footer footer;
}
