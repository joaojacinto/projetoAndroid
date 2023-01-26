<?php
require_once 'DbConnect.php';

$response = array();

$idutil = $_POST["idutilizador"];

if (isset($_POST['idutilizador'])){
    
    $stmt = $conn->prepare("SELECT gordura_corporal,massa_muscular,peso,altura,massa_gorda FROM avaliacao_fisica WHERE idutilizador = ?");
	$stmt->bind_param("i",$idutil);

    $stmt->execute();
					
	$stmt->store_result();

    if($stmt->num_rows > 0){
						
        $stmt->bind_result($gordura_corporal,$massa_muscular,$peso,$altura,$massa_gorda);
        $stmt->fetch();
        
        $avaliacao = array(
            'gordura_corporal'=>$gordura_corporal, 
            'massa_muscular'=>$massa_muscular, 
            'peso'=>$peso,
            'altura'=>$altura,
            'massa_gorda'=>$massa_gorda
        );
        
        $response['error'] = false;
        $response['avaliacao'] = $avaliacao; 
    }else{
        $response['error'] = false; 
        $response['message'] = 'Invalid idutilizador';
    }

} else{
    $response['error'] = true; 
    $response['message'] = 'Invalid API Call';
}

echo json_encode($response);

    function isTheseParametersAvailable($params){
		
		foreach($params as $param){
			if(!isset($_POST[$param])){
				return false; 
			}
		}
		return true; 
	}
?>