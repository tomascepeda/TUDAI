-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-05-17 13:35:11.621

-- tables
-- Table: GR3_ASIGNATURA
CREATE TABLE GR3_ASIGNATURA (
    tipo_asig char(2)  NOT NULL,
    cod_asig int  NOT NULL,
    nombre_asig varchar(40)  NOT NULL,
    cant_hs_t int  NOT NULL,
    cant_hs_p int  NOT NULL,
    CONSTRAINT PK_GR3_ASIGNATURA PRIMARY KEY (tipo_asig,cod_asig)
);

-- Table: GR3_ASIGNATURA_PROFESOR
CREATE TABLE GR3_ASIGNATURA_PROFESOR (
    dni int  NOT NULL,
    tipo_asig char(2)  NOT NULL,
    cod_asig int  NOT NULL,
    cuatrimestre int  NOT NULL,
    cantidad_horas int  NOT NULL,
    CONSTRAINT PK_GR3_ASIGNATURA_PROFESOR PRIMARY KEY (dni,tipo_asig,cod_asig)
);

-- Table: GR3_PROFESOR
CREATE TABLE GR3_PROFESOR (
    dni int  NOT NULL,
    apellido varchar(50)  NOT NULL,
    nombre varchar(30)  NOT NULL,
    titulo varchar(30)  NULL,
    departamento int  NOT NULL,
    tipo_prof int  NOT NULL,
    CONSTRAINT PK_GR3_PROFESOR PRIMARY KEY (dni)
);

-- Table: GR3_PROF_EXCLUSIVO
CREATE TABLE GR3_PROF_EXCLUSIVO (
    dni int  NOT NULL,
    proy_investig varchar(20)  NOT NULL,
    CONSTRAINT PK_GR3_PROF_EXCLUSIVO PRIMARY KEY (dni)
);

-- Table: GR3_PROF_SIMPLE
CREATE TABLE GR3_PROF_SIMPLE (
    dni int  NOT NULL,
    perfil varchar(120)  NOT NULL,
    CONSTRAINT PK_GR3_PROF_SIMPLE PRIMARY KEY (dni)
);

-- foreign keys
-- Reference: FK_GR3_ASIGNATURA_PROFESOR_ASIGNATURA (table: GR3_ASIGNATURA_PROFESOR)
ALTER TABLE GR3_ASIGNATURA_PROFESOR ADD CONSTRAINT FK_GR3_ASIGNATURA_PROFESOR_ASIGNATURA
    FOREIGN KEY (tipo_asig, cod_asig)
    REFERENCES GR3_ASIGNATURA (tipo_asig, cod_asig)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: FK_GR3_ASIGNATURA_PROFESOR_PROFESOR (table: GR3_ASIGNATURA_PROFESOR)
ALTER TABLE GR3_ASIGNATURA_PROFESOR ADD CONSTRAINT FK_GR3_ASIGNATURA_PROFESOR_PROFESOR
    FOREIGN KEY (dni)
    REFERENCES GR3_PROFESOR (dni)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: FK_GR3_PROF_EXCLUSIVO_PROFESOR (table: GR3_PROF_EXCLUSIVO)
ALTER TABLE GR3_PROF_EXCLUSIVO ADD CONSTRAINT FK_GR3_PROF_EXCLUSIVO_PROFESOR
    FOREIGN KEY (dni)
    REFERENCES GR3_PROFESOR (dni)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: FK_GR3_PROF_SIMPLE_PROFESOR (table: GR3_PROF_SIMPLE)
ALTER TABLE GR3_PROF_SIMPLE ADD CONSTRAINT FK_GR3_PROF_SIMPLE_PROFESOR
    FOREIGN KEY (dni)
    REFERENCES GR3_PROFESOR (dni)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.