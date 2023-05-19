package ru.nabokov.docservice.model.thirdSection;

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
@Table(name = "repairs")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date")
    private String date;
    @Column(name = "description")
    private String description;
    @Column(name = "organization")
    private String organization;
    @ManyToOne
    @JoinColumn(name = "repairs_table_id")
    @JsonIgnore
    private RepairsTable repairsTable;
}
