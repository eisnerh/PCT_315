Select DISTINCT `cabina`.`cabina_id`, 
                `cabina`.`descripcion_cabina`, 
                `cabina`.`estado_cabina`, 
                `factura_cabina`.`fecha`, 
                `factura_cabina`.`cant_dia`, date(@fecha := ((fecha) + (cant_dia))), 
                if (date(@fecha := ((fecha) + (cant_dia)))<now(), 
                -1*DATEDIFF(date(@fecha := ((fecha) + (cant_dia))),now()), 
                (DATEDIFF(date(@fecha := ((fecha) + (cant_dia))),now()))) 
                as cantidad 
                from 
                `pct3`.`factura_cabina` AS `factura_cabina`, 
                `pct3`.`cabina` AS `cabina` 
                WHERE 
                `factura_cabina`.`cabina_cabina_id` = `cabina`.`cabina_id` 
                and `cabina`.`estado_cabina` = 'Ocupado' ;
