<?php
require_once 'cabecalhoInterno.php';

$nome = "Daiane";
$idade = "20";
$obito = "não";
$sexo = "Feminino";
$nomeMae = "Tereza";
$cpfMae = "377439628-o6";

$telefone1 = "(19)3881-1606";
$telefone2 = "(19)3887-0987";
$telefone3 = "(19)3881-0987";
$celular1 = "(19)98945-6323";
$celular2 = "(19)98945-6323";
$celular3 = "(19)98945-6323";
$participacoes = "Empresa X";
$rua = "Rua das Alfazemas, 365";
$cidade = "Valinhos";
$cep = "13270-000";

$interesse1 = "comida";
$interesse2 = "carros";
$interesse3 = "motos";

$score = "-1";
$negativo = "0";
$protesto = "3";
$acao = "0";
?>

<ul class="collapsible" data-collapsible="accordion">
    <li>
        <div class="collapsible-header"><i class="material-icons">assignment_ind</i>Dados Pessoais</div>
        <div class="collapsible-body">
            <p>Nome: <?= $nome ?></p>
            <p>Sexo: <?= $sexo ?></p>
            <p>Idade: <?= $idade ?></p>
            <p>Obito: <?= $obito ?></p>
            <p>Nome da mãe: <?= $nomeMae ?></p>
            <p>Cpf da mãe: <?= $cpfMae ?></p>
        </div>
    </li>
    <li>
        <div class="collapsible-header"><span class="badge">1</span><i class="material-icons">grade</i>Ups</div>
        <div class="collapsible-body">
            <div class="row">
                <div class=" col s6">
                    <p><strong>Telefones Fixos:</strong></p>
                    <p><?= $telefone1 ?></p>
                    <p><?= $telefone2 ?></p>
                    <p><?= $telefone3 ?></p>
                </div>
                <div class=" col s6">
                    <p><strong>Telefones móveis:</strong></p>
                    <p><?= $celular1 ?></p>
                    <p><?= $celular2 ?></p>
                    <p><?= $celular3 ?></p>
                </div>
            </div>
            <div class="row">
                <div class="col s6">
                    <p><strong>Participações nas empresas:</strong></p>
                    <p><?= $participacoes ?></p>
                </div>
                <div class="col s6">
                    <p><strong>Endereços cadastrados:</strong></p>
                    <p><?= $rua ?></p>
                    <p><?= $cidade ?></p>
                    <p><?= $cep ?></p>
                </div>
            </div>
        </div>
    </li>
    <li>
        <div class="collapsible-header"><span class="badge"></span><i class="material-icons">place</i>Interesses</div>
        <div class="collapsible-body">
            <p><strong>Interesses:</strong></p>
            <p><?= $interesse1 ?></p>
            <p><?= $interesse2 ?></p>
            <p><?= $interesse3 ?></p>
        </div>
    </li>
    <li>
        <div class="collapsible-header"><span class="badge"></span><i class="material-icons">stars</i>Score</div>
        <div class="collapsible-body">
            <p><strong>Score:</strong></p>
            <p><?= $score ?></p>
            <p><strong>Negativo:</strong></p>
            <p><?= $negativo ?></p>
            <p><strong>Protesto:</strong></p>
            <p><?= $protesto ?></p>
            <p><strong>Ação:</strong></p>
            <p><?= $acao ?></p>
        </div>
    </li>
</ul>
