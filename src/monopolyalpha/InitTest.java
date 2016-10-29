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
public class InitTest extends javax.swing.JFrame
  {

    //Creates new form InitTest
    public InitTest()
      {
        initComponents();
        numPlayers();
        checker();
        this.setAlwaysOnTop(true);
        this.setExtendedState(MAXIMIZED_BOTH);
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
    ImageIcon[] list =
      {
        i1, i2, i3, i4, i5, i6, i7, i8
      };

    private void numPlayers()
      {
        sldPlayer.addChangeListener(new ChangeListener()
          {
            @Override
            public void stateChanged(ChangeEvent e)
              {
                Players = sldPlayer.getValue();
                  System.out.println(""+Players);
                checker();
              }
          });
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        sldPlayer = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        iconselp1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        namep1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        iconp1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namep2 = new javax.swing.JTextField();
        iconselp2 = new javax.swing.JComboBox();
        iconp2 = new javax.swing.JLabel();
        three = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namep3 = new javax.swing.JTextField();
        iconselp3 = new javax.swing.JComboBox();
        iconp3 = new javax.swing.JLabel();
        four = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        namep4 = new javax.swing.JTextField();
        iconselp4 = new javax.swing.JComboBox();
        iconp4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        sldPlayer.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        sldPlayer.setMajorTickSpacing(2);
        sldPlayer.setMaximum(4);
        sldPlayer.setMinimum(2);
        sldPlayer.setMinorTickSpacing(1);
        sldPlayer.setOrientation(javax.swing.JSlider.VERTICAL);
        sldPlayer.setPaintLabels(true);
        sldPlayer.setPaintTicks(true);
        sldPlayer.setSnapToTicks(true);
        sldPlayer.setValue(2);
        sldPlayer.setInverted(true);

        iconselp1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        iconselp1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        iconselp1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                iconselp1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel1.setText("PLayer 1:");

        namep1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Icon:");

        iconp1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        iconp1.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Icon:");

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel4.setText("PLayer 2:");

        namep2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N

        iconselp2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        iconselp2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        iconselp2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                iconselp2ActionPerformed(evt);
            }
        });

        iconp2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        iconp2.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namep1)
                    .addComponent(iconselp1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconp1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namep2)
                    .addComponent(iconselp2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconp2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(namep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iconselp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(iconp1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(namep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iconselp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(iconp2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Icon:");

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel6.setText("PLayer 3:");

        namep3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N

        iconselp3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        iconselp3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        iconselp3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                iconselp3ActionPerformed(evt);
            }
        });

        iconp3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        iconp3.setEnabled(false);

        javax.swing.GroupLayout threeLayout = new javax.swing.GroupLayout(three);
        three.setLayout(threeLayout);
        threeLayout.setHorizontalGroup(
            threeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, threeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(threeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(threeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namep3)
                    .addComponent(iconselp3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconp3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        threeLayout.setVerticalGroup(
            threeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, threeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(threeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconp3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(threeLayout.createSequentialGroup()
                        .addGroup(threeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(namep3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(threeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iconselp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel7.setText("Icon:");

        jLabel8.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel8.setText("PLayer 4:");

        namep4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N

        iconselp4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        iconselp4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        iconselp4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                iconselp4ActionPerformed(evt);
            }
        });

        iconp4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        iconp4.setEnabled(false);

        javax.swing.GroupLayout fourLayout = new javax.swing.GroupLayout(four);
        four.setLayout(fourLayout);
        fourLayout.setHorizontalGroup(
            fourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namep4)
                    .addComponent(iconselp4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconp4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        fourLayout.setVerticalGroup(
            fourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fourLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(fourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fourLayout.createSequentialGroup()
                        .addGroup(fourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(namep4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iconselp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(iconp4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Showcard Gothic", 1, 48)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("New Game");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sldPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(three, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(four, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sldPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iconselp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconselp1ActionPerformed
        int i = iconselp1.getSelectedIndex();
        iconp1.setDisabledIcon(list[i]);
    }//GEN-LAST:event_iconselp1ActionPerformed

    private void iconselp2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_iconselp2ActionPerformed
    {//GEN-HEADEREND:event_iconselp2ActionPerformed
        int i = iconselp2.getSelectedIndex();
        iconp2.setDisabledIcon(list[i]);
    }//GEN-LAST:event_iconselp2ActionPerformed

    private void iconselp3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_iconselp3ActionPerformed
    {//GEN-HEADEREND:event_iconselp3ActionPerformed
        int i = iconselp3.getSelectedIndex();
        iconp3.setDisabledIcon(list[i]);
    }//GEN-LAST:event_iconselp3ActionPerformed

    private void iconselp4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_iconselp4ActionPerformed
    {//GEN-HEADEREND:event_iconselp4ActionPerformed
        int i = iconselp4.getSelectedIndex();
        iconp4.setDisabledIcon(list[i]);
    }//GEN-LAST:event_iconselp4ActionPerformed

    public void checker()
      {
        Players = sldPlayer.getValue();
        if (Players == 2)
          {
            three.setVisible(false);
            four.setVisible(false);
          } else if (Players == 3)
          {
            three.setVisible(true);
            four.setVisible(false);
          } else if (Players == 4)
          {
            three.setVisible(true);
            four.setVisible(true);
          }
      }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
      {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
          {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
              {
                if ("Nimbus".equals(info.getName()))
                  {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                  }
              }
          } catch (ClassNotFoundException ex)
          {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
          {
            public void run()
              {
                new InitTest().setVisible(true);
              }
          });
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel four;
    private javax.swing.JLabel iconp1;
    private javax.swing.JLabel iconp2;
    private javax.swing.JLabel iconp3;
    private javax.swing.JLabel iconp4;
    private javax.swing.JComboBox iconselp1;
    private javax.swing.JComboBox iconselp2;
    private javax.swing.JComboBox iconselp3;
    private javax.swing.JComboBox iconselp4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField namep1;
    private javax.swing.JTextField namep2;
    private javax.swing.JTextField namep3;
    private javax.swing.JTextField namep4;
    private javax.swing.JSlider sldPlayer;
    private javax.swing.JPanel three;
    // End of variables declaration//GEN-END:variables
}
