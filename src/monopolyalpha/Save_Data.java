/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Color;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Harsh
 */
public class Save_Data {

//    private Board Board = InitTest.Board;
    public int players, dice, chance, roll, turn = 0, count = 0, EGS, counter = 0;
    public String theme;
    public int[] numprop = new int[4], cpos = new int[4], bonus = new int[4],
            jailfee = new int[4], propOwner = new int[36], plChances = new int[4],
            plChancesLeft = new int[4], propMoney = new int[4], totMoney = new int[4],
            propHouse = new int[36];
    public int[] money = new int[4];
    public String[] name = new String[4];
    public String[] iconpaths = new String[4];
    Color[] colorPalette = new Color[4];
    public boolean snake = false, bail = false;
    public boolean[] propOwned = new boolean[36], propBuyable = new boolean[36],
            Game = new boolean[4], housable = new boolean[14], propH = new boolean[36];
    public String log;
    public Save_Data() {      
        this.theme = Board.theme;
        this.players = Board.players;
        this.dice = Board.dice;
        this.chance = Board.chance;
        this.roll = Board.roll;
        this.turn = Board.turn;
        this.count = Board.count;
        this.EGS = Board.EGS;
        this.counter = Board.counter;
        this.numprop = Board.numprop;
        this.cpos = Board.cpos;
        this.bonus = Board.bonus;
        this.jailfee = Board.jailfee;
        this.propOwner = Board.propOwner;
        this.plChances = Board.plChances;
        this.plChancesLeft = Board.plChancesLeft;
        this.propMoney = Board.propMoney;
        this.totMoney = Board.totMoney;
        this.propHouse = Board.propHouse;
        this.money = Board.money;
        this.name = Board.name;
        for (int i = 0; i < iconpaths.length; i++) {
            if (InitTest.board.icon[i] != null) {
                this.iconpaths[i] = Board.icon[i].toString();
            }
        }
        this.log = Board.log;
        this.colorPalette = Board.colorPalette;
        this.snake = Board.snake;
        this.bail = Board.bail;
        this.propOwned = Board.propOwned;
        this.propBuyable = Board.propBuyable;
        this.Game = Board.Game;
        this.housable = Board.housable;
        this.propH = Board.propH;
    }
}
