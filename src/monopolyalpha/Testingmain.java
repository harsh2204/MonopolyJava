/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author karmi
 */
public class Testingmain
  {
    public int rentB, rent1, rent2, rentH, colour;
    public String name;

    Testingmain test[] = new Testingmain[24];

    /**
     * @param args the command line arguments
     */
   public void GetProp(){
       Canada_Data can = new Canada_Data();
       can.setProp();
       for(int i = 0; i<test.length;i++){
           test[i]= new Testingmain();
           test[i].name = can.property[i].propName;
           System.out.println("CANADA DATA ARRAY: "+can.property[i].propName+"          ");
           System.out.print("TEST CLASS ARRAY: "+test[i].name+"         ");
       }
   }
  }
