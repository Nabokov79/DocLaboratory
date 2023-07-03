package ru.nabokov.passportservice.model.norms;

import lombok.*;
import ru.nabokov.passportservice.model.pipeline.PipelineNorm;
import ru.nabokov.passportservice.model.passport.Belt;
import ru.nabokov.passportservice.model.passport.Bottom;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tank_norms")
public class TankNorm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type_id")
    private Long typeId;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tank_norms_bottoms",
            joinColumns =  {@JoinColumn(name = "tank_norm_id")},
            inverseJoinColumns = {@JoinColumn(name = "bottom_id")})
    @ToString.Exclude
    private List<Bottom> bottoms;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tank_norms_belts",
            joinColumns =  {@JoinColumn(name = "tank_norm_id")},
            inverseJoinColumns = {@JoinColumn(name = "belt_id")})
    @ToString.Exclude
    private List<Belt> belts;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "norms_pipeline_norms",
            joinColumns =  {@JoinColumn(name = "norm_id")},
            inverseJoinColumns = {@JoinColumn(name = "pipeline_norm_id")})
    @ToString.Exclude
    private List<PipelineNorm> pipelineNorms;
}
