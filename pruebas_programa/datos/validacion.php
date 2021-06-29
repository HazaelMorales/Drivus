<?php 
  if (isset($_POST['registrar'])) {
  
    $correo = $_POST['correo'];
    $contrasena = $_POST['contrasena'];
    
    $contrasena_encriptada = md5($contrasena);

    //hace la revision en dado caso que los campos esten
    if ($correo != '' && $contrasena != '') {
      if ($contrasena == $contrasena_encriptada) {
        $consulta = mysqli_query($conexion,"SELECT COUNT(id) FROM usuarios");
          if ($row = mysqli_fetch_array($consulta)) {
            $id = $row[0];
          }

      mysqli_free_result($consulta);
          //se hace la encriptacion
      $id = dechex($id);
 ?>