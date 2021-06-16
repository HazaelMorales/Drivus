<?php
		require('conexion.php');

		$query="SELECT * FROM veiculos";
		$resultado=mysqli_query($conexion,$query);
		
		while($registro=mysqli_fetch_array($resultado)){
			$result["id"]=$registro['id'];
			$result["modelo"]=$registro['modelo'];
			$result["marca"]=$registro['marca'];
			$result["color"]=$registro['color'];
			$result["placas"]=$registro['placas'];
			$result["año"]=$registro['año'];
			$result["kilometraje"]=$registro['kilometraje'];
			$result["precio"]=$registro['precio'];
			$result["imagen"]=base64_encode($registro['imagen']);
			$json['veiculos'][]=$result;
			//echo $registro['id'].' - '.$registro['nombre'].'<br/>';
		}
		mysqli_close($conexion);
		echo json_encode($json);
?>