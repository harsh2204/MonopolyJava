/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author Harsh Gupta and Karmit Patel
 */
public class Canada_Data {

    Color purple = new Color(75, 0, 130);
    public String p1 = "Hockey Stick";
    public String p2 = "Maple Leaf";
    public String p3 = "Ski";
    public String p4 = "Telephone";
    public ImageIcon i1 = new ImageIcon("Icons/Pieces/Canada/1.png");
    public ImageIcon i2 = new ImageIcon("Icons/Pieces/Canada/2.png");
    public ImageIcon i3 = new ImageIcon("Icons/Pieces/Canada/3.png");
    public ImageIcon i4 = new ImageIcon("Icons/Pieces/Canada/4.png");
    public String propName, desc1, desc2;
    public int price, priceHouse, rent1, rent2, rent3, rent4, rentH;
    public String chance[] = new String[16];
    public String chanceActs[] = new String[16];
    public int chanceVals[] = new int[16],chancePos[]=new int[16];
    public String comm[] = new String[16];
    public String commActs[] = new String[16];
    public int commVals[] = new int[16],commPos[]=new int[16];
    public Canada_Data property[] = new Canada_Data[36];
    public boolean buyable;
    public Color colour;
    public ImageIcon cardIcon;
    public String type;

    public Canada_Data[] setProp() {
        //Initializing the object array.
        for (int i = 0; i < 36; i++) {
            property[i] = new Canada_Data();
        }
        property[0].propName = "Start";
        property[0].buyable = false;
        property[0].type = "ST";
        //======================================================================
        //YELLOW SUITE----------------------------------------------------------
        //BRAMPTON
        property[1].propName = "Brampton";
        property[1].price = 60;
        property[1].rent1 = 10;
        property[1].rent2 = 30;
        property[1].rent3 = 90;
        property[1].rent4 = 160;
        property[1].rentH = 250;
        property[1].priceHouse = 50;
        property[1].colour = Color.YELLOW;
        property[1].buyable = true;
        property[1].cardIcon = new ImageIcon("Board Pictures/Canada/Bra Image.jpg");
        property[1].type = "N";
        //MISSISSAUGA
        property[2].propName = "Mississauga";
        property[2].price = 60;
        property[2].rent1 = 20;
        property[2].rent2 = 60;
        property[2].rent3 = 180;
        property[2].rent4 = 320;
        property[2].rentH = 450;
        property[2].priceHouse = 50;
        property[2].colour = Color.YELLOW;
        property[2].buyable = true;
        property[2].cardIcon = new ImageIcon("Board Pictures/Canada/Mis Image.jpg");
        property[2].type = "N";

        //TIM HORTON'S
        property[3].propName = "Tim Horton's";
        property[3].desc1 = "Rent = 25x roll & +25 ";
        property[3].desc2 = "rent on all properties";
        property[3].price = 325;
        property[3].colour = Color.WHITE;
        property[3].buyable = true;
        property[3].type = "STH";

        //YELLOW KNIFE
        property[4].propName = "YellowKnife";
        property[4].price = 80;
        property[4].rent1 = 30;
        property[4].rent2 = 90;
        property[4].rent3 = 220;
        property[4].rent4 = 350;
        property[4].rentH = 500;
        property[4].priceHouse = 50;
        property[4].colour = Color.YELLOW;
        property[4].buyable = true;
        property[4].cardIcon = new ImageIcon("Board Pictures/Canada/YK Image.jpg");
        property[4].type = "N";

        property[5].propName = "Income Tax";
        property[5].buyable = false;
        property[5].colour = Color.GRAY;
        property[5].type = "IT";

        property[6].propName = "Chance";
        property[6].buyable = false;
        property[6].colour = Color.GRAY;
        property[6].type = "CH";
        //======================================================================
        //BLUE SUITE------------------------------------------------------------
        //WHITEHORSE
        property[7].propName = "Whitehorse";
        property[7].price = 100;
        property[7].rent1 = 30;
        property[7].rent2 = 90;
        property[7].rent3 = 270;
        property[7].rent4 = 400;
        property[7].rentH = 550;
        property[7].priceHouse = 75;
        property[7].colour = Color.BLUE;
        property[7].buyable = true;
        property[7].cardIcon = new ImageIcon("Board Pictures/Canada/WH Image.jpg");
        property[7].type = "N";
        //IQALUIT
        property[8].propName = "Iqaluit";
        property[8].price = 120;
        property[8].rent1 = 40;
        property[8].rent2 = 100;
        property[8].rent3 = 300;
        property[8].rent4 = 450;
        property[8].rentH = 600;
        property[8].priceHouse = 75;
        property[8].colour = Color.BLUE;
        property[8].buyable = true;
        property[8].cardIcon = new ImageIcon("Board Pictures/Canada/Iqa Image.jpg");
        property[8].type = "N";

        property[9].propName = "Jail";
        property[9].buyable = false;
        property[9].colour = Color.BLACK;
        property[9].type = "J";
        //SASKATOON
        property[10].propName = "Saskatoon";
        property[10].price = 120;
        property[10].rent1 = 40;
        property[10].rent2 = 100;
        property[10].rent3 = 260;
        property[10].rent4 = 420;
        property[10].rentH = 580;
        property[10].priceHouse = 75;
        property[10].colour = Color.BLUE;
        property[10].buyable = true;
        property[10].cardIcon = new ImageIcon("Board Pictures/Canada/Sas Image.jpg");
        property[10].type = "N";
        //======================================================================
        //PURPLE SUITE----------------------------------------------------------
        //THUNDER BAY
        property[11].propName = "Thunder Bay";
        property[11].price = 140;
        property[11].rent1 = 50;
        property[11].rent2 = 150;
        property[11].rent3 = 450;
        property[11].rent4 = 625;
        property[11].rentH = 700;
        property[11].priceHouse = 100;
        property[11].colour = purple;
        property[11].buyable = true;
        property[11].cardIcon = new ImageIcon("Board Pictures/Canada/TB Image.jpg");
        property[11].type = "N";

        //CNR
        property[12].propName = "CNR";
        property[12].desc1 = "Rent = 25x roll, 50x roll ";
        property[12].desc2 = "if CN Tower is owned";
        property[12].price = 375;
        property[12].colour = Color.WHITE;
        property[12].buyable = true;
        property[12].type = "S1230";
        //WINDSOR
        property[13].propName = "Windsor";
        property[13].price = 150;
        property[13].rent1 = 60;
        property[13].rent2 = 170;
        property[13].rent3 = 480;
        property[13].rent4 = 650;
        property[13].rentH = 750;
        property[13].priceHouse = 100;
        property[13].colour = purple;
        property[13].buyable = true;
        property[13].cardIcon = new ImageIcon("Board Pictures/Canada/Wind Image.jpg");
        property[13].type = "N";
        //FREDRICTION
        property[14].propName = "Fredricton";
        property[14].price = 180;
        property[14].rent1 = 80;
        property[14].rent2 = 180;
        property[14].rent3 = 500;
        property[14].rent4 = 680;
        property[14].rentH = 900;
        property[14].priceHouse = 100;
        property[14].colour = purple;
        property[14].buyable = true;
        property[14].cardIcon = new ImageIcon("Board Pictures/Canada/Fre Image.jpg");
        property[14].type = "N";

        //NIAGARA FALLS
        property[15].propName = "Niagara Falls";
        property[15].desc1 = "Rent = 25x roll, 50x roll ";
        property[15].desc2 = " if Parliament is owned";
        property[15].price = 375;
        property[15].colour = Color.WHITE;
        property[15].buyable = true;
        property[15].type = "S1533";

        property[16].buyable = false;
        property[16].colour = Color.GRAY;
        property[16].type = "CO";

        //======================================================================
        //GREEN SUITE-----------------------------------------------------------
        //REGINA
        property[17].propName = "Regina";
        property[17].price = 200;
        property[17].rent1 = 100;
        property[17].rent2 = 200;
        property[17].rent3 = 520;
        property[17].rent4 = 700;
        property[17].rentH = 910;
        property[17].priceHouse = 150;
        property[17].colour = Color.GREEN;
        property[17].buyable = true;
        property[17].cardIcon = new ImageIcon("Board Pictures/Canada/Reg Image.png");
        property[17].type = "N";

        property[18].buyable = false;
        property[18].colour = Color.GRAY;
        property[18].type = "FP";
        //ST. JOHN'S
        property[19].propName = "St. John's";
        property[19].price = 220;
        property[19].rent1 = 110;
        property[19].rent2 = 220;
        property[19].rent3 = 540;
        property[19].rent4 = 725;
        property[19].rentH = 925;
        property[19].priceHouse = 150;
        property[19].colour = Color.GREEN;
        property[19].buyable = true;
        property[19].cardIcon = new ImageIcon("Board Pictures/Canada/STJ Image.jpg");
        property[19].type = "N";
        //QUEBEC CITY
        property[20].propName = "Quebec City";
        property[20].price = 220;
        property[20].rent1 = 110;
        property[20].rent2 = 220;
        property[20].rent3 = 540;
        property[20].rent4 = 725;
        property[20].rentH = 925;
        property[20].priceHouse = 150;
        property[20].colour = Color.GREEN;
        property[20].buyable = true;
        property[20].cardIcon = new ImageIcon("Board Pictures/Canada/QBC Image.jpg");
        property[20].type = "N";

        //RBC
        property[21].propName = "RBC";
        property[21].desc1 = "Rent = 25x roll & tax rebate";
        property[21].price = 325;
        property[21].colour = Color.WHITE;
        property[21].buyable = true;
        property[21].type = "SRBC";

        //HALIFAX
        property[22].propName = "Halifax";
        property[22].price = 250;
        property[22].rent1 = 125;
        property[22].rent2 = 250;
        property[22].rent3 = 550;
        property[22].rent4 = 750;
        property[22].rentH = 950;
        property[22].priceHouse = 150;
        property[22].colour = Color.GREEN;
        property[22].buyable = true;
        property[22].cardIcon = new ImageIcon("Board Pictures/Canada/Hal Image.jpg");
        property[22].type = "N";

        property[23].propName = "Blank";
        property[23].buyable = false;
        property[23].colour = Color.WHITE;
        property[23].type = "HT";

        property[24].buyable = false;
        property[24].colour = Color.GRAY;
        property[24].type = "CH";
        //======================================================================
        //RED SUITE-------------------------------------------------------------
        //WINNIPEG
        property[25].propName = "Winnipeg";
        property[25].price = 260;
        property[25].rent1 = 140;
        property[25].rent2 = 300;
        property[25].rent3 = 750;
        property[25].rent4 = 975;
        property[25].rentH = 1000;
        property[25].priceHouse = 200;
        property[25].colour = Color.RED;
        property[25].buyable = true;
        property[25].cardIcon = new ImageIcon("Board Pictures/Canada/Winn Image.jpg");
        property[25].type = "N";
        //EDMONTON
        property[26].propName = "Edmonton";
        property[26].price = 290;
        property[26].rent1 = 150;
        property[26].rent2 = 350;
        property[26].rent3 = 800;
        property[26].rent4 = 1000;
        property[26].rentH = 1100;
        property[26].priceHouse = 200;
        property[26].colour = Color.RED;
        property[26].buyable = true;
        property[26].cardIcon = new ImageIcon("Board Pictures/Canada/Edm Image.jpg");
        property[26].type = "N";

        property[27].buyable = false;
        property[27].colour = Color.GRAY;
        property[27].type = "JK";

        //CALGARY
        property[28].propName = "Calgary";
        property[28].price = 290;
        property[28].rent1 = 150;
        property[28].rent2 = 350;
        property[28].rent3 = 800;
        property[28].rent4 = 1000;
        property[28].rentH = 1100;
        property[28].priceHouse = 200;
        property[28].colour = Color.RED;
        property[28].buyable = true;
        property[28].cardIcon = new ImageIcon("Board Pictures/Canada/Cal Image.jpg");
        property[28].type = "N";
        //OTTAWA
        property[29].propName = "Ottawa";
        property[29].price = 325;
        property[29].rent1 = 170;
        property[29].rent2 = 400;
        property[29].rent3 = 850;
        property[29].rent4 = 1100;
        property[29].rentH = 1200;
        property[29].priceHouse = 200;
        property[29].colour = Color.RED;
        property[29].buyable = true;
        property[29].cardIcon = new ImageIcon("Board Pictures/Canada/Ott Image.jpg");
        property[29].type = "N";
        //======================================================================

        //CN TOWER
        property[30].propName = "CN Tower";
        property[30].desc1 = "Rent = 25x roll, 50x ";
        property[30].desc2 = "roll if CNR is owned";
        property[30].price = 375;
        property[30].colour = Color.WHITE;
        property[30].buyable = true;
        property[30].type = "S1230";

        property[31].buyable = false;
        property[31].colour = Color.GRAY;
        property[31].type = "CO";
        //ORANGE SUITE----------------------------------------------------------
        //VANCOUVER
        property[32].propName = "Vancouver";
        property[32].price = 375;
        property[32].rent1 = 175;
        property[32].rent2 = 500;
        property[32].rent3 = 1100;
        property[32].rent4 = 1300;
        property[32].rentH = 1500;
        property[32].colour = Color.ORANGE;
        property[32].priceHouse = 300;
        property[32].buyable = true;
        property[32].cardIcon = new ImageIcon("Board Pictures/Canada/Van Image.jpg");
        property[32].type = "N";

        //PARLIAMENT HILL
        property[33].propName = "Pariliament Hill";
        property[33].desc1 = "Rent = 25x roll, 50x roll ";
        property[33].desc2 = " if Niagara Falls is owned";
        property[33].price = 375;
        property[33].colour = Color.WHITE;
        property[33].buyable = true;
        property[33].type = "S1533";

        //MONTREAL
        property[34].propName = "Montreal";
        property[34].price = 400;
        property[34].rent1 = 200;
        property[34].rent2 = 600;
        property[34].rent3 = 1400;
        property[34].rent4 = 1700;
        property[34].rentH = 2000;
        property[34].priceHouse = 300;
        property[34].colour = Color.ORANGE;
        property[34].buyable = true;
        property[34].cardIcon = new ImageIcon("Board Pictures/Canada/Mon Image.jpg");
        property[34].type = "N";
        //TORONTO
        property[35].propName = "Toronto";
        property[35].price = 500;
        property[35].rent1 = 250;
        property[35].rent2 = 750;
        property[35].rent3 = 1500;
        property[35].rent4 = 1850;
        property[35].rentH = 2100;
        property[35].priceHouse = 300;
        property[35].colour = Color.ORANGE;
        property[35].buyable = true;
        property[35].cardIcon = new ImageIcon("Board Pictures/Canada/Tor Image.jpg");
        property[35].type = "N";
        //======================================================================
        //GREY SUITE------------------------------------------------------------

        return property;
    }

    public void getCards() {
        //SETTING UP THE CARDS
        //CHANCE CHEST
        chance[0] = "Advance to Go (Collect $200) ";
        chanceActs[0] = "MSS";
        chanceVals[0] = 200;
        chancePos[0]=36;
        chance[1] = "Bank error in your favor – collect $75 ";
        chanceActs[1] = "$";
        chanceVals[1] = 75;
        chance[2] = "Insurance fees – Pay $150 ";
        chanceActs[2] = "$";
        chanceVals[2] = -150;
        chance[3] = "Met with an accident pay $20 to the hospital";
        chanceActs[3] = "$";
        chanceVals[3] = -20;//0- free jail;
        chance[4] = "Holiday Fund matures - Receive $400";
        chanceActs[4] = "$";
        chanceVals[4] = 400;
        chance[5] = "It is your birthday Collect $60 from each player ";
        chanceActs[5] = "P$";
        chanceVals[5] = 60;
        chance[6] = "Blue Jays opening night – collect $50 from every player for opening night seats ";
        chanceActs[6] = "P$";
        chanceVals[6] = 50;
        chance[7] = "Income Tax refund – collect $200 ";
        chanceActs[7] = "$";
        chanceVals[7] = 200;
        chance[8] = "Life Insurance Matures – collect $150 ";
        chanceActs[8] = "$";
        chanceVals[8] = 150;
        chance[9] = "Pay Hospital Room Fees of $250 ";
        chanceActs[9] = "$";
        chanceVals[9] = -250;
        chance[10] = "Pay University Fees of $100 ";
        chanceActs[10] = "$";
        chanceVals[10] = -100;
        chance[11] = "Receive $75 Consultancy Fee ";
        chanceActs[11] = "$";
        chanceVals[11] = 75;
        chance[12] = "You are assessed for street winter damage – $40 per house, $160 per hotel ";
        chanceActs[12] = "H";
        chanceVals[12] = -40;
        chance[13] = "You have won second prize in a poutine eating contest– collect $25 ";
        chanceActs[13] = "$";
        chanceVals[13] = 25;
        chance[14] = "You inherit $100";
        chanceActs[14] = "$";
        chanceVals[14] = 100;
        chance[15] = "From sale of stock you get $50 ";
        chanceActs[15] = "$";
        chanceVals[15] = 50;
//COMMUNITY CHEST
        comm[0] = "Advance to Go (Collect $200)";
        commActs[0] = "MSS";
        commVals[0] = 200;
        commPos[0]=36;
        comm[1] = "Advance to Windsor";
        commActs[1] = "M";
        commPos[1] = 13;
        comm[2] = "Advance token to CN Tower";
        commActs[2] = "M";
        commPos[2] = 30;
        comm[3] = "Advance token to CNR";
        commActs[3] = "M";
        commPos[3] = 12;
        comm[4] = "Advance to St. John's – if you pass Go, collect $200";
        commActs[4] = "MMS";
        commPos[4] = 19;
        commVals[4]=200;
        comm[5] = "Bank pays you dividend of $50";
        commActs[5] = "$";
        commVals[5] = 50;
        comm[6] = "Car accident- Fine 50$";
        commActs[6] = "$";
        commVals[6] = -50;
        comm[7] = "Go back 3 spaces";
        commActs[7] = "MB";
        commPos[7] = -3;
        comm[8] = "Go directly to Jail – do not pass Go, do not collect $200";
        commActs[8] = "M";
        commVals[8] = 9;
        comm[9] = "Make single repairs on all your property – for each house pay $25 – for each hotel $100";
        commActs[9] = "H";
        commVals[9] = -25;
        comm[10] = "Pay poor tax of $15";
        commActs[10] = "$";
        commVals[10] = -15;
        comm[11] = "Take a trip to Timmies – if you pass Go collect $200";
        commActs[11] = "MMS";
        commVals[11] = 200;
        commPos[11]=3;
        comm[12] = "Take a walk on the Niagara Falls – advance token to Niagara Falls";
        commActs[12] = "M";
        commVals[12] = 15;
        comm[13] = "You have been elected chairman of the board – pay each player $50";
        commActs[13] = "P$";
        commVals[13] = -50;
        comm[14] = "You win a curling tournanment – collect $150";
        commActs[14] = "$";
        commVals[14] = 150;
        comm[15] = "You have won a hockey game - collect $100";
        commActs[15] = "$";
        commVals[15] = 100;
    }
}



