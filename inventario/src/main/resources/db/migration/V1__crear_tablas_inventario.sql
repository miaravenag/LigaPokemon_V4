CREATE TABLE ms_articulos_catalogo (
                                       id_articulo  BIGINT       NOT NULL,
                                       nombre_articulo VARCHAR(50) NOT NULL,
                                       descripcion  VARCHAR(150),
                                       CONSTRAINT pk_articulos PRIMARY KEY (id_articulo),
                                       CONSTRAINT uk_nombre_articulo UNIQUE (nombre_articulo)
);

CREATE TABLE ms_inventario_mochila (
                                       id_registro         BIGINT       NOT NULL AUTO_INCREMENT,
                                       uuid_entrenador     VARCHAR(36)  NOT NULL,
                                       id_articulo         BIGINT       NOT NULL,
                                       cantidad_disponible INT          NOT NULL,
                                       CONSTRAINT pk_inventario PRIMARY KEY (id_registro),
                                       CONSTRAINT uk_entrenador_articulo UNIQUE (uuid_entrenador, id_articulo),
                                       CONSTRAINT fk_inventario_articulo FOREIGN KEY (id_articulo)
                                           REFERENCES ms_articulos_catalogo (id_articulo)
);