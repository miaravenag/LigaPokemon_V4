CREATE TABLE ms_pokedex_nacional (
     id_especie BIGINT AUTO_INCREMENT,
     nombre_pokemon VARCHAR(80) NOT NULL,
     tipo_primario VARCHAR(30) NOT NULL,
     tipo_secundario VARCHAR(30) NULL,
     puntos_vida_base INT NOT NULL,

     CONSTRAINT pk_ms_pokedex_nacional PRIMARY KEY (id_especie),
     CONSTRAINT uk_nombre_pokemon UNIQUE (nombre_pokemon)
);