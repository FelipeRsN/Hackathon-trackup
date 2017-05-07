<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/x-www-form-urlencoded");
header("Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept");
    
    $data = file_get_contents("php://input");
    $objData = json_decode($data);
        
    $doc = $objData->documento;

    $dns = "mysql:host=mysql796.umbler.com;dbname=aula";
    $user = "lochesystem";
    $pass = "lochesystem";

    try{

        $con = new PDO($dns, $user, $pass);

        if(!$con){
		    echo "Não foi possivel conectar com Banco de Dados!";
	    }

        $query = $con->prepare('SELECT * FROM Debitos where documento = '.$doc);

        $query->execute();

        $out = "[";

        while($result = $query->fetch()){
                
                $queryId = $con->prepare('SELECT descricao FROM TipoDebitos where id = '.$result["idTipoDebito"]);

                $queryId->execute();

                $resultId = $queryId->fetch();

                if ($out != "[") {
                    $out .= ",";
                }
                $out .= '{"id": "'.$result["id"].'",';
                $out .= '"documento": "'.$result["documento"].'",';
                $out .= '"data": "'.$result["dataOrigem"].'",';
                $out .= '"origem": "'.$result["origem"].'",';
                $out .= '"tipo": "'.$resultId["descricao"].'",';
                $out .= '"valor": "'.$result["valor"].'"}';
        }

        $out .= "]";
        echo $out;

    }catch (Exception $e) {

	    echo "Erro: ". $e->getMessage();

    };