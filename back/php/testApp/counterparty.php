<?php

class Counterparty{
    // наименование
    public $name;
        
    // ИНН
    public $inn;

    // КПП
    public $kpp;

    // банк
    public $bank;

    // расчтеный счет
    public $rs;

    public function toString(){
        return iconv("utf-8", "windows-1251", "Наименование: ") . $this->name . 
             iconv("utf-8", "windows-1251", "<br>ИНН: ") . $this->inn . 
             iconv("utf-8", "windows-1251", "<br>КПП: ") . $this->kpp . 
             iconv("utf-8", "windows-1251", "<br>Банк: ") . $this->bank . 
             iconv("utf-8", "windows-1251", "<br>Расчётный счёт: ") . $this->rs; 
    }

}
?>