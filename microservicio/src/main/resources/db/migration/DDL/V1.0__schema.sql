create sequence usuario_seq;

create table usuario (
 id int not null default nextval ('usuario_seq'),
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion timestamp(0) null,
 primary key (id)
);