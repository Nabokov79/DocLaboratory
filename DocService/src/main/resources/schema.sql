CREATE TABLE IF NOT EXISTS FOOTERS
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    post     VARCHAR                                 NOT NULL,
    initials VARCHAR                                 NOT NULL,
    city     VARCHAR                                 NOT NULL,
    year     VARCHAR                                 NOT NULL,
    CONSTRAINT pk_footer PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS LICENSE
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    division VARCHAR                                 NOT NULL,
    license  VARCHAR                                 NOT NULL,
    CONSTRAINT pk_license PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS TEXT_CENTERED
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    report_name VARCHAR                                 NOT NULL,
    text_first  VARCHAR                                 NOT NULL,
    object      VARCHAR                                 NOT NULL,
    text_second VARCHAR                                 NOT NULL,
    address     VARCHAR                                 NOT NULL,
    CONSTRAINT pk_textCentered PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS TITLE_HEADERS
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    type   VARCHAR                                 NOT NULL,
    name   VARCHAR                                 NOT NULL,
    branch VARCHAR                                 NOT NULL,
    CONSTRAINT pk_titleHeader PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS TITLES
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    header_id  BIGINT                                  NOT NULL,
    license_id BIGINT                                  NOT NULL,
    text_id    BIGINT                                  NOT NULL,
    footer_id  BIGINT                                  NOT NULL,
    CONSTRAINT pk_title PRIMARY KEY (id),
    CONSTRAINT FK_TITLES_ON_TITLE_HEADERS FOREIGN KEY (header_id) REFERENCES title_headers (id),
    CONSTRAINT FK_TITLES_ON_LICENSES FOREIGN KEY (license_id) REFERENCES license (id),
    CONSTRAINT FK_TITLES_ON_TEXT_CENTERED FOREIGN KEY (text_id) REFERENCES text_centered (id),
    CONSTRAINT FK_TITLES_ON_FOOTERS FOREIGN KEY (footer_id) REFERENCES footers (id)
);

CREATE TABLE IF NOT EXISTS FIRST_SECTIONS
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    heading VARCHAR                                 NOT NULL,
    CONSTRAINT pk_firstSection PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS DOCUMENTS
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    document   VARCHAR                                 NOT NULL,
    section_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_document PRIMARY KEY (id),
    CONSTRAINT FK_DOCUMENT_ON_FIRST_SECTIONS FOREIGN KEY (section_id) REFERENCES first_sections (id)
);

CREATE TABLE IF NOT EXISTS DATA_FIRST_SECTIONS
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    heading         VARCHAR                                 NOT NULL,
    text            VARCHAR,
    laboratory_data VARCHAR,
    chief           VARCHAR,
    employee_first  VARCHAR,
    employee_second VARCHAR,
    section_id      BIGINT                                  NOT NULL,
    CONSTRAINT pk_dataFirstSection PRIMARY KEY (id),
    CONSTRAINT FK_DATA_FIRST_SECTIONS_ON_FIRST_SECTIONS FOREIGN KEY (section_id) REFERENCES first_sections (id)
);

CREATE TABLE IF NOT EXISTS DATA_FIRST_SECTIONS_DOCUMENTS
(
    data_first_section_id BIGINT,
    document_id           BIGINT,
    CONSTRAINT pk_data_first_sections_of_documents PRIMARY KEY (data_first_section_id, document_id)
);

CREATE TABLE IF NOT EXISTS SECOND_SECTIONS
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    heading VARCHAR                                 NOT NULL,
    CONSTRAINT pk_secondSection PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS SECOND_SECTION_DATA
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    heading    VARCHAR                                 NOT NULL,
    meaning    VARCHAR                                 NOT NULL,
    section_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_secondSectionData PRIMARY KEY (id),
    CONSTRAINT FK_SECOND_SECTION_DATA_ON_SECOND_SECTIONS FOREIGN KEY (section_id) REFERENCES second_sections (id)
);

CREATE TABLE IF NOT EXISTS COLUMNS_HEADERS
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    number  INTEGER                                 NOT NULL,
    heading VARCHAR                                 NOT NULL,
    CONSTRAINT pk_columnsHeaders PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS REPAIRS_TABLES
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    heading VARCHAR                                 NOT NULL,
    CONSTRAINT pk_repairsTable PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS REPAIRS_TABLES_COLUMNS_HEADERS
(
    repairs_table_id BIGINT,
    column_header_id BIGINT,
    CONSTRAINT pk_repair_tables_of_columns_headers PRIMARY KEY (repairs_table_id, column_header_id)
);

CREATE TABLE IF NOT EXISTS REPAIRS
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    date             VARCHAR                                 NOT NULL,
    description      VARCHAR                                 NOT NULL,
    organization     VARCHAR                                 NOT NULL,
    repairs_table_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_repair PRIMARY KEY (id),
    CONSTRAINT FK_REPAIR_ON_REPAIRS_TABLES FOREIGN KEY (repairs_table_id) REFERENCES repairs (id)
);

CREATE TABLE IF NOT EXISTS SURVEYS_TABLES
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    heading VARCHAR                                 NOT NULL,
    CONSTRAINT pk_surveysTable PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS SURVEYS_TABLES_COLUMNS_HEADERS
(
    surveys_table_id BIGINT,
    column_header_id BIGINT,
    CONSTRAINT pk_surveys_tables_of_columns_headers PRIMARY KEY (surveys_table_id, column_header_id)
);

CREATE TABLE IF NOT EXISTS SURVEYS
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    date             VARCHAR                                 NOT NULL,
    survey           VARCHAR                                 NOT NULL,
    number_document  VARCHAR                                 NOT NULL,
    organization     VARCHAR                                 NOT NULL,
    surveys_table_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_survey PRIMARY KEY (id),
    CONSTRAINT FK_SURVEYS_ON_SURVEYS_TABLES FOREIGN KEY (surveys_table_id) REFERENCES surveys_tables (id)
);

CREATE TABLE IF NOT EXISTS THIRD_SECTIONS
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    heading          VARCHAR                                 NOT NULL,
    repairs_table_id BIGINT                                  NOT NULL,
    surveys_table_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_third_section PRIMARY KEY (id),
    CONSTRAINT FK_THIRD_SECTIONS_ON_SURVEYS_TABLES FOREIGN KEY (surveys_table_id) REFERENCES surveys_tables (id),
    CONSTRAINT FK_THIRD_SECTIONS_ON_REPAIRS_TABLES FOREIGN KEY (repairs_table_id) REFERENCES repairs_tables (id)
);

CREATE TABLE IF NOT EXISTS SIXTH_SECTIONS
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    heading             VARCHAR                                 NOT NULL,
    CONSTRAINT pk_sixthSection PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS SIXTH_SECTIONS
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    heading             VARCHAR                                 NOT NULL,
    CONSTRAINT pk_sixthSection PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS RECOMMENDATIONS
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    recommendation VARCHAR                                 NOT NULL,
    CONSTRAINT pk_recommendations PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS SUBHEADING_SECTIONS
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    subheading  VARCHAR                        NOT NULL,
    conclusion VARCHAR                                 NOT NULL,
    section_id BIGINT NOT NULL,
    CONSTRAINT pk_subheadingSections PRIMARY KEY (id),
    CONSTRAINT FK_SUBHEADINGS_SECTIONS_ON_SIXTH_SECTIONS FOREIGN KEY (section_id) REFERENCES sixth_sections (id)
);

CREATE TABLE IF NOT EXISTS SUBHEADING_SECTIONS_RECOMMENDATIONS
(
    subheading_id BIGINT,
    recommendation_id BIGINT,
    CONSTRAINT pk_subheading_sections_of_recommendations PRIMARY KEY (subheading_id, recommendation_id)
);