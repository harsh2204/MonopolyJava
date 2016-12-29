/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Harsh Gupta, Karmit Patel
 */
public final class Board extends javax.swing.JFrame
  {

    /**
     * Creates new form Board
     */
    public static int players, i, dice, chance, roll, turn = 0, count = 0, propOwner;
    public static String theme;
    public static int[] money = new int[4], numprop = new int[4], cpos = new int[4], npos = new int[4], bonus = new int[4], jailfee = new int[4];
    public static String[] name = new String[4];
    public ThemeSelect ts = new ThemeSelect();
    public InitTest it = new InitTest();
    public Dice di = new Dice();
    public Properties_Data pd = new Properties_Data();
    public static ImageIcon piece;
    public static ImageIcon[] icons = new ImageIcon[100], icon = new ImageIcon[4];
    public static boolean snake = false, bail = false, propOwned = false, propBuyable = true;
    public static JLabel[][] boxes = new JLabel[4][37];
    public static JLabel[] plnames = new JLabel[4], plicons = new JLabel[4], plmoney = new JLabel[4];
    Card c;
    public static Image image;
    public static Timer moveTimer;

    public Board(int playerCount)
      {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.players = playerCount;
        datatransfer();
        System.out.println("Board: Number of pCount: " + players);
//        setPlayernumber();
        setupLabels();
        setupplabels();
        changeimages();
        addpCount();
      }

    public void changeimages()
      {
        for (i = 0; i < players; i++)
          {
            image = icon[i].getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            icons[i] = new ImageIcon(image);
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
        for (i = 0; i < players; i++)
          {
            numprop[i] = 0;
            cpos[i] = 0;
            npos[i] = 0;
            System.out.println("Board: Info:-" + i + " " + name[i] + " " + icon[i] + " " + money[i]);
          }
        System.out.println("Board: Data Transfered!");
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
//        for (int i = 0; i < 4; i++) {
//            for (int k = 0; k < 36; k++) {
//               boxes[i][k].setIcon(new ImageIcon("Icons/Pieces/Canada/1.png"));
//            }
//        }
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
        paneP1.setVisible(true);
        paneP2.setVisible(true);
        System.out.println("Board: pCount Added!");
      }

    public void makeCard(Color bg, ImageIcon i, int index)
      {

        System.out.println("Board- Colour:" + bg + "Index: " + index);
        c = new Card(bg, i, index);
        c.setVisible(true);
      }

    public void breakCard()
      {
        c.setVisible(false);
      }

    public void move(final int turnn)
      {
        npos[turnn] = cpos[turnn] + roll;
        System.out.println("Roll: " + roll + " New Position: " + npos[turnn] + " Current Position: " + cpos[turnn] + " Turn: " + turnn);
        if (npos[turnn] > 35)
          {
            npos[turnn] = npos[turnn] - 35;
          }
        rands.setText("Turn:" + turnn + "Roll:" + roll);
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
                    btnRoll.setEnabled(true);
                    moveTimer.stop();
                    propcall(cpos, turnn);
                  }
              }
          });
        moveTimer.start();
      }

    public void propcall(int[] cpos, int turn)
      {
        pd.GetProp();
        propOwned = pd.prop[cpos[turn]].owned;
        System.out.println("Board: " + cpos[turn] + " Turn: " + turn + " Owned: " + propOwned);
        if (propOwned == false)
          {
            propBuyable = pd.prop[cpos[turn]].buyable;
            System.out.println("Board: " + cpos[turn] + " Turn: " + turn + " Owned: " + propBuyable);
            if (propBuyable == true)
              {
//                buyMenu(cpos[turn],turn);//To be made
              } else
              {
//                checkPropType(cpos[turn],turn);//Check if it is jail or special cards like chance or community chest
              }
          } else
          {
//            payMenu(cpos[turn],turn);//To be made "buyMenu and payMenu" both are forms to be made
          }
      }

    public void rolling()
      {
        if (turn == players)
          {
            turn = 0;
          }
//        roll=di.rollDice();//Temporary Testing Cause
        if (dice == 2)
          {
            roll = (int) (Math.random() * 12 + 1);
          } else
          {
            roll = (int) (Math.random() * 6 + 1);
          }
        move(turn);
        turn++;
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

        paneBoss = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
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
        lblBoard = new javax.swing.JLabel();
        paneControls = new javax.swing.JPanel();
        btnRoll = new javax.swing.JButton();
        paneP1 = new javax.swing.JPanel();
        lblNameP1 = new javax.swing.JLabel();
        lblIconP1 = new javax.swing.JLabel();
        lblMoneyP1 = new javax.swing.JLabel();
        paneP2 = new javax.swing.JPanel();
        lblNameP2 = new javax.swing.JLabel();
        lblIconP2 = new javax.swing.JLabel();
        lblMoneyP2 = new javax.swing.JLabel();
        paneP3 = new javax.swing.JPanel();
        lblNameP3 = new javax.swing.JLabel();
        lblIconP3 = new javax.swing.JLabel();
        lblMoneyP3 = new javax.swing.JLabel();
        paneP4 = new javax.swing.JPanel();
        lblNameP4 = new javax.swing.JLabel();
        lblIconP4 = new javax.swing.JLabel();
        lblMoneyP4 = new javax.swing.JLabel();
        rands = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLayeredPane1.add(lblHoverB7);
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
        jLayeredPane1.add(lblHoverB6);
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
        jLayeredPane1.add(lblHoverB5);
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
        jLayeredPane1.add(lblHoverB4);
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
        jLayeredPane1.add(lblHoverB3);
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
        jLayeredPane1.add(lblHoverB2);
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
        jLayeredPane1.add(lblHoverB1);
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

        jLayeredPane1.add(paneB1);
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

        jLayeredPane1.add(paneB2);
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

        jLayeredPane1.add(paneB3);
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

        jLayeredPane1.add(paneB4);
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

        jLayeredPane1.add(paneB5);
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

        jLayeredPane1.add(paneB6);
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

        jLayeredPane1.add(paneB7);
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

        jLayeredPane1.add(paneB8);
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

        jLayeredPane1.add(paneB9);
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

        jLayeredPane1.add(paneB10);
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

        jLayeredPane1.add(paneB11);
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

        jLayeredPane1.add(paneB12);
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

        jLayeredPane1.add(paneB13);
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

        jLayeredPane1.add(paneB14);
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

        jLayeredPane1.add(paneB15);
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

        jLayeredPane1.add(paneB16);
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

        jLayeredPane1.add(paneB17);
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

        jLayeredPane1.add(paneB18);
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

        jLayeredPane1.add(paneB19);
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

        jLayeredPane1.add(paneB20);
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

        jLayeredPane1.add(paneB21);
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

        jLayeredPane1.add(paneB22);
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

        jLayeredPane1.add(paneB23);
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

        jLayeredPane1.add(paneB24);
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

        jLayeredPane1.add(paneB25);
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

        jLayeredPane1.add(paneB26);
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

        jLayeredPane1.add(paneB27);
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

        jLayeredPane1.add(paneB28);
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

        jLayeredPane1.add(paneB29);
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

        jLayeredPane1.add(paneB30);
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

        jLayeredPane1.add(paneB31);
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

        jLayeredPane1.add(paneB32);
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

        jLayeredPane1.add(paneB33);
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

        jLayeredPane1.add(paneB34);
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

        jLayeredPane1.add(paneB35);
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

        jLayeredPane1.add(paneB36);
        paneB36.setBounds(95, 640, 58, 51);

        lblBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monopolyalpha/Canada Green Board.png"))); // NOI18N
        jLayeredPane1.add(lblBoard);
        lblBoard.setBounds(0, 0, 700, 700);

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

        javax.swing.GroupLayout paneControlsLayout = new javax.swing.GroupLayout(paneControls);
        paneControls.setLayout(paneControlsLayout);
        paneControlsLayout.setHorizontalGroup(
            paneControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneControlsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(583, Short.MAX_VALUE))
        );
        paneControlsLayout.setVerticalGroup(
            paneControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRoll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblNameP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNameP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMoneyP1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMoneyP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout paneP1Layout = new javax.swing.GroupLayout(paneP1);
        paneP1.setLayout(paneP1Layout);
        paneP1Layout.setHorizontalGroup(
            paneP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNameP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMoneyP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconP1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
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
                .addComponent(lblMoneyP1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNameP2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNameP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMoneyP2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMoneyP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout paneP2Layout = new javax.swing.GroupLayout(paneP2);
        paneP2.setLayout(paneP2Layout);
        paneP2Layout.setHorizontalGroup(
            paneP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNameP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(paneP2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconP2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(lblMoneyP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneP2Layout.setVerticalGroup(
            paneP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP2Layout.createSequentialGroup()
                .addComponent(lblNameP2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIconP2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMoneyP2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNameP3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNameP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMoneyP3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMoneyP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout paneP3Layout = new javax.swing.GroupLayout(paneP3);
        paneP3.setLayout(paneP3Layout);
        paneP3Layout.setHorizontalGroup(
            paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNameP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMoneyP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconP3, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneP3Layout.setVerticalGroup(
            paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNameP3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lblIconP3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMoneyP3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNameP4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNameP4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMoneyP4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMoneyP4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout paneP4Layout = new javax.swing.GroupLayout(paneP4);
        paneP4.setLayout(paneP4Layout);
        paneP4Layout.setHorizontalGroup(
            paneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconP4, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(lblMoneyP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameP4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblMoneyP4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneBossLayout = new javax.swing.GroupLayout(paneBoss);
        paneBoss.setLayout(paneBossLayout);
        paneBossLayout.setHorizontalGroup(
            paneBossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBossLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(paneControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
            .addGroup(paneBossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneBossLayout.createSequentialGroup()
                    .addGap(0, 3, Short.MAX_VALUE)
                    .addGroup(paneBossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(paneP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rands, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(paneBossLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(paneP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addGroup(paneBossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(paneP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(paneP4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 4, Short.MAX_VALUE)))
        );
        paneBossLayout.setVerticalGroup(
            paneBossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneBossLayout.createSequentialGroup()
                .addContainerGap(721, Short.MAX_VALUE)
                .addComponent(paneControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(paneBossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneBossLayout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addGroup(paneBossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneBossLayout.createSequentialGroup()
                            .addComponent(paneP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(rands, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(paneP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(paneBossLayout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(paneP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89)
                            .addComponent(paneP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 101, Short.MAX_VALUE)))
        );

        getContentPane().add(paneBoss, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHoverB1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB1MouseEntered
        // TODO add your handling code here:        
        ImageIcon i = new ImageIcon("Board Pictures/Canada/Bra Image.jpg");
        makeCard(Color.yellow, i, 0);
    }//GEN-LAST:event_lblHoverB1MouseEntered

    private void lblHoverB1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB1MouseExited
        // TODO add your handling code here:        
        breakCard();
    }//GEN-LAST:event_lblHoverB1MouseExited

    private void lblHoverB2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB2MouseEntered
        // TODO add your handling code here:
        ImageIcon i = new ImageIcon("Board Pictures/Canada/Mis Image.jpg");
        makeCard(Color.yellow, i, 1);
    }//GEN-LAST:event_lblHoverB2MouseEntered

    private void lblHoverB2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB2MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB2MouseExited

    private void lblHoverB3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB3MouseEntered
        // TODO add your handling code here:
        ImageIcon i = new ImageIcon("Board Pictures/Canada/Mis Image.jpg");
        makeCard(Color.gray, i, 20);
    }//GEN-LAST:event_lblHoverB3MouseEntered

    private void lblHoverB3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB3MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB3MouseExited

    private void lblHoverB4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB4MouseEntered
        // TODO add your handling code here:
        ImageIcon i = new ImageIcon("Board Pictures/Canada/YK Image.jpg");
        makeCard(Color.yellow, i, 2);
    }//GEN-LAST:event_lblHoverB4MouseEntered

    private void lblHoverB4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB4MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB4MouseExited

    private void lblHoverB5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB5MouseEntered
        // TODO add your handling code here:
        ImageIcon i = new ImageIcon("Board Pictures/Canada/Mis Image.jpg");
        makeCard(Color.gray, i, 21);
    }//GEN-LAST:event_lblHoverB5MouseEntered

    private void lblHoverB5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB5MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB5MouseExited

    private void lblHoverB6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB6MouseEntered
        // TODO add your handling code here:
        ImageIcon i = new ImageIcon("Board Pictures/Canada/WH Image.jpg");
        makeCard(Color.blue, i, 3);
    }//GEN-LAST:event_lblHoverB6MouseEntered

    private void lblHoverB6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB6MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB6MouseExited

    private void lblHoverB7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB7MouseEntered
        // TODO add your handling code here:
        ImageIcon i = new ImageIcon("Board Pictures/Canada/Iqa Image.jpg");
        makeCard(Color.blue, i, 4);
    }//GEN-LAST:event_lblHoverB7MouseEntered

    private void lblHoverB7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoverB7MouseExited
        // TODO add your handling code here:
        breakCard();
    }//GEN-LAST:event_lblHoverB7MouseExited

    private void btnRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollActionPerformed
        rolling();
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
    private javax.swing.JButton btnRoll;
    private javax.swing.JLayeredPane jLayeredPane1;
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
    private javax.swing.JPanel paneBoss;
    private javax.swing.JPanel paneControls;
    private javax.swing.JPanel paneP1;
    private javax.swing.JPanel paneP2;
    private javax.swing.JPanel paneP3;
    private javax.swing.JPanel paneP4;
    private javax.swing.JLabel rands;
    // End of variables declaration//GEN-END:variables

  }
