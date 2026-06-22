CREATE TABLE entrenadores (
    id BIGINT AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    region VARCHAR(100) NOT NULL,
    nivel INT NOT NULL,
    id_usuario_seguridad BIGINT NULL,

    CONSTRAINT pk_entrenadores PRIMARY KEY (id)
);