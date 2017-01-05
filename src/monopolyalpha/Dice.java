/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author 714449
 */
public class Dice {

    public static int randomNumber1, randomNumber2;

    public static void sleep(int amt) {
        long a = System.currentTimeMillis();
        long b = System.currentTimeMillis();
        while ((b - a) <= amt) {
            b = System.currentTimeMillis();
        }
    }
//REDUNDANT CUZ DOESNT WORK, MAYBE FIX LATER \/
//    private static void blinkingDie(JDialog j) {
//        for (int i = 0; i < 10; i++) {
//            j.setVisible(false);
//            sleep(200);
//            j.setVisible(true);
//        }
//        j.setVisible(false);
//    }

    public static int rollDice(int num) {
        int roll = 0;
        String path = null;
        String theme = InitTest.theme;
        switch (theme) {
            case "Generic":
                path = "Icons/Dice/Generic/Dice ";
                break;
            case "Canada":
                path = "Icons/Dice/Maple/Dice ";
                break;
            case "Super":
                path = "Icons/Dice/Superhero/Dice ";
                break;
        }
        if (num == 1) {
            final JDialog dice = new JDialog();
            dice.setAlwaysOnTop(true);
            JLabel di = new JLabel(new ImageIcon(path + "1.png"));
            dice.add(di);
            dice.setSize(di.getWidth(), di.getHeight());
            dice.setUndecorated(true);
            dice.getRootPane().setOpaque(false);
            dice.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dice.setBackground(new Color(0, 0, 0, 0));
            dice.pack();
            dice.setLocationRelativeTo(null);
            dice.setVisible(true);
            for (int i = 0; i < 15; i++) {
                dice.setVisible(false);
//                sleep(100);
                Random r = new Random();
                int randomNumber = r.nextInt(6) + 1;
                di.setIcon(new ImageIcon(path + randomNumber + ".png"));
                dice.setVisible(true);
                di.repaint();
                if (i == 14) {
                    roll = randomNumber;
                }
                sleep(250);
            }
//            blinkingDie(dice);
            di.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    dice.setVisible(false);
                }
            });
            sleep(3000);
            dice.setVisible(false);
        }
        if (num == 2) {
            final JDialog dice = new JDialog();
            dice.setAlwaysOnTop(true);
            JLabel di1 = new JLabel(new ImageIcon(path + "1.png"));
            JLabel di2 = new JLabel(new ImageIcon(path + "1.png"));
            dice.setLayout(new GridLayout(1, 2));
            dice.add(di1);
            dice.add(di2);
            dice.setSize(di1.getWidth() + di2.getWidth(), di1.getHeight() + di2.getHeight());
            dice.setUndecorated(true);
            dice.getRootPane().setOpaque(false);
            dice.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dice.setBackground(new Color(0, 0, 0, 0));
//        dice.setGlassPane(di);
            dice.pack();
            dice.setLocationRelativeTo(null);

            dice.setVisible(true);
            for (int i = 0; i < 15; i++) {
                dice.setEnabled(false);
                dice.setVisible(false);
                Random r1 = new Random();
                Random r2 = new Random();
                randomNumber1 = r1.nextInt(6) + 1;
                randomNumber2 = r2.nextInt(6) + 1;
                di1.setIcon(new ImageIcon(path + randomNumber1 + ".png"));
                di2.setIcon(new ImageIcon(path + randomNumber2 + ".png"));
                dice.setVisible(true);
                di1.repaint();
                di2.repaint();
                if (i == 14) {
                    roll = randomNumber1 + randomNumber2;
                }
                sleep(250);
            }
//            blinkingDie(dice);            
            di1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dice.setVisible(false);
                }
            });
            di2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dice.setVisible(false);
                }
            });
            sleep(1500);
            dice.setVisible(false);
        }

        return roll;
    }

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
                new StartScreenfrm().setVisible(true);
            }
        });
    }
}
