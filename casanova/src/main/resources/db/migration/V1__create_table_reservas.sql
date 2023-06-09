create table reservas(
id int not null auto_increment,
ingreso date not null,
salida date not null,
valor varchar(50),
pago varchar(100) not null,

primary key(id)
);