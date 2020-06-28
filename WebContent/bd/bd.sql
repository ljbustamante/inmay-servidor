CREATE DATABASE  IF NOT EXISTS CL3;
USE CL3;

-- Creamos Tablas
create table tb_cliente(
	IdCliente int(11) NOT NULL AUTO_INCREMENT,
	nombre varchar(50) DEFAULT NULL,
	apellido varchar(50) DEFAULT NULL,
	dni char(8) DEFAULT NULL,
	edad int(11) DEFAULT NULL,
	PRIMARY KEY (IdCliente)
);

DELIMITER $$
create procedure sp_listarClientes(minimo int(11), maximo int(11))
BEGIN
	select * from tb_cliente where edad >= minimo && edad <= maximo;
END$$
DELIMITER ;

DELIMITER $$
create procedure sp_guardarCliente(nombre varchar(50), apellido varchar(50), dni char(8), edad int(11))
BEGIN
	insert into tb_cliente values(null, nombre, apellido, dni, edad);
END$$
DELIMITER ;

call sp_guardarCliente('Fátima', 'Donayre', '04185496', 50);
call sp_guardarCliente('Luis', 'Cerrillos', '41249652', 31);
call sp_guardarCliente('Julio', 'Rodriguez', '42418796', 32);
call sp_guardarCliente('Verónica', 'Bustamante', '09745216', 61);

call sp_listarClientes(1, 70);

