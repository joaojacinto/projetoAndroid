<?php
require_once 'DbConnect.php';

$response = array();

if (isset($_GET['apicall'])){
    
    switch($_GET['apicall']){
			
        case 'biceps':
            $stmt = $conn->prepare("SELECT * FROM biceps");

            $stmt->execute();
					
	        $stmt->store_result();

            if($stmt->num_rows > 0){
						
                $stmt->bind_result($exercicio1,$exercicio2,$exercicio3,$exercicio4);
                $stmt->fetch();
        
                $exercicio = array(
                'exercicio1'=>$exercicio1, 
                'exercicio2'=>$exercicio2, 
                'exercicio3'=>$exercicio3,
                'exercicio4'=>$exercicio4
                );
            
                $response['error'] = false;
                $response['avaliacao'] = $exercicio; 
            }else{
                $response['error'] = false; 
                $response['message'] = 'Invalid idutilizador';
            }
            
        break; 
        
        case 'triceps':
            
            $stmt = $conn->prepare("SELECT * FROM triceps");

            $stmt->execute();
					
	        $stmt->store_result();

            if($stmt->num_rows > 0){
						
                $stmt->bind_result($exercicio1,$exercicio2,$exercicio3,$exercicio4);
                $stmt->fetch();
        
                $exercicio = array(
                'exercicio1'=>$exercicio1, 
                'exercicio2'=>$exercicio2, 
                'exercicio3'=>$exercicio3,
                'exercicio4'=>$exercicio4
                );
            
                $response['error'] = false;
                $response['avaliacao'] = $exercicio; 
            }else{
                $response['error'] = false; 
                $response['message'] = 'Invalid idutilizador';
            }
        break;
        
        case 'peito':
            
            $stmt = $conn->prepare("SELECT * FROM peito");

            $stmt->execute();
					
	        $stmt->store_result();

            if($stmt->num_rows > 0){
						
                $stmt->bind_result($exercicio1,$exercicio2,$exercicio3,$exercicio4);
                $stmt->fetch();
        
                $exercicio = array(
                'exercicio1'=>$exercicio1, 
                'exercicio2'=>$exercicio2, 
                'exercicio3'=>$exercicio3,
                'exercicio4'=>$exercicio4
                );
            
                $response['error'] = false;
                $response['avaliacao'] = $exercicio; 
            }else{
                $response['error'] = false; 
                $response['message'] = 'Invalid idutilizador';
            }
        break; 

        case 'costas':
            
            $stmt = $conn->prepare("SELECT * FROM costas");

            $stmt->execute();
					
	        $stmt->store_result();

            if($stmt->num_rows > 0){
						
                $stmt->bind_result($exercicio1,$exercicio2,$exercicio3,$exercicio4);
                $stmt->fetch();
        
                $exercicio = array(
                'exercicio1'=>$exercicio1, 
                'exercicio2'=>$exercicio2, 
                'exercicio3'=>$exercicio3,
                'exercicio4'=>$exercicio4
                );
            
                $response['error'] = false;
                $response['avaliacao'] = $exercicio; 
            }else{
                $response['error'] = false; 
                $response['message'] = 'Invalid idutilizador';
            }
        break; 

        case 'pernas':
            
            $stmt = $conn->prepare("SELECT * FROM pernas");

            $stmt->execute();
					
	        $stmt->store_result();

            if($stmt->num_rows > 0){
						
                $stmt->bind_result($exercicio1,$exercicio2,$exercicio3,$exercicio4);
                $stmt->fetch();
        
                $exercicio = array(
                'exercicio1'=>$exercicio1, 
                'exercicio2'=>$exercicio2, 
                'exercicio3'=>$exercicio3,
                'exercicio4'=>$exercicio4
                );
            
                $response['error'] = false;
                $response['avaliacao'] = $exercicio; 
            }else{
                $response['error'] = false; 
                $response['message'] = 'Invalid idutilizador';
            }
        break; 

        case 'abdominais':
            
            $stmt = $conn->prepare("SELECT * FROM abdominais");

            $stmt->execute();
					
	        $stmt->store_result();

            if($stmt->num_rows > 0){
						
                $stmt->bind_result($exercicio1,$exercicio2,$exercicio3,$exercicio4);
                $stmt->fetch();
        
                $exercicio = array(
                'exercicio1'=>$exercicio1, 
                'exercicio2'=>$exercicio2, 
                'exercicio3'=>$exercicio3,
                'exercicio4'=>$exercicio4
                );
            
                $response['error'] = false;
                $response['avaliacao'] = $exercicio; 
            }else{
                $response['error'] = false; 
                $response['message'] = 'Invalid idutilizador';
            }
        break; 
        
        default: 
            $response['error'] = true; 
            $response['message'] = 'Invalid Operation Called';
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