/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

/**
 *
 * @author Karmit, Harsh
 */
public class playerData
  {

    public int numplayers, i,dice,chance;
    public String theme;
    public int[] money, numprop, cpos,/*what is this? >*/ npos,/*move bonus and jailfee to game class*/ bonus, jailfee;
    public String[] icon, name;
    //1D array used so that everything can be called individually
    //Although it might take more time and more code lines it will make it easy in future 
    ThemeSelect ts = new ThemeSelect();
    InitTest it = new InitTest();
    Dice di = new Dice();

    public playerData()
      {
        numplayers = it.pCount;
        datatransfer();//call this under Game class where we setup the players
        //Player position will be sent by the game class to this when the roll happens
        //playermovement();
      }

    public void datatransfer(){
        for (i = 0; i <= numplayers; i++)
          {
            name[i] = it.player[i][0];
            icon[i] = it.player[i][1];
            money[i] = Integer.parseInt(it.player[i][2]);
            numprop[i] = 0;
            bonus[i] = Integer.parseInt(it.player[i][3]);
            jailfee[i] = Integer.parseInt(it.player[i][4]);
            cpos[i] = 0;
          }
      }
    
//    public void playermovement(){//Dont think we need it here as we will use it in the game class.
//        dice= Dice.roll;//Please Add a variable which stores the roll in the dice class
//        chance=Board.chance; //This is a variable in Board which Kiska chance hai woh and this variable would be used as array index in everything
//        //If u dont get this part message me on FB
//        
//      }

  }
