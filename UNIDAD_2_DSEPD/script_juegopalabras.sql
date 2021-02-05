create schema juegop authorization postgres;
set search_path to juegop;

create table tipos
(
	id_tipos serial primary key,
	descripcion varchar (30)
);
create table palabras
(
	id_palabra	serial primary key,
	palabra 	varchar (30),
	tipo 		int,
	nivel		int, 
	foreign key (tipo) references tipos (id_tipos)
);

create table usuario
(
	id_usuario 	serial primary key,
	nombre	   	varchar (50),
	tpersona	varchar(1),
	fecha_registro	date
);

create table juegos_usuario
(
	id_juegousu	serial primary key,
	idusuario	int,
	idpalabra	int,
	intentosr	int,
	intentost	int, 
	fecha_hora	date,
	foreign key (idusuario) references usuario (id_usuario),
	foreign key (idpalabra) references palabras (id_palabra)
);