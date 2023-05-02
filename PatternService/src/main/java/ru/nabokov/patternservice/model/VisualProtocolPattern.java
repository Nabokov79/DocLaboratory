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
@Table(name = "visual_protocol_patterns")
public class VisualProtocolPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "protocol_header_id", referencedColumnName = "id")
    private ProtocolHeader protocolHeader;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_table_id", referencedColumnName = "id")
    private PatternTable patternTable;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_conclusion_id", referencedColumnName = "id")
    private PatternConclusion patternConclusion;
}
