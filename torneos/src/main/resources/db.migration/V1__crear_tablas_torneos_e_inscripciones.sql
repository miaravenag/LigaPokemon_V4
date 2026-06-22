CREATE TABLE ms_torneos (
                            id_torneo                    BIGINT       NOT NULL AUTO_INCREMENT,
                            nombre_evento                VARCHAR(150) NOT NULL,
                            medallas_minimas_requeridas  INT          NOT NULL,
                            estado_convocatoria          VARCHAR(30)  NOT NULL,

                            CONSTRAINT pk_ms_torneos PRIMARY KEY (id_torneo)
);

CREATE TABLE ms_torneos_inscripciones (
                                          id_inscripcion    BIGINT      NOT NULL AUTO_INCREMENT,
                                          torneo_id_torneo  BIGINT      NOT NULL,
                                          uuid_entrenador   VARCHAR(36) NOT NULL,
                                          fecha_inscripcion DATE        NOT NULL,

                                          CONSTRAINT pk_ms_torneos_inscripciones PRIMARY KEY (id_inscripcion),
                                          CONSTRAINT fk_inscripcion_torneo FOREIGN KEY (torneo_id_torneo)
                                              REFERENCES ms_torneos (id_torneo) ON DELETE CASCADE,
                                          CONSTRAINT uk_torneo_entrenador UNIQUE (torneo_id_torneo, uuid_entrenador)
);
