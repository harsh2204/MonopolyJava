/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

/**
 *
 * @author karmi
 */
public class playerData
  {
    public int numplayers,i;
    public String theme;
    public int[] money,numprop,cpos,npos,bonus,jailfee;
    public String[] icon,name;
    //1D array used so that everything can be called individually
    //Although it might take more time and more code lines it will make it easy in future 
    ThemeSelect ts=new ThemeSelect();
    InitTest it=new InitTest();
    
    public playerData()
      {
        numplayers=it.Players;
        datatransfer();
      }
        
    public void datatransfer()
      {for(i=0;i<=numplayers;i++)
         {
           name[i]=it.player[i][0];
           icon[i]=it.player[i][1];
           money[i]=Integer.parseInt(it.player[i][2]);
           numprop[i]=0;
           bonus[i]=Integer.parseInt(it.player[i][3]);
           jailfee[i]=Integer.parseInt(it.player[i][4]);
           cpos[i]=0;
           
         }
      }
    
  }

