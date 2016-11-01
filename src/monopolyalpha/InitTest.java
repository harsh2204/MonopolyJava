/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.util.*;;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.*;

/**
 *
 * @author Harsh
 */
public class InitTest extends javax.swing.JFrame {

    public String piece1;
    public String piece2;
    public String piece3;
    public String piece4;
    public String piece5;
    public String piece6;
    public String piece7;
    public String piece8;
    public ImageIcon i1;
    public ImageIcon i2;
    public ImageIcon i3;
    public ImageIcon i4;
    public ImageIcon i5;
    public ImageIcon i6;
    public ImageIcon i7;
    public ImageIcon i8;

    //Creates new form InitTest
    public InitTest(String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, ImageIcon ico1, ImageIcon ico2, ImageIcon ico3, ImageIcon ico4, ImageIcon ico5, ImageIcon ico6, ImageIcon ico7, ImageIcon ico8) {
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
        initComponents();
        numPlayers();
        checker();

//        this.setAlwaysOnTop(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        images.add(null);
        images.add(i1);
        images.add(i2);
        images.add(i3);
        images.add(i4);
        images.add(i5);
        images.add(i6);
        images.add(i7);
        images.add(i8);
    }
    int Players;
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    public String nameo, t1, t2, t3, t4;
    NickNames nickName = new NickNames();
    public int counter;
    public Timer ti;
    ImageIcon[] combo = new ImageIcon[4];

    private void numPlayers() {
        sldPlayer.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Players = sldPlayer.getValue();
                checker();

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        comIconP1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        comIconP1.setSelectedIndex(0);
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
        lblP1.setText("PLayer 1:");

        txtNameP1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N

        lblIcon1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblIcon1.setText("Icon:");

        lblPiece1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece1.setEnabled(false);

        lblIcon2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblIcon2.setText("Icon:");

        lblP2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblP2.setText("PLayer 2:");

        txtNameP2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N

        comIconP2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"---", piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        comIconP2.setSelectedIndex(0);
        comIconP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comIconP2ActionPerformed(evt);
            }
        });

        lblPiece2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece2.setEnabled(false);

        btnRand1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnRand1.setText("Random 1");
        btnRand1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRand1MouseClicked(evt);
            }
        });

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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP1_P2Layout.createSequentialGroup()
                                .addComponent(lblIcon2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comIconP2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneP1_P2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btnRand2)))
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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        lblIcon3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblIcon3.setText("Icon:");

        lblP3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblP3.setText("PLayer 3:");

        txtNameP3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N

        comIconP3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---",piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        comIconP3.setSelectedIndex(0);
        comIconP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comIconP3ActionPerformed(evt);
            }
        });

        lblPiece3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece3.setEnabled(false);

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
                        .addComponent(lblP3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNameP3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneP3Layout.createSequentialGroup()
                        .addComponent(lblIcon3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comIconP3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneP3Layout.createSequentialGroup()
                        .addComponent(btnRand3)
                        .addGap(75, 75, 75)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPiece3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneP3Layout.setVerticalGroup(
            paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneP3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPiece3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneP3Layout.createSequentialGroup()
                        .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblP3)
                            .addComponent(txtNameP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRand3)
                        .addGap(18, 18, 18)
                        .addGroup(paneP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comIconP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIcon3))))
                .addContainerGap())
        );

        lblIcon4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblIcon4.setText("Icon:");

        lblP4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblP4.setText("PLayer 4:");

        txtNameP4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N

        comIconP4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        comIconP4.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"---", piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8}));
        comIconP4.setSelectedIndex(0);
        comIconP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comIconP4ActionPerformed(evt);
            }
        });

        lblPiece4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblPiece4.setEnabled(false);

        btnRand4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnRand4.setText("Random 4");
        btnRand4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRand4MouseClicked(evt);
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
                .addContainerGap()
                .addGroup(PaneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaneP4Layout.createSequentialGroup()
                        .addGroup(PaneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblP4)
                            .addComponent(txtNameP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRand4)
                        .addGap(18, 18, 18)
                        .addGroup(PaneP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comIconP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIcon4)))
                    .addComponent(lblPiece4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblTitle.setFont(new java.awt.Font("Showcard Gothic", 1, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("New Game");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(paneP1_P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sldPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(paneP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PaneP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext)
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblTitle)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sldPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(PaneP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneP1_P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnNext))
                .addContainerGap())
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
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnBackActionPerformed

    private void comIconP1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comIconP1ItemStateChanged
        // TODO add your handling code here
    }//GEN-LAST:event_comIconP1ItemStateChanged

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (paneP1_P2.isVisible() && paneP3.isVisible() && PaneP4.isVisible()) {
            playerduplicate(Players);
        } else if (paneP1_P2.isVisible() && paneP3.isVisible()) {
            playerduplicate(Players);
        } else if (paneP1_P2.isVisible()) {
            playerduplicate(Players);
        }


    }//GEN-LAST:event_btnNextActionPerformed

    public void NextCopy(int plnum) {
        playerduplicate(plnum);
    }

    public void checker() {
        Players = sldPlayer.getValue();
        if (Players == 2) {
            paneP3.setVisible(false);
            PaneP4.setVisible(false);
        } else if (Players == 3) {
            paneP3.setVisible(true);
            PaneP4.setVisible(false);
        } else if (Players == 4) {
            paneP3.setVisible(true);
            PaneP4.setVisible(true);
        }
    }

    public void playerduplicate(int Playa) {
        t1 = txtNameP1.getText();
        t2 = txtNameP2.getText();
        t3 = txtNameP3.getText();
        t4 = txtNameP4.getText();

        if (Playa == 1) {
            if (t1.equalsIgnoreCase(t2)) {
                JOptionPane.showMessageDialog(null, "Please select another name for one of the players!!");
            } else if (combo[0] == combo[1]||combo[0]==combo[2]||combo[0]==combo[3]) {
                lblPiece1.setDisabledIcon(null);
                lblPiece1.revalidate();
                comIconP1.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Please select another piece for one of the players!!");
            }
        }
        else if (Playa == 2) {
            if (t1.equalsIgnoreCase(t2)) {
                JOptionPane.showMessageDialog(null, "Please select another name for one of the players!!");
            }else if (combo[1] == combo[0]||combo[1]==combo[2]||combo[1]==combo[3]) {
                lblPiece2.setDisabledIcon(null);
                lblPiece2.revalidate();
                comIconP2.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Please select another piece for one of the players!!");
            } 
        } else if (Playa == 3) {
            if (t1.equalsIgnoreCase(t2) || t1.equalsIgnoreCase(t3) || t2.equalsIgnoreCase(t3)) {
                JOptionPane.showMessageDialog(null, "Please select another name for one of the players!!");
            }else if (combo[2] == combo[0]||combo[2]==combo[1]||combo[2]==combo[3]) {
                lblPiece3.setDisabledIcon(null);
                lblPiece3.revalidate();
                comIconP3.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Please select another piece for one of the players!!");
            }
        } else if (Playa == 4) {
            if (t1.equalsIgnoreCase(t2) || t1.equalsIgnoreCase(t3) || t1.equalsIgnoreCase(t4) || t2.equalsIgnoreCase(t3) || t2.equalsIgnoreCase(t4)
                    || t3.equalsIgnoreCase(t4)) {
            } else if (combo[3] == combo[0]||combo[3]==combo[1]||combo[3]==combo[2]) {
                lblPiece4.setDisabledIcon(null);
                lblPiece4.revalidate();
                comIconP4.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Please select another piece for one of the players!!");
            } 
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
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
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnRand1;
    private javax.swing.JButton btnRand2;
    private javax.swing.JButton btnRand3;
    private javax.swing.JButton btnRand4;
    private javax.swing.JComboBox comIconP1;
    private javax.swing.JComboBox comIconP2;
    private javax.swing.JComboBox comIconP3;
    private javax.swing.JComboBox comIconP4;
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
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel paneP1_P2;
    private javax.swing.JPanel paneP3;
    private javax.swing.JSlider sldPlayer;
    private javax.swing.JTextField txtNameP1;
    private javax.swing.JTextField txtNameP2;
    private javax.swing.JTextField txtNameP3;
    private javax.swing.JTextField txtNameP4;
    // End of variables declaration//GEN-END:variables
}
