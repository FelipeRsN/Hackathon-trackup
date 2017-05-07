<?php
require_once 'cabecalho.php';
?>

<div class="container">
    <div class="section">

        <div class="card horizontal">
            <div class="card-stacked">
                <div class="card-content">
                    <form class="col s12" type="submit" action="areaRestrita.php" method="post">
                        <div class="row">
                            <div class="input-field push-s3 col s6">
                                <i class="material-icons prefix">credit_card</i>
                                <input id="txtCnpj" type="text" class="validate">
                                <label for="txtCnpj">Cnpj</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field push-s3 col s6">
                                <i class="material-icons prefix">https</i>
                                <input id="txtPassword" type="password" class="validate">
                                <label for="txtPassword">Senha</label>
                            </div>
                        </div>
                        <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                            <i class="material-icons right">send</i>
                        </button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>




