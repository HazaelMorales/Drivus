<?php
    include 'conexion.php';
    $json=array();
    $consul = "SELECT * FROM  veiculos";

    $resultado_consult=mysqli_query($conexion,$consul);
            while($registro=mysqli_fetch_array($resultado_consult))
            {
                $json['veiculos'][]=$registro;
            }
        mysqli_close($conexion);
        echo json_encode($json);

?>