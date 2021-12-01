select id, placa, tipo_vehiculo, fecha_hora_ingreso, fecha_hora_salida, valor, observacion
from public.parqueo
where date(fecha_hora_ingreso) = :fechaHoraIngreso