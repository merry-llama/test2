/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

/**
 * Контрагент
 *
 * @author ili4
 */
public class Counterparty {

    /**
     * Наименование
     */
    public String name;

    /**
     * ИНН
     */
    public String inn;

    /**
     * КПП
     */
    public String kpp;

    /**
     * Банк
     */
    public String bank;

    /**
     * Расчетный счет
     */
    public String rs;

    @Override
    public String toString() {
        return "Наименование: " + name + 
                "\nИНН: " + inn + 
                "\nКПП: " + kpp + 
                "\nБанк: " + bank + 
                "\nРасчётный счёт: " + rs;
    }
}
