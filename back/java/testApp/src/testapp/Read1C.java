/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ili4
 */
public class Read1C {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

    public static ArrayList<Payment> readFromFile(String path) throws FileNotFoundException, IOException, ParseException {
        ArrayList<Payment> ret = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "cp1251"));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals("СекцияДокумент=Платежное поручение")) {
                ret.add(readPayment(reader));
            }
        }
        reader.close();
        return ret;
    }

    private static Payment readPayment(BufferedReader reader) throws IOException, ParseException {
        String line;
        Payment payment = new Payment();
        Counterparty payer = new Counterparty();
        Counterparty payee = new Counterparty();
        while (!(line = reader.readLine()).equals("КонецДокумента")
                && line != null) {
            String[] pair = line.split("=");
            
            if (pair.length < 2) continue;
            
            String field = pair[0].trim();
            String value = pair[1].trim();

            switch (field) {
                case "Дата":
                    payment.date = dateFormatter.parse(value);
                    break;
                case "Сумма":
                    payment.summa = new BigDecimal(value);
                    break;
                case "Номер":
                    payment.number = value;
                    break;
                case "НазначениеПлатежа":
                    payment.description = value;
                    break;
                case "Плательщик1":
                    payer.name = value;
                    break;
                case "ПлательщикИНН":
                    payer.inn = value;
                    break;
                case "ПлательщикКПП":
                    payer.kpp = value;
                    break;
                case "ПлательщикБанк1":
                    payer.bank = value;
                    break;
                case "ПлательщикСчет":
                    payer.rs = value;
                    break;
                case "Получатель1":
                    payee.name = value;
                    break;
                case "ПолучательИНН":
                    payee.inn = value;
                    break;
                case "ПолучательКПП":
                    payee.kpp = value;
                    break;
                case "ПолучательБанк1":
                    payee.bank = value;
                    break;
                case "ПолучательСчет":
                    payee.rs = value;
                    break;
            }
        }
        payment.payer = payer;
        payment.payee = payee;
        return payment;
    }
}
