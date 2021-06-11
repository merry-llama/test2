<?php

class Payment{

    // дата платежа
    public $date;
    // сумма
    public $summa;
    // номер платежки
    public $number;
    // назначение платежа
	public $description;
	// плательщик
	public $payer;	
	// получатель
	public $payee;

    public function __construct(){

        $this->payer = new Counterparty();
        $this->payee = new Counterparty();
    }

    public function toString(){
        return iconv("utf-8", "windows-1251", "<br>Платёжное поручение<br>") . 
             iconv("utf-8", "windows-1251", "<br>Дата: ") . $this->date .
             iconv("utf-8", "windows-1251", "<br>Сумма: ") . $this->summa . 
             iconv("utf-8", "windows-1251", "<br>Номер: ") . $this->number . 
             iconv("utf-8", "windows-1251", "<br>Назначение платежа: ") . $this->description .
             iconv("utf-8", "windows-1251", "<br>Плательщик:<br> ") . $this->payer->toString().
             iconv("utf-8", "windows-1251", "<br>Получатель:<br> ") . $this->payee->toString(). "<br>";
    }
}


?>