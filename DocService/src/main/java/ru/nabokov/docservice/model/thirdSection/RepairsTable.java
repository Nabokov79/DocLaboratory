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
@Table(name = "repairs_tables")
public class RepairsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "heading")
    private String heading;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "repairs_tables_columns_headers",
            joinColumns = {@JoinColumn(name = "repairs_table_id")},
            inverseJoinColumns = {@JoinColumn(name = "column_header_id")})
    @ToString.Exclude
    private List<ColumnsHeaders> columnHeaders;
    @OneToMany(mappedBy = "repairsTable", fetch = FetchType.LAZY)
    private List<Repair> repairs;
}
