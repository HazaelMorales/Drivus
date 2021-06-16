<?php

include 'conexion.php';
$json=array();

$md = $_GET['modelo'];
$mm = $_GET['marca'];
$col =$_GET['color'];
$pla =$_GET['placas'];
$año =$_GET['año'];
$km =$_GET['kilometraje'];
$precio =$_GET['precio'];


$insert="INSERT INTO 
veiculos(modelo
,marca
,color
,placas
,año
,kilometraje
,precio
)
    values('{$md}'
        ,'{$mm}'
        ,'{$col}'
        ,'{$pla}'
        ,'{$año}'
        ,'{$km}'
        ,'{$precio}'
    )";



$resulttado_insert=mysqli_query($conexion,$insert);
 
    if($resulttado_insert)
    {
        $consulta="SELECT *  FROM veiculos WHERE placas ='{$pla}'";
        $resultado=mysqli_query($conexion,$consulta);

        if($resgistro=mysqli_fetch_array($resultado))
        {
            $json['veiculos']=$resgistro;
        }
        mysqli_close($conexion);
        echo json_encode($json);
    }else
    {   
        $resulta["placas"]='no registra';
        $json['veiculos'][]=$resulta;
        echo json_encode($json);
    }
}   
?>