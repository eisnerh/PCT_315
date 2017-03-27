SELECT 
    COUNT(*), descripcion_horario AS descripcion
FROM
    horario
GROUP BY descripcion_horario
ORDER BY descripcion_horario;
select distinct descripcion_horario as descripcion from horario
