package ru.nabokov.passportservice.model.passport;

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
@Table(name = "standard_size_pipes")
public class StandardSizePipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "diameter")
    private Integer diameter;
    @Column(name = "thickness")
    private Float thickness;
}
