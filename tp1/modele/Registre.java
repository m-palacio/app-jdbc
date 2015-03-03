/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.util.ArrayList;

/**
 *
 * @author 1495567
 */
public class Registre {
    
    private static ArrayList <Client> maListe = new ArrayList<Client>();

    //Création de get
    public static ArrayList getMaListe() {
        return maListe;
    }
    
    //Méthode d'ajou des employes
    public static void ajouterMembre(Client c){
        
        maListe.add(c);
        
    }
    
    public static void affichierMembre(){
        
        for(Client c : maListe){
            
            System.out.println(c);
            
        }
    }
    
    public static void effacerListe(){
        
        maListe = new ArrayList<Client>();
    }
    
}
