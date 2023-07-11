package ru.nabokov.passportservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "object_data_id")
    private Long objectDataId;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_belts",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "belt_id")})
    @ToString.Exclude
    private List<Belt> belts;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_bottoms",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "bottom_id")})
    @ToString.Exclude
    private List<Bottom> bottoms;
    @OneToMany(mappedBy = "passport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjectCharacteristics> characteristics;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_standard_size_pipes",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "standardSize_pipe_id")})
    @ToString.Exclude
    private List<StandardSizePipe> standardSizePipe;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_surveys",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "survey_id")})
    @ToString.Exclude
    private List<Survey> surveys;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "passports_repairs",
            joinColumns =  {@JoinColumn(name = "passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "repair_id")})
    @ToString.Exclude
    private List<Repair> repairs;
}
