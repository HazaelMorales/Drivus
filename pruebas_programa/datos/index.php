<!--SE hace un php para hacer la conexion de la base de la base de datos-->
<?php 
  include 'conexion.php';
  // en caso que la informacion no sea correcta o este vacio se cola un alert
  function alert($text,$func){
    echo "<script type='text/javascript'>alert('$text'); $func();</script>";
  }
 ?>
 <!--Inicia el formulario-->
 <!DOCTYPE html>
 <html lang="en">
 <head>
   <meta charset="UTF-8">
   <title>Registro</title>
 </head>
 <body>
  <section class="clean" id="Registro">
   <h4 class="Frase">Registro de Cuenta</h4>
          <form method="post">
          <div class="row">
              <div class="input-field col s6">
                  <input id="first_name" name="nombre" type="text" class="validate">
                  <label for="first_name">Nombre</label>
                </div>
                <div class="input-field col s6">
                  <input id="last_name"  name="apellido" type="text" class="validate">
                  <label for="last_name">Apellido</label>
                </div>
            </div>
            <div class="row">
                  <div class="input-field col s12">
                    <input id="email" name="correo" type="email" class="validate">
                    <label for="email">Correo</label>
                  </div>
            </div>
            <div class="row">
                  <div class="input-field col s12">
                    <input id="password" name="contrasena" type="password" class="validate">
                    <label for="password">Contraseña</label>
                  </div>
            </div>
            <div class="row">
                  <div class="input-field col s12">
                    <input id="Confpassword" name="conf_contrasena" type="password" class="validate">
                    <label for="Confpassword">Confirmar Contraseña</label>
                  </div>
            </div>
               <button type="submit" name="registrar" class="btn cyan darken-3 right">Registrar</button>
            </form>
</section>
<!--Se inicio la conexion para recoger los datos-->
<?php 
  if (isset($_POST['registrar'])) {
    $id = "";
    $nombre = $_POST['nombre'];
    $apellido = $_POST['apellido'];
    $correo = $_POST['correo'];
    $contrasena = $_POST['contrasena'];
    $conf_contrasena = $_POST['conf_contrasena'];

    //hace la revicion en dado caso que los campos esten
    if ($nombre != '' && $apellido != '' && $correo != '' && $contrasena != '') {
      if ($contrasena == $conf_contrasena) {
        $consulta = mysqli_query($conexion,"SELECT COUNT(id) FROM usuarios");
          if ($row = mysqli_fetch_array($consulta)) {
            $id = $row[0];
          }

      mysqli_free_result($consulta);
          //se hace la encriptacion
      $id = dechex($id);
      $contrasena = md5($contrasena);
     
          //se hace el registro
      $registro = mysqli_query($conexion,"INSERT INTO usuarios (id, nombre, apellido, correo, contrasena)
         VALUES ('$id', '$nombre', '$apellido', '$correo', '$contrasena') ")or die(mysqli_error());
      alert("Registro Exitoso","nulll");

      }else{
        alert("Contraseñas no coinciden.","registro");
      }
    }else{
      alert("Hay algunos campos vacios.","registro");
    }
  }  
 ?>
 </body>
 </html>
