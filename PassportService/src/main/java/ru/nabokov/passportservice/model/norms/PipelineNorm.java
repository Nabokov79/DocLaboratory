package ru.nabokov.passportservice.model.norms;

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
@Table(name = "pipeline_norms")
public class PipelineNorm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "diameter")
    private Integer diameter;
    @Column(name = "min")
    private Float min;
}
