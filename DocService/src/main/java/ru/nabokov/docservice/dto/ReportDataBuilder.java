package ru.nabokov.docservice.dto;

import ru.nabokov.docservice.dto.client.data_service.DocumentationDto;
import ru.nabokov.docservice.dto.client.data_service.EmployeeDto;
import ru.nabokov.docservice.dto.client.data_service.BranchDto;
import ru.nabokov.docservice.dto.client.data_service.ObjectDataDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.PatternSectionOneDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.TitlePatternDto;

import java.util.List;

public class ReportDataBuilder {

    private final ObjectDataDto objectData;
    private final BranchDto branch;
    private final TitlePatternDto titlePattern;
    private final PatternSectionOneDto pattern;
    private final List<EmployeeDto> employees;
    private List<DocumentationDto> documentations;
    private final String license;

    public ReportDataBuilder(DataBuilder builder) {
        this.objectData = builder.objectData;
        this.branch = builder.branch;
        this.titlePattern = builder.titlePattern;
        this.pattern = builder.pattern;
        this.employees = builder.employees;
        this.documentations = builder.documentations;
        this.license = builder.license;
    }

    public ObjectDataDto getObjectData() {
        return objectData;
    }

    public BranchDto getBranch() {
        return branch;
    }

    public TitlePatternDto getTitlePattern() {
        return titlePattern;
    }

    public PatternSectionOneDto getPattern() {
        return pattern;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public List<DocumentationDto> getDocumentations() {
        return documentations;
    }

    public String getLicense() {
        return license;
    }

    @Override
    public String toString() {
        return "ReportDataBuilder{" +
                "objectData=" + objectData +
                ", branch=" + branch +
                ", titlePattern=" + titlePattern +
                ", pattern=" + pattern +
                ", employees=" + employees +
                ", documentations=" + documentations +
                ", license='" + license + '\'' +
                '}';
    }

    public static class DataBuilder {

        private ObjectDataDto objectData;
        private BranchDto branch;
        private TitlePatternDto titlePattern;
        private PatternSectionOneDto pattern;
        private List<EmployeeDto> employees;
        private List<DocumentationDto> documentations;
        private String license;

        public DataBuilder objectData(ObjectDataDto objectData) {
            this.objectData = objectData;
            return this;
        }
        public DataBuilder branch(BranchDto branch) {
            this.branch = branch;
            return this;
        }

        public DataBuilder titlePattern(TitlePatternDto titlePattern) {
            this.titlePattern = titlePattern;
            return this;
        }

        public DataBuilder pattern(PatternSectionOneDto pattern) {
            this.pattern = pattern;
            return this;
        }

        public DataBuilder employees(List<EmployeeDto> employees) {
            this.employees = employees;
            return this;
        }

        public DataBuilder documentations(List<DocumentationDto> documentations) {
            this.documentations = documentations;
            return this;
        }

        public DataBuilder license(String license) {
            this.license = license;
            return this;
        }

        public ReportDataBuilder build() {
            return new ReportDataBuilder(this);
        }
    }
}
