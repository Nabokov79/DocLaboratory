package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.Defect;
import java.util.List;

public interface DefectService {

    void save(List<Defect> defects);

    void update(List<Defect> defects);
}
