/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Harsh
 */
public class Splash_Screen {

    public static void makeSplash() {
        JDialog d1 = new JDialog();
        JLabel splash1 = new JLabel(new ImageIcon("Karsheel Labs.png"));
        d1.add(splash1);
        d1.setSize(splash1.getWidth(), splash1.getHeight());
        d1.setUndecorated(true);
        d1.getRootPane().setOpaque(false);
        d1.getContentPane().setBackground(new Color (0, 0, 0, 0));
        d1.setBackground(new Color (0, 0, 0, 0));
        d1.pack();
        d1.setLocationRelativeTo(null);
        d1.setVisible(true);
                
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d1.setVisible(false);
        
        JDialog d = new JDialog();
        JLabel splash = new JLabel(new ImageIcon("Splash-Gif.gif"));
        d.add(splash);
        d.setSize(splash.getWidth(), splash.getHeight());
        d.setUndecorated(true);
        d.getRootPane().setOpaque(false);
        d.getContentPane().setBackground(new Color (0, 0, 0, 0));
        d.setBackground(new Color (0, 0, 0, 0));
        d.pack();
        d.setLocationRelativeTo(null);
        d.setVisible(true);
                
        try {
            Thread.sleep(4500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d.setVisible(false);

        /*
         //                    JWindow window = new JWindow();
         //                    window.getContentPane().add(
         //                            new JLabel("", new ImageIcon(new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/SplashDemoProject/src/misc/images/splash.gif")), SwingConstants.CENTER));
         //                    window.setBounds(500, 150, 300, 200);
         //                    window.setVisible(true);
         //                    try {
         //                        Thread.sleep(5000);
         //                    } catch (InterruptedException e) {
         //                        e.printStackTrace();
         //                    }
         //                    window.setVisible(false);
         //                    JFrame frame = new JFrame();
         //                    frame.add(new JLabel("Welcome"));
         //                    frame.setVisible(true);
         //                    frame.setSize(300, 100);
         //                    window.dispose();
         */
    }

    public static void main(String[] args) {
        makeSplash();

    }
}
