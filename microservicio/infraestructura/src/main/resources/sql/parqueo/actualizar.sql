update public.parqueo
set placa = :placa,
	observacion = :observacion,
	fecha_hora_ingreso = :fechaHoraIngreso,
	fecha_hora_salida = :fechaHoraSalida,
	tipo_vehiculo = :tipoVehiculo,
	valor = :valor
where id = :id