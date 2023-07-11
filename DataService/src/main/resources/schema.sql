CREATE TABLE IF NOT EXISTS ORGANIZATIONS
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    type VARCHAR                                 NOT NULL,
    name VARCHAR                                 NOT NULL,
    CONSTRAINT pk_organization PRIMARY KEY (id),
    CONSTRAINT UQ_ORGANIZATIONS UNIQUE (type, name)
);

CREATE TABLE IF NOT EXISTS MANUFACTURERS
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR                                 NOT NULL,
    CONSTRAINT pk_manufacturer PRIMARY KEY (id),
    CONSTRAINT UQ_MANUFACTURERS UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS MOUNTINGS
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR                                 NOT NULL,
    CONSTRAINT pk_mounting PRIMARY KEY (id),
    CONSTRAINT UQ_MOUNTINGS UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS LICENSES
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    document        VARCHAR                                 NOT NULL,
    organization_id BIGINT                                  NOT NULL,
    number          VARCHAR                                 NOT NULL,
    date            DATE                                    NOT NULL,
    CONSTRAINT pk_licenses PRIMARY KEY (id),
    CONSTRAINT UQ_LICENSES UNIQUE (date),
    CONSTRAINT FK_LICENSES_ON_ORGANIZATIONS FOREIGN KEY (organization_id) REFERENCES organizations (id)
);

CREATE TABLE IF NOT EXISTS CITY
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR                                 NOT NULL,
    CONSTRAINT pk_city PRIMARY KEY (id),
    CONSTRAINT UQ_CITY UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS ADDRESSES
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    city_id         BIGINT                                  NOT NULL,
    street          VARCHAR                                 NOT NULL,
    house_number    INTEGER                                 NOT NULL,
    building_number INTEGER,
    letter          VARCHAR,
    CONSTRAINT pk_address PRIMARY KEY (id),
    CONSTRAINT UQ_ADDRESSES UNIQUE (city_id, street, house_number),
    CONSTRAINT FK_ADDRESSES_ON_CITY FOREIGN KEY (city_id) REFERENCES city (id)
);

CREATE TABLE IF NOT EXISTS BRANCH
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    branch          VARCHAR                                 NOT NULL,
    division        VARCHAR                                 NOT NULL,
    index           INTEGER                                 NOT NULL,
    phone           VARCHAR                                 NOT NULL,
    fax             VARCHAR                                 NOT NULL,
    email           VARCHAR                                 NOT NULL,
    address_id      BIGINT                                  NOT NULL,
    license_id      BIGINT                                  NOT NULL,
    organization_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_branch PRIMARY KEY (id),
    CONSTRAINT UQ_BRANCH UNIQUE (division, branch),
    CONSTRAINT FK_BRANCH_ON_ADDRESSES FOREIGN KEY (address_id) REFERENCES addresses (id),
    CONSTRAINT FK_BRANCH_ON_LICENSES FOREIGN KEY (license_id) REFERENCES licenses (id),
    CONSTRAINT FK_BRANCH_ON_ORGANIZATIONS FOREIGN KEY (organization_id) REFERENCES organizations (id)
);

CREATE TABLE IF NOT EXISTS CONTROL_TYPES
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR                                 NOT NULL,
    CONSTRAINT pk_typeControl PRIMARY KEY (id),
    CONSTRAINT UQ_CONTROL_TYPES UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS EMPLOYEES
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name           VARCHAR                                 NOT NULL,
    patronymic     VARCHAR                                 NOT NULL,
    surname        VARCHAR                                 NOT NULL,
    post           VARCHAR                                 NOT NULL,
    service_number INTEGER                                 NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id),
    CONSTRAINT UQ_EMPLOYEES UNIQUE (service_number)
);

CREATE TABLE IF NOT EXISTS CERTIFICATES
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    document_type   VARCHAR                                 NOT NULL,
    number          VARCHAR                                 NOT NULL,
    control_type_id BIGINT                                  NOT NULL,
    level           VARCHAR                                 NOT NULL,
    start_date      DATE                                    NOT NULL,
    end_date        DATE                                    NOT NULL,
    points          VARCHAR,
    organization_id BIGINT                                  NOT NULL,
    employee_id     BIGINT                                  NOT NULL,
    CONSTRAINT pk_certificate PRIMARY KEY (id),
    CONSTRAINT UQ_CERTIFICATES UNIQUE (control_type_id, employee_id),
    CONSTRAINT FK_CERTIFICATE_ON_CONTROL_TYPES FOREIGN KEY (control_type_id) REFERENCES control_types (id),
    CONSTRAINT FK_CERTIFICATE_ON_ORGANIZATION FOREIGN KEY (organization_id) REFERENCES organizations (id),
    CONSTRAINT FK_CERTIFICATE_ON_EMPLOYEES FOREIGN KEY (employee_id) REFERENCES employees (id)
);

CREATE TABLE IF NOT EXISTS MEASURING_TOOLS
(
    id                     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name                   VARCHAR                                 NOT NULL,
    model                  VARCHAR                                 NOT NULL,
    work_number            INTEGER,
    purpose                VARCHAR,
    manufacturing          DATE,
    exploitation           DATE,
    manufacturer_id        BIGINT,
    measuring_range        VARCHAR,
    characteristics        VARCHAR,
    branch_id              BIGINT                                  NOT NULL,
    verification_date      DATE,
    next_verification_date DATE,
    organization_id        BIGINT,
    certificate_number     VARCHAR,
    registry               VARCHAR,
    note                   VARCHAR,
    control_type_id        BIGINT                                  NOT NULL,
    employee_id            BIGINT,
    CONSTRAINT pk_measuringTool PRIMARY KEY (id),
    CONSTRAINT UQ_MEASURING_TOOL UNIQUE (name, model, work_number),
    CONSTRAINT FK_MEASURING_TOOL_ON_MANUFACTURERS FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id),
    CONSTRAINT FK_MEASURING_TOOL_ON_BRANCH FOREIGN KEY (branch_id) REFERENCES branch (id),
    CONSTRAINT FK_MEASURING_TOOL_ON_ORGANIZATION FOREIGN KEY (organization_id) REFERENCES organizations (id),
    CONSTRAINT FK_MEASURING_TOOL_ON_CONTROL_TYPES FOREIGN KEY (control_type_id) REFERENCES control_types (id),
    CONSTRAINT FK_MEASURING_TOOL_ON_EMPLOYEES FOREIGN KEY (employee_id) REFERENCES employees (id)
);

CREATE TABLE IF NOT EXISTS TYPES
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR                                 NOT NULL,
    CONSTRAINT pk_type PRIMARY KEY (id),
    CONSTRAINT UQ_TYPES UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS DOCUMENTATIONS
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    view    VARCHAR,
    number  VARCHAR,
    title   VARCHAR                                 NOT NULL,
    type_id BIGINT,
    CONSTRAINT pk_documentation PRIMARY KEY (id),
    CONSTRAINT UQ_DOCUMENTATIONS UNIQUE (title),
    CONSTRAINT FK_DOCUMENTATIONS_ON_TYPES FOREIGN KEY (type_id) REFERENCES types (id)
);

CREATE TABLE IF NOT EXISTS BUILDINGS
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    address_id BIGINT                                  NOT NULL,
    building   VARCHAR                                 NOT NULL,
    branch     VARCHAR                                 NOT NULL,
    login      VARCHAR,
    CONSTRAINT pk_building PRIMARY KEY (id),
    CONSTRAINT UQ_BUILDINGS UNIQUE (building, branch, login),
    CONSTRAINT FK_BUILDINGS_ON_ADDRESSES FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE TABLE IF NOT EXISTS ELEMENTS
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR                                 NOT NULL,
    CONSTRAINT pk_element PRIMARY KEY (id)
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

CREATE TABLE IF NOT EXISTS ELEMENTS_DEFECTS
(
    element_id BIGINT,
    defect_id  BIGINT,
    CONSTRAINT pk_element_of_defects PRIMARY KEY (element_id, defect_id)
);

CREATE TABLE IF NOT EXISTS ELEMENTS_DEFECTS
(
    element_id BIGINT,
    place_id   BIGINT,
    CONSTRAINT pk_element_of_places PRIMARY KEY (element_id, place_id)
);

CREATE TABLE IF NOT EXISTS OBJECT_DATA
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    type_id     BIGINT                                  NOT NULL,
    model       VARCHAR,
    number      INTEGER,
    volume      INTEGER,
    orientation VARCHAR,
    place       VARCHAR,
    building_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_objectData PRIMARY KEY (id),
    CONSTRAINT UQ_OBJECT_DATA UNIQUE (type_id, building_id),
    CONSTRAINT FK_OBJECT_DATA_ON_TYPES FOREIGN KEY (type_id) REFERENCES types (id),
    CONSTRAINT FK_OBJECT_DATA_ON_BUILDINGS FOREIGN KEY (building_id) REFERENCES buildings (id)
);

CREATE TABLE IF NOT EXISTS OBJECT_DATA_ELEMENTS
(
    object_data_id BIGINT,
    element_id     BIGINT,
    CONSTRAINT pk_object_data_of_elements PRIMARY KEY (object_data_id, element_id)
);

CREATE TABLE IF NOT EXISTS APPLICATIONS
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    address_id   BIGINT                                  NOT NULL,
    work         VARCHAR                                 NOT NULL,
    primary_data DATE                                    NOT NULL,
    repeat_data  DATE,
    report       BOOLEAN,
    protocol     BOOLEAN,
    note         VARCHAR,
    object_id    BIGINT                                  NOT NULL,
    CONSTRAINT pk_application PRIMARY KEY (id),
    CONSTRAINT UQ_APPLICATIONS UNIQUE (primary_data, object_id),
    CONSTRAINT FK_APPLICATIONS_ON_ADDRESSES FOREIGN KEY (address_id) REFERENCES addresses (id),
    CONSTRAINT FK_APPLICATIONS_ON_OBJECT_DATA FOREIGN KEY (object_id) REFERENCES object_data (id)
);

CREATE TABLE IF NOT EXISTS APPLICATIONS_EMPLOYEES
(
    application_id BIGINT,
    employee_id    BIGINT,
    CONSTRAINT pk_application_of_employees PRIMARY KEY (application_id, employee_id)
);

CREATE TABLE IF NOT EXISTS REPORTS_DATA
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    object_data_id BIGINT                                  NOT NULL,
    employee_id    BIGINT,
    start_time     TIMESTAMP,
    end_time       TIMESTAMP,
    number         INTEGER                                 NOT NULL,
    title          VARCHAR,
    status         VARCHAR                                 NOT NULL,
    link_report    VARCHAR,
    link_plan      VARCHAR,
    primary_data   DATE                                    NOT NULL,
    CONSTRAINT pk_reportData PRIMARY KEY (id),
    CONSTRAINT FK_REPORTS_DATA_ON_OBJECT_DATA FOREIGN KEY (object_data_id) REFERENCES object_data (id),
    CONSTRAINT FK_REPORTS_DATA_ON_EMPLOYEES FOREIGN KEY (employee_id) REFERENCES employees (id)
);

CREATE TABLE IF NOT EXISTS NORMS
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    type_id        BIGINT                                  NOT NULL,
    element_id     BIGINT                                  NOT NULL,
    size_tolerance FLOAT                                   NOT NULL,
    min            FLOAT,
    percent_min    INTEGER,
    CONSTRAINT pk_norm PRIMARY KEY (id),
    CONSTRAINT UQ_NORMS UNIQUE (type_id, element_id),
    CONSTRAINT FK_NORMS_ON_TYPES FOREIGN KEY (type_id) REFERENCES types (id),
    CONSTRAINT FK_NORMS_ON_ELEMENTS FOREIGN KEY (element_id) REFERENCES elements (id)
);