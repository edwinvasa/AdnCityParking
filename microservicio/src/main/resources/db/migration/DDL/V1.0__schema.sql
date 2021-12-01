create sequence usuario_seq;

create table usuario (
 id int not null default nextval ('usuario_seq'),
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion timestamp(0) null,
 primary key (id)
);

CREATE TABLE IF NOT EXISTS public.tarifa (
  id serial PRIMARY KEY,
  nombre VARCHAR(80) NOT NULL,
  tipo_vehiculo VARCHAR(80) NOT NULL,
  tipo_dia VARCHAR(80) NOT NULL,
  valor NUMERIC(17, 2) NOT NULL
);

INSERT INTO public.tarifa (nombre, tipo_vehiculo, tipo_dia, valor)
VALUES ('Estandar Motocicleta', 'MOTOCICLETA', 'REGULAR', 2000),
    ('Estandar Automovil', 'AUTOMOVIL', 'REGULAR', 4000),
    ('Sabado Motocicleta', 'MOTOCICLETA', 'SABADO', 3000),
    ('Sabado Automovil', 'AUTOMOVIL', 'SABADO', 6000),
    ('Feriado Motocicleta', 'MOTOCICLETA', 'FESTIVO', 4000),
    ('Feriado Automovil', 'AUTOMOVIL', 'FESTIVO', 8000),
    ('Domingo Motocicleta', 'MOTOCICLETA', 'DOMINGO', 4000),
    ('Domingo Automovil', 'AUTOMOVIL', 'DOMINGO', 8000);

CREATE TABLE IF NOT EXISTS public.parqueo (
    id serial primary key,
    placa varchar(12)  NOT NULL,
    fecha_hora_ingreso TIMESTAMP NOT NULL,
    fecha_hora_salida TIMESTAMP,
    tipo_vehiculo VARCHAR(80) NOT NULL,
    valor NUMERIC(17, 2),
    observacion varchar(100)
);

CREATE TABLE IF NOT EXISTS public.parqueo_detalle (
    id serial primary key,
    parqueo_id INT NOT NULL,
    fecha_hora_inicio TIMESTAMP,
    fecha_hora_fin TIMESTAMP,
    valor NUMERIC(17, 2) NOT NULL,
    tarifa_id INT NOT NULL,
    FOREIGN KEY (tarifa_id)
        REFERENCES tarifa (id),
    FOREIGN KEY (parqueo_id)
        REFERENCES parqueo (id)
);

CREATE TABLE IF NOT EXISTS public.festivo (
  fecha DATE PRIMARY KEY,
  descripcion VARCHAR(100) NOT NULL
);

INSERT INTO public.festivo (fecha, descripcion)
VALUES ('2021-01-01', 'Año Nuevo'),
	('2021-01-11', 'Día de los Reyes Magos'),
	('2021-03-22', 'Día de San José'),
	('2021-04-01', 'Jueves Santo'),
	('2021-04-02', 'Viernes Santo'),
	('2021-05-01', 'Día del Trabajador'),
	('2021-05-17', 'Día de la Ascensión'),
	('2021-06-07', 'Día del Corpus Christi'),
	('2021-06-14', 'Día del Sagrado Corazón'),
	('2021-07-05', 'Día de San Pedro y San Pablo'),
	('2021-07-20', 'Día de la Independencia'),
	('2021-08-07', 'Batalla de Boyacá'),
	('2021-08-16', 'La Asunción de la virgen'),
	('2021-10-10', 'Día de la Raza'),
	('2021-11-01', 'Día de los Difuntos'),
	('2021-11-15', 'Independencia de Cartagena'),
	('2021-12-08', 'Día de la Inmaculada Concepción'),
	('2021-12-25', 'Navidad'),
	('2022-01-01', 'Año Nuevo'),
	('2022-01-10', 'Día de los Reyes Magos'),
	('2022-03-21', 'Día de San José'),
	('2022-04-14', 'Jueves Santo'),
	('2022-04-15', 'Viernes Santo'),
	('2022-05-01', 'Día del Trabajador'),
	('2022-05-30', 'Día de la Ascensión'),
	('2022-06-20', 'Día del Corpus Christi'),
	('2022-06-27', 'Día del Sagrado Corazón'),
	('2022-07-04', 'Día de San Pedro y San Pablo'),
	('2022-07-20', 'Día de la Independencia'),
	('2022-08-07', 'Batalla de Boyacá'),
	('2022-08-15', 'La Asunción de la virgen'),
	('2022-10-17', 'Día de la Raza'),
	('2022-11-07', 'Día de los Difuntos'),
	('2022-11-14', 'Independencia de Cartagena'),
	('2022-12-08', 'Día de la Inmaculada Concepción'),
	('2022-12-25', 'Navidad');