CREATE TABLE operarios (
id INTEGER NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
username VARCHAR(10) NOT NULL,
`password` VARCHAR(10) NOT NULL,
PRIMARY KEY(id)
);
CREATE TABLE productos (
id INTEGER NOT NULL AUTO_INCREMENT,
nombre VARCHAR(20) NOT NULL,
precio double NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE compras (
id INTEGER NOT NULL AUTO_INCREMENT,
cantidad INTEGER NOT NULL,
tipoEnvio INTEGER NOT NULL,
formaEnvio INTEGER NOT NULL,
clienteid INTEGER NOT NULL,
producto INTEGER NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fk_compras_clientes_id  FOREIGN KEY ( clienteid ) REFERENCES clientes (id),
CONSTRAINT fk_compras_productos_id  FOREIGN KEY (producto) REFERENCES productos (id)
);
