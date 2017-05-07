<?php
//USUÁRIOS E UTILIZA ENVIO E RETORNO EM OBJETOS
header("Access-Control-Allow-Origin: *");
header('Content-Type: text/html; charset=utf-8');
   
    $dns = "mysql:host=mysql796.umbler.com;dbname=aula";
    $user = "lochesystem";
    $pass = "lochesystem";
   
    try{

        $con = new PDO($dns, $user, $pass);

        if(!$con){
		    echo "Não foi possivel conectar com Banco de Dados!";
	    }

        
        $query = $con->prepare('SELECT * FROM TipoDebitos');

        $query->execute();

        $out = "[";

        while($result = $query->fetch()){
                if ($out != "[") {
                    $out .= ",";
                }
                $out .= '{"id": "'.$result["id"].'",';
                $out .= '"descricao": "'.$result["descricao"].'"}';
        }

        $out .= "]";
        echo $out;

    }catch (Exception $e) {

	    echo "Erro: ". $e->getMessage();

    };