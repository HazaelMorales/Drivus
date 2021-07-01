<?php
    include 'conexion.php';
    $json=array();
    $consul = "SELECT * FROM  vehiculos";

    $resultado_consult=mysqli_query($conexion,$consul);
        while($registro=mysqli_fetch_array($resultado_consult))
        {
            $json['vehiculos'][]=$registro;
        }
    mysqli_close($conexion);
    echo json_encode($json);

?>