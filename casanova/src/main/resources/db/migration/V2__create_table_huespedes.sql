CREATE TABLE huespedes(
id int not null auto_increment,
nombre varchar(100) not null,
apellido varchar(200) not null,
nacimiento date,
nacionalidad varchar(100),
telefono varchar(50),
codigo int,

primary key(id)
);