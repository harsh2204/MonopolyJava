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
    int price,priceHouse, rent1, rent2, rent3, rent4, rentH, colour;
    /*Colour Scheme Codes:
     1:Yellow
     2:Blue
     3:Purple
     4:Green
     5:Red
     6:Orange
     7:White
     8:Grey
     9:Black
     */
    public Canada_Data property[] = new Canada_Data[20];

    public Canada_Data[] setProp() {
        //Initializing the object array.
        for (int i = 0; i < property.length; i++) {
            property[i] = new Canada_Data();
        }
        //Adding Property names
        property[0].propName = "Brampton";//
        property[1].propName = "Mississauga";//
        property[2].propName = "YellowKnife";//
        property[3].propName = "Whitehorse";//
        property[4].propName = "Iqaluit";//
        property[5].propName = "Saskatoon";//
        property[6].propName = "Thunder Bay";//
        property[7].propName = "Windsor";//
        property[8].propName = "Fredricton";
        property[9].propName = "Regina";//
        property[10].propName = "St. John's";//
        property[11].propName = "Quebec City";//
        property[12].propName = "Halifax";//
        property[13].propName = "Winnipeg";//
        property[14].propName = "Edmonton";//
        property[15].propName = "Calgary";//
        property[16].propName = "Ottawa";//
        property[17].propName = "Vancouver";//
        property[18].propName = "Montreal";//
        property[19].propName = "Toronto";//
        
        //Adding property rents
        //======================================================================
        //YELLOW SUITE----------------------------------------------------------
        //BRAMPTON
        property[0].price = 60;
        property[0].rent1 = 10;
        property[0].rent2 = 30;
        property[0].rent3 = 90;
        property[0].rent4 = 160;
        property[0].rentH = 250;
        property[0].priceHouse=50;
        property[0].colour = 1;
        //MISSISSAUGA
        property[1].price = 60;
        property[1].rent1 = 20;
        property[1].rent2 = 60;
        property[1].rent3 = 180;
        property[1].rent4 = 320;
        property[1].rentH = 450;
        property[1].priceHouse=50;
        property[1].colour = 1;
        //YELLOW KNIFE
        property[2].price = 80;
        property[2].rent1 = 30;
        property[2].rent2 = 90;
        property[2].rent3 = 220;
        property[2].rent4 = 350;
        property[2].rentH = 500;
        property[2].priceHouse=50;
        property[2].colour = 1;
        //======================================================================
        //BLUE SUITE------------------------------------------------------------
        //WHITEHORSE
        property[3].price = 100;
        property[3].rent1 = 30;
        property[3].rent2 = 90;
        property[3].rent3 = 270;
        property[3].rent4 = 400;
        property[3].rentH = 550;
        property[3].priceHouse = 75;
        property[3].colour = 2;
        //IQALUIT
        property[4].price = 120;
        property[4].rent1 = 40;
        property[4].rent2 = 100;
        property[4].rent3 = 300;
        property[4].rent4 = 450;
        property[4].rentH = 600;
        property[4].priceHouse = 75;
        property[4].colour = 2;
        //SASKATOON
        property[5].price = 120;
        property[5].rent1 = 40;
        property[5].rent2 = 100;
        property[5].rent3 = 260;
        property[5].rent4 = 420;
        property[5].rentH = 580;
        property[5].priceHouse = 75;
        property[5].colour = 2;
        //======================================================================
        //PURPLE SUITE----------------------------------------------------------
        //THUNDER BAY
        property[6].price = 140;
        property[6].rent1 = 50;
        property[6].rent2 = 150;
        property[6].rent3 = 450;
        property[6].rent4 = 625;
        property[6].rentH = 700;
        property[6].priceHouse = 100;
        property[6].colour = 3;
        //WINDSOR
        property[7].price = 150;
        property[7].rent1 = 60;
        property[7].rent2 = 170;
        property[7].rent3 = 480;
        property[7].rent4 = 650;
        property[7].rentH = 750;
        property[7].priceHouse = 100;
        property[7].colour = 3;
        //FREDRICTION
        property[8].price = 180;
        property[8].rent1 = 80;
        property[8].rent2 = 180;
        property[8].rent3 = 500;
        property[8].rent4 = 680;
        property[8].rentH = 900;
        property[8].priceHouse = 100;
        property[8].colour = 3;
        //======================================================================
        //GREEN SUITE-----------------------------------------------------------
        //REGINA
        property[9].price = 200;
        property[9].rent1 = 100;
        property[9].rent2 = 200;
        property[9].rent3 = 520;
        property[9].rent4 = 700;
        property[9].rentH = 910;
        property[9].priceHouse = 150;
        property[9].colour = 4;
        //ST. JOHN'S
        property[10].price = 220;
        property[10].rent1 = 110;
        property[10].rent2 = 220;
        property[10].rent3 = 540;
        property[10].rent4 = 725;
        property[10].rentH = 925;
        property[10].priceHouse = 150;
        property[10].colour = 4;
        //QUEBEC CITY
        property[11].price = 220;
        property[11].rent1 = 110;
        property[11].rent2 = 220;
        property[11].rent3 = 540;
        property[11].rent4 = 725;
        property[11].rentH = 925;
        property[11].priceHouse = 150;
        property[11].colour = 4;
        //HALIFAX
        property[12].price = 250;
        property[12].rent1 = 125;
        property[12].rent2 = 250;
        property[12].rent3 = 550;
        property[12].rent4 = 750;
        property[12].rentH = 950;
        property[12].priceHouse = 150;
        property[12].colour = 4;
        //======================================================================
        //RED SUITE-------------------------------------------------------------
        //WINNIPEG
        property[13].price = 260;
        property[13].rent1 = 140;
        property[13].rent2 = 300;
        property[13].rent3 = 750;
        property[13].rent4 = 975;
        property[13].rentH = 1000;
        property[13].priceHouse = 200;
        property[13].colour = 5;
        //EDMONTON
        property[14].price = 290;
        property[14].rent1 = 150;
        property[14].rent2 = 350;
        property[14].rent3 = 800;
        property[14].rent4 = 1000;
        property[14].rentH = 1100;
        property[14].priceHouse = 200;
        property[14].colour = 5;
        //CALGARY
        property[15].price = 290;
        property[15].rent1 = 150;
        property[15].rent2 = 350;
        property[15].rent3 = 800;
        property[15].rent4 = 1000;
        property[15].rentH = 1100;
        property[15].priceHouse = 200;
        property[15].colour = 5;
        //OTTAWA
        property[16].price = 325;
        property[16].rent1 = 170;
        property[16].rent2 = 400;
        property[16].rent3 = 850;
        property[16].rent4 = 1100;
        property[16].rentH = 1200;
        property[16].priceHouse = 200;
        property[16].colour = 5;
        //======================================================================
        //ORANGE SUITE----------------------------------------------------------
        //VANCOUVER
        property[17].price = 350;
        property[17].rent1 = 175;
        property[17].rent2 = 500;
        property[17].rent3 = 1100;
        property[17].rent4 = 1300;
        property[17].rentH = 1500;
        property[17].colour = 6;
        property[17].priceHouse=300;        
        //MONTREAL
        property[18].price = 400;
        property[18].rent1 = 200;
        property[18].rent2 = 600;
        property[18].rent3 = 1400;
        property[18].rent4 = 1700;
        property[18].rentH = 2000;
        property[18].priceHouse=300;
        property[18].colour = 6;
        //TORONTO
        property[19].price = 500;
        property[19].rent1 = 250;
        property[19].rent2 = 750;
        property[19].rent3 = 1500;
        property[19].rent4 = 1850;
        property[19].rentH = 2100;
        property[19].priceHouse=300;
        property[19].colour = 6;
        //======================================================================
        
        return property;
    }
}
