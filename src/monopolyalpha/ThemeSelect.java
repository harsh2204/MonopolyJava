/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Harsh
 */
public class ThemeSelect extends javax.swing.JFrame {

    public static String theme, dicePath, piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8;
    public static ImageIcon i1, i2, i3, i4, i5, i6, i7, i8;

    /**
     * Creates new form ThemeSelect
     */
    public ThemeSelect() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.red);
//        this.setExtendedState(MAXIMIZED_BOTH);
        btnCanada.setMultiClickThreshhold(2000);
        btnSuper.setMultiClickThreshhold(2000);
        btnGeneric.setMultiClickThreshhold(2000);
    }

    public void goNext() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InitTest().setVisible(true);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnCanada = new javax.swing.JButton();
        btnSuper = new javax.swing.JButton();
        btnGeneric = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        btnCanada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monopolyalpha/themeCanadanpr.png"))); // NOI18N
        btnCanada.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/monopolyalpha/themeCanada.png"))); // NOI18N
        btnCanada.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCanadaActionPerformed(evt);
            }
        });

        btnSuper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monopolyalpha/themeSupernpr.png"))); // NOI18N
        btnSuper.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/monopolyalpha/themeSuper.png"))); // NOI18N
        btnSuper.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSuperActionPerformed(evt);
            }
        });

        btnGeneric.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monopolyalpha/themeGenericnpr.png"))); // NOI18N
        btnGeneric.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/monopolyalpha/themeGeneric.png"))); // NOI18N
        btnGeneric.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGenericActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("PLEASE SELECT A THEME");

        back.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSuper, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCanada, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGeneric, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 97, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCanada, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGeneric, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(back)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanadaActionPerformed
        // TODO add your handling code here:
        canth();
        new StartScreenfrm().setVisible(false);
        this.setVisible(false);
        new InitTest().setVisible(true);
//        goNext();
    }//GEN-LAST:event_btnCanadaActionPerformed

    private void btnSuperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuperActionPerformed
        // TODO add your handling code here:
        supth();
        new StartScreenfrm().setVisible(false);
        this.setVisible(false);
        new InitTest().setVisible(true);
//        goNext();
    }//GEN-LAST:event_btnSuperActionPerformed

    private void btnGenericActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenericActionPerformed
        // TODO add your handling code here:
        genth();
        new StartScreenfrm().setVisible(false);
        this.setVisible(false);
        new InitTest().setVisible(true);
    }//GEN-LAST:event_btnGenericActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_backActionPerformed
    {//GEN-HEADEREND:event_backActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartScreenfrm().setVisible(true);
            }
        });
    }//GEN-LAST:event_backActionPerformed

    public void supth() {
        theme = "SuperHeros";
        SuperHero_Data sup = new SuperHero_Data();
        piece1 = "Dog";
        piece2 = "Ship";
        piece3 = "Iron";
        piece4 = "Buggy";
        piece5 = sup.p1;
        piece6 = sup.p2;
        piece7 = sup.p3;
        piece8 = sup.p4;
        i1 = new ImageIcon("Icons/Pieces/Generic/5.png");
        i2 = new ImageIcon("Icons/Pieces/Generic/6.png");
        i3 = new ImageIcon("Icons/Pieces/Generic/7.png");
        i4 = new ImageIcon("Icons/Pieces/Generic/8.png");
        i5 = sup.i1;
        i6 = sup.i2;
        i7 = sup.i3;
        i8 = sup.i4;
    }

    public void genth() {
        theme = "Generic";
        piece1 = "Mic";
        piece2 = "Carty";
        piece3 = "Shoe";
        piece4 = "Hat";
        piece5 = "Dog";
        piece6 = "Ship";
        piece7 = "Iron";
        piece8 = "Buggy";
        i1 = new ImageIcon("Icons/Pieces/Generic/1.png");
        i2 = new ImageIcon("Icons/Pieces/Generic/2.png");
        i3 = new ImageIcon("Icons/Pieces/Generic/3.png");
        i4 = new ImageIcon("Icons/Pieces/Generic/4.png");
        i5 = new ImageIcon("Icons/Pieces/Generic/5.png");
        i6 = new ImageIcon("Icons/Pieces/Generic/6.png");
        i7 = new ImageIcon("Icons/Pieces/Generic/7.png");
        i8 = new ImageIcon("Icons/Pieces/Generic/8.png");
    }

    public void canth() {
        theme = "Canada";
        Canada_Data can = new Canada_Data();
        piece1 = "Mic";
        piece2 = "Carty";
        piece3 = "Shoe";
        piece4 = "Hat";
        piece5 = can.p1;
        piece6 = can.p2;
        piece7 = can.p3;
        piece8 = can.p4;
        i1 = new ImageIcon("Icons/Pieces/Generic/1.png");
        i2 = new ImageIcon("Icons/Pieces/Generic/2.png");
        i3 = new ImageIcon("Icons/Pieces/Generic/3.png");
        i4 = new ImageIcon("Icons/Pieces/Generic/4.png");
        i5 = can.i1;
        i6 = can.i2;
        i7 = can.i3;
        i8 = can.i4;
    }

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
            java.util.logging.Logger.getLogger(ThemeSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemeSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemeSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemeSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartScreenfrm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnCanada;
    private javax.swing.JButton btnGeneric;
    private javax.swing.JButton btnSuper;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
