/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Haard Trivedi
 */
public class Help extends javax.swing.JFrame {
    //Initialize dialog box and label
    JDialog help = new JDialog();
    JLabel manual = new JLabel();
    ImageIcon ic;
    /**
     * Creates new form Help
     */
    public Help() {
        initComponents();
//        help.setUndecorated(true);
        this.setLocationRelativeTo(null);
    }

    public void Centre() {
        //Get screen size 
//        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        //Set dialog box at centre by finding distance between the edge of screen and box and dividing by 2
//        help.setLocation((int) ((dimension.getWidth() - help.getWidth()) / 2), (int) ((dimension.getHeight() - help.getHeight()) / 2));
        help.setLocationRelativeTo(null);
        help.setSize(ic.getIconWidth(), ic.getIconHeight());
//        int x = (int) ((dimension.getWidth() - help.getWidth()) / 2);
//        int y = (int) ((dimension.getHeight() - help.getHeight()) / 2);
//        help.setLocation(x, y);
    }

    public void createDialog() {
        help.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        help.setLayout(new BorderLayout());//Set Border Layout
        help.add(manual, BorderLayout.CENTER);//Add and centre label
        help.setSize(ic.getIconWidth(), ic.getIconHeight());//Set dialog box
        help.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //If escape key is pressed, close help dialog box
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    help.setVisible(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
//        help.pack();
    }

    public ImageIcon imageSet(String path) {
        ic = new ImageIcon(path);//Get image path
//        Image img =ic.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//        ig = new ImageIcon(img);
        return ic;//Return image
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnObject = new javax.swing.JButton();
        btnPrep = new javax.swing.JButton();
        btnBank = new javax.swing.JButton();
        btnGo = new javax.swing.JButton();
        btnRent = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnBuyProp = new javax.swing.JButton();
        btnChaComm = new javax.swing.JButton();
        btnTax = new javax.swing.JButton();
        btnSaveGame = new javax.swing.JButton();
        btnCar = new javax.swing.JButton();
        btnJail = new javax.swing.JButton();
        btnHouse = new javax.swing.JButton();
        btnTrading = new javax.swing.JButton();
        btnMortgage = new javax.swing.JButton();
        btnEGS = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lblTitle.setFont(new java.awt.Font("Showcard Gothic", 1, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Help");
        lblTitle.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        btnObject.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnObject.setText("Object");
        btnObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObjectActionPerformed(evt);
            }
        });

        btnPrep.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnPrep.setText("Preparation");
        btnPrep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrepActionPerformed(evt);
            }
        });

        btnBank.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnBank.setText("The Bank");
        btnBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBankActionPerformed(evt);
            }
        });

        btnGo.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnGo.setText("Go");
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });

        btnRent.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnRent.setText("Paying Rent");
        btnRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentActionPerformed(evt);
            }
        });

        btnPlay.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnBuyProp.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnBuyProp.setText("Buying Property");
        btnBuyProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyPropActionPerformed(evt);
            }
        });

        btnChaComm.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnChaComm.setText("Chance and Community Chest");
        btnChaComm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChaCommActionPerformed(evt);
            }
        });

        btnTax.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnTax.setText("Tax");
        btnTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaxActionPerformed(evt);
            }
        });

        btnSaveGame.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnSaveGame.setText("Save Game");
        btnSaveGame.setToolTipText("");
        btnSaveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveGameActionPerformed(evt);
            }
        });

        btnCar.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnCar.setText("Car insurance");
        btnCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarActionPerformed(evt);
            }
        });

        btnJail.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnJail.setText("Jail");
        btnJail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJailActionPerformed(evt);
            }
        });

        btnHouse.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnHouse.setText("House & Hotel");
        btnHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHouseActionPerformed(evt);
            }
        });

        btnTrading.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnTrading.setText("Trading");
        btnTrading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTradingActionPerformed(evt);
            }
        });

        btnMortgage.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnMortgage.setText("Mortgage");
        btnMortgage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMortgageActionPerformed(evt);
            }
        });

        btnEGS.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnEGS.setText("End Game Scenario");
        btnEGS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEGSActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnObject, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTax, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrep, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBank, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnJail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTrading, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRent, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMortgage, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuyProp, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEGS, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnChaComm)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveGame, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(208, 208, 208))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnObject)
                    .addComponent(btnTax))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrep)
                    .addComponent(btnCar))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBank)
                    .addComponent(btnJail))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHouse)
                    .addComponent(btnPlay))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrading)
                    .addComponent(btnGo))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMortgage)
                    .addComponent(btnRent))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuyProp)
                    .addComponent(btnEGS))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChaComm)
                    .addComponent(btnSaveGame))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObjectActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/Object.png"));//Set label to corresponding image
        createDialog();//Create dialog box 
        Centre();//Centre dialog box
        help.setVisible(true);//Display dialog box
    }//GEN-LAST:event_btnObjectActionPerformed

    private void btnBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBankActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/Bank.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnBankActionPerformed

    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/Go.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnGoActionPerformed

    private void btnRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/RENT.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnRentActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/Play.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnBuyPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyPropActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/Buy.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnBuyPropActionPerformed

    private void btnChaCommActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChaCommActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/Chance Community.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnChaCommActionPerformed

    private void btnTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaxActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/Tax.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnTaxActionPerformed

    private void btnSaveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveGameActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/SAVEGAME.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnSaveGameActionPerformed

    private void btnCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/Car.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnCarActionPerformed

    private void btnJailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJailActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/JAIL.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnJailActionPerformed

    private void btnHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHouseActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/HOUSES.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnHouseActionPerformed

    private void btnTradingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTradingActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/TRADING.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnTradingActionPerformed

    private void btnMortgageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMortgageActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/MORTGAGE.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnMortgageActionPerformed

    private void btnEGSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEGSActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/EGS.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnEGSActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //Close Help screen
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPrepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrepActionPerformed
        manual.setIcon(imageSet("Icons/Help Manual/Preparation.png"));
        createDialog();
        Centre();
        help.setVisible(true);
    }//GEN-LAST:event_btnPrepActionPerformed

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
            java.util.logging.Logger.getLogger(Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Help().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBank;
    private javax.swing.JButton btnBuyProp;
    private javax.swing.JButton btnCar;
    private javax.swing.JButton btnChaComm;
    private javax.swing.JButton btnEGS;
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnHouse;
    private javax.swing.JButton btnJail;
    private javax.swing.JButton btnMortgage;
    private javax.swing.JButton btnObject;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnPrep;
    private javax.swing.JButton btnRent;
    private javax.swing.JButton btnSaveGame;
    private javax.swing.JButton btnTax;
    private javax.swing.JButton btnTrading;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
