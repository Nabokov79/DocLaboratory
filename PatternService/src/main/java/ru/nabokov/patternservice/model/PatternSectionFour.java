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
@Table(name = "pattern_section_four")
public class PatternSectionFour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "header_id", referencedColumnName = "id")
    private Header header;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visual_protocol_pattern_id", referencedColumnName = "id")
    private VisualProtocolPattern visualProtocolPattern;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ultrasonic_protocol_pattern_id", referencedColumnName = "id")
    private UltrasonicProtocolPattern ultrasonicProtocolPattern;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geodesy_protocol_pattern_id", referencedColumnName = "id")
    private GeodesyProtocolPattern geodesyProtocolPattern;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hardness_protocol_pattern_id", referencedColumnName = "id")
    private HardnessProtocolPattern hardnessProtocolPattern;
}
