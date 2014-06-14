
package gui;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import klijent.requesthandler.RequestHandler;
import klijent.session.Sesija;

public class KlijentFormPogodi extends javax.swing.JFrame {

    RequestHandler klijent;
   
    public KlijentFormPogodi() {
        initComponents();
        jLabelGameOver.setVisible(false);
        klijent = new RequestHandler();
        
        Sesija.getSesija().getMapa().put("klijent", klijent);
        pocniKomunikaciju();
        Sesija.getSesija().getMapa().put("uneseni", new ArrayList<Integer>());
        Sesija.getSesija().getMapa().put("promaseni", new ArrayList<Integer>());
        Sesija.getSesija().getMapa().put("pogodjeni", new ArrayList<Integer>());
        Sesija.getSesija().getMapa().put("pogodio", null);
        Sesija.getSesija().getMapa().put("labela", jLabelGameOver);
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldPozicija = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelGameOver = new javax.swing.JLabel();
        jTextFieldUneti = new javax.swing.JTextField();
        jTextFieldPromaseni = new javax.swing.JTextField();
        jTextFieldBrPogodaka = new javax.swing.JTextField();
        jTextFieldBrPromasenih = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Unesi broj:");

        jButton1.setText("Pogodi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Uneti brojevi");

        jLabel3.setText("Promaseni brojevi");

        jLabel4.setText("Broj pogodaka");

        jLabel5.setText("Broj promasaj");

        jLabelGameOver.setText("Igra je zavrsena !");

        jTextFieldUneti.setEditable(false);

        jTextFieldPromaseni.setEditable(false);
        jTextFieldPromaseni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPromaseniActionPerformed(evt);
            }
        });

        jTextFieldBrPogodaka.setEditable(false);
        jTextFieldBrPogodaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBrPogodakaActionPerformed(evt);
            }
        });

        jTextFieldBrPromasenih.setEditable(false);
        jTextFieldBrPromasenih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBrPromasenihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1)
                    .addComponent(jLabelGameOver, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldBrPromasenih))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldBrPogodaka))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldPromaseni))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldUneti, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldUneti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPromaseni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldBrPogodaka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldBrPromasenih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabelGameOver, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            klijent.pogodi(Integer.parseInt(jTextFieldPozicija.getText()));
            ArrayList<Integer> list =
                    (ArrayList<Integer>) Sesija.getSesija().getMapa().get("uneseni");
            ArrayList<Integer> pogodjenji =
                    (ArrayList<Integer>) Sesija.getSesija().getMapa().get("pogodjeni");
            ArrayList<Integer> promaseni =
                    (ArrayList<Integer>) Sesija.getSesija().getMapa().get("promaseni");
            String text = "";
            list.add(Integer.parseInt(jTextFieldPozicija.getText()));
            
            for (Integer integer : list) {
                text = text + integer+" ";
                        
            }
            
            jTextFieldUneti.setText(text);
            
                //sacekam nit
                while (Sesija.getSesija().getMapa().get("pristupio")==null) {
                        
                }
                if (klijent.isPogodio()) {
                    pogodjenji.add(Integer.parseInt(jTextFieldPozicija.getText()));
                    Sesija.getSesija().getMapa().put("pristupio", null);
                }
                
                else{
                    text = "";
                   promaseni.add(Integer.parseInt(jTextFieldPozicija.getText()));
                    for (Integer integer : promaseni) {
                        text = text + integer+" ";
                        
                        }
                    jTextFieldPromaseni.setText(text);
                    Sesija.getSesija().getMapa().put("pristupio", null);
                }
                
                jTextFieldBrPogodaka.setText(pogodjenji.size()+"");
                jTextFieldBrPromasenih.setText(promaseni.size()+"");
                

        } catch (NumberFormatException | IOException | ClassNotFoundException ex) {
            //Logger.getLogger(KlijentFormPogodi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Morate uneti broj !");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldBrPromasenihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBrPromasenihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBrPromasenihActionPerformed

    private void jTextFieldPromaseniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPromaseniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPromaseniActionPerformed

    private void jTextFieldBrPogodakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBrPogodakaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBrPogodakaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KlijentFormPogodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KlijentFormPogodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KlijentFormPogodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KlijentFormPogodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KlijentFormPogodi().setVisible(true);
            }
        });
    }
    
    public  void pocniKomunikaciju() {
       
        
       
        
        try {
            
            int port = 9000;
            klijent.poveziSeSaServerom("localhost", port);
           
            try {

                klijent.pocetnaKomunikacija("HELLO");
                
                //wait for other thread 
                while (Sesija.getSesija().getMapa().get("pristupio")==null) {
                        
                }
                if (klijent.isPogodio()) {
                    
                }

                else{
                    Sesija.getSesija().getMapa().put("pristupio", null);
                }
                
            } catch (UnknownHostException | ClassNotFoundException ex) {
                Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (NumberFormatException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Niste uneli dobre podatke");
            System.exit(0);
        } 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelGameOver;
    private javax.swing.JTextField jTextFieldBrPogodaka;
    private javax.swing.JTextField jTextFieldBrPromasenih;
    private javax.swing.JTextField jTextFieldPozicija;
    private javax.swing.JTextField jTextFieldPromaseni;
    private javax.swing.JTextField jTextFieldUneti;
    // End of variables declaration//GEN-END:variables
}
