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
    int price, rent1, rent2, rent3, rent4, rentH, colour;
    /*Colour Scheme Codes:
     1:Blue
     2:Purpule
     3:Green
     4:Red
     5:Orange
     6:Yellow
     7:White
     8:Grey
     9:Black
     */
    public Canada_Data property[] = new Canada_Data[24];

    public Canada_Data[] setProp() {
        //Initializing the object array.
        for (int i = 0; i < property.length; i++) {
            property[i] = new Canada_Data();
        }
        //Adding Property names.
        property[0].propName = "Toronto";//
        property[1].propName = "Mississauga";//
        property[2].propName = "Montreal";
        property[3].propName = "Vancouver";//
        property[4].propName = "Ottawa";
        property[5].propName = "Calgary";
        property[6].propName = "Iqaluit";//
        property[7].propName = "Edmonton";//
        property[8].propName = "Fredricton";
        property[9].propName = "St John's";
        property[10].propName = "Charlettown";//
        property[11].propName = "Halifax";
        property[12].propName = "Yellowknife";
        property[13].propName = "Whitehorse";
        property[14].propName = "Quebec City";
        property[15].propName = "Winnipeg";
        property[16].propName = "Brampton";//
        property[17].propName = "Victoria";
        property[18].propName = "Niagara";//
        property[19].propName = "Thunder Bay";
        property[20].propName = "Windsor";
        property[21].propName = "Saskatoon";
        property[22].propName = "Regina";
        property[23].propName = "London";

    //Adding property rents
        //SUITE OF BLUE
        //TORONTO
        property[0].price = 400;
        property[0].rent1 = 200;
        property[0].rent2 = 600;
        property[0].rent3 = 1400;
        property[0].rent4 = 1700;
        property[0].rentH = 2000;
        property[0].colour = 1;
        //VANCOUVER
        property[3].price = 350;
        property[3].rent1 = 175;
        property[3].rent2 = 500;
        property[3].rent3 = 1100;
        property[3].rent4 = 1300;
        property[3].rentH = 1500;
        property[3].colour = 1;
        //CHARLOTTETOWN
        property[10].price = 60;
        property[10].rent1 = 10;
        property[10].rent2 = 30;
        property[10].rent3 = 90;
        property[10].rent4 = 160;
        property[10].rentH = 250;
        property[10].colour = 1;
        //IQALUIT
        property[6].price = 60;
        property[6].rent1 = 20;
        property[6].rent2 = 60;
        property[6].rent3 = 180;
        property[6].rent4 = 320;
        property[6].rentH = 450;
        property[6].colour = 1;
        //SUITE OF PURPLE
        //BRAMPTON
        property[16].price = 100;
        property[16].rent1 = 30;
        property[16].rent2 = 90;
        property[16].rent3 = 270;
        property[16].rent4 = 400;
        property[16].rentH = 550;
        property[16].colour = 2;
        //MISSISSAUGA
        property[1].price = 120;
        property[1].rent1 = 40;
        property[1].rent2 = 100;
        property[1].rent3 = 300;
        property[1].rent4 = 450;
        property[1].rentH = 600;
        property[1].colour = 2;
        //NIAGRA
        property[16].price = 100;
        property[16].rent1 = 30;
        property[16].rent2 = 90;
        property[16].rent3 = 270;
        property[16].rent4 = 400;
        property[16].rentH = 550;
        property[16].colour = 2;
        //EDMONTON
        property[7].price = 140;
        property[7].rent1 = 50;
        property[7].rent2 = 150;
        property[7].rent3 = 450;
        property[7].rent4 = 625;
        property[7].rentH = 750;
        property[7].colour = 2;
        
        return property;
    }
}
