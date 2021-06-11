<?php
// ini_set('error_reporting', E_ALL);
// ini_set('display_errors', 1);
// ini_set('display_startup_errors', 1);
require_once("read1c.php");
require_once("payment.php");

$filePath = "../Выписка ГПБ за 20.10.20.txt";
$payments = [];

try {    
    $read1c = new Read1C();
    $payments = $read1c->readFromFile($filePath);

    foreach($payments as $p) {
        echo $p->toString();
    }
} catch (Exception $e) {
    echo 'Error: ',  $e->getMessage(), "\n";
}

?>
