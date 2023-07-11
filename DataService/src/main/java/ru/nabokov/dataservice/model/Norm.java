package ru.nabokov.dataservice.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "norms")
public class Norm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "element_id", referencedColumnName = "id")
    private Element element;
    @Column(name = "size_tolerance")
    private Float sizeTolerance;
    @Column(name = "min")
    private Float min;
    @Column(name = "percent_min")
    private Integer percentMin;
}
