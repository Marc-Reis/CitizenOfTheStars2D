<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        //echo password_hash("SuperGeheim!", PASSWORD_DEFAULT);
        $options = [
            'cost' => 10,
             ];
        echo password_hash("SuperGeheim!", PASSWORD_BCRYPT, $options).'<br>';
        
        
        $hash = '$2a$10$yrEBolfFdpevKE.FwcpTGO.sAehWqh9a6O78CC0x3TVq4AR2O4Nfi';        

        if (password_verify('SuperGeheim!', $hash)) {
            echo 'Valides Passwort!'.'<br>';
        } else {
            echo 'Invalides Passwort.'.'<br>';
        }        
        ?>
    </body>
</html>
