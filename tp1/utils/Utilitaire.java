/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JTextField;

/**
 *
 * @author 1495567
 */
public class Utilitaire {

    //Méthode pour connaitre la longueur d'une chaine
    public static boolean validerChampsVide(JTextField txtInfo) {

        return txtInfo.getText().isEmpty();

    }

    public static boolean validerChampRevenue(JTextField txtRevenuannuel) {

        Double revenue = Double.parseDouble(txtRevenuannuel.getText());

        if (revenue >= 0) {

            return true;
        } else {

            return false;
        }
    }

}
