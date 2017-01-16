/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author karmi
 */
public class jackpotMoney
  {

    public ArrayList JackMoney = new ArrayList();
    public int i;

    public jackpotMoney()
      {
        for (i = 0; i < 91; i++)
          {
            JackMoney.add(i * 2);
          }
        JackMoney.add(800);
        JackMoney.add(900);
        JackMoney.add(1000);
        JackMoney.add(2300);
        JackMoney.add(2400);
        JackMoney.add(2500);
        JackMoney.add(3000);
        JackMoney.add(3000);
        JackMoney.add(10000);
      }

    public int Jack()
      {
        Collections.shuffle(JackMoney);
        return (int) JackMoney.get(0);
      }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {

      }

  }
