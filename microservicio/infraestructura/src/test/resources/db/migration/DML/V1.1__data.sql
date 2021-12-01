INSERT INTO public.parqueo(
	id, placa, fecha_hora_ingreso, fecha_hora_salida, tipo_vehiculo, valor, observacion)
	VALUES (1, 'QZK98B', '2021-11-29 11:15', '2021-11-29 13:10', 'MOTOCICLETA', 4000, 'TANQUE RAYADO');

INSERT INTO public.parqueo_detalle(
	id, parqueo_id, fecha_hora_inicio, fecha_hora_fin, valor, tarifa_id)
	VALUES (1, 1, '2021-11-29 11:15:00', '2021-11-29 13:10:21', 8000.00, 2);