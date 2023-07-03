CREATE TABLE IF NOT EXISTS PASSPORTS
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    object_data_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_passport PRIMARY KEY (id),
    CONSTRAINT UQ_PASSPORTS UNIQUE (object_data_id)
);

CREATE TABLE IF NOT EXISTS BELTS
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    number    INTEGER                                 NOT NULL,
    thickness INTEGER                                 NOT NULL,
    CONSTRAINT pk_belt PRIMARY KEY (id),
    CONSTRAINT UQ_BELTS UNIQUE (number, thickness)
);

CREATE TABLE IF NOT EXISTS PASSPORTS_BELTS
(
    passport_id BIGINT,
    belt_id     BIGINT,
    CONSTRAINT pk_passport_of_belts PRIMARY KEY (passport_id, belt_id)
);

CREATE TABLE IF NOT EXISTS BOTTOMS
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name           VARCHAR                                 NOT NULL,
    thickness      INTEGER                                 NOT NULL,
    thickness_edge INTEGER                                 NOT NULL,
    CONSTRAINT pk_bottom PRIMARY KEY (id),
    CONSTRAINT UQ_BOTTOMS UNIQUE (name, thickness, thickness_edge)
);

CREATE TABLE IF NOT EXISTS PASSPORTS_BOTTOMS
(
    passport_id BIGINT,
    bottom_id   BIGINT,
    CONSTRAINT pk_passport_of_bottoms PRIMARY KEY (passport_id, bottom_id)
);

CREATE TABLE IF NOT EXISTS STANDARD_SIZE_PIPES
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    diameter  INTEGER                                 NOT NULL,
    thickness INTEGER                                 NOT NULL,
    CONSTRAINT pk_standardSizePipe PRIMARY KEY (id),
    CONSTRAINT UQ_STANDARD_SIZE_PIPES UNIQUE (diameter, thickness)
);

CREATE TABLE IF NOT EXISTS PASSPORTS_STANDARD_SIZE_PIPES
(
    passport_id          BIGINT,
    standardSize_pipe_id BIGINT,
    CONSTRAINT pk_passport_of_standardSizePipe PRIMARY KEY (passport_id, standardSize_pipe_id)
);

CREATE TABLE IF NOT EXISTS SURVEYS
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    date            VARCHAR                                 NOT NULL,
    survey          VARCHAR                                 NOT NULL,
    number          VARCHAR                                 NOT NULL,
    organization_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_survey PRIMARY KEY (id),
    CONSTRAINT UQ_SURVEYS UNIQUE (date, survey, number, organization_id)
);

CREATE TABLE IF NOT EXISTS PASSPORTS_SURVEYS
(
    passport_id BIGINT,
    survey_id   BIGINT,
    CONSTRAINT pk_passport_of_surveys PRIMARY KEY (passport_id, survey_id)
);

CREATE TABLE IF NOT EXISTS REPAIRS
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    date            VARCHAR                                 NOT NULL,
    description     VARCHAR                                 NOT NULL,
    organization_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_repair PRIMARY KEY (id),
    CONSTRAINT UQ_REPAIRS UNIQUE (date, description, organization_id)
);

CREATE TABLE IF NOT EXISTS PASSPORTS_REPAIRS
(
    passport_id BIGINT,
    repair_id   BIGINT,
    CONSTRAINT pk_passport_of_repairs PRIMARY KEY (passport_id, repair_id)
);

CREATE TABLE IF NOT EXISTS CHARACTERISTICS
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    number FLOAT                                   NOT NULL,
    name   VARCHAR                                 NOT NULL,
    CONSTRAINT pk_characteristic PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS OBJECT_CHARACTERISTICS
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    characteristic_id BIGINT                                  NOT NULL,
    meaning           VARCHAR                                 NOT NULL,
    passport_id       BIGINT                                  NOT NULL,
    CONSTRAINT pk_objectCharacteristics PRIMARY KEY (id),
    CONSTRAINT FK_OBJECT_CHARACTERISTICS_ON_CHARACTERISTICS FOREIGN KEY (characteristic_id) REFERENCES characteristics (id),
    CONSTRAINT FK_OBJECT_CHARACTERISTICS_ON_PASSPORT FOREIGN KEY (passport_id) REFERENCES passports (id)
);