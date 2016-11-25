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
public class InitTest extends javax.swing.JFrame
  {

    //Initialize piece name and image variables   
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    String theme;
    public int startmoney, dicenum = 1, bonusmoney, jailfee, counter, Players;
    public String piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8;
    public ImageIcon i1, i2, i3, i4, i5, i6, i7, i8;
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    public String nameo, t1, t2, t3, t4;
    NickNames nickName = new NickNames();
    public Timer ti;
    ImageIcon[] combo = new ImageIcon[4];
    String[] combos = new String[5];
    String[][] player = new String[4][2];// [pID][name, icon path]
    //Creates new form InitTest

    public InitTest(String theme, String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, ImageIcon ico1, ImageIcon ico2, ImageIcon ico3, ImageIcon ico4, ImageIcon ico5, ImageIcon ico6, ImageIcon ico7, ImageIcon ico8)
      {
        this.theme = theme;
//      Add piece name and icon to Pane  
        this.piece1 = p1;
        this.piece2 = p2;
        this.piece3 = p3;
        this.piece4 = p4;
        this.piece5 = p5;
        this.piece6 = p6;
        this.piece7 = p7;
        this.piece8 = p8;
        this.i1 = ico1;
        this.i2 = ico2;
        this.i3 = ico3;
        this.i4 = ico4;
        this.i5 = ico5;
        this.i6 = ico6;
        this.i7 = ico7;
        this.i8 = ico8;
        
        int w = (int) screenSize.getWidth();
        int h = (int) screenSize.getHeight();
        
        
        initComponents();
//      Get number of players from slider 
        
        numPlayers();
        checker();
//      this.setAlwaysOnTop(true);
        this.setExtendedState(MAXIMIZED_BOTH);
//      Add images to ComboBox
        images.add(null);
        images.add(i1);
        images.add(i2);
        images.add(i3);
        images.add(i4);
        images.add(i5);
        images.add(i6);
        images.add(i7);
        images.add(i8);
        
        
        bkpanel.setSize(w, h);
        System.out.println(w + "" + h);
        
      }
    
//  Use slider to set number of players playing

    private void numPlayers()
      {
        sldPlayer.addChangeListener(new ChangeListener()
          {
            @Override
            public void stateChanged(ChangeEvent e)
              {
                Players = sldPlayer.getValue();
                checker();
                reset();
              }
          });
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bkpanel = new javax.swing.JPanel();
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
        comMoney = new javax.swing.JComboBox();
        lblDice = new javax.swing.JLabel();
        lblStartup = new javax.swing.JLabel();
        lblEGS = new javax.swing.JLabel();
        comEGS = new javax.swing.JComboBox();
        rndSnake = new javax.swing.JRadioButton();
        rndBail = new javax.swing.JRadioButton();
        lblBonAmt = new javax.swing.JLabel();
        comBonAmt = new javax.swing.JComboBox();
        lblBailFee = new javax.swing.JLabel();
        comBailFee = new javax.swing.JComboBox();
        btnDice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        bkpanel.setOpaque(false);

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

        paneP1_P2.setBackground(new Color(0, 0, 0, 0));
        paneP1_P2.setOpaque(false);

        comIconP1.setBackground(java.awt.Color.green);
        comIconP1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        comIconP1.setSelectedIndex(1);
        comIconP1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comIconP1ItemStateChanged(evt);
            }
        });
        comIconP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comIconP1ActionPerformed(evt);
            }
        });

        lblP1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblP1.setText("Player 1:");

        txtNameP1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        txtNameP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameP1FocusLost(evt);
            }
        });
        txtNameP1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
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
        txtNameP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameP2FocusLost(evt);
            }
        });
        txtNameP2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameP2KeyPressed(evt);
            }
        });

        comIconP2.setBackground(java.awt.Color.green);
        comIconP2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"---", piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        comIconP2.setSelectedIndex(2);
        comIconP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comIconP2ActionPerformed(evt);
            }
        });

        lblPiece2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece2.setEnabled(false);

        btnRand1.setBackground(java.awt.Color.yellow);
        btnRand1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnRand1.setText("Random 1");
        btnRand1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRand1MouseClicked(evt);
            }
        });

        btnRand2.setBackground(java.awt.Color.yellow);
        btnRand2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnRand2.setText("Random 2");
        btnRand2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP1_P2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                        .addComponent(lblPiece1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(lblPiece2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addContainerGap())
        );

        paneP3.setOpaque(false);

        lblIcon3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblIcon3.setText("Icon:");

        lblP3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblP3.setText("Player 3:");

        txtNameP3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        txtNameP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameP3FocusLost(evt);
            }
        });
        txtNameP3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameP3KeyPressed(evt);
            }
        });

        comIconP3.setBackground(java.awt.Color.green);
        comIconP3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---",piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        comIconP3.setSelectedIndex(3);
        comIconP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comIconP3ActionPerformed(evt);
            }
        });

        lblPiece3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece3.setEnabled(false);

        btnRand3.setBackground(java.awt.Color.yellow);
        btnRand3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnRand3.setText("Random 3");
        btnRand3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRand3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout paneP3Layout = new javax.swing.GroupLayout(paneP3);
        paneP3.setLayout(paneP3Layout);
        paneP3Layout.setHorizontalGroup(
            paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneP3Layout.createSequentialGroup()
                        .addComponent(lblIcon3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comIconP3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneP3Layout.createSequentialGroup()
                        .addComponent(lblP3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRand3)
                            .addComponent(txtNameP3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPiece3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneP3Layout.setVerticalGroup(
            paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneP3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        txtNameP4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameP4FocusLost(evt);
            }
        });
        txtNameP4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameP4KeyPressed(evt);
            }
        });

        comIconP4.setBackground(java.awt.Color.green);
        comIconP4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP4.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"---", piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        comIconP4.setSelectedIndex(4);
        comIconP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comIconP4ActionPerformed(evt);
            }
        });

        lblPiece4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece4.setEnabled(false);

        btnRand4.setBackground(java.awt.Color.yellow);
        btnRand4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnRand4.setText("Random 4");
        btnRand4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRand4MouseClicked(evt);
            }
        });
        btnRand4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneP4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(lblPiece4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblTitle.setFont(new java.awt.Font("Showcard Gothic", 1, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("New Game");
        int w = (int) screenSize.getWidth();
        int h = (int) screenSize.getHeight();
        if (w == 1024 && h == 768){
            this.setContentPane(new JLabel(new ImageIcon("Icons/Miscellaneous/red1024-768.png")));
        }else if (w == 1280 && h == 768){
            this.setContentPane(new JLabel(new ImageIcon("Icons/Miscellaneous/red1280-768.png")));
        } else if (w == 1280 && h == 1024){
            this.setContentPane(new JLabel(new ImageIcon("Icons/Miscellaneous/red1280-1024.png")));
        } else if (w == 1366 && h == 768){
            this.setContentPane(new JLabel(new ImageIcon("Icons/Miscellaneous/red1366-768.png")));
        }

        btnBack.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btnNext.setText("Next>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        comMoney.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comMoney.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "$ 500", "$ 1000", "$ 1500", "$ 2000" }));
        comMoney.setAutoscrolls(true);
        comMoney.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comMoney.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comMoneyItemStateChanged(evt);
            }
        });
        comMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comMoneyActionPerformed(evt);
            }
        });

        lblDice.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblDice.setText("Number of Dice:");

        lblStartup.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblStartup.setText("Amount of Startup money:");

        lblEGS.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblEGS.setText("End Game Scenario:");

        comEGS.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N
        comEGS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Last player standing", "45 turns per player", "60 turns per player", "75 turns per player" }));
        comEGS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEGSActionPerformed(evt);
            }
        });

        rndSnake.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        rndSnake.setText("Snake Eye Bonus");
        rndSnake.setOpaque(false);
        rndSnake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rndSnakeActionPerformed(evt);
            }
        });

        rndBail.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        rndBail.setText("JAIL BAIL");
        rndBail.setOpaque(false);
        rndBail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rndBailActionPerformed(evt);
            }
        });

        lblBonAmt.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblBonAmt.setText("BONUS AMOUNT :");
        lblBonAmt.setEnabled(false);

        comBonAmt.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        comBonAmt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "$50", "$100", "$120" }));
        comBonAmt.setEnabled(false);
        comBonAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBonAmtActionPerformed(evt);
            }
        });

        lblBailFee.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblBailFee.setText("BAIL FEE:");
        lblBailFee.setEnabled(false);

        comBailFee.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        comBailFee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "$100", "$150", "$200" }));
        comBailFee.setEnabled(false);
        comBailFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBailFeeActionPerformed(evt);
            }
        });

        btnDice.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        btnDice.setText("1 Dice");
        btnDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bkpanelLayout = new javax.swing.GroupLayout(bkpanel);
        bkpanel.setLayout(bkpanelLayout);
        bkpanelLayout.setHorizontalGroup(
            bkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bkpanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(bkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addComponent(lblEGS)
                        .addGap(70, 70, 70)
                        .addComponent(comEGS, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addGroup(bkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rndBail)
                            .addGroup(bkpanelLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(lblBailFee)))
                        .addGap(43, 43, 43)
                        .addComponent(comBailFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addComponent(paneP1_P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sldPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(bkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PaneP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paneP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addComponent(lblDice, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnDice)
                        .addGap(221, 221, 221)
                        .addComponent(rndSnake))
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addComponent(lblStartup, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(lblBonAmt)
                        .addGap(43, 43, 43)
                        .addComponent(comBonAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(816, 816, 816)
                        .addComponent(btnNext)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        bkpanelLayout.setVerticalGroup(
            bkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bkpanelLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(6, 6, 6)
                .addGroup(bkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneP1_P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sldPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addComponent(paneP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(PaneP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(bkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblDice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnDice))
                    .addComponent(rndSnake))
                .addGap(4, 4, 4)
                .addGroup(bkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblStartup, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(comMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblBonAmt))
                    .addComponent(comBonAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(bkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblEGS))
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(comEGS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addComponent(rndBail)
                        .addGap(1, 1, 1)
                        .addComponent(lblBailFee))
                    .addGroup(bkpanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(comBailFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(bkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(btnNext))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bkpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bkpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        //Generate random nickname
        nickName.listName();
        //Get nickname from nickName class
        nameo = nickName.name;
        //Add nickname to textbox
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
    public void setPlayers()
      {
        if (sldPlayer.getValue() < 3)
          {
            player[0][0] = txtNameP1.getText();
            System.out.println(lblPiece1.getDisabledIcon().toString());
            player[1][0] = txtNameP2.getText();
            player[0][1] = lblPiece1.getDisabledIcon().toString();
            player[1][1] = lblPiece2.getDisabledIcon().toString();
          }
        if (sldPlayer.getValue() > 2)
          {
            player[0][0] = txtNameP1.getText();
            player[1][0] = txtNameP2.getText();
            player[2][0] = txtNameP3.getText();
            player[0][1] = lblPiece1.getDisabledIcon().toString();
            player[1][1] = lblPiece2.getDisabledIcon().toString();
            player[2][1] = lblPiece3.getDisabledIcon().toString();
          }
        if (sldPlayer.getValue() > 3)
          {
            player[3][0] = txtNameP4.getText();
            player[3][1] = lblPiece4.getDisabledIcon().toString();
          }
      }
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        setPlayers();
        java.awt.EventQueue.invokeLater(new Runnable()
          {
            public void run()
              {
                new Board(player, sldPlayer.getValue(), startmoney, dicenum, comEGS.getSelectedIndex(), rndSnake.isSelected(), bonusmoney, rndBail.isSelected(), jailfee, theme).setVisible(true);
              }
          });

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
        //Get startup value
        int i = comMoney.getSelectedIndex();
        //Add money to public int
        switch (i)
          {

            case 1:
                startmoney = 500;
                break;
            case 2:
                startmoney = 1000;
                break;
            case 3:
                startmoney = 1500;
                break;
            case 4:
                startmoney = 2000;
                break;
          }
    }//GEN-LAST:event_comMoneyActionPerformed

    private void btnRand4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRand4ActionPerformed
    {//GEN-HEADEREND:event_btnRand4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRand4ActionPerformed

    private void rndBailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rndBailActionPerformed
        // TODO add your handling code here:
        lblBailFee.setEnabled(rndBail.isSelected());
        comBailFee.setEnabled(rndBail.isSelected());
    }//GEN-LAST:event_rndBailActionPerformed

    private void rndSnakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rndSnakeActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
        //Get bonus value
        int i = comBonAmt.getSelectedIndex();
        //Add money to public int
        switch (i)
          {

            case 1:
                bonusmoney = 50;
                break;
            case 2:
                bonusmoney = 100;
                break;
            case 3:
                bonusmoney = 120;
                break;
          }
    }//GEN-LAST:event_comBonAmtActionPerformed

    private void comBailFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBailFeeActionPerformed
        // TODO add your handling code here:
        //Get fee value
        int i = comBailFee.getSelectedIndex();
        //Add money to public int
        switch (i)
          {

            case 1:
                bonusmoney = 100;
                break;
            case 2:
                bonusmoney = 150;
                break;
            case 3:
                bonusmoney = 200;
                break;
          }
    }//GEN-LAST:event_comBailFeeActionPerformed

    private void comEGSActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_comEGSActionPerformed
    {//GEN-HEADEREND:event_comEGSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comEGSActionPerformed

    public void NextCopy(int plnum)
      {
        pliconduplicate(plnum);
      }

    public void checker()
      {
        Players = sldPlayer.getValue();
        switch (Players)
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
        if (Players == 2)
          {
            comIconP3.setSelectedIndex(3);
            txtNameP3.setText(null);
            comIconP4.setSelectedIndex(4);
            txtNameP4.setText(null);
          } else if (Players == 3)
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
//        java.awt.EventQueue.invokeLater(new Runnable()
//          {
//            public void run()
//              {
//                new InitTest().setVisible(true);
//              }
//          });
      }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PaneP4;
    private javax.swing.JPanel bkpanel;
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
    private javax.swing.JPanel paneP1_P2;
    private javax.swing.JPanel paneP3;
    private javax.swing.JRadioButton rndBail;
    private javax.swing.JRadioButton rndSnake;
    private javax.swing.JSlider sldPlayer;
    private javax.swing.JTextField txtNameP1;
    private javax.swing.JTextField txtNameP2;
    private javax.swing.JTextField txtNameP3;
    private javax.swing.JTextField txtNameP4;
    // End of variables declaration//GEN-END:variables
}
