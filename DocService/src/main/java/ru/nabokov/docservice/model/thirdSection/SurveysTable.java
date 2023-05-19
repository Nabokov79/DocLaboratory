package ru.nabokov.docservice.model.thirdSection;

import lombok.*;
import ru.nabokov.docservice.model.ColumnsHeaders;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surveys_tables")
public class SurveysTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "heading")
    private String heading;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "surveys_tables_columns_headers",
            joinColumns = {@JoinColumn(name = "surveys_table_id")},
            inverseJoinColumns = {@JoinColumn(name = "column_header_id")})
    @ToString.Exclude
    private List<ColumnsHeaders> columnHeaders;
    @OneToMany(mappedBy = "surveysTable", fetch = FetchType.LAZY)
    private List<Survey> surveys;
}
