/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

/**
 *
 * @author Harsh
 */
public class Properties_Data {

    public int price, priceHouse, rent1, rent2, rent3, rent4, rentH, colour;
    public boolean owned, buyable;
    public int owner;
    public String thm, desc1, desc2, name;
    ThemeSelect ts = new ThemeSelect();

    public Properties_Data() {
        this.thm = ts.theme;
    }
    Properties_Data prop[] = new Properties_Data[26];

    /*Colour Scheme Codes:
     1:Yellow
     2:Blue
     3:Purple
     4:Green
     5:Red
     6:Orange
     7:Grey
     8:White
     9:Black
     */
    public void setProp() { //TEMPLATE
        //Adding property rents
        //======================================================================
        //YELLOW SUITE----------------------------------------------------------
        //Property 1
        prop[0].price = 60;
        prop[0].rent1 = 10;
        prop[0].rent2 = 30;
        prop[0].rent3 = 90;
        prop[0].rent4 = 160;
        prop[0].rentH = 250;
        prop[0].priceHouse = 50;
        prop[0].colour = 1;
        //Property 2
        prop[1].price = 60;
        prop[1].rent1 = 20;
        prop[1].rent2 = 60;
        prop[1].rent3 = 180;
        prop[1].rent4 = 320;
        prop[1].rentH = 450;
        prop[1].priceHouse = 50;
        prop[1].colour = 1;
        //Property 3
        prop[2].price = 80;
        prop[2].rent1 = 30;
        prop[2].rent2 = 90;
        prop[2].rent3 = 220;
        prop[2].rent4 = 350;
        prop[2].rentH = 500;
        prop[2].priceHouse = 50;
        prop[2].colour = 1;
        //======================================================================
        //BLUE SUITE------------------------------------------------------------
        //Property 4
        prop[3].price = 100;
        prop[3].rent1 = 30;
        prop[3].rent2 = 90;
        prop[3].rent3 = 270;
        prop[3].rent4 = 400;
        prop[3].rentH = 550;
        prop[3].priceHouse = 75;
        prop[3].colour = 2;
        //Property 5
        prop[4].price = 120;
        prop[4].rent1 = 40;
        prop[4].rent2 = 100;
        prop[4].rent3 = 300;
        prop[4].rent4 = 450;
        prop[4].rentH = 600;
        prop[4].priceHouse = 75;
        prop[4].colour = 2;
        //Property 6
        prop[5].price = 120;
        prop[5].rent1 = 40;
        prop[5].rent2 = 100;
        prop[5].rent3 = 260;
        prop[5].rent4 = 420;
        prop[5].rentH = 580;
        prop[5].priceHouse = 75;
        prop[5].colour = 2;
        //======================================================================
        //PURPLE SUITE----------------------------------------------------------
        //Property 7
        prop[6].price = 140;
        prop[6].rent1 = 50;
        prop[6].rent2 = 150;
        prop[6].rent3 = 450;
        prop[6].rent4 = 625;
        prop[6].rentH = 700;
        prop[6].priceHouse = 100;
        prop[6].colour = 3;
        //Property 8
        prop[7].price = 150;
        prop[7].rent1 = 60;
        prop[7].rent2 = 170;
        prop[7].rent3 = 480;
        prop[7].rent4 = 650;
        prop[7].rentH = 750;
        prop[7].priceHouse = 100;
        prop[7].colour = 3;
        //Property 9
        prop[8].price = 180;
        prop[8].rent1 = 80;
        prop[8].rent2 = 180;
        prop[8].rent3 = 500;
        prop[8].rent4 = 680;
        prop[8].rentH = 900;
        prop[8].priceHouse = 100;
        prop[8].colour = 3;
        //======================================================================
        //GREEN SUITE-----------------------------------------------------------
        //Property 10
        prop[9].price = 200;
        prop[9].rent1 = 100;
        prop[9].rent2 = 200;
        prop[9].rent3 = 520;
        prop[9].rent4 = 700;
        prop[9].rentH = 910;
        prop[9].priceHouse = 150;
        prop[9].colour = 4;
        //Property 11
        prop[10].price = 220;
        prop[10].rent1 = 110;
        prop[10].rent2 = 220;
        prop[10].rent3 = 540;
        prop[10].rent4 = 725;
        prop[10].rentH = 925;
        prop[10].priceHouse = 150;
        prop[10].colour = 4;
        //Property 12
        prop[11].price = 220;
        prop[11].rent1 = 110;
        prop[11].rent2 = 220;
        prop[11].rent3 = 540;
        prop[11].rent4 = 725;
        prop[11].rentH = 925;
        prop[11].priceHouse = 150;
        prop[11].colour = 4;
        //Property 13
        prop[12].price = 250;
        prop[12].rent1 = 125;
        prop[12].rent2 = 250;
        prop[12].rent3 = 550;
        prop[12].rent4 = 750;
        prop[12].rentH = 950;
        prop[12].priceHouse = 150;
        prop[12].colour = 4;
        //======================================================================
        //RED SUITE-------------------------------------------------------------
        //Property 14
        prop[13].price = 260;
        prop[13].rent1 = 140;
        prop[13].rent2 = 300;
        prop[13].rent3 = 750;
        prop[13].rent4 = 975;
        prop[13].rentH = 1000;
        prop[13].priceHouse = 200;
        prop[13].colour = 5;
        //Property 15
        prop[14].price = 290;
        prop[14].rent1 = 150;
        prop[14].rent2 = 350;
        prop[14].rent3 = 800;
        prop[14].rent4 = 1000;
        prop[14].rentH = 1100;
        prop[14].priceHouse = 200;
        prop[14].colour = 5;
        //Property 16
        prop[15].price = 290;
        prop[15].rent1 = 150;
        prop[15].rent2 = 350;
        prop[15].rent3 = 800;
        prop[15].rent4 = 1000;
        prop[15].rentH = 1100;
        prop[15].priceHouse = 200;
        prop[15].colour = 5;
        //Property 17
        prop[16].price = 325;
        prop[16].rent1 = 170;
        prop[16].rent2 = 400;
        prop[16].rent3 = 850;
        prop[16].rent4 = 1100;
        prop[16].rentH = 1200;
        prop[16].priceHouse = 200;
        prop[16].colour = 5;
        //======================================================================
        //ORANGE SUITE----------------------------------------------------------
        //Property 18
        prop[17].price = 375;
        prop[17].rent1 = 175;
        prop[17].rent2 = 500;
        prop[17].rent3 = 1100;
        prop[17].rent4 = 1300;
        prop[17].rentH = 1500;
        prop[17].colour = 6;
        prop[17].priceHouse = 300;
        //Property 19
        prop[18].price = 400;
        prop[18].rent1 = 200;
        prop[18].rent2 = 600;
        prop[18].rent3 = 1400;
        prop[18].rent4 = 1700;
        prop[18].rentH = 2000;
        prop[18].priceHouse = 300;
        prop[18].colour = 6;
        //Property 20
        prop[19].price = 500;
        prop[19].rent1 = 250;
        prop[19].rent2 = 750;
        prop[19].rent3 = 1500;
        prop[19].rent4 = 1850;
        prop[19].rentH = 2100;
        prop[19].priceHouse = 300;
        prop[19].colour = 6;
        //======================================================================
        //GREY SUITE------------------------------------------------------------
        //PARLIAMENT HILL
        //Rent = 25x roll, 50x roll if Niagara Falls is owned
        prop[20].price = 375;
        prop[20].colour = 7;
        //NIAGARA FALLS
        //Rent = 25x roll, 50x roll if Parliament is owned
        prop[21].price = 375;
        prop[21].colour = 7;
        //CN TOWER
        //Rent = 25x roll, 50x roll if CNR is owned
        prop[22].price = 375;
        prop[22].colour = 7;
        //CNR
        //Rent = 25x roll, 50x roll if CN Tower is owned
        prop[23].price = 375;
        prop[23].colour = 7;
        //RBC
        //Rent = 25x roll & tax rebate
        prop[24].price = 325;
        prop[24].colour = 7;
        //TIM HORTON'S
        //Rent = 25x roll & +25 rent on all properties
        prop[25].price = 325;
        prop[25].colour = 7;
        //======================================================================
        for (int i = 0; i < 35; i++) {
            prop[i].owner = -1;
            prop[i].owned = false;
            prop[i].buyable = false;
        }
    }

    public void GetProp() {
        this.thm = ts.theme;
        switch (thm) {
            case "Canada": {
                Canada_Data can = new Canada_Data();
                can.setProp();
                for (int i = 0; i < prop.length; i++) {
                    prop[i] = new Properties_Data();
                    prop[i].name = can.property[i].propName;
                    prop[i].price = can.property[i].price;
                    prop[i].rent1 = can.property[i].rent1;
                    prop[i].rent2 = can.property[i].rent2;
                    prop[i].rent3 = can.property[i].rent3;
                    prop[i].rent4 = can.property[i].rent4;
                    prop[i].rentH = can.property[i].rentH;
                    prop[i].colour = can.property[i].colour;
                    prop[i].priceHouse = can.property[i].priceHouse;
                    prop[i].desc1 = can.property[i].desc1;
                    prop[i].desc2 = can.property[i].desc2;
                    prop[i].owner = -1;
                    prop[i].owned = false;
                    prop[i].buyable = false;
//                System.out.println("TEST PROPERTY NAME: " + prop[i].name);//REMOVE AFTER
//                System.out.println(prop[i].price + " " + prop[i].rent1 + " " + prop[i].rent2 + " " + prop[i].rent3 + " " + prop[i].rent4 + " " + prop[i].rentH + " " + prop[i].colour);//REMOVE AFTER
                }
                break;
            }
            case "Generic": {
                Canada_Data can = new Canada_Data();//change to generic
                can.setProp();//same as above
                for (int i = 0; i < prop.length; i++) {
                    prop[i] = new Properties_Data();
                    prop[i].name = can.property[i].propName;
                    prop[i].price = can.property[i].price;
                    prop[i].rent1 = can.property[i].rent1;
                    prop[i].rent2 = can.property[i].rent2;
                    prop[i].rent3 = can.property[i].rent3;
                    prop[i].rent4 = can.property[i].rent4;
                    prop[i].rentH = can.property[i].rentH;
                    prop[i].colour = can.property[i].colour;
                    prop[i].owner = -1;
                    prop[i].owned = false;
                    prop[i].buyable = false;
//                System.out.println("TEST PROPERTY NAME: " + prop[i].name);//REMOVE AFTER
//                System.out.println(prop[i].price + " " + prop[i].rent1 + " " + prop[i].rent2 + " " + prop[i].rent3 + " " + prop[i].rent4 + " " + prop[i].rentH + " " + prop[i].colour);//REMOVE AFTER
                }
                break;
            }
            case "Super": {
                Canada_Data can = new Canada_Data();//Change to super
                can.setProp();//same as above.
                for (int i = 0; i < prop.length; i++) {
                    prop[i] = new Properties_Data();
                    prop[i].name = can.property[i].propName;
                    prop[i].price = can.property[i].price;
                    prop[i].rent1 = can.property[i].rent1;
                    prop[i].rent2 = can.property[i].rent2;
                    prop[i].rent3 = can.property[i].rent3;
                    prop[i].rent4 = can.property[i].rent4;
                    prop[i].rentH = can.property[i].rentH;
                    prop[i].colour = can.property[i].colour;
                    prop[i].owner = -1;
                    prop[i].owned = false;
                    prop[i].buyable = false;
//                System.out.println("TEST PROPERTY NAME: " + prop[i].name);//REMOVE AFTER
//                System.out.println(prop[i].price + " " + prop[i].rent1 + " " + prop[i].rent2 + " " + prop[i].rent3 + " " + prop[i].rent4 + " " + prop[i].rentH + " " + prop[i].colour);//REMOVE AFTER
                }
                break;
            }
            default:
                break;
        }
    }
}
