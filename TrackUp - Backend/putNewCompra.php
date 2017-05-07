<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/x-www-form-urlencoded");
header("Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept");
    
    $data = file_get_contents("php://input");
    $objData = json_decode($data);

    $doc = $objData->documento;
    $data = date('m/d/Y h:i:s', $objData->data);
    $valor = $objData->valor;

    $dns = "mysql:host=mysql796.umbler.com;dbname=aula";
    $user = "lochesystem";
    $pass = "lochesystem";

    try{

        $con = new PDO($dns, $user, $pass);

        if(!$con){
		    echo "Não foi possivel conectar com Banco de Dados!";
	    }
        
        $query = $con->prepare("INSERT INTO Compras (documento,dataCompra,valorCompra,statusCompra) VALUES ('".$doc."','".$data."','".$valor."','2')");
                
        $query->execute();

        if(!$query){
                
            $out = array('status' => "false");
            echo json_encode($out);
                
        }else{

            $out = array('status' => "true");
            echo json_encode($out);
                
        }


    }catch (Exception $e) {

	    echo "Erro: ". $e->getMessage();

    };