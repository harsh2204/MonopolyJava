/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Harsh
 */
public class InitTest extends javax.swing.JFrame {

    /**
     * Creates new form InitTest
     */
    public InitTest() {
        initComponents();
    }
    Canada_Data Can = new Canada_Data();
    String piece1 = "Hat";
    String piece2 = "Dog";
    String piece3 = "Shoe";
    String piece4 = "Carty";
    String piece5 = Can.p1;
    String piece6 = Can.p2;
    String piece7 = Can.p3;
    String piece8 = Can.p4;
    ImageIcon i1 = Can.i1;
    ImageIcon i2 = Can.i2;
    ImageIcon i3 = Can.i3;
    ImageIcon i4 = Can.i4;
    ImageIcon i5 = Can.i5;
    ImageIcon i6 = Can.i6;
    ImageIcon i7 = Can.i7;
    ImageIcon i8 = Can.i8;
    ImageIcon [] list = {i1,i2,i3,i4,i5,i6,i7,i8};
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComList1 = new javax.swing.JComboBox();
        lblOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComList1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        ComList1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComList1ActionPerformed(evt);
            }
        });

        lblOut.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(ComList1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblOut)
                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(ComList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(lblOut)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComList1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComList1ActionPerformed
        // TODO add your handling code here:
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
    // End of variables declaration//GEN-END:variables
}
