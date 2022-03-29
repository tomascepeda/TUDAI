------------------------------------------------------------
-- 1)
ALTER TABLE GR3_ASIGNATURA
ADD COLUMN cantidad_prof_simples INT;

ALTER TABLE GR3_ASIGNATURA
ADD COLUMN cantidad_prof_exclusivos INT;

ALTER TABLE GR3_ASIGNATURA_PROFESOR
ADD COLUMN activo BOOL;

----------------------------------------------------------------------

-- Esta funcion setea en cero la cantidad de profesores simples y exlusivos al insertar una asignatura
CREATE OR REPLACE FUNCTION TRFN_GR3_ASIGNAR_CANTIDAD() RETURNS TRIGGER AS $$
BEGIN
    new.cantidad_prof_simples := 0;
    new.cantidad_prof_exclusivos := 0;
    return new;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER TR_GR3_ASIGNATURA_ASIGNAR_CANTIDAD
BEFORE INSERT
ON GR3_ASIGNATURA
FOR EACH ROW
EXECUTE PROCEDURE TRFN_GR3_ASIGNAR_CANTIDAD();

---------------------------------------------------------------

CREATE OR REPLACE FUNCTION TRFN_GR3_ACTUALIZAR_ASIGNATURA() RETURNS TRIGGER AS $$
BEGIN
UPDATE GR3_ASIGNATURA a SET(cantidad_prof_simples, cantidad_prof_exclusivos) = (
    SELECT COUNT(tipo_prof) FILTER (WHERE p.tipo_prof = 1), COUNT(tipo_prof) FILTER (WHERE p.tipo_prof = 2)
    FROM GR3_ASIGNATURA_PROFESOR ap
             JOIN GR3_PROFESOR p ON (ap.dni = p.dni)
WHERE (a.tipo_asig = ap.tipo_asig AND a.cod_asig = ap.cod_asig AND ap.activo IS TRUE));
RETURN NULL;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER TR_GR3_ASIGNATURA_PROFESOR_ASIGNAR_CANTIDADES
AFTER INSERT OR UPDATE OF dni, tipo_asig, cod_asig OR DELETE
ON GR3_ASIGNATURA_PROFESOR
FOR EACH STATEMENT
EXECUTE PROCEDURE TRFN_GR3_ACTUALIZAR_ASIGNATURA();

CREATE TRIGGER TR_GR3_PROFESOR_ASIGNAR_CANTIDADES
AFTER UPDATE OF tipo_prof OR DELETE
ON GR3_PROFESOR
FOR EACH STATEMENT
EXECUTE PROCEDURE TRFN_GR3_ACTUALIZAR_ASIGNATURA();
--------------------------------------------------------------------

-- No es actualizable porque tiene un ensamble pero con el trigger TR_GR3_V_PROF_SIMPLE_ACTUALIZABLE se hace actualizable
CREATE VIEW GR3_V_PROF_SIMPLE AS
SELECT p.dni, p.apellido, p.nombre, p.titulo, p.departamento, ps.perfil
FROM GR3_PROFESOR p
JOIN GR3_PROF_SIMPLE ps ON (p.dni = ps.dni);

-- No es actualizable porque tiene un ensamble pero con el trigger TR_GR3_V_PROF_EXCLUSIVO_ACTUALIZABLE se hace actualizable
CREATE VIEW GR3_V_PROF_EXCLUSIVO AS
SELECT p.dni, p.apellido, p.nombre, p.titulo, p.departamento, pe.proy_investig
FROM GR3_PROFESOR p
JOIN GR3_PROF_EXCLUSIVO pe ON (p.dni = pe.dni);

CREATE OR REPLACE FUNCTION TRFN_GR3_ACTUALIZAR_VISTA_V_PROF_SIMPLE()
RETURNS TRIGGER AS $$
BEGIN

    IF (TG_OP = 'UPDATE') THEN

        UPDATE GR3_PROFESOR SET
            apellido = new.apellido,
            nombre = new.nombre,
            titulo = new.titulo,
            departamento = new.departamento
        WHERE dni = new.dni;

        UPDATE GR3_PROF_SIMPLE SET perfil = new.perfil WHERE dni = new.dni;

    ELSE

        INSERT INTO GR3_PROFESOR (dni,apellido, nombre, titulo, departamento, tipo_prof)
            VALUES (new.dni, new.apellido, new.nombre, new.titulo, new.departamento, 1);
        INSERT INTO GR3_PROF_SIMPLE (dni, perfil) VALUES (new.dni, new.perfil);

    END IF;

RETURN NULL;

END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER TR_GR3_V_PROF_SIMPLE_ACTUALIZABLE
INSTEAD OF INSERT OR UPDATE
ON GR3_V_PROF_SIMPLE
FOR EACH ROW
EXECUTE PROCEDURE TRFN_GR3_ACTUALIZAR_VISTA_V_PROF_SIMPLE();

CREATE OR REPLACE FUNCTION TRFN_GR3_ACTUALIZAR_VISTA_V_PROF_EXCLUSIVO()
RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'UPDATE') THEN

        UPDATE GR3_PROFESOR SET
            apellido = new.apellido,
            nombre = new.nombre,
            titulo = new.titulo,
            departamento = new.departamento
        WHERE dni = new.dni;

        UPDATE GR3_PROF_EXCLUSIVO SET proy_investig = new.proy_investig WHERE dni = new.dni;

   ELSE

        INSERT INTO GR3_PROFESOR (dni,apellido, nombre, titulo, departamento, tipo_prof)
        VALUES (new.dni, new.apellido, new.nombre, new.titulo, new.departamento, 2);

        INSERT INTO GR3_PROF_EXCLUSIVO (dni, proy_investig) VALUES (new.dni, new.proy_investig);
    END IF;

RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER TR_GR3_V_PROF_EXCLUSIVO_ACTUALIZABLE
INSTEAD OF INSERT OR UPDATE
ON GR3_V_PROF_EXCLUSIVO
FOR EACH ROW
EXECUTE PROCEDURE TRFN_GR3_ACTUALIZAR_VISTA_V_PROF_EXCLUSIVO();

-- Es actualizable porque tiene todas las PK's
CREATE VIEW GR3_V_ASIGNATURAS_SIMPLE AS
SELECT tipo_asig, cod_asig, nombre_asig, cant_hs_t, cant_hs_p, cantidad_prof_simples
FROM GR3_ASIGNATURA
WHERE cantidad_prof_exclusivos = 0 AND cantidad_prof_simples > 0;

-- No es actualizable porque tiene un ensamble
CREATE VIEW GR3_V_PROFESORES_ASG AS
SELECT a.*, cuatrimestre, dni, cantidad_horas, sum(cantidad_horas) OVER cuatrimestre_dni AS cantidad_horas_totales
    FROM GR3_ASIGNATURA_PROFESOR ap
	JOIN GR3_ASIGNATURA a ON (a.tipo_asig = ap.tipo_asig AND a.cod_asig = ap.cod_asig)
    WINDOW cuatrimestre_dni AS (PARTITION BY cuatrimestre, dni)
ORDER BY cuatrimestre;

UPDATE GR3_ASIGNATURA a SET(cantidad_prof_simples, cantidad_prof_exclusivos) = (
    SELECT COUNT(tipo_prof) FILTER (WHERE p.tipo_prof = 1), COUNT(tipo_prof) FILTER (WHERE p.tipo_prof = 2)
    FROM GR3_ASIGNATURA_PROFESOR ap
             JOIN GR3_PROFESOR p ON (ap.dni = p.dni)
WHERE (a.tipo_asig = ap.tipo_asig AND a.cod_asig = ap.cod_asig AND ap.activo IS TRUE));