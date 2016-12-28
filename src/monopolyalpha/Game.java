/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Harsh
 */
public class Game {

  static String theme;
  static  Board bboard;
  static  Players players = new Players();
  static  InitTest it = new InitTest();
  static  Properties_Data properties;
    public static int playerCount, startCash, di, EGS, snakeAmt, jailFee, roll, turn = 0, totturn = 0;    
  static  Timer tmr;
  static  int b, pp1 = 1, pp2 = 1, pp3 = 1, pp4 = 1;
  static  String[][] pl;
    boolean snake = false, bail = false;

    public Game(String[][] players, int iniCash, int pCount, int dice, int EGSs, boolean snk, boolean jail, int snkAmt, int jailFee, String thm) {
        this.theme = thm;
        System.out.println(theme);
        pl = new String[players.length][];
        this.playerCount = pCount;
        this.startCash = iniCash;
        this.di = dice;
        this.EGS = EGSs;
        if (snk) {
            this.snake = true;
            this.snakeAmt = snkAmt;
        }
        if (jail) {
            this.bail = true;
            this.jailFee = jailFee;
        }
        for (int i = 0; i < players.length; i++) {
            pl[i] = players[i].clone();
        }
        properties = new Properties_Data(theme);
        addPlayers();
        boardSetup();       
    }
    public Game(){
        //ASDF EMPTY CONSTRUCTION JSUT BCUZSD IN EED IT
    }

    public void Start() {
//        for (int i = 0; i < playerCount; i++) {
//            System.out.println(players.peeps[i].ID);
//            System.out.print("  "+players.peeps[i].name);
//            System.out.print("  "+players.peeps[i].cash);
//            System.out.println(players.peeps[i].icon);
//            System.out.println(players.peeps[i].pos);
//        }        

    }
    public static void roll(){
 
         roll = Dice.rollDice(theme, di);
        turn++;
        totturn++;
        switch (playerCount) {
            case 2:
                if (turn == 3) {
                    turn = turn - 2;
                }
                Board.moveTo(turn, roll);
                break;
            case 3:
                if (turn == 4) {
                    turn = turn - 3;
                }
                Board.moveTo(turn, roll);
                break;
            case 4:
                if (turn == 5) {
                    turn = turn - 4;
                }
                Board.moveTo(turn, roll);
                break;
        }

    }
    public void boardSetup(){
        bboard = new Board();
        bboard.setupPlayers();
        bboard.setupLabels();                
        bboard.setVisible(true);
        players.makePieces();
    }
    
    
    public void addPlayers() {
        players.setupPeeps(playerCount);
        for (int i = 0; i < playerCount; i++) {  
            Players.peeps[i].ID = i;
            Players.peeps[i].cash = startCash;
            Players.peeps[i].name = pl[i][0];
            Players.peeps[i].icon = new ImageIcon(pl[i][1]);
            Players.peeps[i].pos = 0;
            Players.peeps[i].propNum = 0;
//            System.out.println(Players.peeps[i].name);
        }
    }
}
