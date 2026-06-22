CREATE TABLE ms_tienda (
                           id_transaccion   BIGINT      NOT NULL AUTO_INCREMENT,
                           id_comprador     VARCHAR(36) NOT NULL,
                           id_articulo      BIGINT      NOT NULL,
                           precio_monedas   INT         NOT NULL,
                           fecha_transaccion DATE       NOT NULL,

                           CONSTRAINT pk_ms_tienda PRIMARY KEY (id_transaccion)
);