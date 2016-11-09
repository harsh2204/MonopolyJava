/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import javax.swing.ImageIcon;

/**
 *
 * @author Harsh
 */
public class Canada_Data {

    public String p1 = "Hockey Stick";
    public String p2 = "Maple Leaf";
    public String p3 = "Ski";
    public String p4 = "Telephone";
    public ImageIcon i1 = new ImageIcon("Icons/Pieces/Canada/1.png");
    public ImageIcon i2 = new ImageIcon("Icons/Pieces/Canada/2.png");
    public ImageIcon i3 = new ImageIcon("Icons/Pieces/Canada/3.png");
    public ImageIcon i4 = new ImageIcon("Icons/Pieces/Canada/4.png");
    String propName;
    int rentB, rent1, rent2, rentH, colour;
   public Canada_Data property[] = new Canada_Data[24];
    public Canada_Data[] setProp(){
        //Initializing the object array.
        for(int i = 0;i<property.length;i++){
            property[i] = new Canada_Data();
        }
        //Adding Property names.
    property[0].propName = "Toronto";
    property[1].propName = "Mississauga";
    property[2].propName = "Montreal";
    property[3].propName = "Vancouver";
    property[4].propName = "Ottawa";
    property[5].propName = "Calgary";
    property[6].propName = "Iqaluit";
    property[7].propName = "Edmonton";
    property[8].propName = "Fredricton";
    property[9].propName = "St John's";
    property[10].propName = "Charletton";
    property[11].propName = "Halifax";
    property[12].propName = "Yellowknife";
    property[13].propName = "Whitehorse";
    property[14].propName = "Quebec City";
    property[15].propName = "Winnipeg";
    property[16].propName = "Brampton";
    property[17].propName = "Victoria";
    property[18].propName = "Niagara";
    property[19].propName = "Thunder Bay";
    property[20].propName = "Windsor";
    property[21].propName = "Saskatoon";
    property[22].propName = "Regina";
    property[23].propName = "London";
            
            
            
    return property;
    }
}
