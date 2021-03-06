/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import modele.Client;
import modele.DAOClub;
import modele.Registre;

/**
 *
 * @author 1495567
 */
public class GuiListerMembres extends javax.swing.JFrame {

    /**
     * Creates new form GuiListerMembres
     */
    //public GuiListerMembres(ArrayList<Client> maListe) {
    public GuiListerMembres() {
        initComponents();

       listerMembres();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMembres = new javax.swing.JTable();
        btnSortir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liste des Membres");

        tableMembres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableMembres);

        btnSortir.setText("Retourner");
        btnSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSortir)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSortir)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortirActionPerformed
        Registre.effacerListe();
        this.dispose();
    }//GEN-LAST:event_btnSortirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSortir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMembres;
    // End of variables declaration//GEN-END:variables

    public void listerMembres() {
        //CRÉATION DES STRING POUR LA ROQUETE ET LA ROUTE DE DU FICHIER 
        String select = "SELECT * FROM MEMBRES";
        String infoconnexion = "/control/infoconnexion.prp";
        //CRÉATION D'OBJET DE TYPE DAOClub
        DAOClub objeDAO = new DAOClub();
        
        objeDAO.connexion(infoconnexion);
        objeDAO.executeSelect(select);
        objeDAO.enregistrerMembre();
        tableMembres.setModel(new TableListerMembres(Registre.getMaListe()));
        objeDAO.fermeture();
    }
}
