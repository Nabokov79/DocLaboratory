CREATE TABLE IF NOT EXISTS COLUMN_HEADERS
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    number  INTEGER                                 NOT NULL,
    heading VARCHAR                                 NOT NULL,
    CONSTRAINT pk_columnHeader PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS COMBINED_COLUMNS
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    number_first  INTEGER                                 NOT NULL,
    name_first    VARCHAR,
    number_second INTEGER                                 NOT NULL,
    name_second   VARCHAR,
    name          VARCHAR                                 NOT NULL,
    CONSTRAINT pk_combinedColumns PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS PROTOCOL_HEADERS
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    number            INTEGER                                 NOT NULL,
    document          VARCHAR                                 NOT NULL,
    name              VARCHAR                                 NOT NULL,
    text              VARCHAR                                 NOT NULL,
    text_measurements VARCHAR                                 NOT NULL,
    location          VARCHAR,
    admissibility     VARCHAR,
    schema_header     VARCHAR,
    CONSTRAINT pk_protocolHeader PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS PATTERN_CONCLUSIONS
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    is_not_defect VARCHAR                                 NOT NULL,
    is_defect     VARCHAR                                 NOT NULL,
    CONSTRAINT pk_patternConclusion PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS GEODESY_PROTOCOL_PATTERNS
(
    id                    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    protocol_header_id    BIGINT                                  NOT NULL,
    pattern_conclusion_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_geodesyProtocolPattern PRIMARY KEY (id),
    CONSTRAINT FK_GEODESY_PROTOCOL_PATTERNS_ON_PROTOCOL_HEADERS FOREIGN KEY (protocol_header_id) REFERENCES protocol_headers (id),
    CONSTRAINT FK_GEODESY_PROTOCOL_PATTERNS_ON_PATTERN_CONCLUSIONS FOREIGN KEY (pattern_conclusion_id) REFERENCES pattern_conclusions (id)
);

CREATE TABLE IF NOT EXISTS PATTERN_TABLES
(
    id                          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name                        VARCHAR                                 NOT NULL,
    text                        VARCHAR,
    combined_column_id          BIGINT,
    geodesy_protocol_pattern_id BIGINT,
    CONSTRAINT pk_patternTable PRIMARY KEY (id),
    CONSTRAINT FK_PATTERN_TABLES_ON_COMBINED_COLUMNS FOREIGN KEY (combined_column_id) REFERENCES combined_columns (id),
    CONSTRAINT FK_PATTERN_TABLES_ON_GEODESY_PROTOCOL_PATTERNS FOREIGN KEY (geodesy_protocol_pattern_id) REFERENCES geodesy_protocol_patterns (id)
);

CREATE TABLE IF NOT EXISTS PATTERN_TABLES_COLUMN_HEADERS
(
    pattern_table_id BIGINT,
    column_header_id BIGINT,
    CONSTRAINT pk_pattern_tables_of_column_headers PRIMARY KEY (pattern_table_id, column_header_id)
);

CREATE TABLE IF NOT EXISTS VISUAL_PROTOCOL_PATTERNS
(
    id                    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    protocol_header_id    BIGINT                                  NOT NULL,
    pattern_table_id      BIGINT                                  NOT NULL,
    pattern_conclusion_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_visualProtocolPattern PRIMARY KEY (id),
    CONSTRAINT FK_VISUAL_PROTOCOL_PATTERNS_ON_PROTOCOL_HEADERS FOREIGN KEY (protocol_header_id) REFERENCES protocol_headers (id),
    CONSTRAINT FK_VISUAL_PROTOCOL_PATTERNS_ON_PATTERN_TABLES FOREIGN KEY (pattern_table_id) REFERENCES pattern_tables (id),
    CONSTRAINT FK_VISUAL_PROTOCOL_PATTERNS_ON_PATTERN_CONCLUSIONS FOREIGN KEY (pattern_conclusion_id) REFERENCES pattern_conclusions (id)
);

CREATE TABLE IF NOT EXISTS ULTRASONIC_PROTOCOL_PATTERNS
(
    id                    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    protocol_header_id    BIGINT                                  NOT NULL,
    pattern_table_id      BIGINT                                  NOT NULL,
    pattern_conclusion_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_ultrasonicProtocolPattern PRIMARY KEY (id),
    CONSTRAINT FK_ULTRASONIC_PROTOCOL_PATTERNS_ON_PROTOCOL_HEADERS FOREIGN KEY (protocol_header_id) REFERENCES protocol_headers (id),
    CONSTRAINT FK_ULTRASONIC_PROTOCOL_PATTERNS_ON_PATTERN_TABLES FOREIGN KEY (pattern_table_id) REFERENCES pattern_tables (id),
    CONSTRAINT FK_ULTRASONIC_PROTOCOL_PATTERNS_ON_PATTERN_CONCLUSIONS FOREIGN KEY (pattern_conclusion_id) REFERENCES pattern_conclusions (id)
);

CREATE TABLE IF NOT EXISTS HARDNESS_PROTOCOL_PATTERNS
(
    id                    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    protocol_header_id    BIGINT                                  NOT NULL,
    pattern_table_id      BIGINT                                  NOT NULL,
    pattern_conclusion_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_hardnessProtocolPattern PRIMARY KEY (id),
    CONSTRAINT FK_HARDNESS_PROTOCOL_PATTERNS_ON_PROTOCOL_HEADERS FOREIGN KEY (protocol_header_id) REFERENCES protocol_headers (id),
    CONSTRAINT FK_HARDNESS_PROTOCOL_PATTERNS_ON_PATTERN_TABLES FOREIGN KEY (pattern_table_id) REFERENCES pattern_tables (id),
    CONSTRAINT FK_HARDNESS_PROTOCOL_PATTERNS_ON_PATTERN_CONCLUSIONS FOREIGN KEY (pattern_conclusion_id) REFERENCES pattern_conclusions (id)
);

CREATE TABLE IF NOT EXISTS PIPELINES
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR                                 NOT NULL,
    CONSTRAINT pk_pipeline PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS PIPELINE_TABLES
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    pipeline_id      BIGINT                                  NOT NULL,
    pattern_table_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_pipelineTable PRIMARY KEY (id),
    CONSTRAINT FK_PIPELINE_TABLES_ON_PIPELINES FOREIGN KEY (pipeline_id) REFERENCES pipelines (id),
    CONSTRAINT FK_PIPELINE_TABLES_ON_PATTERN_TABLES FOREIGN KEY (pattern_table_id) REFERENCES pattern_tables (id)
);

CREATE TABLE IF NOT EXISTS ELEMENTS
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    item              INTEGER,
    name              VARCHAR                                 NOT NULL,
    pattern_table_id  BIGINT,
    pipeline_table_id BIGINT,
    CONSTRAINT pk_element PRIMARY KEY (id),
    CONSTRAINT FK_ELEMENTS_ON_PATTERN_TABLES FOREIGN KEY (pattern_table_id) REFERENCES pattern_tables (id),
    CONSTRAINT FK_ELEMENTS_ON_PIPELINE_TABLES FOREIGN KEY (pipeline_table_id) REFERENCES pipeline_tables (id)
);

CREATE TABLE IF NOT EXISTS DEFECTS
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name       VARCHAR                                 NOT NULL,
    element_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_defect PRIMARY KEY (id),
    CONSTRAINT FK_DEFECTS_ON_ELEMENTS FOREIGN KEY (element_id) REFERENCES elements (id)
);

CREATE TABLE IF NOT EXISTS PLACES
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    place      VARCHAR                                 NOT NULL,
    element_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_place PRIMARY KEY (id),
    CONSTRAINT FK_PLACES_ON_ELEMENTS FOREIGN KEY (element_id) REFERENCES elements (id)
);

CREATE TABLE IF NOT EXISTS HEADERS
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    number  INTEGER                                 NOT NULL,
    heading VARCHAR                                 NOT NULL,
    CONSTRAINT pk_header PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS SUBHEADINGS
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    number  DOUBLE PRECISION                        NOT NULL,
    heading VARCHAR                                 NOT NULL,
    text    VARCHAR,
    CONSTRAINT pk_subheading PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS SUBHEADINGS_COLUMN_HEADERS
(
    subheading_id BIGINT,
    column_header_id          BIGINT,
    CONSTRAINT pk_subheading_two_of_column_headers PRIMARY KEY (subheading_id, column_header_id)
);

CREATE TABLE IF NOT EXISTS DOCUMENTATIONS
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    type_document   VARCHAR                                 NOT NULL,
    number_document VARCHAR,
    title           VARCHAR                                 NOT NULL,
    subheading_id   BIGINT                                  NOT NULL,
    CONSTRAINT pk_documentation PRIMARY KEY (id),
    CONSTRAINT FK_DOCUMENTATIONS_ON_SUBHEADERS FOREIGN KEY (subheading_id) REFERENCES subheadings (id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_FOUR
(
    id                             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    header_id                      BIGINT                                  NOT NULL,
    visual_protocol_pattern_id     BIGINT,
    ultrasonic_protocol_pattern_id BIGINT,
    geodesy_protocol_pattern_id    BIGINT,
    hardness_protocol_pattern_id   BIGINT,
    CONSTRAINT pk_patternSectionFour PRIMARY KEY (id),
    CONSTRAINT FK_PATTERN_SECTION_FOUR_ON_HEADERS FOREIGN KEY (header_id) REFERENCES headers (id),
    CONSTRAINT FK_PATTERN_SECTION_FOUR_ON_VISUAL_PROTOCOL_PATTERNS FOREIGN KEY (visual_protocol_pattern_id) REFERENCES visual_protocol_patterns (id),
    CONSTRAINT FK_PATTERN_SECTION_FOUR_ON_ULTRASONIC_PROTOCOL_PATTERNS FOREIGN KEY (ultrasonic_protocol_pattern_id) REFERENCES ultrasonic_protocol_patterns (id),
    CONSTRAINT FK_PATTERN_SECTION_FOUR_ON_GEODESY_PROTOCOL_PATTERNS FOREIGN KEY (geodesy_protocol_pattern_id) REFERENCES geodesy_protocol_patterns (id),
    CONSTRAINT FK_PATTERN_SECTION_FOUR_ON_HARDNESS_PROTOCOL_PATTERNS FOREIGN KEY (hardness_protocol_pattern_id) REFERENCES hardness_protocol_patterns (id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_ONE
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    header_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_patternSectionOne PRIMARY KEY (id),
    CONSTRAINT FK_PATTERN_SECTION_ONE_ON_HEADERS FOREIGN KEY (header_id) REFERENCES headers (id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_ONE_SUBHEADINGS
(
    pattern_section_one_id BIGINT,
    subheading_id          BIGINT,
    CONSTRAINT pk_pattern_section_one_of_subheadings PRIMARY KEY (pattern_section_one_id, subheading_id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_TWO
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    header_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_patternSectionTwo PRIMARY KEY (id),
    CONSTRAINT FK_PATTERN_SECTION_TWO_ON_HEADERS FOREIGN KEY (header_id) REFERENCES headers (id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_TWO_SUBHEADINGS
(
    pattern_section_two_id BIGINT,
    subheading_id          BIGINT,
    CONSTRAINT pk_pattern_section_two_of_subheadings PRIMARY KEY (pattern_section_two_id, subheading_id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_THREE
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    header_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_patternSectionThree PRIMARY KEY (id),
    CONSTRAINT FK_PATTERN_SECTION_THREE_ON_HEADERS FOREIGN KEY (header_id) REFERENCES headers (id)
);

CREATE TABLE IF NOT EXISTS  PATTERN_SECTION_THREE_SUBHEADINGS
(
    pattern_section_three_id BIGINT,
    subheading_id          BIGINT,
    CONSTRAINT pk_pattern_section_three_of_subheadings PRIMARY KEY (pattern_section_three_id, subheading_id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_FIVE
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    header_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_patternSectionFive PRIMARY KEY (id),
    CONSTRAINT FK_PATTERN_SECTION_FIVE_ON_HEADERS FOREIGN KEY (header_id) REFERENCES headers (id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_FIVE_SUBHEADINGS
(
    pattern_section_five_id BIGINT,
    subheading_id           BIGINT,
    CONSTRAINT pk_pattern_section_five_of_subheadings PRIMARY KEY (pattern_section_five_id, subheading_id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_SIX
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    header_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_patternSectionSix PRIMARY KEY (id),
    CONSTRAINT FK_PATTERN_SECTION_SIX_ON_HEADERS FOREIGN KEY (header_id) REFERENCES headers (id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_SIX_SUBHEADINGS
(
    pattern_section_six_id BIGINT,
    subheading_id          BIGINT,
    CONSTRAINT pk_pattern_section_six_of_subheadings PRIMARY KEY (pattern_section_six_id, subheading_id)
);

CREATE TABLE IF NOT EXISTS PATTERN_SECTION_SEVEN
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    header_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_patternSectionSeven PRIMARY KEY (id),
    CONSTRAINT FK_PATTERN_SECTION_SEVEN_ON_HEADERS FOREIGN KEY (header_id) REFERENCES headers (id)
);

CREATE TABLE IF NOT EXISTS DRAWINGS
(
    id                       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    type                     VARCHAR                                 NOT NULL,
    number                   INTEGER                                 NOT NULL,
    name                     VARCHAR                                 NOT NULL,
    pattern_section_seven_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_drawing PRIMARY KEY (id),
    CONSTRAINT UQ_DRAWINGS UNIQUE (number, name),
    CONSTRAINT FK_DRAWINGS_ON_PATTERN_SECTION_SEVEN FOREIGN KEY (pattern_section_seven_id) REFERENCES pattern_section_seven (id)
);

CREATE TABLE IF NOT EXISTS TEXTS_CENTERED
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    report_name VARCHAR                                 NOT NULL,
    text_first  VARCHAR                                 NOT NULL,
    object      VARCHAR                                 NOT NULL,
    text_second VARCHAR                                 NOT NULL,
    signature   VARCHAR                                 NOT NULL,
    city        VARCHAR                                 NOT NULL,
    year        VARCHAR                                 NOT NULL,
    CONSTRAINT pk_textsCentered PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS TITLE_PATTERNS
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    text_centered_id   BIGINT                                  NOT NULL,
    CONSTRAINT pk_titlePattern PRIMARY KEY (id),
    CONSTRAINT FK_REPORT_PATTERNS_ON_TEXTS_CENTERED FOREIGN KEY (text_centered_id) REFERENCES texts_centered (id)
);

CREATE TABLE IF NOT EXISTS REPORT_PATTERNS
(
    id                       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    type_id                  BIGINT                                  NOT NULL,
    title_pattern_id         BIGINT                                  NOT NULL,
    pattern_section_one_id   BIGINT,
    pattern_section_two_id   BIGINT,
    pattern_section_three_id BIGINT,
    pattern_section_four_id  BIGINT,
    pattern_section_five_id  BIGINT,
    pattern_section_six_id   BIGINT,
    pattern_section_seven_id BIGINT,
    CONSTRAINT pk_reportPattern PRIMARY KEY (id),
    CONSTRAINT FK_REPORT_PATTERNS_ON_TITLE_PATTERNS FOREIGN KEY (title_pattern_id) REFERENCES title_patterns (id),
    CONSTRAINT FK_REPORT_PATTERNS_ON_PATTERN_SECTION_ONE FOREIGN KEY (pattern_section_one_id) REFERENCES pattern_section_one (id),
    CONSTRAINT FK_REPORT_PATTERNS_ON_PATTERN_SECTION_TWO FOREIGN KEY (pattern_section_two_id) REFERENCES pattern_section_two (id),
    CONSTRAINT FK_REPORT_PATTERNS_ON_PATTERN_SECTION_THREE FOREIGN KEY (pattern_section_three_id) REFERENCES pattern_section_three (id),
    CONSTRAINT FK_REPORT_PATTERNS_ON_PATTERN_SECTION_FOUR FOREIGN KEY (pattern_section_four_id) REFERENCES pattern_section_four (id),
    CONSTRAINT FK_REPORT_PATTERNS_ON_PATTERN_SECTION_FIVE FOREIGN KEY (pattern_section_five_id) REFERENCES pattern_section_five (id),
    CONSTRAINT FK_REPORT_PATTERNS_ON_PATTERN_SECTION_SIX FOREIGN KEY (pattern_section_six_id) REFERENCES pattern_section_six (id),
    CONSTRAINT FK_REPORT_PATTERNS_ON_PATTERN_SECTION_SEVEN FOREIGN KEY (pattern_section_seven_id) REFERENCES pattern_section_seven (id)
);