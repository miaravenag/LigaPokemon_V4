CREATE TABLE ms_medallas_gimnasio (
                                      id_logro       BIGINT       NOT NULL AUTO_INCREMENT,
                                      id_entrenador  VARCHAR(36)  NOT NULL,
                                      nombre_medalla VARCHAR(25)  NOT NULL,
                                      es_oficial     BOOLEAN      NOT NULL DEFAULT TRUE,
                                      CONSTRAINT pk_ms_medallas_gimnasio PRIMARY KEY (id_logro)
);