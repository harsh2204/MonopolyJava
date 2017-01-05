/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

/**
 *
 * @author karmi
 */
public class HouseFrm extends javax.swing.JFrame
  {

    int pl, turn, j = -1, money = 0, x = 0, y = 0;
    InitTest it = new InitTest();
    Board bd = InitTest.board;
    Properties_Data pd = new Properties_Data();
    public int[] propOwner = new int[36], nums = new int[36], sel = new int[36], propHouse = new int[36];
    public boolean[] propH = new boolean[36];
    public JCheckBox[] props = new JCheckBox[100];

    public HouseFrm(int[] propOwner, boolean[] propH, int turn, int[] propHouse)
      {
        pl = it.pCount;
        this.turn = turn;
        initComponents();
        this.setLocationRelativeTo(null);
        this.propOwner = propOwner;
        this.propH = propH;
        this.propHouse = propHouse;
        addProps(turn);
      }

    public void addProps(int turn)
      {
        for (int i = 0; i < 36; i++)
          {
            if (propOwner[i] == turn)
              {
                if (propH[i] == true)
                  {
                    this.props[y] = new JCheckBox(bd.propName[i]);
                    this.paneprops.add(props[y]);
                    j++;
                    nums[j] = i;
                    System.out.println("House:: Number:" + j + " Name:" + bd.propName[i] + "   " + nums[j]);
                    if (propHouse[i] > 4)
                      {
                        props[y].setEnabled(false);
                      }
                    this.props[y].addActionListener(new ActionListener()
                      {
                        @Override
                        public void actionPerformed(ActionEvent e)
                          {
                            updateMoney();
                          }
                      });
                    y++;
                  }
              }
          }
      }

    public void updateMoney()
      {
        pd.GetProp();
        money = 0;
        for (int i = 0; i <= j; i++)
          {
            if (props[i].isSelected())
              {
                System.out.println("House:: Selected:" + i + " Number:" + nums[i] + " MOney:" + pd.prop[nums[i]].priceHouse);
                sel[x] = i;
                x++;
                money += pd.prop[nums[i]].priceHouse;

              }
          }
        lblMoney.setText("$ " + money);
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jToolBar1 = new javax.swing.JToolBar();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lblnameP = new javax.swing.JLabel();
        paneprops = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMoney = new javax.swing.JLabel();
        btnUpg = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Build your custom house!");

        lblnameP.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblnameP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cost");

        lblMoney.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnUpg.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpg.setText("Upgrade");
        btnUpg.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpgActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblnameP, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneprops, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnameP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneprops, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnUpg, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExitActionPerformed
    {//GEN-HEADEREND:event_btnExitActionPerformed
        this.setVisible(false);
        Dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnUpgActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUpgActionPerformed
    {//GEN-HEADEREND:event_btnUpgActionPerformed
        bd.money[turn] -= money;
        bd.displayChangeBuy(this.turn);
        for (int i = 0; i <= j; i++)
          {
            if (props[i].isSelected())
              {
                bd.propHouse[nums[i]]++;
                props[i].setSelected(false);
                updateMoney();
                bd.setupHouses();
              }
          }
    }//GEN-LAST:event_btnUpgActionPerformed
    private void Dispose()
      {
        InitTest.board.enableNext();
        this.dispose();
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
            java.util.logging.Logger.getLogger(HouseFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(HouseFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(HouseFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(HouseFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
          {
            @Override
            public void run()
              {
                new StartScreenfrm().setVisible(true);
              }
          });
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnUpg;
    public javax.swing.JDesktopPane jDesktopPane1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JSplitPane jSplitPane1;
    public javax.swing.JToolBar jToolBar1;
    public javax.swing.JLabel lblMoney;
    public javax.swing.JLabel lblnameP;
    public javax.swing.JPanel paneprops;
    // End of variables declaration//GEN-END:variables
  }
