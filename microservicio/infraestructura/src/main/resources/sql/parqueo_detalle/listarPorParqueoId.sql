select id, parqueo_id, fecha_hora_inicio, fecha_hora_fin, valor, tarifa_id
from public.parqueo_detalle
where parqueo_id = :parqueoId