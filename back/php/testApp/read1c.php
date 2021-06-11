<?php
// ini_set('error_reporting', E_ALL);
// ini_set('display_errors', 1);
// ini_set('display_startup_errors', 1);
require_once("payment.php");
require_once("counterparty.php");

class Read1C {

    public function readFromFile($path){

        $line = "";
        $line2 = iconv("utf-8", "windows-1251", "СекцияДокумент=Платежное поручение");
        $ret = [];
        $reader = fopen($path, "r");
        if ($reader) {
            while (($line = fgets($reader)) !== false) {
                if(trim($line) == $line2){
                    array_push($ret, $this->readPayment($reader));
                }
            }
            fclose($reader);
            return $ret;
        }
    }

    private function readPayment($reader){
        $line = ""; 
        $line2 = iconv("utf-8", "windows-1251", "КонецДокумента");
        $pair = array();
        $payment = new Payment();
        while (!(trim($line = fgets($reader)) == $line2) && ($line != null)) {

            $pair = explode("=", trim($line));

            if (count($pair) < 2)  continue; 

            $field = trim($pair[0]);
            $value = trim($pair[1]);

            switch(iconv("windows-1251", "utf-8", $field)){
                case "Дата": 
                    $payment->date = $value;
                    break;
                case "Сумма": 
                    $payment->summa = $value;
                    break;
                case "Номер": 
                    $payment->number = $value;
                    break;  
                case "НазначениеПлатежа":
                    $payment->description = $value;
                    break;
                case "Плательщик1":
                    $payment->payer->name = $value;
                    break;
                case "ПлательщикИНН": 
                    $payment->payer->inn = $value;
                    break;           
                case "ПлательщикКПП":
                    $payment->payer->kpp = $value;
                    break;
                case "ПлательщикБанк1":
                    $payment->payer->bank = $value;
                    break;
                case "ПлательщикСчет": 
                    $payment->payer->rs = $value;
                    break;
                case "Получатель1":
                    $payment->payee->name = $value;
                    break;
                case "ПолучательИНН":
                    $payment->payee->inn = $value;
                    break;
                case "ПолучательКПП": 
                    $payment->payee->kpp = $value;
                    break;
                case "ПолучательБанк1": 
                    $payment->payee->bank = $value;
                    break;
                case "ПолучательСчет": 
                    $payment->payee->rs = $value;
                    break;
            }

        }
        return $payment;

    }
}