<?php
 
require('conexion.php');
$correo=$_POST['correo'];
$contrasena=$_POST['contrasena'];
$contrasena_encriptada = md5($contrasena);


//conexion a la base de datos

 
$consultar="SELECT * FROM usuarios WHERE correo ='$correo' and contrasena ='$contrasena_encriptada'";
$resultado=mysqli_query($conexion, $consultar);

$filas=mysqli_num_rows($resultado);

if($filas>0){
    header ("location:Bienvenido.html");
    
}
else{
    echo"erroe en la autentificación";
}
mysqli_free_result($resultado);
mysqli_close($conexion);
?>