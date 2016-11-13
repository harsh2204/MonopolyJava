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
    
    public int price,priceHouse, rent1, rent2, rent3, rent4, rentH, colour;
    public String name;
    Properties_Data prop[] = new Properties_Data[20];
public void GetProp(){
       Canada_Data can = new Canada_Data();
       can.setProp();
       for(int i = 0; i<prop.length;i++){
           prop[i]= new Properties_Data();
           prop[i].name = can.property[i].propName;
           prop[i].price = can.property[i].price;
           prop[i].rent1 = can.property[i].rent1;
           prop[i].rent2 = can.property[i].rent2;
           prop[i].rent3 = can.property[i].rent3;
           prop[i].rent4 = can.property[i].rent4;
           prop[i].rentH = can.property[i].rentH;
           prop[i].colour = can.property[i].colour;
           System.out.println("TEST PROPERTY NAME: "+prop[i].name);//REMOVE AFTER
           System.out.println(prop[i].price+" "+prop[i].rent1+" "+prop[i].rent2+" "+prop[i].rent3+" "+prop[i].rent4+" "+prop[i].rentH+" "+prop[i].colour);//REMOVE AFTER
       }
   }
}
