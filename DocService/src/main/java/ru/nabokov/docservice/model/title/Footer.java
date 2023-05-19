package ru.nabokov.docservice.model.title;

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
@Table(name = "footers")
public class Footer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "post")
    private String post;
    @Column(name = "initials")
    private String initials;
    @Column(name = "city")
    private String city;
    @Column(name = "year")
    private String year;
}
