/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.io.Serializable;


/**
 *
 * @author Harsh
 */
public class Save_Data  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public int playerCount;
    public String player1;
    public String player2;
    public String player3;
    public String player4;
    public double cash1;
    public double cash2;
    public double cash3;
    public double cash4;
}
