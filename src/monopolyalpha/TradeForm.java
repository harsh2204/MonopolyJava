/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Harsh
 */
public class TradeForm extends javax.swing.JFrame {

    /**
     * Creates new form TradeForm
     */
    public JCheckBox[] checkboxes1, checkboxes2;
    Board board;
    JPanel[] others;
    ArrayList<Integer> from = new ArrayList();
    ArrayList<Integer> to = new ArrayList();
    public int tradeToInd;
    public int tradeTo = -1;

    public TradeForm(Board bd) {
        this.board = bd;
        initComponents();
        paneCur.setPreferredSize(new Dimension(paneCur.getWidth(), paneOthers.getHeight()));
        paneCur.setLayout(new BoxLayout(paneCur, BoxLayout.Y_AXIS));
        checkboxes1 = new JCheckBox[36];
        checkboxes2 = new JCheckBox[36];
        others = new JPanel[board.players];
        for (int i = 0; i < others.length; i++) {
            if (i != board.turn) {
                others[i] = new JPanel();
                others[i].setLayout(new BoxLayout(others[i], BoxLayout.Y_AXIS));
                others[i].setBorder(new LineBorder(board.colorPalette[i], 3));
                others[i].setBackground(board.colorPalette[i].brighter());
                others[i].setSize(paneOthers.getSize());
                for (int j = 0; j < board.propName.length; j++) {
                    if (board.propOwner[j] == i) {
                        this.checkboxes2[j] = new JCheckBox(board.propName[j]);
                        this.checkboxes2[j].setFont(new Font("Showcard Gothic", 0, 18));
                        this.checkboxes2[j].setOpaque(true);
                        this.checkboxes2[j].setBackground(lessSat(board.pd.prop[j].colour));
                        others[i].add(checkboxes2[j]);
                    }
                    paneOthers.addTab(board.name[i], others[i]);
                    paneCur.validate();
                    paneCur.repaint();
                }
            }

        }
        for (int i = 0; i < board.propName.length; i++) {
            if (board.propOwner[i] == board.turn) {
                System.out.println(board.propName[i] + " added");
                this.checkboxes1[i] = new JCheckBox(board.propName[i]);
                this.checkboxes1[i].setFont(new Font("Showcard Gothic", 0, 18));
                this.checkboxes1[i].setOpaque(true);
                this.checkboxes1[i].setBackground(lessSat(board.pd.prop[i].colour));
                paneCur.add(checkboxes1[i]);
                paneCur.validate();
                paneCur.repaint();
            }
        }
    }

    public java.awt.Color lessSat(java.awt.Color c) {

        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        int a = c.getAlpha();
        double opacity = a / 255.0;
        javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(r, g, b, opacity);
        fxColor = fxColor.desaturate();
        java.awt.Color endFinal = new java.awt.Color((float) fxColor.getRed(),
                (float) fxColor.getGreen(),
                (float) fxColor.getBlue(),
                (float) fxColor.getOpacity());
        return endFinal;
    }

    public void tradeLog() {
// FROM ------------------------------------------------------------------------        
        board.appendS(board.name[board.turn], board.turn);
        board.appendS(" traded ", 4);
        if (from.size() == 1 && chkMon1.isSelected() == true) {
            for (int i = 0; i < from.size(); i++) {
//                board.appendS(checkboxes1[i].getText(), board.turn);
                board.ProptertyText(from.get(i));
            }
            board.appendS(" and $", 4);
            board.appendS(txtMon1.getText(), board.turn);
        } else if (from.size() > 1 && chkMon1.isSelected() == true) {
            for (int x = 0; x < from.size(); x++) {
                if (x == from.size()) {
                    board.ProptertyText(from.get(x));
                } else {
                    board.ProptertyText(from.get(x));
                    board.appendS(" and ", 4);
                }
            }
            board.appendS(" and $", board.turn);
            board.appendS(txtMon1.getText(), board.turn);

        } else if (from.size() == 1) {
            for (int i = 0; i < from.size(); i++) {
//                    board.appendS(checkboxes1[from.get(i)].getText(), board.turn);
                board.ProptertyText(from.get(i));
            }
        } else if (chkMon1.isSelected() == true) {
            board.appendS("$", 4);
            board.appendS(txtMon1.getText(), board.turn);
        } else if (from.size() > 1) {
            for (int x = 0; x < from.size(); x++) {
                if (x == from.size() - 1) {
                    board.ProptertyText(from.get(x));
                } else {
                    board.ProptertyText(from.get(x));
                    board.appendS(" ", 4);
                }
            }
        }
// TO ------------------------------------------------------------------------
        board.appendS(" to ", 4);
        //Why do you even need this? -->
//        for (int i = 0; i < others.length; i++) {
//            if (paneOthers.getTitleAt(tradeToInd).equals(board.name[i])) {
//                board.appendS(board.name[i], tradeTo);
//            }
//        }
        board.appendS(board.name[tradeTo], tradeTo);
        board.appendS(" for ", 4);
        if (to.size() == 1 && chkMon2.isSelected() == true) {
            for (int i = 0; i < to.size(); i++) {
//                    board.appendS(checkboxes2[i].getText(), tradeTo);   
                board.ProptertyText(to.get(i));
            }
            board.appendS(" and $", 4);
            board.appendS(txtMon2.getText(), tradeTo);
        } else if (to.size() == 1) {
            for (int i = 0; i < to.size(); i++) {
//                    board.appendS(checkboxes2[i].getText(), tradeTo);
                board.ProptertyText(to.get(i));
            }
        } else if (to.size() > 1 && chkMon2.isSelected() == true) {
            for (int x = 0; x < to.size(); x++) {
                if (x == to.size()) {
                    board.ProptertyText(to.get(x));
                } else {
//                    board.appendS(checkboxes2[x].getText(), tradeTo);
                    board.ProptertyText(to.get(x));
                    board.appendS(" and ", 4);
                }
            }
            board.appendS("$", tradeTo);
            board.appendS(txtMon2.getText(), tradeTo);
        } else if (chkMon2.isSelected() == true) {
            board.appendS("$", tradeTo);
            board.appendS(txtMon2.getText(), tradeTo);
        } else if (to.size() > 1) {
            for (int x = 0; x < to.size(); x++) {
                if (x == to.size()) {
                    board.ProptertyText(to.get(x));
                } else {
                    board.ProptertyText(to.get(x));
                    board.appendS(" and ", 4);
                }

            }
        }
        board.addLog(" ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        paneCur = new javax.swing.JPanel();
        paneOthers = new javax.swing.JTabbedPane();
        btnTrd = new javax.swing.JButton();
        chkMon1 = new javax.swing.JCheckBox();
        chkMon2 = new javax.swing.JCheckBox();
        txtMon1 = new javax.swing.JTextField();
        txtMon2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Monopoly Trade Terminal");

        paneCur.setBorder(javax.swing.BorderFactory.createLineBorder(board.colorPalette[board.turn], 3));

        javax.swing.GroupLayout paneCurLayout = new javax.swing.GroupLayout(paneCur);
        paneCur.setLayout(paneCurLayout);
        paneCurLayout.setHorizontalGroup(
            paneCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        paneCurLayout.setVerticalGroup(
            paneCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnTrd.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnTrd.setText("TRADE");
        btnTrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrdActionPerformed(evt);
            }
        });

        chkMon1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        chkMon1.setText("Money");
        chkMon1.setOpaque(false);
        chkMon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMon1ActionPerformed(evt);
            }
        });

        chkMon2.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        chkMon2.setText("Money");
        chkMon2.setOpaque(false);
        chkMon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMon2ActionPerformed(evt);
            }
        });

        txtMon1.setEnabled(false);

        txtMon2.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkMon1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMon1))
                    .addComponent(paneCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTrd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneOthers, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkMon2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paneCur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paneOthers, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chkMon1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtMon1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chkMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTrd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public String constructString() {
    //        String trades = "";
    //        String fromTr = board.name[board.turn] + " traded ";
    //        int wordCounter = 0;
    //        if (!from.isEmpty()) {
    //            for (Integer from1 : from) {
    //                if (from.size() > 1) {
    //                    if (wordCounter >= 1) {
    //                        fromTr = fromTr.concat(checkboxes1[from1].getText() + " and ");
    //                    } else {
    //                        fromTr = fromTr.concat(checkboxes1[from1].getText() + ", ");
    //                    }
    //                    wordCounter++;
    //                } else {
    //                    fromTr = fromTr.concat(checkboxes1[from1].getText() + " ");
    //                }
    //            }
    //        }
    //        if (chkMon1.isSelected()) {
    //            fromTr = fromTr.concat("$" + txtMon1.getText() + " ");
    //        }
    //        System.out.println(fromTr);
    //        String toTr = "for " + board.name[tradeTo] + "'s ";
    //        wordCounter = 0;
    //        if (!to.isEmpty()) {
    //            for (Integer to1 : to) {
    //                if (to.size() > 1) {
    //                    if (wordCounter >= 1) {
    //                        toTr = toTr.concat(checkboxes2[to1].getText() + " and ");
    //                    } else {
    //                        toTr = toTr.concat(checkboxes2[to1].getText() + ", ");
    //                    }
    //                    wordCounter++;
    //                }
    //                else{
    //                    toTr = toTr.concat(checkboxes2[to1].getText() + " ");
    //                }
    //            }
    //        }
    //        if (chkMon2.isSelected()) {
    //            toTr = toTr.concat("$" + txtMon2.getText() + " ");
    //        }
    //        System.out.println(toTr);
    //        trades = fromTr.concat(toTr);
    //        return trades;
    //    }

    private void btnTrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrdActionPerformed
        // TODO add your handling code here:
        int tradeFrom = board.turn;
        tradeToInd = paneOthers.getSelectedIndex();
        for (int i = 0; i < others.length; i++) {
            if (paneOthers.getTitleAt(tradeToInd).equals(board.name[i])) {
                System.out.println("other player found");
                tradeTo = i;
            }
        }
        for (int i = 0; i < checkboxes1.length; i++) {
            if (checkboxes1[i] != null) {
                System.out.println("From prop: " + checkboxes1[i].getText());
                if (checkboxes1[i].isSelected()) {
                    from.add(i);
                }
            }
        }
        for (int i = 0; i < checkboxes2.length; i++) {
            if (checkboxes2[i] != null) {
                System.out.println("To prop: " + checkboxes2[i].getText());
                if (checkboxes2[i].isSelected()) {
                    to.add(i);
                }
            }
        }
        tradeLog();
        if (from.isEmpty() && txtMon1.getText().isEmpty() == true) {
            JOptionPane.showConfirmDialog(null, "Caution! You are trading to/for no property or money");
        } else {
            for (int i = 0; i < from.size(); i++) {
                System.out.println("from: " + from.get(i));
                board.propOwner[from.get(i)] = tradeTo;
                board.updateColors(tradeTo, from.get(i));
            }
        }
        if (to.isEmpty() && txtMon2.getText().isEmpty() == true) {
            JOptionPane.showConfirmDialog(null, "Caution! You are trading to/for no property or money");
        } else {
            for (int i = 0; i < to.size(); i++) {
                System.out.println("to: " + to.get(i));
                board.propOwner[to.get(i)] = tradeFrom;
                board.updateColors(tradeFrom, to.get(i));
            }
        }
        if (chkMon1.isSelected()) {
            System.out.println("Money!");
            try {
                board.money[tradeFrom] -= Integer.parseInt(txtMon1.getText());
                board.money[tradeTo] += Integer.parseInt(txtMon1.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter the correct amount of money");
                txtMon1.setText("");
            }
        }
        if (chkMon2.isSelected()) {
            System.out.println("Money!2");
            try {
                board.money[tradeTo] -= Integer.parseInt(txtMon2.getText());
                board.money[tradeFrom] += Integer.parseInt(txtMon2.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter the correct amount of money");
                txtMon2.setText("");
            }
        }
        if (chkMon2.isSelected()) {
            board.displayChangePay(tradeTo, tradeFrom, Integer.parseInt(txtMon2.getText()));
        }
        if (chkMon1.isSelected()) {
            board.displayChangePay(tradeFrom, tradeTo, Integer.parseInt(txtMon1.getText()));
        }
        board.checkPlayerMoney(board.turn);
//        board.addLog(constructString());
        this.dispose();
    }//GEN-LAST:event_btnTrdActionPerformed

    private void chkMon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMon1ActionPerformed
        // TODO add your handling code here:        
        if (chkMon1.isSelected()) {
            txtMon1.setEnabled(true);
        } else {
            txtMon1.setEnabled(false);
        }
    }//GEN-LAST:event_chkMon1ActionPerformed

    private void chkMon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMon2ActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < others.length; i++) {
            if (paneOthers.getTitleAt(tradeToInd).equals(board.name[i])) {
                System.out.println("other player found");
                tradeTo = i;
            }
        }
        if (chkMon2.isSelected()) {
            txtMon2.setEnabled(true);
        } else {
            txtMon2.setEnabled(false);
        }
    }//GEN-LAST:event_chkMon2ActionPerformed

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
            java.util.logging.Logger.getLogger(TradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TradeForm().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTrd;
    private javax.swing.JCheckBox chkMon1;
    private javax.swing.JCheckBox chkMon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel paneCur;
    private javax.swing.JTabbedPane paneOthers;
    private javax.swing.JTextField txtMon1;
    private javax.swing.JTextField txtMon2;
    // End of variables declaration//GEN-END:variables
}
