CREATE TABLE ms_acceso_y_seguridad (
    id_usuario BIGINT AUTO_INCREMENT,
    nombre_usuario VARCHAR(20) NOT NULL,
    contrasena_encriptada VARCHAR(40) NOT NULL,
    rol_asignado ENUM('ADMIN', 'OPERADOR', 'ENTRENADOR') NOT NULL,

    CONSTRAINT pk_ms_acceso_y_seguridad PRIMARY KEY (id_usuario),
    CONSTRAINT uk_nombre_usuario UNIQUE (nombre_usuario)
);