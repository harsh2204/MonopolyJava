/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author 714449
 */
public class Dice {
     public static void sleep(int amt) {
        long a = System.currentTimeMillis();
        long b = System.currentTimeMillis();
        while ((b - a) <= amt) {
            b = System.currentTimeMillis();
        }
    }
    public static int rollDice() {
        int roll=0;
        JDialog dice = new JDialog();
        JLabel di = new JLabel(new ImageIcon("Icons/Dice/Maple/Dice 1.png"));
        dice.add(di);
        dice.setSize(di.getWidth(),di.getHeight());
        dice.setUndecorated(true);
        dice.getRootPane().setOpaque(false);
        dice.getContentPane().setBackground(new Color (0, 0, 0, 0));
        dice.setBackground(new Color (0, 0, 0, 0));
        dice.pack();
        dice.setLocationRelativeTo(null);
        dice.setVisible(true);
        for (int i = 0; i < 9; i++) {
            di.setIcon(null);
            sleep(100);
            Random r = new Random();
            int randomNumber = r.nextInt(6) + 1;
            di.setIcon(new ImageIcon("Icons/Dice/Maple/Dice " + randomNumber + ".png"));
            di.repaint();
            roll = randomNumber;
            sleep(250);
        }
        return roll;
    }
}
