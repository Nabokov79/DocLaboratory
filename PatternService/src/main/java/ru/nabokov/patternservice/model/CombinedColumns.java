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
@Table(name = "combined_columns")
public class CombinedColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number_first")
    private Integer numberFirst;
    @Column(name = "name_first")
    private String nameFirst;
    @Column(name = "number_second")
    private Integer numberSecond;
    @Column(name = "name_second")
    private String nameSecond;
    @Column(name = "name")
    private String name;
}
