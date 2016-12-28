/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Harsh
 */
public class Players {

    ThemeSelect ts = new ThemeSelect();
    Properties_Data pd = new Properties_Data(ts.theme);
   int playerNum;
   ImageIcon icon, piece;
   String name;//name
   int ID; //player id
   int cash;//money
   int propNum;//number of properties
   int pos;
    ArrayList<Properties_Data> properties = new ArrayList<>();
   static Players[] peeps;

    public void setupPeeps(int len) {       
        peeps = new Players[len];
        for (int i = 0; i < len; i++) {
            peeps[i] = new Players();
        }
    }
    public void makePieces() {
        for (int i = 0; i < playerNum; i++) {
            Image image1 = peeps[i].icon.getImage(); // transform it 
            Image newimg1 = image1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            ImageIcon imageIcon1 = new ImageIcon(newimg1);  // transform it back
            peeps[i].piece = imageIcon1;
        }
    }
    public boolean owns(Properties_Data prop){        
        if(prop.owner==this){
           return true;
        }else{
            return false;
        }
    }
}
