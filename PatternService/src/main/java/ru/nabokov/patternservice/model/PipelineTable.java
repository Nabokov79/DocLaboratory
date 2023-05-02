package ru.nabokov.patternservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "pipeline_tables")
public class PipelineTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pipeline_id", referencedColumnName = "id")
    private Pipeline pipeline;
    @OneToMany(mappedBy = "pipelineTable", fetch = FetchType.LAZY)
    private List<Element> elements;
    @ManyToOne
    @JoinColumn(name = "pattern_table_id")
    @JsonIgnore
    private PatternTable patternTable;
}
