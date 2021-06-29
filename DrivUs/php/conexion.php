<?php

	$hostname ='localhost';
	$database ='drivus';
	$username ='root';
	$password ='';

	$conexion = mysqli_connect($hostname,$username,$password,$database);
	if ($conexion ->connect_errno){
    	echo "los sentimos, el sistio web esta experimentando problemas , intentelo mas tarde ";
	}else{
	}

?>