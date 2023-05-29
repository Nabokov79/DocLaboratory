package ru.nabokov.docservice.model.title;

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
@Table(name = "text_centered")
public class TextCentered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "report_name")
    private String reportName;
    @Column(name = "text_first")
    private String textFirst;
    @Column(name = "object")
    private String object;
    @Column(name = "text_second")
    private String textSecond;
    @Column(name = "address")
    private String address;
}
