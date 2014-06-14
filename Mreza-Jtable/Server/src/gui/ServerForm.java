
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.Timer;
import server.ServerListenhread;
import server.clienthandler.ClientHandler;
import sun.font.TrueTypeFont;

/**
 *
 * @author janjic
 */
public class ServerForm extends javax.swing.JFrame {
    
    private final SimpleDateFormat hhmm  = new SimpleDateFormat("hh:mm");
    private final SimpleDateFormat hhmmss  = new SimpleDateFormat("hh:mm:ss");

    
    
    public ServerForm() {
        initComponents();
        jLabelPoslednji.setVisible(false);
        jLabelPrvi.setVisible(false);
        jLabelSada.setVisible(false);
        jLabelTimeSada.setVisible(true);
        jLabelTimePrvi.setVisible(false);
        jLabelTimePoslednji.setVisible(false);
        jButtonIzbaci.setEnabled(false);
        
        //postavim u sesiju
        ServerListenhread.getServer().getServerSesija().put("combo", jComboBoxKorisnici);
        ServerListenhread.getServer().getServerSesija().put("labelaprvi", jLabelPrvi);
        ServerListenhread.getServer().getServerSesija().put("labelaprvi_time", jLabelTimePrvi);
        ServerListenhread.getServer().getServerSesija().put("labelaposlednji", jLabelPoslednji);
        ServerListenhread.getServer().getServerSesija().put("labelaposlednji_time", jLabelTimePoslednji);
        ServerListenhread.getServer().getServerSesija().put("btn", jButtonIzbaci);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        jLabelSada = new javax.swing.JLabel();
        jLabelPrvi = new javax.swing.JLabel();
        jLabelPoslednji = new javax.swing.JLabel();
        jLabelTimeSada = new javax.swing.JLabel();
        jLabelTimePrvi = new javax.swing.JLabel();
        jLabelTimePoslednji = new javax.swing.JLabel();
        jLabelTimerPokrenut = new javax.swing.JLabel();
        jComboBoxKorisnici = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButtonIzbaci = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Pokreni server");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelStatus.setText("Server nije pokrenut !");

        jLabelSada.setText("Sada je :");

        jLabelPrvi.setText("Prvi klijent se povezao");

        jLabelPoslednji.setText("Poslednji klijent se povezao");

        jLabel1.setText("Trenutni korisnici");

        jButtonIzbaci.setText("Izbaci");
        jButtonIzbaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzbaciActionPerformed(evt);
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
                        .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTimerPokrenut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSada)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTimeSada, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPrvi)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTimePrvi, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPoslednji)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTimePoslednji, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxKorisnici, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonIzbaci)))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelStatus)
                    .addComponent(jLabelTimerPokrenut, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSada)
                    .addComponent(jLabelTimeSada, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPrvi)
                    .addComponent(jLabelTimePrvi, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPoslednji)
                    .addComponent(jLabelTimePoslednji, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxKorisnici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIzbaci))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ServerListenhread.getServer().start();
        jLabelStatus.setText("Server je pokrenut u :");
        jLabelTimerPokrenut.setText(hhmm.format(Calendar.getInstance().getTime()));
        ServerListenhread.getServer().getServerSesija().put("pokrenut", hhmm.format(Calendar.getInstance().getTime()));
        setTimer();
        jLabelSada.setVisible(true);
        jButton1.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonIzbaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzbaciActionPerformed
       
       ClientHandler clientHandler= (ClientHandler)jComboBoxKorisnici.getSelectedItem();
        
        ServerListenhread.getServer().getKlijenti().remove(clientHandler);
            
            if (ServerListenhread.getServer().getServerSesija().get(clientHandler.getName())!=null) {
                int broj = (int) ServerListenhread.getServer().getServerSesija().get(clientHandler.getName());
                
                if (broj>0) {
                    ServerListenhread.getServer().getServerSesija().put(clientHandler.getName(), --broj);
                }
                
                
            }
            ((JComboBox) ServerListenhread.getServer().getServerSesija().get("combo")).setModel(
                          new DefaultComboBoxModel(  ServerListenhread.getServer().getKlijenti().toArray()));
        try {
            clientHandler.getSocket().close();
            clientHandler.interrupt();
        } catch (IOException ex) {
            Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }//GEN-LAST:event_jButtonIzbaciActionPerformed

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
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerForm().setVisible(true);
            }
        });
    }
   
    public void  setTimer(){
        
        Timer t = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                jLabelTimeSada.setText(hhmmss.format(Calendar.getInstance().getTime()));
            }
        });
        t.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonIzbaci;
    private javax.swing.JComboBox jComboBoxKorisnici;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPoslednji;
    private javax.swing.JLabel jLabelPrvi;
    private javax.swing.JLabel jLabelSada;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTimePoslednji;
    private javax.swing.JLabel jLabelTimePrvi;
    private javax.swing.JLabel jLabelTimeSada;
    private javax.swing.JLabel jLabelTimerPokrenut;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
