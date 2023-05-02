package ru.nabokov.patternservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "geodesy_protocol_patterns")
public class GeodesyProtocolPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "protocol_header_id", referencedColumnName = "id")
    private ProtocolHeader protocolHeader;
    @OneToMany(mappedBy = "geodesyProtocolPattern", fetch = FetchType.LAZY)
    private List<PatternTable> patternTables;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_conclusion_id", referencedColumnName = "id")
    private PatternConclusion patternConclusion;
}
