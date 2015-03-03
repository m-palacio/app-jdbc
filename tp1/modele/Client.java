/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

/**
 *
 * @author 1495567
 */
public class Client {
    
    private int codeMembre;
    private String nom;
    private String preNom;
    private String adresse;
    private String Statut;
    private double revenueAnnuel;

    //Constructeurs
    public Client() {
    }

    public Client(int codeMembre, String nom, String preNom, String adresse, String Statut, double revenueAnnuel) {
        this.codeMembre = codeMembre;
        this.nom = nom;
        this.preNom = preNom;
        this.adresse = adresse;
        this.Statut = Statut;
        this.revenueAnnuel = revenueAnnuel;
    }

    //Getters and Setters
    public int getCodeMembre() {
        return codeMembre;
    }

    public void setCodeMembre(int codeMembre) {
        this.codeMembre = codeMembre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPreNom() {
        return preNom;
    }

    public void setPreNom(String preNom) {
        this.preNom = preNom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String Statut) {
        this.Statut = Statut;
    }

    public double getRevenueAnnuel() {
        return revenueAnnuel;
    }

    public void setRevenueAnnuel(double revenueAnnuel) {
        this.revenueAnnuel = revenueAnnuel;
    }

    //Méthode toString
    @Override
    public String toString() {
        return "Client{" + "codeMembre=" + codeMembre + ", nom=" + nom + ", preNom=" + preNom + ", adresse=" + adresse + ", Statut=" + Statut + ", revenueAnnuel=" + revenueAnnuel + '}';
    }
      
    
}
