/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

/**
 *
 * @author Harsh
 */
public class MonopolyAlpha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
       Splash_Screen splash = new Splash_Screen();
       splash.makeSplash();
       
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Save_Manager().setVisible(true);
            }
        });
     
       
    }

}