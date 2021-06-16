<?php
include 'conexion.php';
$correo=$_POST['usr_correo'];
$contrasena=$_POST['usr_password'];


$sql=$conexion->prepare("SELECT * FROM usuarios WHERE correo=? AND contraseña=?");
$sql->bind_param('ss',$correo,$contrasena);
$sql->execute();

$resultado = $sql->get_result();
if ($fila = $resultado->fetch_assoc()){
        echo json_encode($fila,JSON_UNESCAPED_UNICODE);
}
$sql->close();
$conexion->close();
?>