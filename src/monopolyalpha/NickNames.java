/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Haard Trivedi
 * Thursday October 27, 2016
 */
public class NickNames {

   public String[] first = new String[31];
    public String[] last = new String[31];
    public ArrayList <String> firsti=new ArrayList(),lasti=new ArrayList(),namei=new ArrayList();
    public String name;
    
    public void listName() {
        first[0] = "Master";
        first[1] = "Captain";
        first[2] = "Doctor";
        first[3] = "Professor";
        first[4] = "Fire";
        first[5] = "Water";
        first[6] = "Earth";
        first[7] = "Air";
        first[8] = "Dragon";
        first[9] = "Lava";
        first[10] = "Thunder";
        first[11] = "Lightning";
        first[12] = "Major";
        first[13] = "Sorceror";
        first[14] = "Blue";
        first[15] = "Red";
        first[16] = "Yellow";
        first[17] = "Optimus";
        first[18] = "Sailor";
        first[19] = "Lion";
        first[20] = "Bat";
        first[21] = "Ruler";
        first[20] = "Doll";
        first[22] = "Pink";
        first[23] = "Cat";
        first[24] = "Rainbow";
        first[25] = "Pretty";
        first[26] = "Crazy";
        first[27] = "Lucky";
        first[28] = "Tiny";
        first[29] = "Ultra";
        first[30] = "Bionic";

        last[0] = "Apprentice";
        last[1] = "Doom";
        last[2] = "Strike";
        last[3] = "Evil";
        last[4] = "Bird";
        last[5] = "Phoenix";
        last[6] = "Unicorn";
        last[7] = "Prime";
        last[8] = "Breath";
        last[9] = "Sky";
        last[10] = "Devil";
        last[11] = "Dawg";
        last[12] = "Moon";
        last[13] = "Sun";
        last[14] = "Goblin";
        last[15] = "Ghost";
        last[16] = "Karma";
        last[17] = "Lover";
        last[18] = "Violet";
        last[19] = "Mermaid";
        last[20] = "Princess";
        last[21] = "Face";
        last[20] = "Nova";
        last[22] = "Boy";
        last[23] = "Canada";
        last[24] = "Hero";
        last[25] = "Legend";
        last[26] = "Night";
        last[27] = "Fab";
        last[28] = "Big";
        last[29] = "Pants";
        last[30] = "Chick";
        for(int i=0;i<=30;i++)
        {
            firsti.add(first[i]);
            lasti.add(last[i]);
        }
        getName();
    }
    public void getName() {
        Collections.shuffle(firsti);
        Collections.shuffle(lasti);
        name = firsti.get(12)+" "+(lasti.get(19));
    }
}
