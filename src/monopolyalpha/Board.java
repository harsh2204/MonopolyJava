/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 *
 * @author Harsh Gupta
 */
public class Board extends javax.swing.JFrame {

    /**
     * Creates new form Board
     */
    int playerCount, startCash, di, EGS, snakeAmt, jailFee, roll;

    String theme;
    //for object array
    String player;//name
    int playerID; //player id
    int cash;//money
    int propCount;//number of properties
    //
    Properties_Data properties = new Properties_Data(theme);
    ImageIcon piece;
    Board[] board;
    String[][] pl;
    boolean snake=false, bail=false;

    public Board(String[][] players, int pCount, int iniCash, int diCount, int EGS, boolean snk, int snkAmt, boolean jail, int jailFee, String theme) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.theme = theme;
        this.playerCount = pCount;
        this.startCash = iniCash;
        this.di = diCount;
        this.EGS = EGS;
        if (snk) {
            this.snake = true;
            this.snakeAmt = snkAmt;
        }
        if (jail) {
            this.bail = true;
            this.jailFee = jailFee;
        }
        this.pl = new String[players.length][];
        for (int i = 0; i < players.length; i++) {
            pl[i] = players[i].clone();
        }
        board = new Board[pCount];
    }

    public void addPlayers() {
        for (int i = 0; i < board.length; i++) {
            board[i] = new Board(pl, playerCount, startCash, di, EGS, snake, snakeAmt, bail, jailFee, theme);
        }
        for (int i = 0; i <playerCount; i++) {
            
                board[i].player = pl[i][0];
                board[i].piece = new ImageIcon(pl[i][1]);
            
        }
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

        lblBoard = new javax.swing.JLabel(new ImageIcon("Board/New Board.png"));
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 768));

        lblBoard.setIcon(new ImageIcon("Board Images/Canada/New Board.png"));
        lblBoard.setPreferredSize(new java.awt.Dimension(700, 700));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(lblBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jButton1)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(lblBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        lblBoard.setHorizontalAlignment(SwingConstants.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addPlayers();
        System.out.println(board.length);
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i].player + "   ");
            System.out.print(board[i].piece);
        }
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblBoard;
    // End of variables declaration//GEN-END:variables
}
