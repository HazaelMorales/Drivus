<?php

include 'conexion.php';
$json=array();
if(isset($_GET["nombre"])
&& isset($_GET["apellidop"]) 
&& isset($_GET["apeliidom"]) 
&& isset($_GET["genero"]) 
&& isset($_GET["fecha_nac"])  
&& isset($_GET["colonia"])
&& isset($_GET["calle"])
&& isset($_GET["num_casa"])
&& isset($_GET["cpostal"])
&& isset($_GET["telefono"])
&& isset($_GET["correo"])
&& isset($_GET["contraseña"])
){



$nn = $_GET['nombre'];
$ap = $_GET['apellidop'];
$am =$_GET['apellidom'];
$gg =$_GET['genero'];
$fn =$_GET['fecha_nac'];
$col =$_GET['colonia'];
$calle =$_GET['calle'];
$numcasa =$_GET['num_casa'];
$cp =$_GET['cpostal'];
$tel =$_GET['telefono'];
$email =$_GET['correo'];
$pc =$_GET['contraseña'];

$insert="INSERT INTO 
usuarios(nombre
,apellidop
,apellidom
,genero
,fecha_nac
,colonia
,calle
,num_casa
,cposta
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
        $consulta="SELECT *  FROM usuarios WHERE correo ='{$email}'";
        $resultado=mysqli_query($conexion,$consulta);

        if($resgistro=mysqli_fetch_array($resultado))
        {
            $json['usuarios']=$resgistro;
        }
        mysqli_close($conexion);
        echo json_encode($json);
    }else
    {   
        $resulta["nombre"]='no registra';
        $resulta["apellidop"]='no registra';
        $resulta["apellidom"]='no registra';
        $resulta["genero"]='no registra';
        $resulta["fecha_nac"]='no registra';
        $resulta["colonia"]='no registra';
        $resulta["calle"]='no registra';
        $resulta["num_casa"]='no registra';
        $resulta["cpostal"]='no registra';
        $resulta["telefono"]='no registra';
        $resulta["correo"]='no registra';
        $resulta["contraseña"]='no registra';
        $json['usuarios'][]=$resulta;
        echo json_encode($json);
    }
} 
{   

    echo "ingresa datos por favor, o hay datos sin ingresar ";
}
?>