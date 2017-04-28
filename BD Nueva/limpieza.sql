SELECT 
    *
FROM
    limpieza.auxiliar a inner join limpieza.pasillo p on
    a.idauxiliar = p.idpasillo
ORDER BY RAND()
LIMIT 6