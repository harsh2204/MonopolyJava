/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

/**
 *
 * @author 714449
 */
public class Dice {
    
    
     Random r = new Random();
    int randomNumber = r.nextInt(6) + 1;

    diceImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/Images/Dice " + randomNumber + ".png")));

    
}
