create schema cuidadosalud authorization postgres;
set search_path to cuidadosalud;

CREATE TABLE USUARIO(
ID_USUARIO serial primary key,
NOMBRE VARCHAR(30),
FECHANAC Date,
ESTATURA INT,
SEXO varchar(1),
PASSWORD varchar(30)
);

CREATE TABLE TIPOACTIVIDAD(
ID_TIPO_A serial primary key,
DESCRIPCION VARCHAR(50),
FACTORH numeric,
FACTORM numeric
);

CREATE TABLE ANTROPOMETRICOS(
ID_ANTRO serial primary key,
ID_USU int,
FECHA Date,
PESO INT,
CINTURA INT,
CADERA INT,
foreign key (ID_USU) references USUARIO(ID_USUARIO)
);

CREATE TABLE ACTIVIDADUSUARIO(
ID_ACTUSU serial primary key,
DESCRIPCION VARCHAR(30),
TA INT,
FECHA1 Date,
FECHA2 Date,
ID_USUAR int,
foreign key (TA) references TIPOACTIVIDAD(ID_TIPO_A),
foreign key(ID_USUAR) references USUARIO(ID_USUARIO)
);

