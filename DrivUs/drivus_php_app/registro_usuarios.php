<?php
    include 'conexion.php';
    $json=array();

    if(isset($_POST['nombre']) 
    && isset($_POST['ApellidoP']) 
    && isset($_POST['ApellidoM']) 
    && isset($_POST['genero']) 
    && isset($_POST['fecha_nac'])  
    && isset($_POST['calle'])
    && isset($_POST['num_casa'])
    && isset($_POST['colonia'])
    && isset($_POST['cpostal'])
    && isset($_POST['telefono'])
    && isset($_POST['correo'])
    && isset($_POST['contraseña'])
    ){

        $nn= $_POST['nombre'];
        $ap = $_POST['ApellidoP'];
        $am = $_POST['ApellidoM'];
        $gg =$_POST['genero'];
        $fn =$_POST['fecha_nac'];
        $calle =$_POST['calle'];
        $numcasa =$_POST['num_casa'];
        $col =$_POST['colonia'];
        $cp =$_POST['cpostal'];
        $tel =$_POST['telefono'];
        $email =$_POST['correo'];
        $password =$_POST['contraseña'];

        $insert="INSERT INTO 
        cliente(email
        ,password
        ,nombre
        ,aPaterno
        ,aMaterno)
            values('{$email}'
                ,'{$password}'
                ,'{$nn}'
                ,'{$ap}'
                ,'{$am}'
            )";

        $resultado_insert=mysqli_query($conexion,$insert);
     
        if($resultado_insert){

            $id_cliente_omega = mysqli_insert_id($conexion);

            $insert_1="INSERT INTO 
            cliente_info(id_cliente
            ,birthday
            ,telefono
            ,calle
            ,colonia
            ,no_casa
            ,cp)
                values('{$id_cliente_omega}'
                ,'{$fn}'
                ,'{$tel}'
                ,'{$calle}'
                ,'{$col}'
                ,'{$numcasa}'
                ,'{$cp}'
                )";

            $resultado_insert_1=mysqli_query($conexion,$insert_1);

            if($resultado_insert_1){
                echo "1";
            }else{
                echo "0";
            }
        }else{   
            echo "No se logro inserccion";
        }
    }
    mysqli_close($conexion);
?>
