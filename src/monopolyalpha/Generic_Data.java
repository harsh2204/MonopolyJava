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
 * @author neelm_000
 */
public class Generic_Data {
       
    Color purple = new Color(75, 0, 130);
    String propName, desc1, desc2;
    int price,priceHouse, rent1, rent2, rent3, rent4, rentH;
    public String chance[]= new String[16];
    public String community[]= new String[16];
    public Generic_Data property[] = new Generic_Data[36];
    public boolean buyable;
    public Color colour;
    public ImageIcon cardIcon;
    public String type;
    
    public Generic_Data[] setProp() {
        //Initializing the object array.
        for (int i = 0; i < property.length; i++) {
            property[i] = new Generic_Data();
        }
        
        property[0].propName = "Start";
        property[0].buyable = false;
        property[0].type = "ST";
        //======================================================================
        //YELLOW SUITE----------------------------------------------------------
        //BRAMPTON
        property[1].propName = "Oriental Ave.";
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
        property[2].propName = "Vermont Ave.";
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
        property[3].propName = "Special 1";
        property[3].desc1 = "Rent = 25x roll & +25 ";
        property[3].desc2 = "rent on all properties";
        property[3].price = 325;
        property[3].colour = Color.WHITE;
        property[3].buyable = true;
        property[2].type = "STH";

        //YELLOW KNIFE
        property[4].propName = "Connecticut Ave.";
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
        property[7].propName = "St. Charles Place.";
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
        property[8].propName = "States Ave.";
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
        property[10].propName = "Virginia Ave.";
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
        property[11].propName = "St. James Place.";
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
        property[12].propName = "Special";
        property[12].desc1 = "Rent = 25x roll, 50x roll ";
        property[12].desc2 = "if Avengers Base is owned";
        property[12].price = 375;
        property[12].colour = Color.WHITE;
        property[12].buyable = true;
        property[12].type = "S1230";
        //WINDSOR
        property[13].propName = "Tennesse Ave.";
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
        property[14].propName = "Pennsylvania Ave.";
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
        property[15].propName = "Kentucky Ave.";
        property[15].desc1 = "Rent = 25x roll, 50x roll ";
        property[15].desc2 = " if Arkhum Asylum is owned";
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
        property[17].propName = "Indiana Ave.";
        property[17].price = 200;
        property[17].rent1 = 100;
        property[17].rent2 = 200;
        property[17].rent3 = 520;
        property[17].rent4 = 700;
        property[17].rentH = 910;
        property[17].priceHouse = 150;
        property[17].colour = Color.GREEN;
        property[17].buyable = true;
        property[17].cardIcon = new ImageIcon("Board Pictures/Canada/Reg Image.jpg");
        property[17].type = "N";

        property[18].buyable = false;
        property[18].colour = Color.GRAY;
        property[18].type = "FP";
        //ST. JOHN'S
        property[19].propName = "Illinois Ave.";
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
        property[20].propName = "Atlantic Ave.";
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
        property[21].propName="Special";
        property[21].desc1 = "Rent = 25x roll & tax rebate";
        property[21].price = 325;
        property[21].colour = Color.WHITE;
        property[21].buyable = true;
        property[21].type = "SRBC";

        //HALIFAX
        property[22].propName = "Ventnor Ave.";
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
        property[25].propName = "Marvin Gardens";
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
        property[26].propName = "Pacific Ave.";
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
        property[28].propName = "North Carolina Ave.";
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
        property[29].propName = "New York Ave.";
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

        //CN TOWER
        property[30].propName ="Special";  
        property[30].desc1 = "Rent = 25x roll, 50x ";
        property[30].desc2 = "roll if S.H.I.E.L.D. Headquarters is owned";
        property[30].price = 375;
        property[30].colour = Color.WHITE;
        property[30].buyable = true;
        property[30].type = "S1230";

        property[31].buyable = false;
        property[31].colour = Color.GRAY;
        property[31].type = "CO";
        //ORANGE SUITE----------------------------------------------------------
        //VANCOUVER
        property[32].propName = "New York Ave.";
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
        property[33].propName="Special";
        property[33].desc1 = "Rent = 25x roll, 50x roll ";
        property[33].desc2 = " if Watch Tower is owned";
        property[33].price = 375;
        property[33].colour = Color.WHITE;
        property[33].buyable = true;
        property[33].type = "S1533";

        //MONTREAL
        property[34].propName = "Park Place";
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
        property[35].propName = "Boardwalk";
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
        
        return property;
      }
            
    public void getCards(){
        //SETTING UP THE CARDS
        
        
        //CHANCE CHEST
        chance[0]="Advance to Go (Collect $200) ";
        chance[1]="Bank error in your favor – collect $75 ";
        chance[2]="Insurance fees – Pay $50 ";
        chance[3]="Get out of jail free – this card may be kept until needed, or sold ";
        chance[4]="Holiday Fund matures - Receive $100";
        chance[5]="It is your birthday Collect $10 from each player ";
        chance[6]="Blue Jays opening night – collect $50 from every player for opening night seats ";
        chance[7]="Income Tax refund – collect $20 ";
        chance[8]="Life Insurance Matures – collect $100 ";
        chance[9]="Pay Hospital Room Fees of $100 ";
        chance[10]="Pay University Fees of $50 ";
        chance[11]="Receive $25 Consultancy Fee ";
        chance[12]="You are assessed for street winter damage – $40 per house, $115 per hotel ";
        chance[13]="You have won second prize in a poutine eating contest– collect $10 ";
        chance[14]="You inherit $100";
        chance[15]="From sale of stock you get $50 ";
        
        
        //COMMUNITY CHEST
        community[0]="Advance to Go (Collect $200)";
        community[1]="Advance to Windsor";
        community[2]="Advance token to CN Tower";
        community[3]="Advance token to CNR";
        community[4]="Advance to St. John's – if you pass Go, collect $200";
        community[5]="Bank pays you dividend of $50";
        community[6]="Get out of Jail free – this card may be kept until needed, or traded/sold";
        community[7]="Go back 3 spaces";
        community[8]="Go directly to Jail – do not pass Go, do not collect $200";
        community[9]="Make shingle repairs on all your property – for each house pay $25 – for each hotel $100";
        community[10]="Pay poor tax of $15";
        community[11]="Take a trip to Timmies – if you pass Go collect $200";
        community[12]="Take a walk on the Niagara Falls – advance token to Niagara Falls";
        community[13]="You have been elected chairman of the board – pay each player $50";
        community[14]="You win a curling tournanment – collect $150";
        community[15]="You have won a hockey game - collect $100";
    }
    
}
