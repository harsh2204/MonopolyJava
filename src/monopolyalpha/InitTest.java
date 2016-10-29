/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author Harsh
 */
public class InitTest extends javax.swing.JFrame {

    //Creates new form InitTest
    public InitTest() {
        initComponents();
        numPlayers();
    }
    int Players;
    Canada_Data Can = new Canada_Data();
    String piece1 = "Mic";
    String piece2 = "Cart";
    String piece3 = "Shoe";
    String piece4 = "Hat";
    String piece5 = Can.p1;
    String piece6 = Can.p2;
    String piece7 = Can.p3;
    String piece8 = Can.p4;
    ImageIcon i1 = new ImageIcon("Icons/Pieces/Generic/1.png");
    ImageIcon i2 = new ImageIcon("Icons/Pieces/Generic/2.png");
    ImageIcon i3 = new ImageIcon("Icons/Pieces/Generic/3.png");
    ImageIcon i4 = new ImageIcon("Icons/Pieces/Generic/4.png");
    ImageIcon i5 = Can.i1;
    ImageIcon i6 = Can.i2;
    ImageIcon i7 = Can.i3;
    ImageIcon i8 = Can.i4;
    ImageIcon[] list = {i1, i2, i3, i4, i5, i6, i7, i8};
    
    public void numPlayers(){
        sldPlayer.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            Players = sldPlayer.getValue();
            lblOut.setText("The number of players : " 
            + Players);
         }
      });
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComList1 = new javax.swing.JComboBox();
        lblOut = new javax.swing.JLabel();
        sldPlayer = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ComList1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        ComList1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComList1ActionPerformed(evt);
            }
        });

        lblOut.setText("jLabel1");

        sldPlayer.setMajorTickSpacing(2);
        sldPlayer.setMaximum(4);
        sldPlayer.setMinimum(2);
        sldPlayer.setMinorTickSpacing(1);
        sldPlayer.setPaintLabels(true);
        sldPlayer.setPaintTicks(true);
        sldPlayer.setSnapToTicks(true);
        sldPlayer.setValue(2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblOut)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(ComList1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(sldPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(sldPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(ComList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(lblOut)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComList1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComList1ActionPerformed
        int i = ComList1.getSelectedIndex();
        lblOut.setIcon(list[i]);
    }//GEN-LAST:event_ComList1ActionPerformed

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
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InitTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComList1;
    private javax.swing.JLabel lblOut;
    private javax.swing.JSlider sldPlayer;
    // End of variables declaration//GEN-END:variables
}
