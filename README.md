--Empezaremos creando la Base de Datos para ello se abre el Command Line de MySQL y pega lo siguiente. Primero asegúrate de no contar con una BD con el mismo nombre, si en dado caso existe, salta el paso de la creación.
```
CREATE DATABASE forohub;

USE forohub;

CREATE TABLE curso(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	categoria VARCHAR(50) NOT NULL
);

CREATE TABLE perfil(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL
);

CREATE TABLE usuario(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	usuario VARCHAR(100) NOT NULL,
	correo_electronico VARCHAR(100) NOT NULL UNIQUE,
	clave VARCHAR(300) NOT NULL,
	id_perfil BIGINT NOT NULL,
	
	CONSTRAINT fk_perfil_id_perfil FOREIGN KEY(id_perfil) REFERENCES perfil (id)
);

CREATE TABLE respuesta(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	mensaje VARCHAR(100) NOT NULL,
id_topico BIGINT NOT NULL,
	fecha_creacion DATETIME NOT NULL,
	id_autor BIGINT NOT NULL,
	solucion VARCHAR(600) NOT NULL,

	CONSTRAINT fk_topico_id_topico FOREIGN KEY(id_topico) REFERENCES topico(id),
	CONSTRAINT fk_usuario_id_autor FOREIGN KEY(id_autor) REFERENCES usuario(id)
);

CREATE TABLE topico (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL,
	mensaje VARCHAR(600) NOT NULL,
	fecha_creacion DATETIME NOT NULL,
	status TINYINT NOT NULL,
	id_autor BIGINT NOT NULL,
	id_curso BIGINT NOT NULL,
	id_respuestas BIGINT NOT NULL,

	CONSTRAINT fk_usuario_id_autor FOREIGN KEY(id_autor) REFERENCES usuario(id),
	CONSTRAINT fk_curso_id_curso FOREIGN KEY(id_curso) REFERENCES curso(id),
 	CONSTRAINT fk_respuesta_id_respuesta FOREIGN KEY(id_respuestas) REFERENCES respuesta(id)
);
```
