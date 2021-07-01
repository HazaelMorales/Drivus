<?php
	include 'conexion.php';
	$json=array();
	
	$query="SELECT * FROM vehiculos";
	$resultado=mysqli_query($conexion,$query);
		
	while($registro=mysqli_fetch_array($resultado)){
		$result["id"]=$registro['id'];
		$result["modelo"]=$registro['modelo'];
		$result["marca"]=$registro['marca'];
		$result["color"]=$registro['color'];
		$result["placas"]=$registro['placas'];
		$result["year"]=$registro['year'];
		$result["velocidad"]=$registro['velocidad'];
		$result["precio"]=$registro['precio'];
		$result["url_imagen"]=$registro['url_imagen'];
		$json['vehiculos'][]=$result;
		//echo $registro['id'].' - '.$registro['nombre'].'<br/>';
	}
	mysqli_close($conexion);
	echo json_encode($json);
?>