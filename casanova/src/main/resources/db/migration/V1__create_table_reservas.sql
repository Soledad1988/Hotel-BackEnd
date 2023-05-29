create table reservas(
codigo integer not null auto_increment,
ingreso date,
salida date,
valor varchar(50),
pago varchar(100),

primary key(codigo)
);