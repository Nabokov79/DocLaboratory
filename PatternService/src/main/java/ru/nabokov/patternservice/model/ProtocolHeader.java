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
@Table(name = "protocol_headers")
public class ProtocolHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "document")
    private String document;
    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
    @Column(name = "header_measurements")
    private String headerMeasurements;
    @Column(name = "location")
    private String location;
    @Column(name = "admissibility")
    private String admissibility;

    @Override
    public String toString() {
        return "ProtocolHeader{" +
                "id=" + id +
                ", number=" + number +
                ", document='" + document + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", headerMeasurements='" + headerMeasurements + '\'' +
                ", location='" + location + '\'' +
                ", admissibility='" + admissibility + '\'' +
                '}';
    }
}
