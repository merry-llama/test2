/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ili4
 */
public class TestApp {

    private static String filePath = "..\\Выписка ГПБ за 20.10.20.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ArrayList<Payment> payments = Read1C.readFromFile(filePath);

            for (Payment p : payments) {
                System.out.println(p + "\n");
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
