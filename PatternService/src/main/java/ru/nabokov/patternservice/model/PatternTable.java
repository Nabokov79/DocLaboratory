package ru.nabokov.patternservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pattern_tables")
public class PatternTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "pattern_tables_column_headers",
            joinColumns = {@JoinColumn(name = "pattern_table_id")},
            inverseJoinColumns = {@JoinColumn(name = "column_header_id")})
    @ToString.Exclude
    private List<ColumnHeader> columnHeaders;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "combined_column_id", referencedColumnName = "id")
    private CombinedColumns combinedColumn;
    @OneToMany(mappedBy = "patternTable", fetch = FetchType.LAZY)
    private List<Element> elements;
    @OneToMany(mappedBy = "patternTable", fetch = FetchType.LAZY)
    private List<PipelineTable> pipelineTables;
    @ManyToOne
    @JoinColumn(name = "geodesy_protocol_pattern_id")
    @JsonIgnore
    private GeodesyProtocolPattern geodesyProtocolPattern;
}
