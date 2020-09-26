DROP DATABASE FitLogic;

CREATE DATABASE FitLogicfn;
USE FitLogic;

CREATE TABLE TipoUsuario(
	idtipousuario INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	tipo VARCHAR(32) NOT NULL,
)

INSERT INTO TipoUsuario(tipo) 
VALUES ('Administrador'),
			 ('Gerente'),
			 ('Recepcionista'),
			 ('Coach'),
			 ('Cliente');
			 
SELECT * FROM TipoUsuario

CREATE TABLE EstadoUsuario(
	idestado INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	estado VARCHAR(32) NOT NULL
)

INSERT INTO EstadoUsuario(estado)
VALUES ('Activo'),
			 ('Inactivo'),
			 ('Pagó'),
			 ('Sin pagar'),
			 ('Deshabilitado')

			 
SELECT * FROM EstadoUsuario

CREATE TABLE Usuario(
	idusuario INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	nombres VARCHAR(64) NOT NULL,
	apellidos VARCHAR(64) NOT NULL,
	usuario VARCHAR(64) NOT NULL,
	contrasena VARCHAR(128) NOT NULL,
	email VARCHAR(64) NOT NULL UNIQUE,
	genero CHAR(1) NOT NULL CHECK (genero in ('M','F','I')),
	dui VARCHAR(16)NOT NULL,
	nacimiento DATE NOT NULL,
	direccion VARCHAR(128),
	telefono VARCHAR(16) NOT NULL,
	idtipousuario INT NOT NULL REFERENCES TipoUsuario(idtipousuario),
	idestado INT NOT NULL REFERENCES EstadoUsuario(idestado),
	primerinicio INT DEFAULT 1
	)

INSERT INTO Usuario(nombres, apellidos, usuario, contrasena, email, genero, dui, nacimiento, direccion, telefono, idtipousuario, idestado, primerinicio)
VALUES ('Bryan Josué', 'Galdámez Recinos', 'josuegalre', '$2a$12$0/6YiClSFaS3Ipjlyqdo7OvcBrQ4z.39TSNBSPPH6x4e5ZtOoI..S', 'josuegalre@gmail.com', 'M', '20180298-0', '2002-02-18', 'Mi casa', '71264957', 1, 1, 0),
			('Josué Edgardo', 'Lacayo Reyes', 'lacayito21', '$2a$12$0/6YiClSFaS3Ipjlyqdo7OvcBrQ4z.39TSNBSPPH6x4e5ZtOoI..S', 'lacayito21@gmail.com', 'M', '20160024-1', '2001-07-05', 'Mi casa', '12345678', 2, 1, 0),
			('Roberto Alejandro', 'Delgado Sólorzano', 'delgado32', '$2a$12$0/6YiClSFaS3Ipjlyqdo7OvcBrQ4z.39TSNBSPPH6x4e5ZtOoI..S', 'delgado2@gmail.com', 'M', '20150036-2', '2001-10-18', 'Mi casa', '87654321', 3, 1, 0),
			('Jorge David', 'Morataya Belloso', 'davidmorataya', '$2a$12$0/6YiClSFaS3Ipjlyqdo7OvcBrQ4z.39TSNBSPPH6x4e5ZtOoI..S', 'davidmorataya@gmail.com', 'M', '20150455-2', '2002-06-25', 'M', '12345678', 4, 1, 0),
			('Abner Josué', 'Orellana Guardado', 'abnerjosue', '$2a$12$0/6YiClSFaS3Ipjlyqdo7OvcBrQ4z.39TSNBSPPH6x4e5ZtOoI..S', 'abner@gmail.com', 'M', '20180258-3', '2001-07-11', 'M', '12345678', 5, 4, 0);
	
SELECT * FROM Usuario;

CREATE TABLE RecuperarContrasena(
	idpeticion INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	idusuario INT NOT NULL REFERENCES Usuario(idusuario),
	pin VARCHAR(16) NOT NULL,
	fechalimite DATETIME NOT NULL
)
			 
SELECT * FROM RecuperarContrasena;

CREATE TABLE Membresias(
	idmembresia INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	tipo VARCHAR(32) NOT NULL,
	descripcion VARCHAR(128) NOT NULL,
	costo numeric(4,2) NOT NULL,
	estado CHAR(1) NOT NULL CHECK (estado IN ('A','I','M'))
)

INSERT INTO Membresias(tipo, descripcion, costo, estado)
VALUES ('Premium', 'Membresia tipo premium', 30,'A'),
			 ('Estándar', 'Membresia tipo estándar', 15, 'M');
			 
SELECT * FROM Membresias;

CREATE TABLE Cliente(
	idcliente INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	idusuario INT NOT NULL REFERENCES Usuario(idusuario),
	idmembresia INT NOT NULL REFERENCES Membresias(idmembresia),
	peso NUMERIC(6,2),
	altura NUMERIC(6,2)
)

SELECT * FROM Cliente;

CREATE TABLE TipoDocumentos(
	idtipodoc INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	tipo VARCHAR(32) NOT NULL
)

INSERT INTO TipoDocumentos(tipo)
VALUES ('Rutina de ejercicios'),
			 ('Curriculum vitae'),
			 ('Partida de nacimiento');
			 
SELECT * FROM TipoDocumentos;

CREATE TABLE Documentos(
	idDocumentos INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	url_doc varchar(64) NOT NULL,
	idCliente INT NOT NULL REFERENCES Cliente(idCliente),
	idtipodoc INT NOT NULL REFERENCES TipoDocumentos(idtipodoc)
)
			 
SELECT * FROM Documentos;

CREATE TABLE TipoEquipamiento(
	idtipoequipamiento INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	tipo VARCHAR(16) NOT NULL,
	descripcion VARCHAR(128) NOT NULL,
	estado CHAR(1) NOT NULL CHECK (estado in ('A', 'I', 'M'))
)

INSERT INTO TipoEquipamiento (tipo, descripcion, estado)
VALUES ('Pesas', 'Para pesas', 'A'),
			 ('Balón', 'Para clases', 'I'),
			 ('Pelota', 'Para ejercicios', 'A'),
			 ('Saltacuerda', 'Para la clase de aerobicos', 'A'),
			 ('Mancuerna', 'Para pesas', 'M');

SELECT * FROM TipoEquipamiento;

CREATE TABLE Equipamiento(
	idequipo INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	idtipoequipo INT NOT NULL REFERENCES TipoEquipamiento(idtipoequipamiento),
	cantidad INT NOT NULL
)

INSERT INTO Equipamiento (idtipoequipo, cantidad)
VALUES ( 1, 30),
			 ( 2, 55),
			 ( 3, 102),
			 ( 4, 83),
			 ( 5, 90);
			 
SELECT * FROM Equipamiento;

CREATE TABLE EstadoSalon(
	idestadosalon INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	estado VARCHAR(16) NOT NULL
)

INSERT INTO EstadoSalon (estado)
VALUES ('Activo'),
	   ('Inactivo'),
	   ('En mantenimiento')

CREATE TABLE Salon(
	idsalon INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	nombre VARCHAR(32) NOT NULL,
	descripcion VARCHAR(128) NOT NULL,
	capacidad INT NOT NULL,
	idestadosalon INT NOT NULL REFERENCES EstadoSalon(idestadosalon)
)

INSERT INTO Salon (nombre, descripcion, capacidad, idestadosalon)
VALUES ('Salón Olivo','Un salon grande', 20, 1),
	   ('Salón Luego','Un salon pequeño', 5, 1),
	   ('Salón Rumania','Un salon pequeño', 10, 2),
	   ('Salón Orquidea','Un salon muy grande', 25, 3),
	   ('Salón Jímenez','El salon principal', 30, 3)

CREATE TABLE Clase(
	idclase INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	idcoach INT NOT NULL REFERENCES Usuario(idusuario),
	horainicio TIME NOT NULL,
	horafin TIME NOT NULL,
	descripcion VARCHAR(128) NOT NULL,
	idequipo INT NULL REFERENCES Equipamiento(idequipo),
	idsalon INT NOT NULL REFERENCES Salon (idsalon)
)

INSERT INTO Clase (idcoach, horainicio, horafin, descripcion, idequipo, idsalon )
VALUES ( 4, '14:30:00', '15:30:00', 'Clase de pilates', 1, 1),
			 ( 4, '17:00:00', '18:00:00', 'Aerobicos', 4, 2),
			 ( 4, '13:00:00', '14:30:00', 'Balones de relajación', 3, 4),
			 ( 4, '16:40:00', '17:40:00', 'Mancuernas', 5, 5),
			 ( 4, '09:00:00', '10:00:00', 'Fútbol', 2, 1);

SELECT * FROM Clase;

CREATE TABLE Alumnos(
	idalumnos INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	idclase INT NOT NULL REFERENCES Clase(idclase),
	idcliente INT NOT NULL REFERENCES Cliente(idcliente)
)
			 
SELECT * FROM Alumnos;

CREATE TABLE Bitacora(
	id_accion INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	usuario INT NOT NULL REFERENCES Usuario(idusuario),
	event_info NVARCHAR(2048) NOT NULL,
	fecha DATE DEFAULT GETDATE()
)
			 
SELECT * FROM Bitacora;

CREATE TABLE Pago(
	idpago INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	monto DECIMAL(5,2) NOT NULL,
	cancelado DECIMAL(5,2) NOT NULL,
	devuelto DECIMAL(5,2) NOT NULL,
	fechapago DATE DEFAULT GETDATE()
)

SELECT * FROM Pago;

CREATE TABLE Factura(
	idfactura INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	idcliente INT NOT NULL REFERENCES Cliente(idcliente),
	idpago INT NOT NULL REFERENCES Pago(idpago)
)
			 
SELECT * FROM Factura;
SELECT * FROM Bitacora
SELECT * FROM Clase
SELECT * FROM Cliente
SELECT * FROM Documentos
SELECT * FROM Equipamiento
SELECT * FROM EstadoUsuario
SELECT * FROM Factura
SELECT * FROM Membresias
SELECT * FROM Pago
SELECT * FROM RecuperarContrasena
SELECT * FROM TipoDocumentos
SELECT * FROM TipoEquipamiento
SELECT * FROM TipoUsuario
SELECT * FROM Usuario
SELECT * FROM Pago
SELECT * FROM TipoEquipamiento
SELECT * FROM Equipamiento

UPDATE Clase SET horafin = '12:00' WHERE idclase IN (6,7)

SELECT u.nombres, u.apellidos, u.telefono, u.dui, u.usuario, m.tipo, u.email, m.costo 
FROM Cliente c, Usuario u, Membresias m 
WHERE u.idusuario = c.idusuario AND c.idmembresia = m.idmembresia AND u.idusuario = 1

SELECT MAX(p.fechapago) 
FROM Pago p, Factura f, Cliente c
WHERE p.idpago = f.idpago AND f.idcliente = c.idcliente AND c.idcliente = 3

UPDATE Pago SET fechapago = '2019-08-20' WHERE idpago = 39




SELECT * FROM Pago
SELECT * FROM Factura

INSERT INTO Pago (monto, cancelado, devuelto, fechapago)
VALUES (?,?,?,?)

SELECT MAX(idpago) FROM Pago

INSERT INTO Factura (idcliente, idpago)
VALUES (?, ?)


SELECT tp.tipo FROM TipoEquipamiento tp, Equipamiento e WHERE tp.idtipoequipamiento = e.idtipoequipo

DELETE FROM RecuperarContrasena where idusuario = 1

SELECT u.idusuario, (u.nombres+' '+u.apellidos), t.tipo, e.estado 
FROM TipoUsuario t, Usuario u, EstadoUsuario e 
WHERE t.idtipousuario = u.idtipousuario AND e.idestado = u.idestado AND (u.nombres+' '+u.apellidos) LIKE '%z%'


SELECT nombre FROM Salon

UPDATE Usuario SET primerinicio = 0 WHERE idusuario = 1
UPDATE Usuario SET contrasena = 'FitL0gic' WHERE idusuario = 1

SELECT COUNT(Usuario) FROM Usuario 

SELECT c.idclase, c.descripcion, (u.nombres+' '+u.apellidos), tp.tipo, s.nombre,(SELECT DATEDIFF(MINUTE, c.horainicio, c.horafin)) 
FROM Clase c, Usuario u, TipoEquipamiento tp, Equipamiento e, Salon s 
WHERE C.idcoach = U.idusuario AND c.idequipo = e.idequipo AND e.idtipoequipo = tp.idtipoequipamiento AND c.idsalon = s.idsalon AND c.descripcion LIKE '%ba%'

UPDATE Usuario SET nombres = ?, apellidos = ?, usuario = ?, email = ?, genero = ?, dui = ?, nacimiento = ?, direccion = ?, telefono = ?, idtipousuario = ?, idestado = ? WHERE idusuario = ?
UPDATE Cliente SET idmembresia = ?, peso = ?, altura = ? WHERE idusuario = ?


SELECT c.idcliente, (u.nombres+' '+u.apellidos), u.usuario, u.email, u.dui, u.telefono, m.tipo 
FROM Usuario u, Membresias m, Cliente c 
WHERE u.idusuario = c.idusuario AND c.idmembresia = m.idmembresia AND u.idtipousuario = 5


SELECT c.idcliente, u.nombres, u.apellidos, u.telefono, u.usuario, m.tipo, u.email, p.monto, p.cancelado, p.devuelto
FROM Cliente c, Usuario u, Membresias m , Pago p, Factura f
WHERE f.idcliente = c.idcliente AND f.idpago = p.idpago AND c.idmembresia = m.idmembresia AND c.idusuario = u.idusuario AND u.idtipousuario = 5 AND f.idfactura = 1

SELECT f.idfactura, c.idcliente, u.nombres, u.apellidos, u.telefono, u.usuario, m.tipo, u.email, p.monto, p.cancelado, p.devuelto 
FROM Cliente c, Usuario u, Membresias m , Pago p, Factura f
WHERE f.idcliente = c.idcliente AND f.idpago = p.idpago AND c.idmembresia = m.idmembresia AND c.idusuario = u.idusuario AND u.idtipousuario = 5 AND f.idfactura = 1