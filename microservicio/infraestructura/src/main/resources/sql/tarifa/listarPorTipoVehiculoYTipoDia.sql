select id, nombre, valor, tipo_vehiculo, tipo_dia
from public.tarifa
where tipo_vehiculo = :tipoVehiculo
and tipo_dia = :tipoDia