<?php

include 'conexion.php';
$json=array();

$nn = $_POST['nombre'];
$ap = $_POST['apellidop'];
$am =$_POST['apellidom'];
$gg =$_POST['genero'];
$fn =$_POST['fecha_nac'];
$col =$_POST['colonia'];
$calle =$_POST['calle'];
$numcasa =$_POST['num_casa'];
$cp =$_POST['cpostal'];
$tel =$_POST['telefono'];
$email =$_POST['correo'];
$pc =$_POST['contraseña'];

$insert="INSERT INTO 
usuarios(nombre
,apellidop
,apellidom
,genero
,fecha_nac
,colonia
,calle
,num_casa
,cpostal
,telefono
,correo
,contraseña
)
    values('{$nn}'
        ,'{$ap}'
        ,'{$am}'
        ,'{$gg}'
        ,'{$fn}'
        ,'{$col}'
        ,'{$calle}'
        ,'{$numcasa}'
        ,'{$cp}'
        ,'{$tel}'
        ,'{$email}'
        ,'{$pc}'
    )";



    $resulttado_insert=mysqli_query($conexion,$insert);
 
    if($resulttado_insert)
    {
       echo "1";
    }else
    {   
        echo "0";
    }
?>
