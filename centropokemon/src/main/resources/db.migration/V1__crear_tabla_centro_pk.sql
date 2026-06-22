CREATE TABLE centro_pk (
                           id               BIGINT       NOT NULL AUTO_INCREMENT,
                           nombre           VARCHAR(150) NOT NULL,
                           ciudad           VARCHAR(100) NOT NULL,
                           region           VARCHAR(100) NOT NULL,
                           direccion        VARCHAR(255) NULL,
                           total_atenciones INT          NOT NULL DEFAULT 0,
                           disponible       BOOLEAN      NOT NULL DEFAULT TRUE,

                           CONSTRAINT pk_centro_pk PRIMARY KEY (id)
);