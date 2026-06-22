INSERT INTO ms_articulos_catalogo (id_articulo, nombre_articulo, descripcion)
VALUES (1, 'Poción', 'Recupera 20 HP'),
       (2, 'Poción Super', 'Recupera 50 HP'),
       (3, 'Poké Ball', 'Captura Pokémon salvajes');

INSERT INTO ms_inventario_mochila (uuid_entrenador, id_articulo, cantidad_disponible)
VALUES ('uuid-juan', 1, 5),
       ('uuid-juan', 2, 2);