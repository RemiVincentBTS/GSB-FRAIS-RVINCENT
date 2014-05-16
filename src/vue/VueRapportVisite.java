/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.toedter.calendar.JDateChooser;
import controleur.CtrlAbstrait;
import controleur.CtrlRapportVisite;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author btssio
 */
public class VueRapportVisite extends VueAbstraite {

    private DefaultComboBoxModel modeleJComboBoxNumeroRapport; 
    private DefaultComboBoxModel modeleJComboBoxVisiteur;
    private DefaultComboBoxModel modeleJComboBoxPraticien;
    private DefaultTableModel modeleJtableEchantillons;

    
    public VueRapportVisite(CtrlAbstrait ctrl) {
        super(ctrl);
        initComponents();
        this.setLocation(500, 200);
        
        
        
        // Liste visiteur
        modeleJComboBoxNumeroRapport = new DefaultComboBoxModel();
        jComboBoxNumeroRapport.setModel(modeleJComboBoxNumeroRapport);
        // Liste secteur
        modeleJComboBoxVisiteur = new DefaultComboBoxModel();
        jComboBoxVisiteur.setModel(modeleJComboBoxVisiteur);
        // Liste Laboratoire
        modeleJComboBoxPraticien = new DefaultComboBoxModel();
        jComboBoxPraticien.setModel(modeleJComboBoxPraticien);  
        
        
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooserDateRapport = new com.toedter.calendar.JDateChooser();
        jComboBoxNumeroRapport = new javax.swing.JComboBox();
        jTextFieldMotifVisite = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaBilan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEchantillon = new javax.swing.JTable();
        jComboBoxVisiteur = new javax.swing.JComboBox();
        jComboBoxPraticien = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jButtonMedicament = new javax.swing.JButton();
        jButtonPrecedent = new javax.swing.JButton();
        jButtonSuivant = new javax.swing.JButton();
        jButtonSaisieRapport = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonAjouterRapport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jLabel1.setText("Numero rapport :");

        jLabel2.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jLabel2.setText("Visiteur concerné :");

        jLabel3.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jLabel3.setText("Praticien :");

        jLabel4.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jLabel4.setText("Date rapport :");

        jLabel5.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jLabel5.setText("Motif Visite :");

        jLabel6.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jLabel6.setText("Bilan :");

        jDateChooserDateRapport.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N

        jComboBoxNumeroRapport.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jComboBoxNumeroRapport.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextFieldMotifVisite.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N

        jTextAreaBilan.setColumns(20);
        jTextAreaBilan.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jTextAreaBilan.setRows(5);
        jScrollPane1.setViewportView(jTextAreaBilan);

        jTableEchantillon.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jTableEchantillon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Médicament", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableEchantillon);

        jComboBoxVisiteur.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jComboBoxVisiteur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxPraticien.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jComboBoxPraticien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Bitstream Charter", 2, 15)); // NOI18N
        jLabel9.setText("Offre d'échantillons");

        jButtonMedicament.setText("Ajouter un médicament");
        jButtonMedicament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMedicamentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldMotifVisite, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserDateRapport, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPraticien, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxVisiteur, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxNumeroRapport, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonMedicament, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(12, 12, 12))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxNumeroRapport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxVisiteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxPraticien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooserDateRapport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldMotifVisite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMedicament))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jButtonPrecedent.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jButtonPrecedent.setText("Précèdent");
        jButtonPrecedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrecedentActionPerformed(evt);
            }
        });

        jButtonSuivant.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jButtonSuivant.setText("Suivant");
        jButtonSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuivantActionPerformed(evt);
            }
        });

        jButtonSaisieRapport.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jButtonSaisieRapport.setText("Saisir un nouveau rapport");
        jButtonSaisieRapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaisieRapportActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Bitstream Charter", 2, 36)); // NOI18N
        jLabel10.setText("Rapport de visite");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/Images/15019291-icone-de-notes-papier-pour-notes-sur-la-base-sombre.gif"))); // NOI18N

        jButtonAjouterRapport.setFont(new java.awt.Font("Bitstream Charter", 1, 15)); // NOI18N
        jButtonAjouterRapport.setText("Ajouter");
        jButtonAjouterRapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterRapportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPrecedent, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonSaisieRapport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAjouterRapport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSuivant)
                    .addComponent(jButtonPrecedent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSaisieRapport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAjouterRapport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrecedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrecedentActionPerformed
        try {
            ((CtrlRapportVisite)controleur).Precedent();
        } catch (Exception ex) {
            Logger.getLogger(VueRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPrecedentActionPerformed

    private void jButtonSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuivantActionPerformed
        try {
            ((CtrlRapportVisite)controleur).Suivant();
        } catch (Exception ex) {
            Logger.getLogger(VueRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSuivantActionPerformed

    private void jButtonSaisieRapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaisieRapportActionPerformed
        ((CtrlRapportVisite)controleur).PreparationSaisieNouveauRapportVisite();
    }//GEN-LAST:event_jButtonSaisieRapportActionPerformed

    private void jButtonAjouterRapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterRapportActionPerformed
        try {
            ((CtrlRapportVisite)controleur).SaisieNouveauRapportVisite();
        } catch (Exception ex) {
            Logger.getLogger(VueRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAjouterRapportActionPerformed

    private void jButtonMedicamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMedicamentActionPerformed
        try {
            ((CtrlRapportVisite)controleur).ChoixMedicament();
        } catch (Exception ex) {
            Logger.getLogger(VueRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMedicamentActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       try {
            ((CtrlRapportVisite)controleur).fichierQuitter();
        } catch (Exception ex) {
            Logger.getLogger(VueRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    // GETTER & SETTERS
    public JButton getjButtonMedicament() {
        return jButtonMedicament;
    }

    public void setjButtonMedicament(JButton jButtonMedicament) {
        this.jButtonMedicament = jButtonMedicament;
    }
    
    
    public JButton getjButtonAjouterRapport() {
        return jButtonAjouterRapport;
    }

    public void setjButtonAjouterRapport(JButton jButtonAjouterRapport) {
        this.jButtonAjouterRapport = jButtonAjouterRapport;
    }
    
    
    
    public DefaultTableModel getModeleJtableEchantillons() {
        return modeleJtableEchantillons;
    }

    public void setModeleJtableEchantillons(DefaultTableModel modeleJtableEchantillons) {
        this.modeleJtableEchantillons = modeleJtableEchantillons;
    }
        
    
    public DefaultComboBoxModel getModeleJComboBoxNumeroRapport() {
        return modeleJComboBoxNumeroRapport;
    }

    public void setModeleJComboBoxNumeroRapport(DefaultComboBoxModel modeleJComboBoxNumeroRapport) {
        this.modeleJComboBoxNumeroRapport = modeleJComboBoxNumeroRapport;
    }

    public DefaultComboBoxModel getModeleJComboBoxVisiteur() {
        return modeleJComboBoxVisiteur;
    }

    public void setModeleJComboBoxVisiteur(DefaultComboBoxModel modeleJComboBoxVisiteur) {
        this.modeleJComboBoxVisiteur = modeleJComboBoxVisiteur;
    }

    public DefaultComboBoxModel getModeleJComboBoxPraticien() {
        return modeleJComboBoxPraticien;
    }

    public void setModeleJComboBoxPraticien(DefaultComboBoxModel modeleJComboBoxPraticien) {
        this.modeleJComboBoxPraticien = modeleJComboBoxPraticien;
    }

    public JButton getjButtonPrecedent() {
        return jButtonPrecedent;
    }

    public void setjButtonPrecedent(JButton jButtonPrecedent) {
        this.jButtonPrecedent = jButtonPrecedent;
    }

    public JButton getjButtonSaisieRapport() {
        return jButtonSaisieRapport;
    }

    public void setjButtonSaisieRapport(JButton jButtonSaisieRapport) {
        this.jButtonSaisieRapport = jButtonSaisieRapport;
    }

    public JButton getjButtonSuivant() {
        return jButtonSuivant;
    }

    public void setjButtonSuivant(JButton jButtonSuivant) {
        this.jButtonSuivant = jButtonSuivant;
    }

    public JComboBox getjComboBoxNumeroRapport() {
        return jComboBoxNumeroRapport;
    }

    public void setjComboBoxNumeroRapport(JComboBox jComboBoxNumeroRapport) {
        this.jComboBoxNumeroRapport = jComboBoxNumeroRapport;
    }

    public JComboBox getjComboBoxPraticien() {
        return jComboBoxPraticien;
    }

    public void setjComboBoxPraticien(JComboBox jComboBoxPraticien) {
        this.jComboBoxPraticien = jComboBoxPraticien;
    }

    public JComboBox getjComboBoxVisiteur() {
        return jComboBoxVisiteur;
    }

    public void setjComboBoxVisiteur(JComboBox jComboBoxVisiteur) {
        this.jComboBoxVisiteur = jComboBoxVisiteur;
    }

    public JDateChooser getjDateChooserDateRapport() {
        return jDateChooserDateRapport;
    }

    public void setjDateChooserDateRapport(JDateChooser jDateChooserDateRapport) {
        this.jDateChooserDateRapport = jDateChooserDateRapport;
    }

    public JTable getjTableEchantillon() {
        return jTableEchantillon;
    }

    public void setjTableEchantillon(JTable jTableEchantillon) {
        this.jTableEchantillon = jTableEchantillon;
    }

    public JTextArea getjTextAreaBilan() {
        return jTextAreaBilan;
    }

    public void setjTextAreaBilan(JTextArea jTextAreaBilan) {
        this.jTextAreaBilan = jTextAreaBilan;
    }

    public JTextField getjTextFieldMotifVisite() {
        return jTextFieldMotifVisite;
    }

    public void setjTextFieldMotifVisite(JTextField jTextFieldMotifVisite) {
        this.jTextFieldMotifVisite = jTextFieldMotifVisite;
    }
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouterRapport;
    private javax.swing.JButton jButtonMedicament;
    private javax.swing.JButton jButtonPrecedent;
    private javax.swing.JButton jButtonSaisieRapport;
    private javax.swing.JButton jButtonSuivant;
    private javax.swing.JComboBox jComboBoxNumeroRapport;
    private javax.swing.JComboBox jComboBoxPraticien;
    private javax.swing.JComboBox jComboBoxVisiteur;
    private com.toedter.calendar.JDateChooser jDateChooserDateRapport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEchantillon;
    private javax.swing.JTextArea jTextAreaBilan;
    private javax.swing.JTextField jTextFieldMotifVisite;
    // End of variables declaration//GEN-END:variables
}
