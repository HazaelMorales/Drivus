<?php
    include 'conexion.php';
    $json=array();
    $consul = "SELECT * FROM  usuarios";

    $resultado_consult=mysqli_query($conexion,$consul);
            while($registro=mysqli_fetch_array($resultado_consult))
            {
                $json['ususarios'][]=$registro;
            }
        mysqli_close($conexion);
        echo json_encode($json);

?>