/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;

/**
 *
 * @author Harsh, Karmit, Haard, Neel(barely)
 */
public final class InitTest extends JFrame
  {

    //Initialize piece name and image variables   
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static String theme;
    public static int startmoney, dicenum = 1, bonusmoney, jailfee, counter, pCount=0, w, h, i;
    public static String piecep1, piecep2, piecep3, piecep4, piecep5, piecep6, piecep7, piecep8;
    public static ImageIcon i1, i2, i3, i4, i5, i6, i7, i8;
    public static ArrayList<ImageIcon> images = new ArrayList<>();
    public static String nameo, t1, t2, t3, t4;
    public static NickNames nickName = new NickNames();
    public static Timer ti;
    public static int[] startm = new int[4], bonusm = new int[4], jailfeem = new int[4];
    public static ImageIcon[] combo = new ImageIcon[100], icon = new ImageIcon[4];
    public static String[] combos = new String[100], pieces = new String[100], name = new String[4];
    public static String[][] player = new String[4][100];
    public ThemeSelect ts = new ThemeSelect();
    public static JTextField[] plnames = new JTextField[4];
    public static JLabel[] plicons = new JLabel[4];
    public static Boolean snake = false, jail = false;

    public InitTest()
      {
        datatransfer();
        initComponents();
        combosetting();
        checker();
        this.setExtendedState(MAXIMIZED_BOTH);
        imagesetting();
        setup();
      }

    public void setup()
      {
        plnames[0] = txtNameP1;
        plnames[1] = txtNameP2;
        plnames[2] = txtNameP3;
        plnames[3] = txtNameP4;
        plicons[0] = lblPiece1;
        plicons[1] = lblPiece2;
        plicons[2] = lblPiece3;
        plicons[3] = lblPiece4;
      }

    public void imagesetting()
      {
        images.add(0, null);
        images.add(1, i1);
        images.add(2, i2);
        images.add(3, i3);
        images.add(4, i4);
        images.add(5, i5);
        images.add(6, i6);
        images.add(7, i7);
        images.add(8, i8);
      }

    public void combosetting()
      {
        comIconP1.setModel(new javax.swing.DefaultComboBoxModel(new String[]
          {
            pieces[0], pieces[1], pieces[2], pieces[3], pieces[4], pieces[5], pieces[6], pieces[7], pieces[8]
          }));
        comIconP2.setModel(new javax.swing.DefaultComboBoxModel(new String[]
          {
            pieces[0], pieces[1], pieces[2], pieces[3], pieces[4], pieces[5], pieces[6], pieces[7], pieces[8]
          }));
        comIconP3.setModel(new javax.swing.DefaultComboBoxModel(new String[]
          {
            pieces[0], pieces[1], pieces[2], pieces[3], pieces[4], pieces[5], pieces[6], pieces[7], pieces[8]
          }));
        comIconP4.setModel(new javax.swing.DefaultComboBoxModel(new String[]
          {
            pieces[0], pieces[1], pieces[2], pieces[3], pieces[4], pieces[5], pieces[6], pieces[7], pieces[8]
          }));
      }

    public void datatransfer()
      {
        switch (ts.theme)
          {
            case "Canada":
                ts.canth();
                System.out.println("" + ts.theme);
                break;
            case "Generic":
                ts.genth();
                System.out.println("" + ts.theme);
                break;
            case "SuperHeroes":
                ts.supth();
                System.out.println("" + ts.theme);
                break;
          }
        this.theme = ts.theme;
        this.piecep1 = ts.piece1;
        this.piecep2 = ts.piece2;
        this.piecep3 = ts.piece3;
        this.piecep4 = ts.piece4;
        this.piecep5 = ts.piece5;
        this.piecep6 = ts.piece6;
        this.piecep7 = ts.piece7;
        this.piecep8 = ts.piece8;
        this.i1 = ts.i1;
        this.i2 = ts.i2;
        this.i3 = ts.i3;
        this.i4 = ts.i4;
        this.i5 = ts.i5;
        this.i6 = ts.i6;
        this.i7 = ts.i7;
        this.i8 = ts.i8;
        pieces[0] = "---";
        pieces[1] = piecep1;
        pieces[2] = piecep2;
        pieces[3] = piecep3;
        pieces[4] = piecep4;
        pieces[5] = piecep5;
        pieces[6] = piecep6;
        pieces[7] = piecep7;
        pieces[8] = piecep8;
      }


    public void setStartmoney()
      {
        int i = comMoney.getSelectedIndex();
        switch (i)
          {
            case 0:
                startmoney = 500;
                break;
            case 1:
                startmoney = 1000;
                break;
            case 2:
                startmoney = 1500;
                break;
            case 3:
                startmoney = 2000;
                break;
          }
      }

    public void setBonusmoney()
      {
        int i = comBonAmt.getSelectedIndex();
        switch (i)
          {
            case 0:
                bonusmoney = 50;
                break;
            case 1:
                bonusmoney = 100;
                break;
            case 2:
                bonusmoney = 120;
                break;
          }
      }

    public void setBailfee()
      {
        int i = comBailFee.getSelectedIndex();
        switch (i)
          {
            case 0:
                jailfee = 100;
                break;
            case 1:
                jailfee = 150;
                break;
            case 2:
                jailfee = 200;
                break;
          }
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        sldPlayer = new javax.swing.JSlider();
        paneP1_P2 = new javax.swing.JPanel();
        comIconP1 = new javax.swing.JComboBox();
        lblP1 = new javax.swing.JLabel();
        txtNameP1 = new javax.swing.JTextField();
        lblIcon1 = new javax.swing.JLabel();
        lblPiece1 = new javax.swing.JLabel();
        lblIcon2 = new javax.swing.JLabel();
        lblP2 = new javax.swing.JLabel();
        txtNameP2 = new javax.swing.JTextField();
        comIconP2 = new javax.swing.JComboBox();
        lblPiece2 = new javax.swing.JLabel();
        btnRand1 = new javax.swing.JButton();
        btnRand2 = new javax.swing.JButton();
        paneP3 = new javax.swing.JPanel();
        lblIcon3 = new javax.swing.JLabel();
        lblP3 = new javax.swing.JLabel();
        txtNameP3 = new javax.swing.JTextField();
        comIconP3 = new javax.swing.JComboBox();
        lblPiece3 = new javax.swing.JLabel();
        btnRand3 = new javax.swing.JButton();
        PaneP4 = new javax.swing.JPanel();
        lblIcon4 = new javax.swing.JLabel();
        lblP4 = new javax.swing.JLabel();
        txtNameP4 = new javax.swing.JTextField();
        comIconP4 = new javax.swing.JComboBox();
        lblPiece4 = new javax.swing.JLabel();
        btnRand4 = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        paneDice = new javax.swing.JPanel();
        lblDice = new javax.swing.JLabel();
        lblStartup = new javax.swing.JLabel();
        lblEGS = new javax.swing.JLabel();
        comEGS = new javax.swing.JComboBox();
        comMoney = new javax.swing.JComboBox();
        btnDice = new javax.swing.JButton();
        paneBonus = new javax.swing.JPanel();
        comBonAmt = new javax.swing.JComboBox();
        rndSnake = new javax.swing.JRadioButton();
        rndBail = new javax.swing.JRadioButton();
        comBailFee = new javax.swing.JComboBox();
        lblBailFee = new javax.swing.JLabel();
        lblBonAmt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        sldPlayer.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        sldPlayer.setMajorTickSpacing(2);
        sldPlayer.setMaximum(4);
        sldPlayer.setMinimum(2);
        sldPlayer.setMinorTickSpacing(1);
        sldPlayer.setOrientation(javax.swing.JSlider.VERTICAL);
        sldPlayer.setPaintLabels(true);
        sldPlayer.setPaintTicks(true);
        sldPlayer.setSnapToTicks(true);
        sldPlayer.setValue(2);
        sldPlayer.setInverted(true);
        sldPlayer.setOpaque(false);
        sldPlayer.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                sldPlayerStateChanged(evt);
            }
        });

        paneP1_P2.setBackground(new Color(0, 0, 0, 0));
        paneP1_P2.setOpaque(false);

        comIconP1.setBackground(java.awt.Color.green);
        comIconP1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP1.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                comIconP1ItemStateChanged(evt);
            }
        });
        comIconP1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comIconP1ActionPerformed(evt);
            }
        });

        lblP1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblP1.setText("Player 1:");

        txtNameP1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        txtNameP1.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                txtNameP1FocusLost(evt);
            }
        });
        txtNameP1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                txtNameP1KeyPressed(evt);
            }
        });

        lblIcon1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblIcon1.setText("Icon:");

        lblPiece1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece1.setEnabled(false);

        lblIcon2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblIcon2.setText("Icon:");

        lblP2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblP2.setText("Player 2:");

        txtNameP2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        txtNameP2.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                txtNameP2FocusLost(evt);
            }
        });
        txtNameP2.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                txtNameP2KeyPressed(evt);
            }
        });

        comIconP2.setBackground(java.awt.Color.green);
        comIconP2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comIconP2ActionPerformed(evt);
            }
        });

        lblPiece2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece2.setEnabled(false);

        btnRand1.setBackground(java.awt.Color.yellow);
        btnRand1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnRand1.setText("Random 1");
        btnRand1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btnRand1MouseClicked(evt);
            }
        });

        btnRand2.setBackground(java.awt.Color.yellow);
        btnRand2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnRand2.setText("Random 2");
        btnRand2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btnRand2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout paneP1_P2Layout = new javax.swing.GroupLayout(paneP1_P2);
        paneP1_P2.setLayout(paneP1_P2Layout);
        paneP1_P2Layout.setHorizontalGroup(
            paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP1_P2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneP1_P2Layout.createSequentialGroup()
                        .addGroup(paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneP1_P2Layout.createSequentialGroup()
                                .addComponent(lblP2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNameP2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneP1_P2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btnRand2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP1_P2Layout.createSequentialGroup()
                                .addComponent(lblIcon2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comIconP2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPiece2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneP1_P2Layout.createSequentialGroup()
                        .addGroup(paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paneP1_P2Layout.createSequentialGroup()
                                .addComponent(btnRand1)
                                .addGap(82, 82, 82))
                            .addGroup(paneP1_P2Layout.createSequentialGroup()
                                .addGroup(paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(paneP1_P2Layout.createSequentialGroup()
                                        .addComponent(lblIcon1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comIconP1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(paneP1_P2Layout.createSequentialGroup()
                                        .addComponent(lblP1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNameP1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(lblPiece1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneP1_P2Layout.setVerticalGroup(
            paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP1_P2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneP1_P2Layout.createSequentialGroup()
                        .addGroup(paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblP1)
                            .addComponent(txtNameP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRand1)
                        .addGap(18, 18, 18)
                        .addGroup(paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comIconP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIcon1)))
                    .addComponent(lblPiece1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneP1_P2Layout.createSequentialGroup()
                        .addGroup(paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblP2)
                            .addComponent(txtNameP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRand2)
                        .addGap(18, 18, 18)
                        .addGroup(paneP1_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comIconP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIcon2)))
                    .addComponent(lblPiece2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneP3.setOpaque(false);

        lblIcon3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblIcon3.setText("Icon:");

        lblP3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblP3.setText("Player 3:");

        txtNameP3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        txtNameP3.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                txtNameP3FocusLost(evt);
            }
        });
        txtNameP3.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                txtNameP3KeyPressed(evt);
            }
        });

        comIconP3.setBackground(java.awt.Color.green);
        comIconP3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comIconP3ActionPerformed(evt);
            }
        });

        lblPiece3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece3.setEnabled(false);

        btnRand3.setBackground(java.awt.Color.yellow);
        btnRand3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnRand3.setText("Random 3");
        btnRand3.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btnRand3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout paneP3Layout = new javax.swing.GroupLayout(paneP3);
        paneP3.setLayout(paneP3Layout);
        paneP3Layout.setHorizontalGroup(
            paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP3Layout.createSequentialGroup()
                .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneP3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paneP3Layout.createSequentialGroup()
                                .addComponent(lblIcon3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comIconP3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneP3Layout.createSequentialGroup()
                                .addComponent(lblP3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNameP3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneP3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnRand3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPiece3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneP3Layout.setVerticalGroup(
            paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP3Layout.createSequentialGroup()
                        .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblP3)
                            .addComponent(txtNameP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRand3)
                        .addGap(18, 18, 18)
                        .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comIconP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIcon3))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP3Layout.createSequentialGroup()
                        .addComponent(lblPiece3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        PaneP4.setOpaque(false);

        lblIcon4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblIcon4.setText("Icon:");

        lblP4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblP4.setText("Player 4:");

        txtNameP4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        txtNameP4.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                txtNameP4FocusLost(evt);
            }
        });
        txtNameP4.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                txtNameP4KeyPressed(evt);
            }
        });

        comIconP4.setBackground(java.awt.Color.green);
        comIconP4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comIconP4ActionPerformed(evt);
            }
        });

        lblPiece4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece4.setEnabled(false);

        btnRand4.setBackground(java.awt.Color.yellow);
        btnRand4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnRand4.setText("Random 4");
        btnRand4.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btnRand4MouseClicked(evt);
            }
        });
        btnRand4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRand4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaneP4Layout = new javax.swing.GroupLayout(PaneP4);
        PaneP4.setLayout(PaneP4Layout);
        PaneP4Layout.setHorizontalGroup(
            PaneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneP4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PaneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PaneP4Layout.createSequentialGroup()
                        .addComponent(lblP4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNameP4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PaneP4Layout.createSequentialGroup()
                        .addComponent(lblIcon4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comIconP4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PaneP4Layout.createSequentialGroup()
                        .addComponent(btnRand4)
                        .addGap(77, 77, 77)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPiece4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PaneP4Layout.setVerticalGroup(
            PaneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneP4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PaneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneP4Layout.createSequentialGroup()
                        .addGroup(PaneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblP4)
                            .addComponent(txtNameP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRand4)
                        .addGap(18, 18, 18)
                        .addGroup(PaneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comIconP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIcon4))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneP4Layout.createSequentialGroup()
                        .addComponent(lblPiece4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        lblTitle.setFont(new java.awt.Font("Showcard Gothic", 1, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("New Game");
        int w = (int) screenSize.getWidth();
        int h = (int) screenSize.getHeight();
        if (w == 1024 && h == 768)
        {
            this.setContentPane(new JLabel(new ImageIcon("Icons/Miscellaneous/red1024-768.png")));
        }else if (w == 1280 && h == 768)
        {
            this.setContentPane(new JLabel(new ImageIcon("Icons/Miscellaneous/red1280-768.png")));
        } else if (w == 1280 && h == 1024)
        {
            this.setContentPane(new JLabel(new ImageIcon("Icons/Miscellaneous/red1280-1024.png")));
        } else if (w == 1366 && h == 768)
        {
            this.setContentPane(new JLabel(new ImageIcon("Icons/Miscellaneous/red1366-768.png")));
        }

        btnBack.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btnNext.setText("Next>");
        btnNext.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnNextActionPerformed(evt);
            }
        });

        paneDice.setOpaque(false);

        lblDice.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblDice.setText("Number of Dice:");

        lblStartup.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblStartup.setText("Amount of Startup money:");

        lblEGS.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblEGS.setText("End Game Scenario:");

        comEGS.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N
        comEGS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Last player standing", "45 turns per player", "60 turns per player", "75 turns per player" }));
        comEGS.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comEGSActionPerformed(evt);
            }
        });

        comMoney.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comMoney.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "$ 500", "$ 1000", "$ 1500", "$ 2000" }));
        comMoney.setAutoscrolls(true);
        comMoney.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comMoney.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                comMoneyItemStateChanged(evt);
            }
        });
        comMoney.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comMoneyActionPerformed(evt);
            }
        });

        btnDice.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnDice.setText("1 Dice");
        btnDice.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneDiceLayout = new javax.swing.GroupLayout(paneDice);
        paneDice.setLayout(paneDiceLayout);
        paneDiceLayout.setHorizontalGroup(
            paneDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDiceLayout.createSequentialGroup()
                        .addComponent(lblEGS)
                        .addGap(70, 70, 70)
                        .addComponent(comEGS, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneDiceLayout.createSequentialGroup()
                        .addComponent(lblDice, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnDice))
                    .addGroup(paneDiceLayout.createSequentialGroup()
                        .addComponent(lblStartup, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneDiceLayout.setVerticalGroup(
            paneDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDiceLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblDice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDice))
                .addGap(4, 4, 4)
                .addGroup(paneDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDiceLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblStartup, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneDiceLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(comMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(paneDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEGS)
                    .addComponent(comEGS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        paneBonus.setOpaque(false);

        comBonAmt.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        comBonAmt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "$50", "$100", "$120" }));
        comBonAmt.setEnabled(false);
        comBonAmt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comBonAmtActionPerformed(evt);
            }
        });

        rndSnake.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        rndSnake.setText("Snake Eye Bonus");
        rndSnake.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rndSnakeActionPerformed(evt);
            }
        });

        rndBail.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        rndBail.setText("JAIL BAIL");
        rndBail.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rndBailActionPerformed(evt);
            }
        });

        comBailFee.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        comBailFee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "$100", "$150", "$200" }));
        comBailFee.setEnabled(false);
        comBailFee.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comBailFeeActionPerformed(evt);
            }
        });

        lblBailFee.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblBailFee.setText("BAIL FEE:");
        lblBailFee.setEnabled(false);

        lblBonAmt.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblBonAmt.setText("BONUS AMOUNT :");
        lblBonAmt.setEnabled(false);

        javax.swing.GroupLayout paneBonusLayout = new javax.swing.GroupLayout(paneBonus);
        paneBonus.setLayout(paneBonusLayout);
        paneBonusLayout.setHorizontalGroup(
            paneBonusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
            .addGroup(paneBonusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneBonusLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(paneBonusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneBonusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneBonusLayout.createSequentialGroup()
                                .addComponent(lblBonAmt)
                                .addGap(43, 43, 43)
                                .addComponent(comBonAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneBonusLayout.createSequentialGroup()
                                .addGroup(paneBonusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rndSnake)
                                    .addComponent(rndBail)
                                    .addGroup(paneBonusLayout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(lblBailFee)))
                                .addGap(68, 68, 68)))
                        .addGroup(paneBonusLayout.createSequentialGroup()
                            .addGap(194, 194, 194)
                            .addComponent(comBailFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(193, Short.MAX_VALUE)))
        );
        paneBonusLayout.setVerticalGroup(
            paneBonusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
            .addGroup(paneBonusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneBonusLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(rndSnake)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(paneBonusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneBonusLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(lblBonAmt))
                        .addComponent(comBonAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(rndBail)
                    .addGap(1, 1, 1)
                    .addGroup(paneBonusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBailFee)
                        .addComponent(comBailFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(33, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneDice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 494, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(paneP1_P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sldPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(paneBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(paneP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PaneP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitle)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sldPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(PaneP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneP1_P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(paneBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneDice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comIconP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comIconP1ActionPerformed
        int i = comIconP1.getSelectedIndex();
        lblPiece1.setDisabledIcon(images.get(i));
        combo[0] = images.get(i);
        NextCopy(1);
    }//GEN-LAST:event_comIconP1ActionPerformed

    private void comIconP2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_comIconP2ActionPerformed
    {//GEN-HEADEREND:event_comIconP2ActionPerformed
        int i = comIconP2.getSelectedIndex();
        lblPiece2.setDisabledIcon(images.get(i));
        combo[1] = images.get(i);
        NextCopy(2);
    }//GEN-LAST:event_comIconP2ActionPerformed

    private void comIconP3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_comIconP3ActionPerformed
    {//GEN-HEADEREND:event_comIconP3ActionPerformed
        int i = comIconP3.getSelectedIndex();
        lblPiece3.setDisabledIcon(images.get(i));
        combo[2] = images.get(i);
        NextCopy(3);
    }//GEN-LAST:event_comIconP3ActionPerformed

    private void comIconP4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_comIconP4ActionPerformed
    {//GEN-HEADEREND:event_comIconP4ActionPerformed
        int i = comIconP4.getSelectedIndex();
        lblPiece4.setDisabledIcon(images.get(i));
        combo[3] = images.get(i);
        NextCopy(4);
    }//GEN-LAST:event_comIconP4ActionPerformed

    private void btnRand1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btnRand1MouseClicked
    {//GEN-HEADEREND:event_btnRand1MouseClicked
        nickName.listName();
        nameo = nickName.name;
        txtNameP1.setText(nameo);
    }//GEN-LAST:event_btnRand1MouseClicked

    private void btnRand2MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btnRand2MouseClicked
    {//GEN-HEADEREND:event_btnRand2MouseClicked
        nickName.listName();
        nameo = nickName.name;
        txtNameP2.setText(nameo);
    }//GEN-LAST:event_btnRand2MouseClicked

    private void btnRand3MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btnRand3MouseClicked
    {//GEN-HEADEREND:event_btnRand3MouseClicked
        nickName.listName();
        nameo = nickName.name;
        txtNameP3.setText(nameo);
    }//GEN-LAST:event_btnRand3MouseClicked

    private void btnRand4MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btnRand4MouseClicked
    {//GEN-HEADEREND:event_btnRand4MouseClicked
        nickName.listName();
        nameo = nickName.name;
        txtNameP4.setText(nameo);
    }//GEN-LAST:event_btnRand4MouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Back
        this.setVisible(false);
        new ThemeSelect().setVisible(true);

    }//GEN-LAST:event_btnBackActionPerformed

    private void comIconP1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comIconP1ItemStateChanged
    }//GEN-LAST:event_comIconP1ItemStateChanged

    public void setplayers()
      {
        setStartmoney();
        setBonusmoney();
        setBailfee();
        if (rndSnake.isSelected())
          {
            snake = true;
          }
        if (rndBail.isSelected())
          {
            jail = true;
          }
        pCount = sldPlayer.getValue();
        for (i = 0; i < pCount; i++)
          {
            name[i] = plnames[i].getText();
            icon[i] = (ImageIcon) plicons[i].getDisabledIcon();
            startm[i] = startmoney;
            if (snake == true)
              {
                bonusm[i] = bonusmoney;
              } else
              {
                bonusm[i] = 0;
              }
            if (jail == true)
              {
                jailfeem[i] = jailfee;
              } else
              {
                jailfeem[i] = 0;
              }
            System.out.println("InitTest: Info:-" + i + " " + name[i] + " " + icon[i] + " " + startm[i] + "pCount: " + pCount);
          }
        System.out.println("InitTest: Number of pCount: " + pCount);
      }
  
    
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        setplayers();
        new Board(pCount).setVisible(true);
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtNameP1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameP1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
          {
            combos[0] = txtNameP1.getText();
            playernameduplicate(1);
          }
    }//GEN-LAST:event_txtNameP1KeyPressed

    private void txtNameP2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameP2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
          {
            combos[1] = txtNameP1.getText();
            playernameduplicate(2);
          }
    }//GEN-LAST:event_txtNameP2KeyPressed

    private void txtNameP3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameP3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
          {
            combos[2] = txtNameP1.getText();
            playernameduplicate(3);
          }
    }//GEN-LAST:event_txtNameP3KeyPressed

    private void txtNameP4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameP4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
          {
            combos[3] = txtNameP1.getText();
            playernameduplicate(4);
          }
    }//GEN-LAST:event_txtNameP4KeyPressed

    private void txtNameP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameP1FocusLost
        playernameduplicate(1);
    }//GEN-LAST:event_txtNameP1FocusLost

    private void txtNameP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameP2FocusLost
        playernameduplicate(2);
    }//GEN-LAST:event_txtNameP2FocusLost

    private void txtNameP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameP3FocusLost
        playernameduplicate(3);
    }//GEN-LAST:event_txtNameP3FocusLost

    private void txtNameP4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameP4FocusLost
        playernameduplicate(4);
    }//GEN-LAST:event_txtNameP4FocusLost

    private void comMoneyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comMoneyItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comMoneyItemStateChanged

    private void comMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comMoneyActionPerformed
        setStartmoney();
    }//GEN-LAST:event_comMoneyActionPerformed

    private void btnRand4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRand4ActionPerformed
    {//GEN-HEADEREND:event_btnRand4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRand4ActionPerformed

    private void rndBailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rndBailActionPerformed
        // TODO add your handling code here:
        jail = true;
        lblBailFee.setEnabled(rndBail.isSelected());
        comBailFee.setEnabled(rndBail.isSelected());
    }//GEN-LAST:event_rndBailActionPerformed

    private void rndSnakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rndSnakeActionPerformed
        // TODO add your handling code here:
        snake = true;
        lblBonAmt.setEnabled(rndSnake.isSelected());
        comBonAmt.setEnabled(rndSnake.isSelected());
    }//GEN-LAST:event_rndSnakeActionPerformed

    private void btnDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiceActionPerformed
        // TODO add your handling code here:
        if (dicenum == 1)
          {
            btnDice.setText("2 Dice");
            dicenum = 2;
          } else
          {
            btnDice.setText("1 Dice");
            dicenum = 1;
          }
    }//GEN-LAST:event_btnDiceActionPerformed

    private void comBonAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBonAmtActionPerformed
        setBonusmoney();
    }//GEN-LAST:event_comBonAmtActionPerformed

    private void comBailFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBailFeeActionPerformed
        setBailfee();
    }//GEN-LAST:event_comBailFeeActionPerformed

    private void comEGSActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_comEGSActionPerformed
    {//GEN-HEADEREND:event_comEGSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comEGSActionPerformed

    private void sldPlayerStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_sldPlayerStateChanged
    {//GEN-HEADEREND:event_sldPlayerStateChanged
        pCount = sldPlayer.getValue();
                checker();
                reset();
    }//GEN-LAST:event_sldPlayerStateChanged

    public void NextCopy(int plnum)
      {
        pliconduplicate(plnum);
      }

    public final void checker()
      {
        pCount = sldPlayer.getValue();
        switch (pCount)
          {
            //If there are 2 players selected
            case 2:
                paneP3.setVisible(false);
                PaneP4.setVisible(false);
                break;
            //If there are 3 players selected
            case 3:
                paneP3.setVisible(true);
                PaneP4.setVisible(false);
                break;
            //If there are 4 players selected
            case 4:
                paneP3.setVisible(true);
                PaneP4.setVisible(true);
                break;
          }
      }

    public void pliconduplicate(int plnum)
      {
        //Get anmes of each player
        t1 = txtNameP1.getText();
        t2 = txtNameP2.getText();
        t3 = txtNameP3.getText();
        t4 = txtNameP4.getText();

        switch (plnum)
          {
            //If there is 1 player selected
            case 1:
                //If Player 1 name is same as Player 2 name

                if (combo[0] == combo[1] || combo[0] == combo[2] || combo[0] == combo[3])
                  {
                    //Set piece image to blank
                    lblPiece1.setDisabledIcon(null);
                    lblPiece1.revalidate();
                    //Set game piece name to nothing
                    comIconP1.setSelectedIndex(0);
                    //Prompt user to chane game piece
                    JOptionPane.showMessageDialog(null, "Please select another piece for one of the players!");
                  }
                break;
            case 2:
                if (combo[1] == combo[0] || combo[1] == combo[2] || combo[1] == combo[3])
                  {
                    lblPiece2.setDisabledIcon(null);
                    lblPiece2.revalidate();
                    comIconP2.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Please select another piece for one of the players!");
                  }
                break;
            case 3:
                if (combo[2] == combo[0] || combo[2] == combo[1] || combo[2] == combo[3])
                  {
                    lblPiece3.setDisabledIcon(null);
                    lblPiece3.revalidate();
                    comIconP3.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Please select another piece for one of the players!");
                  }
                break;
            case 4:
                if (combo[3] == combo[0] || combo[3] == combo[1] || combo[3] == combo[2])
                  {
                    lblPiece4.setDisabledIcon(null);
                    lblPiece4.revalidate();
                    comIconP4.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Please select another piece for one of the players!");
                  }
                break;
          }
      }

    public void reset()
      {
        if (pCount == 2)
          {
            comIconP3.setSelectedIndex(3);
            txtNameP3.setText(null);
            comIconP4.setSelectedIndex(4);
            txtNameP4.setText(null);
          } else if (pCount == 3)
          {
            comIconP4.setSelectedIndex(4);
            txtNameP4.setText(null);
          }

      }

    public void playernameduplicate(int plnum)
      {
        t1 = txtNameP1.getText();
        t2 = txtNameP2.getText();
        t3 = txtNameP3.getText();
        t4 = txtNameP4.getText();
        if (t1.isEmpty() == true)
          {
            t1 = "1";
          }
        if (t2.isEmpty() == true)
          {
            t2 = "2";
          }
        if (t3.isEmpty() == true)
          {
            t3 = "3";
          }
        if (t4.isEmpty() == true)
          {
            t4 = "4";
          }

        switch (plnum)
          {
            case 1:
                if (t1.equalsIgnoreCase(t2) || t1.equalsIgnoreCase(t3) || t1.equalsIgnoreCase(t4))
                  {
                    JOptionPane.showMessageDialog(null, "Please enter another name! This name already taken!");
                    txtNameP1.setText(null);
                    t1 = null;
                  }
                break;

            case 2:
                if (t2.equalsIgnoreCase(t1) || t2.equalsIgnoreCase(t3) || t2.equalsIgnoreCase(t4))
                  {
                    JOptionPane.showMessageDialog(null, "Please enter another name! This name already taken!");
                    txtNameP2.setText(null);
                    t2 = null;
                  }
                break;
            case 3:
                if (t3.equalsIgnoreCase(t2) || t3.equalsIgnoreCase(t1) || t3.equalsIgnoreCase(t4))
                  {
                    JOptionPane.showMessageDialog(null, "Please enter another name! This name already taken!");
                    txtNameP3.setText(null);
                    t3 = null;
                  }
                break;
            case 4:
                if (t4.equalsIgnoreCase(t1) || t4.equalsIgnoreCase(t2) || t4.equalsIgnoreCase(t3))
                  {
                    JOptionPane.showMessageDialog(null, "Please enter another name! This name already taken!");
                    txtNameP4.setText(null);
                    t4 = null;
                  }
                break;

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
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JPanel PaneP4;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDice;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnRand1;
    private javax.swing.JButton btnRand2;
    private javax.swing.JButton btnRand3;
    private javax.swing.JButton btnRand4;
    private javax.swing.JComboBox comBailFee;
    private javax.swing.JComboBox comBonAmt;
    private javax.swing.JComboBox comEGS;
    private javax.swing.JComboBox comIconP1;
    private javax.swing.JComboBox comIconP2;
    private javax.swing.JComboBox comIconP3;
    private javax.swing.JComboBox comIconP4;
    private javax.swing.JComboBox comMoney;
    private javax.swing.JLabel lblBailFee;
    private javax.swing.JLabel lblBonAmt;
    private javax.swing.JLabel lblDice;
    private javax.swing.JLabel lblEGS;
    private javax.swing.JLabel lblIcon1;
    private javax.swing.JLabel lblIcon2;
    private javax.swing.JLabel lblIcon3;
    private javax.swing.JLabel lblIcon4;
    private javax.swing.JLabel lblP1;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblP3;
    private javax.swing.JLabel lblP4;
    private javax.swing.JLabel lblPiece1;
    private javax.swing.JLabel lblPiece2;
    private javax.swing.JLabel lblPiece3;
    private javax.swing.JLabel lblPiece4;
    private javax.swing.JLabel lblStartup;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel paneBonus;
    private javax.swing.JPanel paneDice;
    private javax.swing.JPanel paneP1_P2;
    private javax.swing.JPanel paneP3;
    private javax.swing.JRadioButton rndBail;
    private javax.swing.JRadioButton rndSnake;
    public static javax.swing.JSlider sldPlayer;
    private javax.swing.JTextField txtNameP1;
    private javax.swing.JTextField txtNameP2;
    private javax.swing.JTextField txtNameP3;
    private javax.swing.JTextField txtNameP4;
    // End of variables declaration//GEN-END:variables
}
