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

    public int rentB, rent1, rent2, rentH, colour;
    public String name;
    Properties_Data prop[] = new Properties_Data[20];
public void GetProp(){
       Canada_Data can = new Canada_Data();
       can.setProp();
       for(int i = 0; i<prop.length;i++){
           prop[i]= new Properties_Data();
           prop[i].name = can.property[i].propName;
           System.out.print("CANADA DATA NAME: "+can.property[i].propName+"          ");
           System.out.println("TEST CLASS NAME: "+prop[i].name);
       }
   }
}
