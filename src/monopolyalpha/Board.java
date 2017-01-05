/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Harsh Gupta, Karmit Patel
 */
public final class Board extends javax.swing.JFrame
  {

    /**
     * Creates new form Board
     */
    public static int players, i, dice, chance, roll, turn = 0, count = 0, EGS, counter = 0;
    public static String theme;
    public static int[] money = new int[4], numprop = new int[4], cpos = new int[4], npos = new int[4], bonus = new int[4], jailfee = new int[4], propOwner = new int[36], propPrice = new int[36], propRent = new int[36], plChances = new int[4], plChancesLeft = new int[4], propMoney = new int[4], totMoney = new int[4], propHouse = new int[36];
    public String[] name = new String[4], propName = new String[36], propType = new String[36];
    public ThemeSelect ts = new ThemeSelect();
    public InitTest it = new InitTest();
    public Dice di = new Dice();
    public Properties_Data pd = new Properties_Data();
    Color transparent50 = new Color(0, 0, 0, 64);
    Color[] colorPalette = new Color[4];
    public static ImageIcon piece;
    SimpleAttributeSet[] keyWord = new SimpleAttributeSet[5];
    public static ImageIcon[] icons = new ImageIcon[100], icon = new ImageIcon[4], houseImg = new ImageIcon[5];
    public static boolean snake = false, bail = false, hover = true;
    public static boolean[] propOwned = new boolean[36], propBuyable = new boolean[36], Game = new boolean[4], housable = new boolean[14], propH = new boolean[36];
    public static JLabel[][] boxes = new JLabel[4][37];
    public JPanel[] boxPanes = new JPanel[36];
    public static JLabel[] plnames = new JLabel[4], plicons = new JLabel[4], plmoney = new JLabel[4], houses = new JLabel[36];
    Card c;
    public JButton[] plHouse = new JButton[4];
    public static Image image;
    public static Timer moveTimer, timer;
    Canada_Data cd = new Canada_Data();
    SuperHero_Data sd = new SuperHero_Data();
    Generic_Data gd = new Generic_Data();

    public Board(int playerCount)
      {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.players = playerCount;
        datatransfer();
        propDataTransfer();
        setupData();
        System.out.println("Board: Number of pCount: " + players);
//        setPlayernumber();
        setupLabels();
        setupplabels();
        changeimages();
        addpCount();
        displayChange(turn);
        setupHouses();
        addWindowListener(new WindowAdapter()
          {

            @Override
            public void windowClosing(WindowEvent we)
              {
                String ObjButtons[]
                        =
                          {
                            "Yes", "No", "Save"
                          };
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Are you sure you want to exit?", "Monopoly Java",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[2]);
                if (PromptResult == 0)
                  {
                    System.exit(0);
                  }
                if (PromptResult == 2)
                  {
                    new Save_Manager().setVisible(true);
                  }
              }
          });
      }

    public void propDataTransfer()
      {
        pd.GetProp();
        for (i = 0; i < 36; i++)
          {
            propName[i] = pd.prop[i].name;
            propPrice[i] = pd.prop[i].price;
            propRent[i] = pd.prop[i].rent1;
            propOwned[i] = pd.prop[i].owned;
            propOwner[i] = pd.prop[i].owner;
            propBuyable[i] = pd.prop[i].buyable;
            propType[i] = pd.prop[i].type;
          }
//        propOwned[1]=true;
//        propOwned[2]=true;
//        propOwned[4]=true;
//        propOwner[1]=2;
//        propOwner[2]=2;
//        propOwner[4]=2;
      }

    public void changeimages()
      {
        //Seting up colors for user names        
        for (int i = 0; i < 4; i++)
          {
            Random random = new Random();
            float hue = random.nextFloat(); // Saturation between 0.1 and 0.3 
            float saturation = (random.nextInt(4000) + 2000) / 10000f;
            float luminance = 0.9f;
            Color color = Color.getHSBColor(hue, saturation, luminance);
            colorPalette[i] = color;
            System.out.println(color);
          }
        for (i = 0; i < players; i++)
          {
            image = icon[i].getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            icons[i] = new ImageIcon(image);
            plnames[i].setOpaque(true);
            plnames[i].setBackground(colorPalette[i]);
          }
        System.out.println("Board: Image Changed!");
      }

    public void setupplabels()
      {
        plnames[0] = lblNameP1;
        plnames[1] = lblNameP2;
        plicons[0] = lblIconP1;
        plicons[1] = lblIconP2;
        plmoney[0] = lblMoneyP1;
        plmoney[1] = lblMoneyP2;
        plnames[2] = lblNameP3;
        plnames[3] = lblNameP4;
        plicons[2] = lblIconP3;
        plicons[3] = lblIconP4;
        plmoney[2] = lblMoneyP3;
        plmoney[3] = lblMoneyP4;
        System.out.println("Board: Labels setup done!");
      }

    public void setupHouses()
      {
        for (i = 0; i < boxPanes.length; i++)
          {
            houses[i] = new JLabel();
            if (propBuyable[i])
              {
                if ("N".equals(propType[i]))
                  {
                    if (i > 0 && i < 10)
                      {
//                        houses[i].setOpaque(false);
                        houses[i].setSize(20, 20);
//                    houses[i].setBorder(new LineBorder(Color.BLACK,2));
                        houses[i].setLocation(new Point(boxPanes[i].getLocation().x + boxPanes[i].getWidth() + 7, boxPanes[i].getLocation().y));
                        paneBoard.add(houses[i]);
                        houses[i].setIcon(houseImg[propHouse[i]]);
//                        houses[i].setIcon(new ImageIcon("Icons/Miscellaneous/Property Icons/Pink.png"));
                      }
                    if (i > 9 && i < 19)
                      {
//                        houses[i].setOpaque(false);
                        houses[i].setSize(20, 20);
//                    houses[i].setBorder(new LineBorder(Color.BLACK,2));
                        houses[i].setLocation(new Point(boxPanes[i].getLocation().x + 2, boxPanes[i].getLocation().y + boxPanes[i].getHeight() + 14));
                        paneBoard.add(houses[i]);
                        houses[i].setIcon(houseImg[propHouse[i]]);
//                        houses[i].setIcon(new ImageIcon("Icons/Miscellaneous/Property Icons/Brown.png"));
                      }
                    if (i > 18 && i < 28)
                      {
//                        houses[i].setOpaque(false);
                        houses[i].setSize(20, 20);
//                    houses[i].setBorder(new LineBorder(Color.BLACK,2));
                        houses[i].setLocation(new Point(boxPanes[i].getLocation().x - 25, boxPanes[i].getLocation().y));
                        paneBoard.add(houses[i]);
                        houses[i].setIcon(houseImg[propHouse[i]]);
//                        houses[i].setIcon(new ImageIcon("Icons/Miscellaneous/Property Icons/Grey.png"));
                      }
                    if (i > 27 && i <= 35)
                      {
//                        houses[i].setOpaque(false);
                        houses[i].setSize(20, 20);
//                    houses[i].setBorder(new LineBorder(Color.BLACK,2));
                        houses[i].setLocation(new Point(boxPanes[i].getLocation().x + 2, boxPanes[i].getLocation().y - 35));
                        paneBoard.add(houses[i]);
                        houses[i].setIcon(houseImg[propHouse[i]]);
//                        houses[i].setIcon(new ImageIcon("Icons/Miscellaneous/Property Icons/Hotel.png"));
                      }
                  }
              }
            paneBoard.validate();
            paneBoard.repaint();
          }
//        for (JLabel house : houses)
//          {
//            house.setVisible(false);
//          }
      }

    public void setupData()
      {
        int chances = 0;
        switch (EGS)
          {
            case 0:
                chances = 36345;
                break;
            case 1:
                chances = 45;
                break;
            case 2:
                chances = 60;
                break;
            case 3:
                chances = 75;
                break;
          }

        plHouse[0] = btnHouseP1;
        plHouse[1] = btnHouseP2;
        plHouse[2] = btnHouseP3;
        plHouse[3] = btnHouseP4;
        plHouse[0].setVisible(false);
        plHouse[1].setVisible(false);
        plHouse[2].setVisible(false);
        plHouse[3].setVisible(false);
        for (i = 0; i < players; i++)
          {
            plHouse[i].setVisible(true);
            plHouse[i].setEnabled(false);
            plHouse[i].addActionListener(new ActionListener()
              {
                @Override
                public void actionPerformed(ActionEvent e)
                  {
                    new HouseFrm(propOwner, propH, turn, propHouse).setVisible(true);
                  }
              });
            propMoney[i] = 0;
            totMoney[i] = 0;
            Game[i] = true;
            plChancesLeft[i] = chances;
            plChances[i] = 100;
            numprop[i] = 0;
            cpos[i] = 0;
            npos[i] = 0;
            System.out.println("Board: Info:-" + i + " " + name[i] + " " + icon[i] + " " + money[i]);
          }
        System.out.println("Board: Data Transfered!");
        for (i = 0; i < 36; i++)
          {
            propHouse[i] = 0;
            propH[i] = false;
          }

        for (i = 0; i < 14; i++)
          {
            housable[i] = false;
          }

        houseImg[0] = null;
        houseImg[1] = new ImageIcon("Icons/Miscellaneous/Property Icons/Pink.png");
        houseImg[2] = new ImageIcon("Icons/Miscellaneous/Property Icons/Brown.png");
        houseImg[3] = new ImageIcon("Icons/Miscellaneous/Property Icons/Grey.png");
        houseImg[4] = new ImageIcon("Icons/Miscellaneous/Property Icons/Hotel.png");

      }

    public void datatransfer()
      {
//        it.setplayers();
//        this.players=it.sldPlayer.getValue();
//        this.players = it.pCount;  //This is the only errror it takes 2 as default value instead of "pCount" from Init Test Fix it if u can
        this.name = it.name;
        this.icon = it.icon;
        this.money = it.startm;
        this.bonus = it.bonusm;
        this.jailfee = it.jailfeem;
        this.dice = it.dicenum;
        this.EGS = it.EGS;

      }

    private void setupLabels()
      {
        //1
        boxes[0][0] = P1B1;
        boxes[0][1] = P1B2;
        boxes[0][2] = P1B3;
        boxes[0][3] = P1B4;
        boxes[0][4] = P1B5;
        boxes[0][5] = P1B6;
        boxes[0][6] = P1B7;
        boxes[0][7] = P1B8;
        boxes[0][8] = P1B9;
        boxes[0][9] = P1B10;
        boxes[0][10] = P1B11;
        boxes[0][11] = P1B12;
        boxes[0][12] = P1B13;
        boxes[0][13] = P1B14;
        boxes[0][14] = P1B15;
        boxes[0][15] = P1B16;
        boxes[0][16] = P1B17;
        boxes[0][17] = P1B18;
        boxes[0][18] = P1B19;
        boxes[0][19] = P1B20;
        boxes[0][20] = P1B21;
        boxes[0][21] = P1B22;
        boxes[0][22] = P1B23;
        boxes[0][23] = P1B24;
        boxes[0][24] = P1B25;
        boxes[0][25] = P1B26;
        boxes[0][26] = P1B27;
        boxes[0][27] = P1B28;
        boxes[0][28] = P1B29;
        boxes[0][29] = P1B30;
        boxes[0][30] = P1B31;
        boxes[0][31] = P1B32;
        boxes[0][32] = P1B33;
        boxes[0][33] = P1B34;
        boxes[0][34] = P1B35;
        boxes[0][35] = P1B36;
        //2
        boxes[1][0] = P2B1;
        boxes[1][1] = P2B2;
        boxes[1][2] = P2B3;
        boxes[1][3] = P2B4;
        boxes[1][4] = P2B5;
        boxes[1][5] = P2B6;
        boxes[1][6] = P2B7;
        boxes[1][7] = P2B8;
        boxes[1][8] = P2B9;
        boxes[1][9] = P2B10;
        boxes[1][10] = P2B11;
        boxes[1][11] = P2B12;
        boxes[1][12] = P2B13;
        boxes[1][13] = P2B14;
        boxes[1][14] = P2B15;
        boxes[1][15] = P2B16;
        boxes[1][16] = P2B17;
        boxes[1][17] = P2B18;
        boxes[1][18] = P2B19;
        boxes[1][19] = P2B20;
        boxes[1][20] = P2B21;
        boxes[1][21] = P2B22;
        boxes[1][22] = P2B23;
        boxes[1][23] = P2B24;
        boxes[1][24] = P2B25;
        boxes[1][25] = P2B26;
        boxes[1][26] = P2B27;
        boxes[1][27] = P2B28;
        boxes[1][28] = P2B29;
        boxes[1][29] = P2B30;
        boxes[1][30] = P2B31;
        boxes[1][31] = P2B32;
        boxes[1][32] = P2B33;
        boxes[1][33] = P2B34;
        boxes[1][34] = P2B35;
        boxes[1][35] = P2B36;
        //3
        boxes[2][0] = P3B1;
        boxes[2][1] = P3B2;
        boxes[2][2] = P3B3;
        boxes[2][3] = P3B4;
        boxes[2][4] = P3B5;
        boxes[2][5] = P3B6;
        boxes[2][6] = P3B7;
        boxes[2][7] = P3B8;
        boxes[2][8] = P3B9;
        boxes[2][9] = P3B10;
        boxes[2][10] = P3B11;
        boxes[2][11] = P3B12;
        boxes[2][12] = P3B13;
        boxes[2][13] = P3B14;
        boxes[2][14] = P3B15;
        boxes[2][15] = P3B16;
        boxes[2][16] = P3B17;
        boxes[2][17] = P3B18;
        boxes[2][18] = P3B19;
        boxes[2][19] = P3B20;
        boxes[2][20] = P3B21;
        boxes[2][21] = P3B22;
        boxes[2][22] = P3B23;
        boxes[2][23] = P3B24;
        boxes[2][24] = P3B25;
        boxes[2][25] = P3B26;
        boxes[2][26] = P3B27;
        boxes[2][27] = P3B28;
        boxes[2][28] = P3B29;
        boxes[2][29] = P3B30;
        boxes[2][30] = P3B31;
        boxes[2][31] = P3B32;
        boxes[2][32] = P3B33;
        boxes[2][33] = P3B34;
        boxes[2][34] = P3B35;
        boxes[2][35] = P3B36;
        //4
        boxes[3][0] = P4B1;
        boxes[3][1] = P4B2;
        boxes[3][2] = P4B3;
        boxes[3][3] = P4B4;
        boxes[3][4] = P4B5;
        boxes[3][5] = P4B6;
        boxes[3][6] = P4B7;
        boxes[3][7] = P4B8;
        boxes[3][8] = P4B9;
        boxes[3][9] = P4B10;
        boxes[3][10] = P4B11;
        boxes[3][11] = P4B12;
        boxes[3][12] = P4B13;
        boxes[3][13] = P4B14;
        boxes[3][14] = P4B15;
        boxes[3][15] = P4B16;
        boxes[3][16] = P4B17;
        boxes[3][17] = P4B18;
        boxes[3][18] = P4B19;
        boxes[3][19] = P4B20;
        boxes[3][20] = P4B21;
        boxes[3][21] = P4B22;
        boxes[3][22] = P4B23;
        boxes[3][23] = P4B24;
        boxes[3][24] = P4B25;
        boxes[3][25] = P4B26;
        boxes[3][26] = P4B27;
        boxes[3][27] = P4B28;
        boxes[3][28] = P4B29;
        boxes[3][29] = P4B30;
        boxes[3][30] = P4B31;
        boxes[3][31] = P4B32;
        boxes[3][32] = P4B33;
        boxes[3][33] = P4B34;
        boxes[3][34] = P4B35;
        boxes[3][35] = P4B36;

        //Jpanels now
        boxPanes[0] = paneB1;
        boxPanes[1] = paneB2;
        boxPanes[2] = paneB3;
        boxPanes[3] = paneB4;
        boxPanes[4] = paneB5;
        boxPanes[5] = paneB6;
        boxPanes[6] = paneB7;
        boxPanes[7] = paneB8;
        boxPanes[8] = paneB9;
        boxPanes[9] = paneB10;
        boxPanes[10] = paneB11;
        boxPanes[11] = paneB12;
        boxPanes[12] = paneB13;
        boxPanes[13] = paneB14;
        boxPanes[14] = paneB15;
        boxPanes[15] = paneB16;
        boxPanes[16] = paneB17;
        boxPanes[17] = paneB18;
        boxPanes[18] = paneB19;
        boxPanes[19] = paneB20;
        boxPanes[20] = paneB21;
        boxPanes[21] = paneB22;
        boxPanes[22] = paneB23;
        boxPanes[23] = paneB24;
        boxPanes[24] = paneB25;
        boxPanes[25] = paneB26;
        boxPanes[26] = paneB27;
        boxPanes[27] = paneB28;
        boxPanes[28] = paneB29;
        boxPanes[29] = paneB30;
        boxPanes[30] = paneB31;
        boxPanes[31] = paneB32;
        boxPanes[32] = paneB33;
        boxPanes[33] = paneB34;
        boxPanes[34] = paneB35;
        boxPanes[35] = paneB36;
//        for (int i = 0; i < 4; i++) {
//            for (int k = 0; k < 36; k++) {
//               boxes[i][k].setIcon(new ImageIcon("Icons/Pieces/Canada/1.png"));
//            }
//        }
      }

    public Color moreSat(Color c)
      {
        float[] hsbvals = new float[3];
        hsbvals = c.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
//        for(int i =0;i<hsbvals.length;i++){
//            System.out.println("hsb"+i+hsbvals[i]);
//        }
        hsbvals[1] *= 2;
        hsbvals[2] *= 0.9;
//        hsbvals[2]*=1.1;
        return Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]);
      }

    public void addpCount()
      {
        for (i = 0; i < players; i++)
          {
            plnames[i].setText("" + name[i]);
            plicons[i].setIcon(icon[i]);
            plmoney[i].setText("$" + Integer.toString(money[i]));
            boxes[i][cpos[i]].setIcon(icons[i]);
          }
        for (int i = 0; i < keyWord.length; i++)
          {
            keyWord[i] = new SimpleAttributeSet();
          }
        paneP1.setVisible(true);
        paneP2.setVisible(true);
        StyleConstants.setForeground(keyWord[0], moreSat(colorPalette[0]));
        StyleConstants.setForeground(keyWord[1], moreSat(colorPalette[1]));
        StyleConstants.setForeground(keyWord[2], moreSat(colorPalette[2]));
        StyleConstants.setForeground(keyWord[3], moreSat(colorPalette[3]));
        StyleConstants.setForeground(keyWord[4], Color.BLACK);
        System.out.println("Board: pCount Added!");
      }

    public void makeCard(int index)
      {

        //System.out.println("Board- Colour:" + bg + "Index: " + index);
        c = new Card(pd.prop[index].colour, pd.prop[index].cardIcon, index, pd);
        c.setVisible(true);
      }

    public void breakCard()
      {
        c.setVisible(false);
      }

    public void appendS(String s, int playerID)
      {
        try
          {
            StyledDocument doc = txtLog.getStyledDocument();
            doc.insertString(doc.getLength(), s, keyWord[playerID]);
          } catch (BadLocationException exc)
          {
            exc.printStackTrace();
          }
      }

    public void addLog(String s)
      {
        appendS(s + "\n", 4);

      }

    public void move(final int turnn)
      {
        npos[turnn] = cpos[turnn] + roll;
        System.out.println("Board:: Roll:" + roll + " Turn:" + turn + " CPos:" + cpos[turnn]);
        //addLog("Roll: " + roll + " New Position: " + npos[turnn] + " Current Position: " + cpos[turnn] + " Turn: " + turnn);
        if (npos[turnn] > 35)
          {
            npos[turnn] = npos[turnn] - 35;
          }
        count = 0;
        moveTimer = new Timer(500, new ActionListener()
          {
            @Override
            public void actionPerformed(ActionEvent e)
              {
                btnRoll.setEnabled(false);
                count++;
                cpos[turnn]++;
                if (cpos[turnn] > 35)
                  {
                    money[turnn] += 200;
                    displayChangeRE();
                    appendS(name[turnn], turnn);
                    addLog(" just collected $200 for passing Go");
                    cpos[turnn] = 0;
                    boxes[turnn][cpos[turnn]].setIcon(icons[turnn]);
                    boxes[turnn][35].setIcon(null);

                  } else
                  {
                    System.out.println("Current Position: " + cpos[turnn]);
                    boxes[turnn][cpos[turnn]].setIcon(icons[turnn]);
                    boxes[turnn][cpos[turnn] - 1].setIcon(null);
                  }
                if (count == roll)
                  {
                    moveTimer.stop();
                    propcall(cpos, turnn, roll);
                  }
              }
          });
        moveTimer.start();
      }

    public void Goto(int npos, int[] cpos, int turn, int roll)
      {
        if (npos == 36)
          {
            npos = 0;
          }
        boxes[turn][cpos[turn]].setIcon(null);
        boxes[turn][npos].setIcon(icons[turn]);
        cpos[turn] = npos;
        propcall(cpos, turn, roll);
      }

    public void enableNext()
      {
        btnNext.setEnabled(true);
      }

    public void propcall(int[] cpos, int turn, int roll)
      {
        if (propBuyable[cpos[turn]] == true)
          {
            if (propOwned[cpos[turn]] == true)
              {
                int pOwner = propOwner[cpos[turn]];
                if (pOwner != turn)
                  {
                    propOwnedCheck(pOwner, turn, cpos);
                  }
              } else
              {
                btnReBuy.setEnabled(true);
                BuyScreen buy = new BuyScreen(new Card(pd.prop[cpos[turn]].colour, pd.prop[cpos[turn]].cardIcon, cpos[turn], pd));
                buy.setVisible(true);
              }
          } else
          {
            btnReBuy.setEnabled(false);
            System.out.println("Board:: Turn:" + turn + " CPos:" + cpos[turn] + " Buyable:" + propBuyable[cpos[turn]]);
            propNBCheck(turn, cpos, roll);
          }
        enableNext();
        plChancesLeft[turn]--;
        plChances[turn]--;
        houseCheck(cpos, turn);
        plHouseCheck(turn);
        hover = true;
        if (plChancesLeft[turn] <= 0)
          {
            gameOver(turn);
          }
        if (money[turn] >= 0)
          {
//            sellShit(turn);//A method or fram to be made to sell properties if money on hand is 0 or less than 0
          }
        if (totMoney[turn] == 0)
          {
            gameOver(turn);
          }
      }

    public void houseCheck(int[] cpos, int turn)
      {
        if (propOwned[1] == true && propOwned[2] == true && propOwned[4] == true)
          {
            if (propOwner[1] == propOwner[2] && propOwner[2] == propOwner[4])
              {
                housable[0] = true;
                propH[1] = true;
                propH[2] = true;
                propH[4] = true;
              }
          }
        if (propOwned[7] == true && propOwned[8] == true && propOwned[10] == true)
          {
            if (propOwner[7] == propOwner[8] && propOwner[8] == propOwner[10])
              {
                housable[1] = true;
                propH[7] = true;
                propH[8] = true;
                propH[10] = true;
              }
          }
        if (propOwned[11] == true && propOwned[13] == true && propOwned[14] == true)
          {
            if (propOwner[11] == propOwner[13] && propOwner[13] == propOwner[14])
              {
                housable[2] = true;
                propH[11] = true;
                propH[13] = true;
                propH[14] = true;
              }
          }
        if (propOwned[17] == true && propOwned[19] == true && propOwned[20] == true)
          {
            if (propOwner[17] == propOwner[19] && propOwner[19] == propOwner[20])
              {
                housable[3] = true;
                propH[17] = true;
                propH[19] = true;
                propH[20] = true;
              }
          }
        if (propOwned[17] == true && propOwned[19] == true && propOwned[22] == true)
          {
            if (propOwner[17] == propOwner[19] && propOwner[19] == propOwner[22])
              {
                housable[4] = true;
                propH[17] = true;
                propH[19] = true;
                propH[22] = true;
              }
          }
        if (propOwned[17] == true && propOwned[20] == true && propOwned[22] == true)
          {
            if (propOwner[17] == propOwner[2] && propOwner[20] == propOwner[22])
              {
                housable[5] = true;
                propH[17] = true;
                propH[20] = true;
                propH[22] = true;
              }
          }
        if (propOwned[19] == true && propOwned[20] == true && propOwned[22] == true)
          {
            if (propOwner[19] == propOwner[20] && propOwner[20] == propOwner[22])
              {
                housable[6] = true;
                propH[19] = true;
                propH[20] = true;
                propH[22] = true;
              }
          }
        if (propOwned[25] == true && propOwned[26] == true && propOwned[28] == true)
          {
            if (propOwner[25] == propOwner[26] && propOwner[26] == propOwner[28])
              {
                housable[7] = true;
                propH[25] = true;
                propH[26] = true;
                propH[28] = true;
              }
          }
        if (propOwned[25] == true && propOwned[26] == true && propOwned[29] == true)
          {
            if (propOwner[25] == propOwner[26] && propOwner[26] == propOwner[29])
              {
                housable[8] = true;
                propH[25] = true;
                propH[26] = true;
                propH[29] = true;
              }
          }
        if (propOwned[25] == true && propOwned[28] == true && propOwned[29] == true)
          {
            if (propOwner[25] == propOwner[28] && propOwner[28] == propOwner[29])
              {
                housable[9] = true;
                propH[25] = true;
                propH[28] = true;
                propH[29] = true;
              }
          }
        if (propOwned[26] == true && propOwned[28] == true && propOwned[29] == true)
          {
            if (propOwner[26] == propOwner[28] && propOwner[28] == propOwner[29])
              {
                housable[10] = true;
                propH[26] = true;
                propH[28] = true;
                propH[29] = true;
              }
          }
        if (propOwned[26] == true && propOwned[25] == true && propOwned[28] == true && propOwned[29] == true)
          {
            if (propOwner[26] == propOwner[25] && propOwner[25] == propOwner[28] && propOwner[28] == propOwner[29])
              {
                housable[12] = true;
                propH[26] = true;
                propH[25] = true;
                propH[28] = true;
                propH[29] = true;
              }
          }
        if (propOwned[17] == true && propOwned[19] == true && propOwned[20] == true && propOwned[22] == true)
          {
            if (propOwner[17] == propOwner[19] && propOwner[19] == propOwner[20] && propOwner[20] == propOwner[22])
              {
                housable[13] = true;
                propH[17] = true;
                propH[19] = true;
                propH[20] = true;
                propH[22] = true;
              }
          }
        if (propOwned[32] == true && propOwned[34] == true && propOwned[35] == true)
          {
            if (propOwner[32] == propOwner[34] && propOwner[34] == propOwner[35])
              {
                housable[11] = true;
                propH[32] = true;
                propH[34] = true;
                propH[35] = true;
              }
          }
      }

    public void setHouses()
      {
//        setupHouses();
        for (i = 0; i < 36; i++)
          {
//            houses[i].setIcon(houseImg[0]);
            houses[i].setIcon(houseImg[propHouse[i]]);
          }
      }

    public void gameOver(int turn)
      {
        for (i = 0; i < 36; i++)
          {
            if (propOwner[i] == turn)
              {
                propOwner[i] = -1;
                propOwned[i] = false;
              }
          }

        //Other stuff to be added and thought
      }

    public void updateColors(int player, int pos)
      {

        for (int i = 0; i < 4; i++)
          {
            boxes[i][pos].setOpaque(false);
            boxes[i][pos].setBackground(new Color(0, 0, 0, 0));
          }
//Colours stuff
        boxes[player][pos].setOpaque(true);
        boxes[player][pos].setBackground(colorPalette[player]);
        //--------------------------------
      }

    public void propBuy(int turn)
      {
        updateColors(turn, cpos[turn]);
        money[turn] -= propPrice[cpos[turn]];
        propMoney[turn] += propPrice[cpos[turn]];
        totMoney[turn] = propMoney[turn] + money[turn];
        propOwned[cpos[turn]] = true;
        propOwner[cpos[turn]] = turn;
        numprop[turn]++;
        displayChangeBuy(turn);
        appendS(name[turn] + " ", turn);
        addLog("just bought " + propName[cpos[turn]] + " for " + propPrice[cpos[turn]] + " $");
        btnReBuy.setEnabled(false);
      }

    public void propOwnedCheck(int pOwner, int turn, int[] cpos)
      {
        String pType = propType[cpos[turn]];
        System.out.println("Boadr:: Name:" + propName[cpos[turn]] + " Type:" + pType);
        int pRent = 0;
        switch (pType)
          {
            case "STH":
                pRent = (25 * roll) + (25 * numprop[turn]);
                break;
            case "S1230":
                if (propOwner[12] == propOwner[30])
                  {
                    pRent = (50 * roll);
                  } else
                  {
                    pRent = (25 * roll);
                  }
                break;
            case "S1533":
                if (propOwner[15] == propOwner[33])
                  {
                    pRent = (50 * roll);
                  } else
                  {
                    pRent = (25 * roll);
                  }
                break;
            case "SRBC":
                pRent = (25 * roll);
                break;
            default:
                switch (propHouse[cpos[turn]])
                  {
                    case 0:
                        pRent = pd.prop[cpos[turn]].rent1;
                        break;
                    case 1:
                        pRent = pd.prop[cpos[turn]].rent2;
                        break;
                    case 2:
                        pRent = pd.prop[cpos[turn]].rent3;
                        break;
                    case 3:
                        pRent = pd.prop[cpos[turn]].rent4;
                        break;
                    case 4:
                        pRent = pd.prop[cpos[turn]].rentH;
                        break;
                  }
          }
        money[pOwner] += pRent;
        money[turn] -= pRent;
        displayChangePay(turn, pOwner, pRent);
        btnNext.setEnabled(true);
        System.out.println("Board:: Name:" + propName[cpos[turn]] + " Old Owner:" + pOwner + " Rent: " + pRent);
      }

    public void propNBCheck(int turn, int[] cpos, int roll)
      {
        String pType = propType[cpos[turn]];
        int pRent = 0;
        System.out.println("Board:: NB Type:" + propType[cpos[turn]]);
        switch (propType[cpos[turn]])
          {
            case "FP":
                pRent = -(10 * numprop[turn]);
                money[turn] += pRent;
                displayChangeS(turn, pRent);
                break;
            case "IT":
                pRent = -(5 * numprop[turn]);
                money[turn] += pRent;
                displayChangeS(turn, pRent);
                break;
            case "HT":
                pRent = -(2 * plChances[turn]);
                money[turn] += pRent;
                displayChangeS(turn, pRent);
                break;
            case "J":
                pRent = -(jailfee[turn]);
                money[turn] += pRent;
                displayChangeS(turn, pRent);
                break;
            case "CH":
                chanceCard(roll);
                break;
            case "CO":
                communityCard(roll);
                break;
            case "UK":
                pRent = -100;
                money[turn] -= pRent;
                displayChangeS(turn, pRent);
                break;
            case "ST":
//                appendS(name[turn], turn);
//                addLog(" just collected $200 for landing on Go");
                pRent = 0;
                break;
          }
        if (!pType.equals("CH") || !pType.equals("CO"))
          {
            btnNext.setEnabled(false);
            btnNext.setEnabled(true);
          }
      }

    public void displayChangeBuy(int turn)
      {
        plmoney[turn].setForeground(Color.red);
        plmoney[turn].setText("$ " + money[turn] + "(-" + propPrice[cpos[turn]] + ")");
      }

    public void displayChangePay(int turn, int propOwner, int pRent)
      {
        plmoney[turn].setForeground(Color.red);
        plmoney[turn].setText("$ " + money[turn] + "(-" + pRent + ")");

        plmoney[propOwner].setForeground(Color.red);
        plmoney[propOwner].setText("$ " + money[propOwner] + "(+" + pRent + ")");
      }

    public void displayChangeRE()
      {
        plmoney[turn].setForeground(Color.green);
        plmoney[turn].setText("$ " + money[turn] + " (+200)");
      }

    public void displayChangeS(int turn, int pRent)
      {
        if (pRent < 0)
          {
//            String sign = "-";
            plmoney[turn].setForeground(Color.red);
            plmoney[turn].setText("$ " + money[turn] + " (" + pRent + ")");
          } else if (pRent > 0)
          {
            String sign = "+";
            plmoney[turn].setForeground(Color.green);
            plmoney[turn].setText("$ " + money[turn] + " (" + sign + pRent + ")");
          } else
          {
            plmoney[turn].setForeground(Color.black);
            plmoney[turn].setText("$ " + money[turn] + " (" + pRent + ")");
          }
      }

    public void chanceCard(final int roll)
      {
        Random rand = new Random();
        final int ind = rand.nextInt(15);
//        final int ind = 5;
        final JFrame card = new JFrame();
        Container pane = card.getContentPane();
        String desc = pd.chance[ind];
        card.setPreferredSize(new Dimension(600, 200));
        JLabel type = new JLabel("Chance", JLabel.CENTER);
        type.setFont(new Font("Serif", Font.BOLD, 48));
        type.setPreferredSize(new Dimension(600, 60));
        pane.add(type, BorderLayout.PAGE_START);
        JLabel description = new JLabel(desc, JLabel.CENTER);
        description.setFont(new Font("Serif", Font.BOLD, 24));
        pane.add(description, BorderLayout.CENTER);
        pane.setBackground(Color.yellow);
        card.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        card.setUndecorated(true);
        card.pack();
        card.setLocationRelativeTo(null);
        card.setVisible(true);
        card.setAlwaysOnTop(true);
        System.out.println("ChanceCard:: Index:" + ind);
        counter = 0;
        timer = new Timer(1000, new ActionListener()
          {
            @Override
            public void actionPerformed(ActionEvent e)
              {
                counter++;
                System.out.println("Counter:" + counter);
                if (counter == 5)
                  {
                    System.out.println("Counter Stop!");
                    card.setVisible(false);
                    card.dispose();
                    checkChance(ind, roll);
                    btnNext.setEnabled(true);
                    timer.stop();
                  }
              }
          });
        timer.start();

      }

    public void checkChance(int ind, int roll)
      {
        pd.GetProp();
        switch (pd.chanceActs[ind])
          {
            case "$":
                money[turn] += pd.chanceVals[ind];
                displayChangeS(turn, pd.chanceVals[ind]);
                break;
            case "M":
                Goto(pd.chancePos[ind], cpos, turn, roll);
                break;
            case "MM":
                Goto(pd.chancePos[ind], cpos, turn, roll);
                money[turn] += pd.chanceVals[ind];
                displayChangeS(turn, pd.chanceVals[ind]);
                break;
            case "P$":
                for (i = 0; i < players; i++)
                  {
                    money[i] += pd.chanceVals[ind];
                    displayChangeS(i, pd.chanceVals[ind]);
                  }
                money[turn] -= (pd.chanceVals[ind] * (players));
                displayChangeS(turn, -1 * (pd.chanceVals[ind]));
                break;
            case "H":
                money[turn] += pd.chanceVals[ind];
                displayChangeS(turn, pd.chanceVals[ind]);
                break;
            case "MSS":
                Goto(pd.chancePos[ind], cpos, turn, roll);
                money[turn] += pd.chanceVals[ind];
                displayChangeS(turn, pd.chanceVals[ind]);
                break;
            case "MMS":
                if (cpos[turn] <= pd.chancePos[ind])
                  {
                    Goto(pd.chancePos[ind], cpos, turn, roll);
                  } else
                  {
                    Goto(pd.chancePos[ind], cpos, turn, roll);
                    money[turn] += pd.chanceVals[ind];
                    displayChangeS(turn, pd.chanceVals[ind]);
                  }
                break;
          }
      }

    public void communityCard(final int roll)
      {
        Random rand = new Random();
        final int ind = rand.nextInt(15);
//        int ind = 0;
        final JFrame comCard = new JFrame();
        Container pane = comCard.getContentPane();
        String desc = pd.comm[ind];
        comCard.setPreferredSize(new Dimension(600, 200));
        JLabel type = new JLabel("Community", JLabel.CENTER);
        type.setFont(new Font("Serif", Font.BOLD, 48));
        type.setPreferredSize(new Dimension(600, 60));
        pane.add(type, BorderLayout.PAGE_START);
        JLabel description = new JLabel(desc, JLabel.CENTER);
        description.setFont(new Font("Serif", Font.BOLD, 24));
        pane.add(description, BorderLayout.CENTER);
        pane.setBackground(Color.orange);
        comCard.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        comCard.setUndecorated(true);
        comCard.pack();
        comCard.setLocationRelativeTo(null);
        comCard.setVisible(true);
        comCard.setAlwaysOnTop(true);
        System.out.println("CommCard:: Index:" + ind);
        counter = 0;
        timer = new Timer(1000, new ActionListener()
          {
            @Override
            public void actionPerformed(ActionEvent e)
              {
                counter++;
                if (counter == 5)
                  {
                    comCard.setVisible(false);
                    comCard.dispose();
                    commCheck(ind, roll);
                    btnNext.setEnabled(true);
                    timer.stop();
                  }
              }
          });
        timer.start();

      }

    public void commCheck(int ind, int roll)
      {
        pd.GetProp();
        switch (pd.commActs[ind])
          {
            case "$":
                money[turn] += pd.commVals[ind];
                displayChangeS(turn, pd.commVals[ind]);
                break;
            case "M":
                Goto(pd.commPos[ind], cpos, turn, roll);
                break;
            case "MM":
                Goto(pd.commPos[ind], cpos, turn, roll);
                money[turn] += pd.commVals[ind];
                displayChangeS(turn, pd.commVals[ind]);
                break;
            case "P$":
                for (i = 0; i < players; i++)
                  {
                    money[i] -= pd.commVals[ind];
                    displayChangeS(i, pd.commVals[ind]);
                  }
                money[turn] += (pd.commVals[ind] * (players));
                displayChangeS(turn, pd.commVals[ind]);
                break;
            case "H":
                money[turn] += pd.commVals[ind];
                displayChangeS(turn, pd.commVals[ind]);
                break;
            case "MSS":
                Goto(pd.commPos[ind], cpos, turn, roll);
                money[turn] += pd.commVals[ind];
                displayChangeS(turn, pd.commVals[ind]);
                break;
            case "MMS":
                if (cpos[turn] <= pd.commPos[ind])
                  {
                    Goto(pd.commPos[ind], cpos, turn, roll);
                  } else
                  {
                    Goto(pd.commPos[ind], cpos, turn, roll);
                    money[turn] += pd.commVals[ind];
                    displayChangeS(turn, pd.commVals[ind]);
                  }
                break;
            case "MB":
                Goto(cpos[turn] + pd.commPos[ind], cpos, turn, roll);
          }
      }

    public void rolling()
      {
        if (snake)
          {
            roll = Dice.rollDice(dice);
            if (Dice.randomNumber1 == Dice.randomNumber2)
              {
                money[turn] += bonus[turn];
              }
          } else
          {
            if (turn == players)
              {
                turn = 0;
              }
//        roll = Dice.rollDice(dice);
//      Temporary Testing Cause
            if (dice == 2)
              {
                roll = (int) (Math.random() * 12 + 1);
              } else
              {
                roll = (int) (Math.random() * 6 + 1);
              }
          }
        move(turn);
        appendS(name[turn], turn);
        addLog(" rolled: " + roll);

      }

    public void plHouseCheck(int turn)
      {
        for (i = 0; i < 36; i++)
          {
            if ("N".equals(propType[i]))
              {
                if (propOwner[i] == turn)
                  {
                    if (propH[i] == true)
                      {
                        plHouse[turn].setEnabled(true);
                      }
                  }
              }
          }
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        dlgLog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextPane();
        btnCD = new javax.swing.JButton();
        frmBuy = new javax.swing.JFrame();
        paneCard = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBuy = new javax.swing.JButton();
        btnPass = new javax.swing.JButton();
        paneBoss = new javax.swing.JPanel();
        paneBoard = new javax.swing.JLayeredPane();
        lblHoverB7 = new javax.swing.JLabel();
        lblHoverB6 = new javax.swing.JLabel();
        lblHoverB5 = new javax.swing.JLabel();
        lblHoverB4 = new javax.swing.JLabel();
        lblHoverB3 = new javax.swing.JLabel();
        lblHoverB2 = new javax.swing.JLabel();
        lblHoverB1 = new javax.swing.JLabel();
        paneB1 = new javax.swing.JPanel();
        P1B1 = new javax.swing.JLabel();
        P2B1 = new javax.swing.JLabel();
        P3B1 = new javax.swing.JLabel();
        P4B1 = new javax.swing.JLabel();
        paneB2 = new javax.swing.JPanel();
        P1B2 = new javax.swing.JLabel();
        P2B2 = new javax.swing.JLabel();
        P3B2 = new javax.swing.JLabel();
        P4B2 = new javax.swing.JLabel();
        paneB3 = new javax.swing.JPanel();
        P1B3 = new javax.swing.JLabel();
        P2B3 = new javax.swing.JLabel();
        P3B3 = new javax.swing.JLabel();
        P4B3 = new javax.swing.JLabel();
        paneB4 = new javax.swing.JPanel();
        P1B4 = new javax.swing.JLabel();
        P2B4 = new javax.swing.JLabel();
        P3B4 = new javax.swing.JLabel();
        P4B4 = new javax.swing.JLabel();
        paneB5 = new javax.swing.JPanel();
        P1B5 = new javax.swing.JLabel();
        P2B5 = new javax.swing.JLabel();
        P3B5 = new javax.swing.JLabel();
        P4B5 = new javax.swing.JLabel();
        paneB6 = new javax.swing.JPanel();
        P1B6 = new javax.swing.JLabel();
        P2B6 = new javax.swing.JLabel();
        P3B6 = new javax.swing.JLabel();
        P4B6 = new javax.swing.JLabel();
        paneB7 = new javax.swing.JPanel();
        P1B7 = new javax.swing.JLabel();
        P2B7 = new javax.swing.JLabel();
        P3B7 = new javax.swing.JLabel();
        P4B7 = new javax.swing.JLabel();
        paneB8 = new javax.swing.JPanel();
        P1B8 = new javax.swing.JLabel();
        P2B8 = new javax.swing.JLabel();
        P3B8 = new javax.swing.JLabel();
        P4B8 = new javax.swing.JLabel();
        paneB9 = new javax.swing.JPanel();
        P1B9 = new javax.swing.JLabel();
        P2B9 = new javax.swing.JLabel();
        P3B9 = new javax.swing.JLabel();
        P4B9 = new javax.swing.JLabel();
        paneB10 = new javax.swing.JPanel();
        P1B10 = new javax.swing.JLabel();
        P2B10 = new javax.swing.JLabel();
        P3B10 = new javax.swing.JLabel();
        P4B10 = new javax.swing.JLabel();
        paneB11 = new javax.swing.JPanel();
        P1B11 = new javax.swing.JLabel();
        P2B11 = new javax.swing.JLabel();
        P3B11 = new javax.swing.JLabel();
        P4B11 = new javax.swing.JLabel();
        paneB12 = new javax.swing.JPanel();
        P1B12 = new javax.swing.JLabel();
        P2B12 = new javax.swing.JLabel();
        P3B12 = new javax.swing.JLabel();
        P4B12 = new javax.swing.JLabel();
        paneB13 = new javax.swing.JPanel();
        P1B13 = new javax.swing.JLabel();
        P2B13 = new javax.swing.JLabel();
        P3B13 = new javax.swing.JLabel();
        P4B13 = new javax.swing.JLabel();
        paneB14 = new javax.swing.JPanel();
        P1B14 = new javax.swing.JLabel();
        P2B14 = new javax.swing.JLabel();
        P3B14 = new javax.swing.JLabel();
        P4B14 = new javax.swing.JLabel();
        paneB15 = new javax.swing.JPanel();
        P1B15 = new javax.swing.JLabel();
        P2B15 = new javax.swing.JLabel();
        P3B15 = new javax.swing.JLabel();
        P4B15 = new javax.swing.JLabel();
        paneB16 = new javax.swing.JPanel();
        P1B16 = new javax.swing.JLabel();
        P2B16 = new javax.swing.JLabel();
        P3B16 = new javax.swing.JLabel();
        P4B16 = new javax.swing.JLabel();
        paneB17 = new javax.swing.JPanel();
        P1B17 = new javax.swing.JLabel();
        P2B17 = new javax.swing.JLabel();
        P3B17 = new javax.swing.JLabel();
        P4B17 = new javax.swing.JLabel();
        paneB18 = new javax.swing.JPanel();
        P1B18 = new javax.swing.JLabel();
        P2B18 = new javax.swing.JLabel();
        P3B18 = new javax.swing.JLabel();
        P4B18 = new javax.swing.JLabel();
        paneB19 = new javax.swing.JPanel();
        P1B19 = new javax.swing.JLabel();
        P2B19 = new javax.swing.JLabel();
        P3B19 = new javax.swing.JLabel();
        P4B19 = new javax.swing.JLabel();
        paneB20 = new javax.swing.JPanel();
        P1B20 = new javax.swing.JLabel();
        P2B20 = new javax.swing.JLabel();
        P3B20 = new javax.swing.JLabel();
        P4B20 = new javax.swing.JLabel();
        paneB21 = new javax.swing.JPanel();
        P1B21 = new javax.swing.JLabel();
        P2B21 = new javax.swing.JLabel();
        P3B21 = new javax.swing.JLabel();
        P4B21 = new javax.swing.JLabel();
        paneB22 = new javax.swing.JPanel();
        P1B22 = new javax.swing.JLabel();
        P2B22 = new javax.swing.JLabel();
        P3B22 = new javax.swing.JLabel();
        P4B22 = new javax.swing.JLabel();
        paneB23 = new javax.swing.JPanel();
        P1B23 = new javax.swing.JLabel();
        P2B23 = new javax.swing.JLabel();
        P3B23 = new javax.swing.JLabel();
        P4B23 = new javax.swing.JLabel();
        paneB24 = new javax.swing.JPanel();
        P1B24 = new javax.swing.JLabel();
        P2B24 = new javax.swing.JLabel();
        P3B24 = new javax.swing.JLabel();
        P4B24 = new javax.swing.JLabel();
        paneB25 = new javax.swing.JPanel();
        P1B25 = new javax.swing.JLabel();
        P2B25 = new javax.swing.JLabel();
        P3B25 = new javax.swing.JLabel();
        P4B25 = new javax.swing.JLabel();
        paneB26 = new javax.swing.JPanel();
        P1B26 = new javax.swing.JLabel();
        P2B26 = new javax.swing.JLabel();
        P3B26 = new javax.swing.JLabel();
        P4B26 = new javax.swing.JLabel();
        paneB27 = new javax.swing.JPanel();
        P1B27 = new javax.swing.JLabel();
        P2B27 = new javax.swing.JLabel();
        P3B27 = new javax.swing.JLabel();
        P4B27 = new javax.swing.JLabel();
        paneB28 = new javax.swing.JPanel();
        P1B28 = new javax.swing.JLabel();
        P2B28 = new javax.swing.JLabel();
        P3B28 = new javax.swing.JLabel();
        P4B28 = new javax.swing.JLabel();
        paneB29 = new javax.swing.JPanel();
        P1B29 = new javax.swing.JLabel();
        P2B29 = new javax.swing.JLabel();
        P3B29 = new javax.swing.JLabel();
        P4B29 = new javax.swing.JLabel();
        paneB30 = new javax.swing.JPanel();
        P1B30 = new javax.swing.JLabel();
        P2B30 = new javax.swing.JLabel();
        P3B30 = new javax.swing.JLabel();
        P4B30 = new javax.swing.JLabel();
        paneB31 = new javax.swing.JPanel();
        P1B31 = new javax.swing.JLabel();
        P2B31 = new javax.swing.JLabel();
        P3B31 = new javax.swing.JLabel();
        P4B31 = new javax.swing.JLabel();
        paneB32 = new javax.swing.JPanel();
        P1B32 = new javax.swing.JLabel();
        P2B32 = new javax.swing.JLabel();
        P3B32 = new javax.swing.JLabel();
        P4B32 = new javax.swing.JLabel();
        paneB33 = new javax.swing.JPanel();
        P1B33 = new javax.swing.JLabel();
        P2B33 = new javax.swing.JLabel();
        P3B33 = new javax.swing.JLabel();
        P4B33 = new javax.swing.JLabel();
        paneB34 = new javax.swing.JPanel();
        P1B34 = new javax.swing.JLabel();
        P2B34 = new javax.swing.JLabel();
        P3B34 = new javax.swing.JLabel();
        P4B34 = new javax.swing.JLabel();
        paneB35 = new javax.swing.JPanel();
        P1B35 = new javax.swing.JLabel();
        P2B35 = new javax.swing.JLabel();
        P3B35 = new javax.swing.JLabel();
        P4B35 = new javax.swing.JLabel();
        paneB36 = new javax.swing.JPanel();
        P1B36 = new javax.swing.JLabel();
        P2B36 = new javax.swing.JLabel();
        P3B36 = new javax.swing.JLabel();
        P4B36 = new javax.swing.JLabel();
        paneControls = new javax.swing.JPanel();
        btnRoll = new javax.swing.JButton();
        btnLog = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnTrade = new javax.swing.JButton();
        btnReBuy = new javax.swing.JButton();
        paneP1 = new javax.swing.JPanel();
        lblNameP1 = new javax.swing.JLabel();
        lblIconP1 = new javax.swing.JLabel();
        lblMoneyP1 = new javax.swing.JLabel();
        btnHouseP1 = new javax.swing.JButton();
        paneP2 = new javax.swing.JPanel();
        lblNameP2 = new javax.swing.JLabel();
        lblIconP2 = new javax.swing.JLabel();
        lblMoneyP2 = new javax.swing.JLabel();
        btnHouseP2 = new javax.swing.JButton();
        paneP3 = new javax.swing.JPanel();
        lblNameP3 = new javax.swing.JLabel();
        lblIconP3 = new javax.swing.JLabel();
        lblMoneyP3 = new javax.swing.JLabel();
        btnHouseP3 = new javax.swing.JButton();
        paneP4 = new javax.swing.JPanel();
        lblNameP4 = new javax.swing.JLabel();
        lblIconP4 = new javax.swing.JLabel();
        lblMoneyP4 = new javax.swing.JLabel();
        btnHouseP4 = new javax.swing.JButton();
        lblBoard = new javax.swing.JLabel();

        dlgLog.setAlwaysOnTop(true);
        dlgLog.setUndecorated(true);
        dlgLog.setResizable(false);

        jScrollPane2.setViewportView(txtLog);

        btnCD.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnCD.setText("CLOSE");
        btnCD.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgLogLayout = new javax.swing.GroupLayout(dlgLog.getContentPane());
        dlgLog.getContentPane().setLayout(dlgLogLayout);
        dlgLogLayout.setHorizontalGroup(
            dlgLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgLogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgLogLayout.createSequentialGroup()
                        .addGap(0, 171, Short.MAX_VALUE)
                        .addComponent(btnCD, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 173, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        dlgLogLayout.setVerticalGroup(
            dlgLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgLogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneCardLayout = new javax.swing.GroupLayout(paneCard);
        paneCard.setLayout(paneCardLayout);
        paneCardLayout.setHorizontalGroup(
            paneCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        paneCardLayout.setVerticalGroup(
            paneCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );

        btnBuy.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        btnBuy.setText("BUY");

        btnPass.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        btnPass.setText("PASS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPass, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuy, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(btnPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frmBuyLayout = new javax.swing.GroupLayout(frmBuy.getContentPane());
        frmBuy.getContentPane().setLayout(frmBuyLayout);
        frmBuyLayout.setHorizontalGroup(
            frmBuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmBuyLayout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(paneCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
            .addGroup(frmBuyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        frmBuyLayout.setVerticalGroup(
            frmBuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmBuyLayout.createSequentialGroup()
                .addComponent(paneCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        paneBoss.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHoverB7.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                lblHoverB7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                lblHoverB7MouseExited(evt);
            }
        });
        paneBoard.add(lblHoverB7);
        lblHoverB7.setBounds(2, 98, 90, 60);

        lblHoverB6.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                lblHoverB6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                lblHoverB6MouseExited(evt);
            }
        });
        paneBoard.add(lblHoverB6);
        lblHoverB6.setBounds(2, 160, 90, 60);

        lblHoverB5.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                lblHoverB5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                lblHoverB5MouseExited(evt);
            }
        });
        paneBoard.add(lblHoverB5);
        lblHoverB5.setBounds(2, 288, 90, 60);

        lblHoverB4.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                lblHoverB4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                lblHoverB4MouseExited(evt);
            }
        });
        paneBoard.add(lblHoverB4);
        lblHoverB4.setBounds(2, 352, 90, 60);

        lblHoverB3.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                lblHoverB3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                lblHoverB3MouseExited(evt);
            }
        });
        paneBoard.add(lblHoverB3);
        lblHoverB3.setBounds(2, 415, 90, 60);

        lblHoverB2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                lblHoverB2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                lblHoverB2MouseExited(evt);
            }
        });
        paneBoard.add(lblHoverB2);
        lblHoverB2.setBounds(2, 480, 90, 60);

        lblHoverB1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                lblHoverB1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                lblHoverB1MouseExited(evt);
            }
        });
        paneBoard.add(lblHoverB1);
        lblHoverB1.setBounds(2, 545, 90, 60);

        paneB1.setBackground(new java.awt.Color(255, 255, 255));
        paneB1.setOpaque(false);

        javax.swing.GroupLayout paneB1Layout = new javax.swing.GroupLayout(paneB1);
        paneB1.setLayout(paneB1Layout);
        paneB1Layout.setHorizontalGroup(
            paneB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB1Layout.createSequentialGroup()
                .addGroup(paneB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB1Layout.createSequentialGroup()
                        .addComponent(P1B1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB1Layout.createSequentialGroup()
                        .addComponent(P4B1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 2, Short.MAX_VALUE))
        );
        paneB1Layout.setVerticalGroup(
            paneB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB1Layout.createSequentialGroup()
                .addGroup(paneB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        paneBoard.add(paneB1);
        paneB1.setBounds(20, 620, 60, 60);

        paneB2.setBackground(new java.awt.Color(255, 255, 255));
        paneB2.setOpaque(false);

        javax.swing.GroupLayout paneB2Layout = new javax.swing.GroupLayout(paneB2);
        paneB2.setLayout(paneB2Layout);
        paneB2Layout.setHorizontalGroup(
            paneB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB2Layout.createSequentialGroup()
                .addGroup(paneB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB2Layout.createSequentialGroup()
                        .addComponent(P1B2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB2Layout.createSequentialGroup()
                        .addComponent(P4B2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB2Layout.setVerticalGroup(
            paneB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB2Layout.createSequentialGroup()
                .addGroup(paneB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB2);
        paneB2.setBounds(10, 550, 58, 50);

        paneB3.setBackground(new java.awt.Color(255, 255, 255));
        paneB3.setOpaque(false);

        javax.swing.GroupLayout paneB3Layout = new javax.swing.GroupLayout(paneB3);
        paneB3.setLayout(paneB3Layout);
        paneB3Layout.setHorizontalGroup(
            paneB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB3Layout.createSequentialGroup()
                .addGroup(paneB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB3Layout.createSequentialGroup()
                        .addComponent(P1B3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB3Layout.createSequentialGroup()
                        .addComponent(P4B3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB3Layout.setVerticalGroup(
            paneB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB3Layout.createSequentialGroup()
                .addGroup(paneB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB3);
        paneB3.setBounds(10, 485, 58, 51);

        paneB4.setBackground(new java.awt.Color(255, 255, 255));
        paneB4.setOpaque(false);

        javax.swing.GroupLayout paneB4Layout = new javax.swing.GroupLayout(paneB4);
        paneB4.setLayout(paneB4Layout);
        paneB4Layout.setHorizontalGroup(
            paneB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB4Layout.createSequentialGroup()
                .addGroup(paneB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB4Layout.createSequentialGroup()
                        .addComponent(P1B4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB4Layout.createSequentialGroup()
                        .addComponent(P4B4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB4Layout.setVerticalGroup(
            paneB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB4Layout.createSequentialGroup()
                .addGroup(paneB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB4);
        paneB4.setBounds(10, 420, 58, 51);

        paneB5.setBackground(new java.awt.Color(255, 255, 255));
        paneB5.setOpaque(false);

        javax.swing.GroupLayout paneB5Layout = new javax.swing.GroupLayout(paneB5);
        paneB5.setLayout(paneB5Layout);
        paneB5Layout.setHorizontalGroup(
            paneB5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB5Layout.createSequentialGroup()
                .addGroup(paneB5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB5Layout.createSequentialGroup()
                        .addComponent(P1B5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB5Layout.createSequentialGroup()
                        .addComponent(P4B5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB5Layout.setVerticalGroup(
            paneB5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB5Layout.createSequentialGroup()
                .addGroup(paneB5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB5);
        paneB5.setBounds(10, 355, 58, 51);

        paneB6.setBackground(new java.awt.Color(255, 255, 255));
        paneB6.setOpaque(false);

        javax.swing.GroupLayout paneB6Layout = new javax.swing.GroupLayout(paneB6);
        paneB6.setLayout(paneB6Layout);
        paneB6Layout.setHorizontalGroup(
            paneB6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB6Layout.createSequentialGroup()
                .addGroup(paneB6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB6Layout.createSequentialGroup()
                        .addComponent(P1B6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB6Layout.createSequentialGroup()
                        .addComponent(P4B6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB6Layout.setVerticalGroup(
            paneB6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB6Layout.createSequentialGroup()
                .addGroup(paneB6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB6);
        paneB6.setBounds(10, 295, 58, 51);

        paneB7.setBackground(new java.awt.Color(255, 255, 255));
        paneB7.setOpaque(false);

        javax.swing.GroupLayout paneB7Layout = new javax.swing.GroupLayout(paneB7);
        paneB7.setLayout(paneB7Layout);
        paneB7Layout.setHorizontalGroup(
            paneB7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB7Layout.createSequentialGroup()
                .addGroup(paneB7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB7Layout.createSequentialGroup()
                        .addComponent(P1B7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB7Layout.createSequentialGroup()
                        .addComponent(P4B7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB7Layout.setVerticalGroup(
            paneB7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB7Layout.createSequentialGroup()
                .addGroup(paneB7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB7);
        paneB7.setBounds(10, 230, 58, 51);

        paneB8.setBackground(new java.awt.Color(255, 255, 255));
        paneB8.setOpaque(false);

        javax.swing.GroupLayout paneB8Layout = new javax.swing.GroupLayout(paneB8);
        paneB8.setLayout(paneB8Layout);
        paneB8Layout.setHorizontalGroup(
            paneB8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB8Layout.createSequentialGroup()
                .addGroup(paneB8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB8Layout.createSequentialGroup()
                        .addComponent(P1B8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB8Layout.createSequentialGroup()
                        .addComponent(P4B8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB8Layout.setVerticalGroup(
            paneB8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB8Layout.createSequentialGroup()
                .addGroup(paneB8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB8);
        paneB8.setBounds(10, 165, 58, 51);

        paneB9.setBackground(new java.awt.Color(255, 255, 255));
        paneB9.setOpaque(false);

        javax.swing.GroupLayout paneB9Layout = new javax.swing.GroupLayout(paneB9);
        paneB9.setLayout(paneB9Layout);
        paneB9Layout.setHorizontalGroup(
            paneB9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB9Layout.createSequentialGroup()
                .addGroup(paneB9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB9Layout.createSequentialGroup()
                        .addComponent(P1B9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB9Layout.createSequentialGroup()
                        .addComponent(P4B9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB9Layout.setVerticalGroup(
            paneB9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB9Layout.createSequentialGroup()
                .addGroup(paneB9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB9);
        paneB9.setBounds(10, 100, 58, 51);

        paneB10.setBackground(new java.awt.Color(255, 255, 255));
        paneB10.setOpaque(false);

        javax.swing.GroupLayout paneB10Layout = new javax.swing.GroupLayout(paneB10);
        paneB10.setLayout(paneB10Layout);
        paneB10Layout.setHorizontalGroup(
            paneB10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB10Layout.createSequentialGroup()
                .addGroup(paneB10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB10Layout.createSequentialGroup()
                        .addComponent(P1B10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB10Layout.createSequentialGroup()
                        .addComponent(P4B10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB10Layout.setVerticalGroup(
            paneB10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB10Layout.createSequentialGroup()
                .addGroup(paneB10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB10);
        paneB10.setBounds(5, 10, 58, 51);

        paneB11.setBackground(new java.awt.Color(255, 255, 255));
        paneB11.setOpaque(false);

        javax.swing.GroupLayout paneB11Layout = new javax.swing.GroupLayout(paneB11);
        paneB11.setLayout(paneB11Layout);
        paneB11Layout.setHorizontalGroup(
            paneB11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB11Layout.createSequentialGroup()
                .addGroup(paneB11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB11Layout.createSequentialGroup()
                        .addComponent(P1B11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB11Layout.createSequentialGroup()
                        .addComponent(P4B11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB11Layout.setVerticalGroup(
            paneB11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB11Layout.createSequentialGroup()
                .addGroup(paneB11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB11);
        paneB11.setBounds(98, 10, 58, 51);

        paneB12.setBackground(new java.awt.Color(255, 255, 255));
        paneB12.setOpaque(false);

        javax.swing.GroupLayout paneB12Layout = new javax.swing.GroupLayout(paneB12);
        paneB12.setLayout(paneB12Layout);
        paneB12Layout.setHorizontalGroup(
            paneB12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB12Layout.createSequentialGroup()
                .addGroup(paneB12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB12Layout.createSequentialGroup()
                        .addComponent(P1B12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB12Layout.createSequentialGroup()
                        .addComponent(P4B12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB12Layout.setVerticalGroup(
            paneB12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB12Layout.createSequentialGroup()
                .addGroup(paneB12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB12);
        paneB12.setBounds(160, 10, 58, 51);

        paneB13.setBackground(new java.awt.Color(255, 255, 255));
        paneB13.setOpaque(false);

        javax.swing.GroupLayout paneB13Layout = new javax.swing.GroupLayout(paneB13);
        paneB13.setLayout(paneB13Layout);
        paneB13Layout.setHorizontalGroup(
            paneB13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB13Layout.createSequentialGroup()
                .addGroup(paneB13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB13Layout.createSequentialGroup()
                        .addComponent(P1B13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB13Layout.createSequentialGroup()
                        .addComponent(P4B13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB13Layout.setVerticalGroup(
            paneB13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB13Layout.createSequentialGroup()
                .addGroup(paneB13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB13);
        paneB13.setBounds(225, 10, 58, 51);

        paneB14.setBackground(new java.awt.Color(255, 255, 255));
        paneB14.setOpaque(false);

        javax.swing.GroupLayout paneB14Layout = new javax.swing.GroupLayout(paneB14);
        paneB14.setLayout(paneB14Layout);
        paneB14Layout.setHorizontalGroup(
            paneB14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB14Layout.createSequentialGroup()
                .addGroup(paneB14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB14Layout.createSequentialGroup()
                        .addComponent(P1B14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB14Layout.createSequentialGroup()
                        .addComponent(P4B14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB14Layout.setVerticalGroup(
            paneB14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB14Layout.createSequentialGroup()
                .addGroup(paneB14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB14);
        paneB14.setBounds(290, 10, 58, 51);

        paneB15.setBackground(new java.awt.Color(255, 255, 255));
        paneB15.setOpaque(false);

        javax.swing.GroupLayout paneB15Layout = new javax.swing.GroupLayout(paneB15);
        paneB15.setLayout(paneB15Layout);
        paneB15Layout.setHorizontalGroup(
            paneB15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB15Layout.createSequentialGroup()
                .addGroup(paneB15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB15Layout.createSequentialGroup()
                        .addComponent(P1B15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB15Layout.createSequentialGroup()
                        .addComponent(P4B15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB15Layout.setVerticalGroup(
            paneB15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB15Layout.createSequentialGroup()
                .addGroup(paneB15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB15);
        paneB15.setBounds(355, 10, 58, 51);

        paneB16.setBackground(new java.awt.Color(255, 255, 255));
        paneB16.setOpaque(false);

        javax.swing.GroupLayout paneB16Layout = new javax.swing.GroupLayout(paneB16);
        paneB16.setLayout(paneB16Layout);
        paneB16Layout.setHorizontalGroup(
            paneB16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB16Layout.createSequentialGroup()
                .addGroup(paneB16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB16Layout.createSequentialGroup()
                        .addComponent(P1B16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB16Layout.createSequentialGroup()
                        .addComponent(P4B16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB16Layout.setVerticalGroup(
            paneB16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB16Layout.createSequentialGroup()
                .addGroup(paneB16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB16);
        paneB16.setBounds(415, 10, 58, 51);

        paneB17.setBackground(new java.awt.Color(255, 255, 255));
        paneB17.setOpaque(false);

        javax.swing.GroupLayout paneB17Layout = new javax.swing.GroupLayout(paneB17);
        paneB17.setLayout(paneB17Layout);
        paneB17Layout.setHorizontalGroup(
            paneB17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB17Layout.createSequentialGroup()
                .addGroup(paneB17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB17Layout.createSequentialGroup()
                        .addComponent(P1B17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB17Layout.createSequentialGroup()
                        .addComponent(P4B17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB17Layout.setVerticalGroup(
            paneB17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB17Layout.createSequentialGroup()
                .addGroup(paneB17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB17);
        paneB17.setBounds(480, 10, 58, 51);

        paneB18.setBackground(new java.awt.Color(255, 255, 255));
        paneB18.setOpaque(false);

        javax.swing.GroupLayout paneB18Layout = new javax.swing.GroupLayout(paneB18);
        paneB18.setLayout(paneB18Layout);
        paneB18Layout.setHorizontalGroup(
            paneB18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB18Layout.createSequentialGroup()
                .addGroup(paneB18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB18Layout.createSequentialGroup()
                        .addComponent(P1B18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB18Layout.createSequentialGroup()
                        .addComponent(P4B18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB18Layout.setVerticalGroup(
            paneB18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB18Layout.createSequentialGroup()
                .addGroup(paneB18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB18);
        paneB18.setBounds(545, 10, 58, 51);

        paneB19.setBackground(new java.awt.Color(255, 255, 255));
        paneB19.setOpaque(false);

        javax.swing.GroupLayout paneB19Layout = new javax.swing.GroupLayout(paneB19);
        paneB19.setLayout(paneB19Layout);
        paneB19Layout.setHorizontalGroup(
            paneB19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB19Layout.createSequentialGroup()
                .addGroup(paneB19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB19Layout.createSequentialGroup()
                        .addComponent(P1B19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB19Layout.createSequentialGroup()
                        .addComponent(P4B19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB19Layout.setVerticalGroup(
            paneB19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB19Layout.createSequentialGroup()
                .addGroup(paneB19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB19);
        paneB19.setBounds(630, 10, 58, 51);

        paneB20.setBackground(new java.awt.Color(255, 255, 255));
        paneB20.setOpaque(false);

        javax.swing.GroupLayout paneB20Layout = new javax.swing.GroupLayout(paneB20);
        paneB20.setLayout(paneB20Layout);
        paneB20Layout.setHorizontalGroup(
            paneB20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB20Layout.createSequentialGroup()
                .addGroup(paneB20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB20Layout.createSequentialGroup()
                        .addComponent(P1B20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB20Layout.createSequentialGroup()
                        .addComponent(P4B20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB20Layout.setVerticalGroup(
            paneB20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB20Layout.createSequentialGroup()
                .addGroup(paneB20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB20);
        paneB20.setBounds(630, 100, 58, 51);

        paneB21.setBackground(new java.awt.Color(255, 255, 255));
        paneB21.setOpaque(false);

        javax.swing.GroupLayout paneB21Layout = new javax.swing.GroupLayout(paneB21);
        paneB21.setLayout(paneB21Layout);
        paneB21Layout.setHorizontalGroup(
            paneB21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB21Layout.createSequentialGroup()
                .addGroup(paneB21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB21Layout.createSequentialGroup()
                        .addComponent(P1B21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB21Layout.createSequentialGroup()
                        .addComponent(P4B21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB21Layout.setVerticalGroup(
            paneB21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB21Layout.createSequentialGroup()
                .addGroup(paneB21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB21);
        paneB21.setBounds(630, 165, 58, 51);

        paneB22.setBackground(new java.awt.Color(255, 255, 255));
        paneB22.setOpaque(false);

        javax.swing.GroupLayout paneB22Layout = new javax.swing.GroupLayout(paneB22);
        paneB22.setLayout(paneB22Layout);
        paneB22Layout.setHorizontalGroup(
            paneB22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB22Layout.createSequentialGroup()
                .addGroup(paneB22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB22Layout.createSequentialGroup()
                        .addComponent(P1B22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB22Layout.createSequentialGroup()
                        .addComponent(P4B22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB22Layout.setVerticalGroup(
            paneB22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB22Layout.createSequentialGroup()
                .addGroup(paneB22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB22);
        paneB22.setBounds(630, 230, 58, 51);

        paneB23.setBackground(new java.awt.Color(255, 255, 255));
        paneB23.setOpaque(false);

        javax.swing.GroupLayout paneB23Layout = new javax.swing.GroupLayout(paneB23);
        paneB23.setLayout(paneB23Layout);
        paneB23Layout.setHorizontalGroup(
            paneB23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB23Layout.createSequentialGroup()
                .addGroup(paneB23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB23Layout.createSequentialGroup()
                        .addComponent(P1B23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB23Layout.createSequentialGroup()
                        .addComponent(P4B23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB23Layout.setVerticalGroup(
            paneB23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB23Layout.createSequentialGroup()
                .addGroup(paneB23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB23);
        paneB23.setBounds(630, 295, 58, 51);

        paneB24.setBackground(new java.awt.Color(255, 255, 255));
        paneB24.setOpaque(false);

        javax.swing.GroupLayout paneB24Layout = new javax.swing.GroupLayout(paneB24);
        paneB24.setLayout(paneB24Layout);
        paneB24Layout.setHorizontalGroup(
            paneB24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB24Layout.createSequentialGroup()
                .addGroup(paneB24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB24Layout.createSequentialGroup()
                        .addComponent(P1B24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB24Layout.createSequentialGroup()
                        .addComponent(P4B24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB24Layout.setVerticalGroup(
            paneB24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB24Layout.createSequentialGroup()
                .addGroup(paneB24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB24);
        paneB24.setBounds(630, 355, 58, 51);

        paneB25.setBackground(new java.awt.Color(255, 255, 255));
        paneB25.setOpaque(false);

        javax.swing.GroupLayout paneB25Layout = new javax.swing.GroupLayout(paneB25);
        paneB25.setLayout(paneB25Layout);
        paneB25Layout.setHorizontalGroup(
            paneB25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB25Layout.createSequentialGroup()
                .addGroup(paneB25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB25Layout.createSequentialGroup()
                        .addComponent(P1B25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB25Layout.createSequentialGroup()
                        .addComponent(P4B25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB25Layout.setVerticalGroup(
            paneB25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB25Layout.createSequentialGroup()
                .addGroup(paneB25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB25);
        paneB25.setBounds(630, 420, 58, 51);

        paneB26.setBackground(new java.awt.Color(255, 255, 255));
        paneB26.setOpaque(false);

        javax.swing.GroupLayout paneB26Layout = new javax.swing.GroupLayout(paneB26);
        paneB26.setLayout(paneB26Layout);
        paneB26Layout.setHorizontalGroup(
            paneB26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB26Layout.createSequentialGroup()
                .addGroup(paneB26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB26Layout.createSequentialGroup()
                        .addComponent(P1B26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB26Layout.createSequentialGroup()
                        .addComponent(P4B26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB26Layout.setVerticalGroup(
            paneB26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB26Layout.createSequentialGroup()
                .addGroup(paneB26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB26);
        paneB26.setBounds(630, 485, 58, 51);

        paneB27.setBackground(new java.awt.Color(255, 255, 255));
        paneB27.setOpaque(false);

        javax.swing.GroupLayout paneB27Layout = new javax.swing.GroupLayout(paneB27);
        paneB27.setLayout(paneB27Layout);
        paneB27Layout.setHorizontalGroup(
            paneB27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB27Layout.createSequentialGroup()
                .addGroup(paneB27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB27Layout.createSequentialGroup()
                        .addComponent(P1B27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB27Layout.createSequentialGroup()
                        .addComponent(P4B27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB27Layout.setVerticalGroup(
            paneB27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB27Layout.createSequentialGroup()
                .addGroup(paneB27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB27);
        paneB27.setBounds(630, 545, 58, 51);

        paneB28.setBackground(new java.awt.Color(255, 255, 255));
        paneB28.setOpaque(false);

        javax.swing.GroupLayout paneB28Layout = new javax.swing.GroupLayout(paneB28);
        paneB28.setLayout(paneB28Layout);
        paneB28Layout.setHorizontalGroup(
            paneB28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB28Layout.createSequentialGroup()
                .addGroup(paneB28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB28Layout.createSequentialGroup()
                        .addComponent(P1B28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB28Layout.createSequentialGroup()
                        .addComponent(P4B28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB28Layout.setVerticalGroup(
            paneB28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB28Layout.createSequentialGroup()
                .addGroup(paneB28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB28);
        paneB28.setBounds(630, 640, 58, 51);

        paneB29.setBackground(new java.awt.Color(255, 255, 255));
        paneB29.setOpaque(false);

        javax.swing.GroupLayout paneB29Layout = new javax.swing.GroupLayout(paneB29);
        paneB29.setLayout(paneB29Layout);
        paneB29Layout.setHorizontalGroup(
            paneB29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB29Layout.createSequentialGroup()
                .addGroup(paneB29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB29Layout.createSequentialGroup()
                        .addComponent(P1B29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB29Layout.createSequentialGroup()
                        .addComponent(P4B29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB29Layout.setVerticalGroup(
            paneB29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB29Layout.createSequentialGroup()
                .addGroup(paneB29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB29);
        paneB29.setBounds(545, 640, 58, 51);

        paneB30.setBackground(new java.awt.Color(255, 255, 255));
        paneB30.setOpaque(false);

        javax.swing.GroupLayout paneB30Layout = new javax.swing.GroupLayout(paneB30);
        paneB30.setLayout(paneB30Layout);
        paneB30Layout.setHorizontalGroup(
            paneB30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB30Layout.createSequentialGroup()
                .addGroup(paneB30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB30Layout.createSequentialGroup()
                        .addComponent(P1B30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB30Layout.createSequentialGroup()
                        .addComponent(P4B30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB30Layout.setVerticalGroup(
            paneB30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB30Layout.createSequentialGroup()
                .addGroup(paneB30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB30);
        paneB30.setBounds(480, 640, 58, 51);

        paneB31.setBackground(new java.awt.Color(255, 255, 255));
        paneB31.setOpaque(false);

        javax.swing.GroupLayout paneB31Layout = new javax.swing.GroupLayout(paneB31);
        paneB31.setLayout(paneB31Layout);
        paneB31Layout.setHorizontalGroup(
            paneB31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB31Layout.createSequentialGroup()
                .addGroup(paneB31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB31Layout.createSequentialGroup()
                        .addComponent(P1B31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB31Layout.createSequentialGroup()
                        .addComponent(P4B31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB31Layout.setVerticalGroup(
            paneB31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB31Layout.createSequentialGroup()
                .addGroup(paneB31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB31);
        paneB31.setBounds(415, 640, 58, 51);

        paneB32.setBackground(new java.awt.Color(255, 255, 255));
        paneB32.setOpaque(false);

        javax.swing.GroupLayout paneB32Layout = new javax.swing.GroupLayout(paneB32);
        paneB32.setLayout(paneB32Layout);
        paneB32Layout.setHorizontalGroup(
            paneB32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB32Layout.createSequentialGroup()
                .addGroup(paneB32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB32Layout.createSequentialGroup()
                        .addComponent(P1B32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB32Layout.createSequentialGroup()
                        .addComponent(P4B32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB32Layout.setVerticalGroup(
            paneB32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB32Layout.createSequentialGroup()
                .addGroup(paneB32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB32);
        paneB32.setBounds(352, 640, 58, 51);

        paneB33.setBackground(new java.awt.Color(255, 255, 255));
        paneB33.setOpaque(false);

        javax.swing.GroupLayout paneB33Layout = new javax.swing.GroupLayout(paneB33);
        paneB33.setLayout(paneB33Layout);
        paneB33Layout.setHorizontalGroup(
            paneB33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB33Layout.createSequentialGroup()
                .addGroup(paneB33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB33Layout.createSequentialGroup()
                        .addComponent(P1B33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB33Layout.createSequentialGroup()
                        .addComponent(P4B33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB33Layout.setVerticalGroup(
            paneB33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB33Layout.createSequentialGroup()
                .addGroup(paneB33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB33);
        paneB33.setBounds(290, 640, 58, 51);

        paneB34.setBackground(new java.awt.Color(255, 255, 255));
        paneB34.setOpaque(false);

        javax.swing.GroupLayout paneB34Layout = new javax.swing.GroupLayout(paneB34);
        paneB34.setLayout(paneB34Layout);
        paneB34Layout.setHorizontalGroup(
            paneB34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB34Layout.createSequentialGroup()
                .addGroup(paneB34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB34Layout.createSequentialGroup()
                        .addComponent(P1B34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB34Layout.createSequentialGroup()
                        .addComponent(P4B34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB34Layout.setVerticalGroup(
            paneB34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB34Layout.createSequentialGroup()
                .addGroup(paneB34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB34);
        paneB34.setBounds(225, 640, 58, 51);

        paneB35.setBackground(new java.awt.Color(255, 255, 255));
        paneB35.setOpaque(false);

        javax.swing.GroupLayout paneB35Layout = new javax.swing.GroupLayout(paneB35);
        paneB35.setLayout(paneB35Layout);
        paneB35Layout.setHorizontalGroup(
            paneB35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB35Layout.createSequentialGroup()
                .addGroup(paneB35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB35Layout.createSequentialGroup()
                        .addComponent(P1B35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB35Layout.createSequentialGroup()
                        .addComponent(P4B35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB35Layout.setVerticalGroup(
            paneB35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB35Layout.createSequentialGroup()
                .addGroup(paneB35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB35);
        paneB35.setBounds(160, 640, 58, 51);

        paneB36.setBackground(new java.awt.Color(255, 255, 255));
        paneB36.setOpaque(false);

        javax.swing.GroupLayout paneB36Layout = new javax.swing.GroupLayout(paneB36);
        paneB36.setLayout(paneB36Layout);
        paneB36Layout.setHorizontalGroup(
            paneB36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB36Layout.createSequentialGroup()
                .addGroup(paneB36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneB36Layout.createSequentialGroup()
                        .addComponent(P1B36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P2B36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneB36Layout.createSequentialGroup()
                        .addComponent(P4B36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(P3B36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneB36Layout.setVerticalGroup(
            paneB36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneB36Layout.createSequentialGroup()
                .addGroup(paneB36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1B36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2B36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneB36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4B36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P3B36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoard.add(paneB36);
        paneB36.setBounds(95, 640, 58, 51);

        paneBoss.add(paneBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 700, 700));

        btnRoll.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnRoll.setText("Roll!");
        btnRoll.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRollActionPerformed(evt);
            }
        });
        btnRoll.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                btnRollKeyReleased(evt);
            }
        });

        btnLog.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnLog.setText("LOG");
        btnLog.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLogActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnNext.setText("NEXT");
        btnNext.setEnabled(false);
        btnNext.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnNextActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExitActionPerformed(evt);
            }
        });

        btnTrade.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnTrade.setText("Trade");
        btnTrade.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTradeActionPerformed(evt);
            }
        });

        btnReBuy.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnReBuy.setText("BUY");
        btnReBuy.setEnabled(false);
        btnReBuy.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnReBuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneControlsLayout = new javax.swing.GroupLayout(paneControls);
        paneControls.setLayout(paneControlsLayout);
        paneControlsLayout.setHorizontalGroup(
            paneControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneControlsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLog, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTrade, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        paneControlsLayout.setVerticalGroup(
            paneControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(paneControlsLayout.createSequentialGroup()
                .addGroup(paneControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnTrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRoll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnLog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReBuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneBoss.add(paneControls, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 727, 710, -1));

        paneP1.setBorder(new javax.swing.border.MatteBorder(null));

        lblNameP1.setBackground(new java.awt.Color(255, 0, 0));
        lblNameP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNameP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblIconP1.setBackground(new java.awt.Color(255, 0, 0));

        lblMoneyP1.setBackground(new java.awt.Color(255, 0, 0));
        lblMoneyP1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblMoneyP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnHouseP1.setText("jButton1");

        javax.swing.GroupLayout paneP1Layout = new javax.swing.GroupLayout(paneP1);
        paneP1.setLayout(paneP1Layout);
        paneP1Layout.setHorizontalGroup(
            paneP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNameP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneP1Layout.createSequentialGroup()
                        .addComponent(lblMoneyP1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHouseP1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneP1Layout.setVerticalGroup(
            paneP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNameP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lblIconP1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMoneyP1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(btnHouseP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblNameP1.getAccessibleContext().setAccessibleDescription("");

        paneBoss.add(paneP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 230, -1));

        paneP2.setBorder(new javax.swing.border.MatteBorder(null));

        lblNameP2.setBackground(new java.awt.Color(0, 255, 0));
        lblNameP2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNameP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblIconP2.setBackground(new java.awt.Color(0, 255, 0));

        lblMoneyP2.setBackground(new java.awt.Color(0, 255, 0));
        lblMoneyP2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblMoneyP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnHouseP2.setText("jButton1");

        javax.swing.GroupLayout paneP2Layout = new javax.swing.GroupLayout(paneP2);
        paneP2.setLayout(paneP2Layout);
        paneP2Layout.setHorizontalGroup(
            paneP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNameP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconP2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneP2Layout.createSequentialGroup()
                        .addComponent(lblMoneyP2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHouseP2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneP2Layout.setVerticalGroup(
            paneP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNameP2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIconP2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMoneyP2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHouseP2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneBoss.add(paneP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, -1, -1));

        paneP3.setBorder(new javax.swing.border.MatteBorder(null));

        lblNameP3.setBackground(new java.awt.Color(0, 0, 255));
        lblNameP3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNameP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblIconP3.setBackground(new java.awt.Color(0, 0, 255));

        lblMoneyP3.setBackground(new java.awt.Color(0, 0, 255));
        lblMoneyP3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblMoneyP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnHouseP3.setText("jButton1");

        javax.swing.GroupLayout paneP3Layout = new javax.swing.GroupLayout(paneP3);
        paneP3.setLayout(paneP3Layout);
        paneP3Layout.setHorizontalGroup(
            paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNameP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneP3Layout.createSequentialGroup()
                        .addComponent(lblMoneyP3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHouseP3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneP3Layout.setVerticalGroup(
            paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNameP3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lblIconP3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMoneyP3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(btnHouseP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneBoss.add(paneP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, 290));

        paneP4.setBorder(new javax.swing.border.MatteBorder(null));

        lblNameP4.setBackground(new java.awt.Color(255, 255, 0));
        lblNameP4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNameP4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblIconP4.setBackground(new java.awt.Color(255, 255, 0));

        lblMoneyP4.setBackground(new java.awt.Color(255, 255, 0));
        lblMoneyP4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblMoneyP4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnHouseP4.setText("jButton1");

        javax.swing.GroupLayout paneP4Layout = new javax.swing.GroupLayout(paneP4);
        paneP4.setLayout(paneP4Layout);
        paneP4Layout.setHorizontalGroup(
            paneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paneP4Layout.createSequentialGroup()
                        .addComponent(lblMoneyP4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHouseP4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneP4Layout.setVerticalGroup(
            paneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblNameP4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIconP4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMoneyP4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHouseP4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneBoss.add(paneP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 400, -1, 298));

        lblBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monopolyalpha/Canada Green Board.png"))); // NOI18N
        paneBoss.add(lblBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneBoss, javax.swing.GroupLayout.PREFERRED_SIZE, 1176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(paneBoss, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHoverB1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB1MouseEntered
        if (hover = true)
          {
            makeCard(1);
          }
    }//GEN-LAST:event_lblHoverB1MouseEntered

    private void lblHoverB1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB1MouseExited
        // TODO add your handling code here:        
        breakCard();
    }//GEN-LAST:event_lblHoverB1MouseExited

    private void lblHoverB2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB2MouseEntered
        if (hover = true)
          {
            makeCard(2);
          }
    }//GEN-LAST:event_lblHoverB2MouseEntered

    private void lblHoverB2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB2MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB2MouseExited

    private void lblHoverB3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB3MouseEntered
        if (hover = true)
          {
            makeCard(3);
          }
    }//GEN-LAST:event_lblHoverB3MouseEntered

    private void lblHoverB3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB3MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB3MouseExited

    private void lblHoverB4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB4MouseEntered
        if (hover = true)
          {
            makeCard(4);
          }
    }//GEN-LAST:event_lblHoverB4MouseEntered

    private void lblHoverB4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB4MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB4MouseExited

    private void lblHoverB5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB5MouseEntered
        // TODO add your handling code here:       
    }//GEN-LAST:event_lblHoverB5MouseEntered

    private void lblHoverB5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB5MouseExited
        // TODO add your handling code here:        
    }//GEN-LAST:event_lblHoverB5MouseExited

    private void lblHoverB6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB6MouseEntered
        if (hover = true)
          {
            makeCard(7);
          }
    }//GEN-LAST:event_lblHoverB6MouseEntered

    private void lblHoverB6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB6MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB6MouseExited

    private void lblHoverB7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB7MouseEntered
        if (hover = true)
          {
            makeCard(8);
          }
    }//GEN-LAST:event_lblHoverB7MouseEntered

    private void lblHoverB7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB7MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB7MouseExited

    private void btnRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollActionPerformed

        btnRoll.setEnabled(false);
        rolling();
        hover = false;
//        int m = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number to move"));
//        roll = m;
//        move(turn);
//        chanceCard(roll);
    }//GEN-LAST:event_btnRollActionPerformed

    private void btnRollKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_btnRollKeyReleased
    {//GEN-HEADEREND:event_btnRollKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_R)
          {
            rolling();
          }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
          {
            System.exit(0);
          }
    }//GEN-LAST:event_btnRollKeyReleased

    private void btnCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCDActionPerformed
        // TODO add your handling code here:
        dlgLog.setVisible(false);
    }//GEN-LAST:event_btnCDActionPerformed

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        // TODO add your handling code here:
        dlgLog.setSize(600, 400);
        dlgLog.setVisible(true);
        dlgLog.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnLogActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        btnRoll.setEnabled(true);
        appendS(name[turn] + "'s", turn);
        addLog(" turn ended.");
        turn++;
        if (turn == players)
          {
            turn = 0;
          }
        plHouseCheck(turn);
        btnNext.setEnabled(false);
        displayChange(turn);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        String ObjButtons[]
                =
                  {
                    "Yes", "No", "Save"
                  };
        int PromptResult = JOptionPane.showOptionDialog(null,
                "Are you sure you want to exit?", "Monopoly Java",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
                ObjButtons, ObjButtons[2]);
        if (PromptResult == 0)
          {
            System.exit(0);
          }
        if (PromptResult == 2)
          {
            new Save_Manager().setVisible(true);
          }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnReBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReBuyActionPerformed
        // TODO add your handling code here:
        BuyScreen buy = new BuyScreen(new Card(pd.prop[cpos[turn]].colour, pd.prop[cpos[turn]].cardIcon, cpos[turn], pd));
        buy.setVisible(true);
    }//GEN-LAST:event_btnReBuyActionPerformed

    private void btnTradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTradeActionPerformed
        // TODO add your handling code here:       
        new TradeForm().setVisible(true);
    }//GEN-LAST:event_btnTradeActionPerformed

    public void displayChange(int turn)
      {

        for (i = 0; i < players; i++)
          {
            if (i == turn)
              {
                plnames[i].setEnabled(true);
                plmoney[i].setEnabled(true);
                plicons[i].setEnabled(true);
              } else
              {
                plHouse[i].setEnabled(false);
                plnames[i].setEnabled(false);
                plmoney[i].setEnabled(false);
                plicons[i].setEnabled(false);
              }
          }
      }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
      {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
          {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
              {
                if ("Nimbus".equals(info.getName()))
                  {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                  }
              }
          } catch (ClassNotFoundException ex)
          {
            java.util.logging.Logger.getLogger(Board.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(Board.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(Board.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(Board.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
          {
            public void run()
              {
                new StartScreenfrm().setVisible(true);
              }
          });
      }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel P1B1;
    private javax.swing.JLabel P1B10;
    private javax.swing.JLabel P1B11;
    private javax.swing.JLabel P1B12;
    private javax.swing.JLabel P1B13;
    private javax.swing.JLabel P1B14;
    private javax.swing.JLabel P1B15;
    private javax.swing.JLabel P1B16;
    private javax.swing.JLabel P1B17;
    private javax.swing.JLabel P1B18;
    private javax.swing.JLabel P1B19;
    private javax.swing.JLabel P1B2;
    private javax.swing.JLabel P1B20;
    private javax.swing.JLabel P1B21;
    private javax.swing.JLabel P1B22;
    private javax.swing.JLabel P1B23;
    private javax.swing.JLabel P1B24;
    private javax.swing.JLabel P1B25;
    private javax.swing.JLabel P1B26;
    private javax.swing.JLabel P1B27;
    private javax.swing.JLabel P1B28;
    private javax.swing.JLabel P1B29;
    private javax.swing.JLabel P1B3;
    private javax.swing.JLabel P1B30;
    private javax.swing.JLabel P1B31;
    private javax.swing.JLabel P1B32;
    private javax.swing.JLabel P1B33;
    private javax.swing.JLabel P1B34;
    private javax.swing.JLabel P1B35;
    private javax.swing.JLabel P1B36;
    private javax.swing.JLabel P1B4;
    private javax.swing.JLabel P1B5;
    private javax.swing.JLabel P1B6;
    private javax.swing.JLabel P1B7;
    private javax.swing.JLabel P1B8;
    private javax.swing.JLabel P1B9;
    private javax.swing.JLabel P2B1;
    private javax.swing.JLabel P2B10;
    private javax.swing.JLabel P2B11;
    private javax.swing.JLabel P2B12;
    private javax.swing.JLabel P2B13;
    private javax.swing.JLabel P2B14;
    private javax.swing.JLabel P2B15;
    private javax.swing.JLabel P2B16;
    private javax.swing.JLabel P2B17;
    private javax.swing.JLabel P2B18;
    private javax.swing.JLabel P2B19;
    private javax.swing.JLabel P2B2;
    private javax.swing.JLabel P2B20;
    private javax.swing.JLabel P2B21;
    private javax.swing.JLabel P2B22;
    private javax.swing.JLabel P2B23;
    private javax.swing.JLabel P2B24;
    private javax.swing.JLabel P2B25;
    private javax.swing.JLabel P2B26;
    private javax.swing.JLabel P2B27;
    private javax.swing.JLabel P2B28;
    private javax.swing.JLabel P2B29;
    private javax.swing.JLabel P2B3;
    private javax.swing.JLabel P2B30;
    private javax.swing.JLabel P2B31;
    private javax.swing.JLabel P2B32;
    private javax.swing.JLabel P2B33;
    private javax.swing.JLabel P2B34;
    private javax.swing.JLabel P2B35;
    private javax.swing.JLabel P2B36;
    private javax.swing.JLabel P2B4;
    private javax.swing.JLabel P2B5;
    private javax.swing.JLabel P2B6;
    private javax.swing.JLabel P2B7;
    private javax.swing.JLabel P2B8;
    private javax.swing.JLabel P2B9;
    private javax.swing.JLabel P3B1;
    private javax.swing.JLabel P3B10;
    private javax.swing.JLabel P3B11;
    private javax.swing.JLabel P3B12;
    private javax.swing.JLabel P3B13;
    private javax.swing.JLabel P3B14;
    private javax.swing.JLabel P3B15;
    private javax.swing.JLabel P3B16;
    private javax.swing.JLabel P3B17;
    private javax.swing.JLabel P3B18;
    private javax.swing.JLabel P3B19;
    private javax.swing.JLabel P3B2;
    private javax.swing.JLabel P3B20;
    private javax.swing.JLabel P3B21;
    private javax.swing.JLabel P3B22;
    private javax.swing.JLabel P3B23;
    private javax.swing.JLabel P3B24;
    private javax.swing.JLabel P3B25;
    private javax.swing.JLabel P3B26;
    private javax.swing.JLabel P3B27;
    private javax.swing.JLabel P3B28;
    private javax.swing.JLabel P3B29;
    private javax.swing.JLabel P3B3;
    private javax.swing.JLabel P3B30;
    private javax.swing.JLabel P3B31;
    private javax.swing.JLabel P3B32;
    private javax.swing.JLabel P3B33;
    private javax.swing.JLabel P3B34;
    private javax.swing.JLabel P3B35;
    private javax.swing.JLabel P3B36;
    private javax.swing.JLabel P3B4;
    private javax.swing.JLabel P3B5;
    private javax.swing.JLabel P3B6;
    private javax.swing.JLabel P3B7;
    private javax.swing.JLabel P3B8;
    private javax.swing.JLabel P3B9;
    private javax.swing.JLabel P4B1;
    private javax.swing.JLabel P4B10;
    private javax.swing.JLabel P4B11;
    private javax.swing.JLabel P4B12;
    private javax.swing.JLabel P4B13;
    private javax.swing.JLabel P4B14;
    private javax.swing.JLabel P4B15;
    private javax.swing.JLabel P4B16;
    private javax.swing.JLabel P4B17;
    private javax.swing.JLabel P4B18;
    private javax.swing.JLabel P4B19;
    private javax.swing.JLabel P4B2;
    private javax.swing.JLabel P4B20;
    private javax.swing.JLabel P4B21;
    private javax.swing.JLabel P4B22;
    private javax.swing.JLabel P4B23;
    private javax.swing.JLabel P4B24;
    private javax.swing.JLabel P4B25;
    private javax.swing.JLabel P4B26;
    private javax.swing.JLabel P4B27;
    private javax.swing.JLabel P4B28;
    private javax.swing.JLabel P4B29;
    private javax.swing.JLabel P4B3;
    private javax.swing.JLabel P4B30;
    private javax.swing.JLabel P4B31;
    private javax.swing.JLabel P4B32;
    private javax.swing.JLabel P4B33;
    private javax.swing.JLabel P4B34;
    private javax.swing.JLabel P4B35;
    private javax.swing.JLabel P4B36;
    private javax.swing.JLabel P4B4;
    private javax.swing.JLabel P4B5;
    private javax.swing.JLabel P4B6;
    private javax.swing.JLabel P4B7;
    private javax.swing.JLabel P4B8;
    private javax.swing.JLabel P4B9;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnCD;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHouseP1;
    private javax.swing.JButton btnHouseP2;
    private javax.swing.JButton btnHouseP3;
    private javax.swing.JButton btnHouseP4;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPass;
    private javax.swing.JButton btnReBuy;
    private javax.swing.JButton btnRoll;
    private javax.swing.JButton btnTrade;
    private javax.swing.JDialog dlgLog;
    private javax.swing.JFrame frmBuy;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBoard;
    private javax.swing.JLabel lblHoverB1;
    private javax.swing.JLabel lblHoverB2;
    private javax.swing.JLabel lblHoverB3;
    private javax.swing.JLabel lblHoverB4;
    private javax.swing.JLabel lblHoverB5;
    private javax.swing.JLabel lblHoverB6;
    private javax.swing.JLabel lblHoverB7;
    private javax.swing.JLabel lblIconP1;
    private javax.swing.JLabel lblIconP2;
    private javax.swing.JLabel lblIconP3;
    private javax.swing.JLabel lblIconP4;
    private javax.swing.JLabel lblMoneyP1;
    private javax.swing.JLabel lblMoneyP2;
    private javax.swing.JLabel lblMoneyP3;
    private javax.swing.JLabel lblMoneyP4;
    private javax.swing.JLabel lblNameP1;
    private javax.swing.JLabel lblNameP2;
    private javax.swing.JLabel lblNameP3;
    private javax.swing.JLabel lblNameP4;
    private javax.swing.JPanel paneB1;
    private javax.swing.JPanel paneB10;
    private javax.swing.JPanel paneB11;
    private javax.swing.JPanel paneB12;
    private javax.swing.JPanel paneB13;
    private javax.swing.JPanel paneB14;
    private javax.swing.JPanel paneB15;
    private javax.swing.JPanel paneB16;
    private javax.swing.JPanel paneB17;
    private javax.swing.JPanel paneB18;
    private javax.swing.JPanel paneB19;
    private javax.swing.JPanel paneB2;
    private javax.swing.JPanel paneB20;
    private javax.swing.JPanel paneB21;
    private javax.swing.JPanel paneB22;
    private javax.swing.JPanel paneB23;
    private javax.swing.JPanel paneB24;
    private javax.swing.JPanel paneB25;
    private javax.swing.JPanel paneB26;
    private javax.swing.JPanel paneB27;
    private javax.swing.JPanel paneB28;
    private javax.swing.JPanel paneB29;
    private javax.swing.JPanel paneB3;
    private javax.swing.JPanel paneB30;
    private javax.swing.JPanel paneB31;
    private javax.swing.JPanel paneB32;
    private javax.swing.JPanel paneB33;
    private javax.swing.JPanel paneB34;
    private javax.swing.JPanel paneB35;
    private javax.swing.JPanel paneB36;
    private javax.swing.JPanel paneB4;
    private javax.swing.JPanel paneB5;
    private javax.swing.JPanel paneB6;
    private javax.swing.JPanel paneB7;
    private javax.swing.JPanel paneB8;
    private javax.swing.JPanel paneB9;
    private javax.swing.JLayeredPane paneBoard;
    private javax.swing.JPanel paneBoss;
    private javax.swing.JPanel paneCard;
    private javax.swing.JPanel paneControls;
    private javax.swing.JPanel paneP1;
    private javax.swing.JPanel paneP2;
    private javax.swing.JPanel paneP3;
    private javax.swing.JPanel paneP4;
    private javax.swing.JTextPane txtLog;
    // End of variables declaration//GEN-END:variables

  }
