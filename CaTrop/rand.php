<<?php  
$colores = array("rojo", "azul", "amarillo", "verde", "negro", "blanco");
echo "Array original";
var_export ($colores);
echo "Valor aleatorio: ". $colores[array_rand($colores)];
?>
