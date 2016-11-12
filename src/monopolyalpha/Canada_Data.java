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
        //Adding Property names.
        property[0].propName = "Toronto";//
        property[1].propName = "Mississauga";//
        property[2].propName = "Montreal";//
        property[3].propName = "Vancouver";//
        property[4].propName = "Ottawa";//
        property[5].propName = "Calgary";//
        property[6].propName = "Iqaluit";//
        property[7].propName = "Edmonton";//
        property[8].propName = "Fredricton";
        property[9].propName = "St John's";//
        property[10].propName = "Halifax";//
        property[11].propName = "Yellowknife";//
        property[12].propName = "Whitehorse";//
        property[13].propName = "Quebec City";//
        property[14].propName = "Winnipeg";//
        property[15].propName = "Brampton";//
        property[16].propName = "Thunder Bay";//
        property[17].propName = "Windsor";//
        property[18].propName = "Saskatoon";//
        property[19].propName = "Regina";//

    //Adding property rents
        //SUITE OF YELLOW-------------------------------------------------------
        //BRAMPTON
        property[15].price = 60;
        property[15].rent1 = 10;
        property[15].rent2 = 30;
        property[15].rent3 = 90;
        property[15].rent4 = 160;
        property[15].rentH = 250;
        property[15].priceHouse=50;
        property[15].colour = 1;
        //MISSISSAUGA
        property[1].price = 60;
        property[1].rent1 = 20;
        property[1].rent2 = 60;
        property[1].rent3 = 180;
        property[1].rent4 = 320;
        property[1].rentH = 450;
        property[15].priceHouse=50;
        property[1].colour = 1;
        //YELLOW KNIFE
        property[11].price = 80;
        property[11].rent1 = 30;
        property[11].rent2 = 90;
        property[11].rent3 = 220;
        property[11].rent4 = 350;
        property[11].rentH = 500;
        property[15].priceHouse=50;
        property[11].colour = 1;
        //======================================================================
        //SUITE OF BLUE---------------------------------------------------------
        //WHITEHORSE13
        property[12].price = 100;
        property[12].rent1 = 30;
        property[12].rent2 = 90;
        property[12].rent3 = 270;
        property[12].rent4 = 400;
        property[12].rentH = 550;
        property[12].priceHouse = 75;
        property[12].colour = 2;
        //IQALUIT
        property[6].price = 120;
        property[6].rent1 = 40;
        property[6].rent2 = 100;
        property[6].rent3 = 300;
        property[6].rent4 = 450;
        property[6].rentH = 600;
        property[6].priceHouse = 75;
        property[6].colour = 2;
        //SASKATOON21
        property[18].price = 120;
        property[18].rent1 = 40;
        property[18].rent2 = 100;
        property[18].rent3 = 260;
        property[18].rent4 = 420;
        property[18].rentH = 580;
        property[18].priceHouse = 75;
        property[18].colour = 2;
        //======================================================================
        //SUITE OF PURPLE-------------------------------------------------------
        //[19] THUNDER BAY
        property[16].price = 140;
        property[16].rent1 = 50;
        property[16].rent2 = 150;
        property[16].rent3 = 450;
        property[16].rent4 = 625;
        property[16].rentH = 700;
        property[16].priceHouse = 100;
        property[16].colour = 3;
        //[20] WINDSOR
        property[17].price = 150;
        property[17].rent1 = 60;
        property[17].rent2 = 170;
        property[17].rent3 = 480;
        property[17].rent4 = 650;
        property[17].rentH = 750;
        property[17].priceHouse = 100;
        property[17].colour = 3;
        //[8] FREDRICTION
        property[8].price = 180;
        property[8].rent1 = 80;
        property[8].rent2 = 180;
        property[8].rent3 = 500;
        property[8].rent4 = 680;
        property[8].rentH = 900;
        property[8].priceHouse = 100;
        property[8].colour = 3;
        //======================================================================
        //SUITE OF GREEN--------------------------------------------------------
        //[22] REGINA
        property[19].price = 200;
        property[19].rent1 = 100;
        property[19].rent2 = 200;
        property[19].rent3 = 520;
        property[19].rent4 = 700;
        property[19].rentH = 910;
        property[19].priceHouse = 125;
        property[19].colour = 4;
        //[9] ST JOHNS
        property[9].price = 220;
        property[9].rent1 = 110;
        property[9].rent2 = 220;
        property[9].rent3 = 540;
        property[9].rent4 = 725;
        property[9].rentH = 925;
        property[9].priceHouse = 125;
        property[9].colour = 4;
        //[14] QUEBEC CITY
        property[13].price = 220;
        property[13].rent1 = 110;
        property[13].rent2 = 220;
        property[13].rent3 = 540;
        property[13].rent4 = 725;
        property[13].rentH = 925;
        property[13].priceHouse = 125;
        property[13].colour = 4;
        //[11] HALIFAX
        property[10].price = 250;
        property[10].rent1 = 125;
        property[10].rent2 = 250;
        property[10].rent3 = 550;
        property[10].rent4 = 750;
        property[10].rentH = 950;
        property[10].priceHouse = 125;
        property[10].colour = 4;
        //======================================================================
        //SUITE OF RED----------------------------------------------------------
        //[14] WINNIPEG
        property[14].price = 260;
        property[14].rent1 = 140;
        property[14].rent2 = 300;
        property[14].rent3 = 750;
        property[14].rent4 = 975;
        property[14].rentH = 1000;
        property[14].priceHouse = 150;
        property[14].colour = 5;
        //[7] EDMONTON
        property[7].price = 290;
        property[7].rent1 = 150;
        property[7].rent2 = 350;
        property[7].rent3 = 800;
        property[7].rent4 = 1000;
        property[7].rentH = 1100;
        property[7].priceHouse = 150;
        property[7].colour = 5;
        //[5] CALGARY
        property[5].price = 290;
        property[5].rent1 = 150;
        property[5].rent2 = 350;
        property[5].rent3 = 800;
        property[5].rent4 = 1000;
        property[5].rentH = 1100;
        property[5].priceHouse = 150;
        property[5].colour = 5;
        //[4] OTTAWA
        property[4].price = 325;
        property[4].rent1 = 170;
        property[4].rent2 = 400;
        property[4].rent3 = 850;
        property[4].rent4 = 1100;
        property[4].rentH = 1200;
        property[4].priceHouse = 150;
        property[4].colour = 5;
        //======================================================================
        //SUITE OF ORANGE-------------------------------------------------------
        //VANCOUVER
        property[3].price = 350;
        property[3].rent1 = 175;
        property[3].rent2 = 500;
        property[3].rent3 = 1100;
        property[3].rent4 = 1300;
        property[3].rentH = 1500;
        property[3].colour = 6;
        property[0].priceHouse=300;        
        //MONTREAL
        property[2].price = 400;
        property[2].rent1 = 200;
        property[2].rent2 = 600;
        property[2].rent3 = 1400;
        property[2].rent4 = 1700;
        property[2].rentH = 2000;
        property[0].priceHouse=300;
        property[2].colour = 6;
        //TORONTO
        property[0].price = 500;
        property[0].rent1 = 250;
        property[0].rent2 = 750;
        property[0].rent3 = 1500;
        property[0].rent4 = 1850;
        property[0].rentH = 2100;
        property[0].priceHouse=300;
        property[0].colour = 6;
        //======================================================================
        
        return property;
    }
}
