<?php

$hostname ='localhost';
$database ='driveus';
$username ='root';
$password ='';

$conexion = mysqli_connect($hostname,$username,$password,$database);
if ($conexion ->connect_errno){
   // echo "los sentimos, el sistio web esta experiemntedo problemas , intentelo mas tarde ";
}else{
   // echo "Conexion adquirida";
}

?>