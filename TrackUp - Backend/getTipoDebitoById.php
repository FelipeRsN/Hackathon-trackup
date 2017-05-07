<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/x-www-form-urlencoded");
header("Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept");
    
    $data = file_get_contents("php://input");
    $objData = json_decode($data);

    $idTipo = $objData->idTipo;

    $dns = "mysql:host=mysql796.umbler.com;dbname=aula";
    $user = "lochesystem";
    $pass = "lochesystem";

    try{

        $con = new PDO($dns, $user, $pass);

        if(!$con){
		    echo "Não foi possivel conectar com Banco de Dados!";
	    }

        
        $query = $con->prepare('SELECT descricao FROM TipoDebitos where id = '.$idTipo);

        $query->execute();

        $out = "[";

        while($result = $query->fetch()){
                if ($out != "[") {
                    $out .= ",";
                }
                $out .= '{"descricao": "'.$result["descricao"].'"}';
        }

        $out .= "]";
        echo $out;

    }catch (Exception $e) {

	    echo "Erro: ". $e->getMessage();

    };