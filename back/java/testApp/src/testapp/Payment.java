/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Платежное поручение
 *
 * @author ili4
 */
public class Payment {
    
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Дата платежа
     */
    public Date date;

    /**
     * Сумма
     */
    public BigDecimal summa;

    /**
     * Номер платежки
     */
    public String number;

    /**
     * Назначение платежа
     */
    public String description;

    /**
     * Плательщик
     */
    public Counterparty payer;

    /**
     * Получатель
     */
    public Counterparty payee;

    @Override
    public String toString() {
        return "Платёжное поручение\n" + 
                "Дата: " + dateFormatter.format(date) + 
                "\nСумма: " + summa + 
                "\nНомер: " + number + 
                "\nНазначение платежа: " + description + 
                "\nПлательщик:\n" + payer + 
                "\nПолучатель:\n" + payee;
    }

    
}
