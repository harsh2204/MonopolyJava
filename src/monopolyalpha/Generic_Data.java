/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import javax.swing.ImageIcon;

/**
 *
 * @author neelm_000
 */
public class Generic_Data {
       
    String propName;
    int price,priceHouse, rent1, rent2, rent3, rent4, rentH, colour;
    public String chance[]= new String[16];
    public String community[]= new String[16];
    public Generic_Data property[] = new Generic_Data[26];
    
    public Generic_Data[] setProp() {
        //Initializing the object array.
        for (int i = 0; i < property.length; i++) {
            property[i] = new Generic_Data();
        }
        //Adding Property names
        //Yellow
        property[0].propName = "Oriental Ave.";//
        property[1].propName = "Vermont Ave.";//
        property[2].propName = "Connecticut Ave.";//
        //Blue
        property[3].propName = "St. Charles Place";//
        property[4].propName = "States Ave.";//
        property[5].propName = "Virginia Ave.";//
        //Purple
        property[6].propName = "St. James Place";//
        property[7].propName = "Tennessee Ave.";//
        property[8].propName = "Pennsylvania Ave.";
        //Green
        property[9].propName = "Kentucky Ave.";//
        property[10].propName = "Indiana Ave.";//
        property[11].propName = "Illinois Ave.";//
        property[12].propName = "Atlantic Ave.";//
        //Red
        property[13].propName = "Ventnor Ave.";//
        property[14].propName = "Marvin Gardens";//
        property[15].propName = "Pacific Ave.";//
        property[16].propName = "North Carolina Ave.";//
        //Orange
        property[17].propName = "New York Ave.";//
        property[18].propName = "Park Place";//
        property[19].propName = "Boardwalk";//
        
       //Special Cards
        property[20].propName = "S.H.I.E.L.D. Headquarters";
        property[21].propName = "Wayne Enterprises";
        property[22].propName = "Stark Tower";
        property[23].propName = "Asgard's Nexus Portal";
        property[24].propName = "The Collector's Hideout";
        property[25].propName = "Arkham Asylum";
        
        
        //Adding property rents
        //======================================================================
        //YELLOW SUITE----------------------------------------------------------
        //ORIENTAL AVE.
        property[0].price = 60;
        property[0].rent1 = 10;
        property[0].rent2 = 30;
        property[0].rent3 = 90;
        property[0].rent4 = 160;
        property[0].rentH = 250;
        property[0].priceHouse=50;
        property[0].colour = 1;
        //VERMONT AVE.
        property[1].price = 60;
        property[1].rent1 = 20;
        property[1].rent2 = 60;
        property[1].rent3 = 180;
        property[1].rent4 = 320;
        property[1].rentH = 450;
        property[1].priceHouse=50;
        property[1].colour = 1;
        //CONNECTICUT AVE.
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
        //ST. CHARLES PLACE
        property[3].price = 100;
        property[3].rent1 = 30;
        property[3].rent2 = 90;
        property[3].rent3 = 270;
        property[3].rent4 = 400;
        property[3].rentH = 550;
        property[3].priceHouse = 75;
        property[3].colour = 2;
        //STATES AVE.
        property[4].price = 120;
        property[4].rent1 = 40;
        property[4].rent2 = 100;
        property[4].rent3 = 300;
        property[4].rent4 = 450;
        property[4].rentH = 600;
        property[4].priceHouse = 75;
        property[4].colour = 2;
        //VIRGINIA AVE.
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
        //ST. JAMES PLACE
        property[6].price = 140;
        property[6].rent1 = 50;
        property[6].rent2 = 150;
        property[6].rent3 = 450;
        property[6].rent4 = 625;
        property[6].rentH = 700;
        property[6].priceHouse = 100;
        property[6].colour = 3;
        //TENNESSEE AVE.
        property[7].price = 150;
        property[7].rent1 = 60;
        property[7].rent2 = 170;
        property[7].rent3 = 480;
        property[7].rent4 = 650;
        property[7].rentH = 750;
        property[7].priceHouse = 100;
        property[7].colour = 3;
        //PENNSYLVANIA AVE.
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
        //KENTUCKY AVE.
        property[9].price = 200;
        property[9].rent1 = 100;
        property[9].rent2 = 200;
        property[9].rent3 = 520;
        property[9].rent4 = 700;
        property[9].rentH = 910;
        property[9].priceHouse = 150;
        property[9].colour = 4;
        //INDIANA AVE.
        property[10].price = 220;
        property[10].rent1 = 110;
        property[10].rent2 = 220;
        property[10].rent3 = 540;
        property[10].rent4 = 725;
        property[10].rentH = 925;
        property[10].priceHouse = 150;
        property[10].colour = 4;
        //ILLINOIS AVE.
        property[11].price = 220;
        property[11].rent1 = 110;
        property[11].rent2 = 220;
        property[11].rent3 = 540;
        property[11].rent4 = 725;
        property[11].rentH = 925;
        property[11].priceHouse = 150;
        property[11].colour = 4;
        //ATLANTIC AVE.
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
        //VENTNOR AVE.
        property[13].price = 260;
        property[13].rent1 = 140;
        property[13].rent2 = 300;
        property[13].rent3 = 750;
        property[13].rent4 = 975;
        property[13].rentH = 1000;
        property[13].priceHouse = 200;
        property[13].colour = 5;
        //MARVIN GARDENS
        property[14].price = 290;
        property[14].rent1 = 150;
        property[14].rent2 = 350;
        property[14].rent3 = 800;
        property[14].rent4 = 1000;
        property[14].rentH = 1100;
        property[14].priceHouse = 200;
        property[14].colour = 5;
        //PACIFIC AVE.
        property[15].price = 290;
        property[15].rent1 = 150;
        property[15].rent2 = 350;
        property[15].rent3 = 800;
        property[15].rent4 = 1000;
        property[15].rentH = 1100;
        property[15].priceHouse = 200;
        property[15].colour = 5;
        //NORTH CAROLINA AVE.
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
        //NEW YORK AVE.
        property[17].price = 375;
        property[17].rent1 = 175;
        property[17].rent2 = 500;
        property[17].rent3 = 1100;
        property[17].rent4 = 1300;
        property[17].rentH = 1500;
        property[17].colour = 6;
        property[17].priceHouse=300;        
        //PARK PLACE
        property[18].price = 400;
        property[18].rent1 = 200;
        property[18].rent2 = 600;
        property[18].rent3 = 1400;
        property[18].rent4 = 1700;
        property[18].rentH = 2000;
        property[18].priceHouse=300;
        property[18].colour = 6;
        //BOARDWALK 
        property[19].price = 500;
        property[19].rent1 = 250;
        property[19].rent2 = 750;
        property[19].rent3 = 1500;
        property[19].rent4 = 1850;
        property[19].rentH = 2100;
        property[19].priceHouse=300;
        property[19].colour = 6;
        //======================================================================
        //GREY SUITE------------------------------------------------------------
        //
        //Rent = 25x roll, 50x roll if owned
        property[20].price = 375;
        property[20].colour = 7;
        //
        //Rent = 25x roll, 50x roll if owned
        property[21].price = 375;
        property[21].colour = 7;
        //
        //Rent = 25x roll, 50x roll if owned
        property[22].price = 375;
        property[22].colour = 7;
        //
        //Rent = 25x roll, 50x roll if owned
        property[23].price = 375;
        property[23].colour = 7;
        //
        //Rent = 25x roll & tax rebate
        property[24].price = 325;
        property[24].colour = 7;
        //
        //Rent = 25x roll & +25 rent on all properties
        property[25].price = 325;
        property[25].colour = 7;
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
