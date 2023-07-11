package ru.nabokov.passportservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "object_characteristics")
public class ObjectCharacteristics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "characteristic_id", referencedColumnName = "id")
    private Characteristic characteristic;
    @Column(name = "meaning")
    private String meaning;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "passport_id",  nullable = false)
    @JsonIgnore
    private Passport passport;
}
