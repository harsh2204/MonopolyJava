/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author 850110
 */
public class Card extends javax.swing.JFrame {

    /**
     * Creates new form Card
     */
    String title, price, baseRent, rent1, rent2, rent3, rentHotel, mortgage, house, hotel;
    Color background;
    ImageIcon ic;

    public Card(ImageIcon icon, int index, String theme) {        
        this.ic = icon;
        Properties_Data p = new Properties_Data(theme);
        p.GetProp();
        this.background = p.prop[index].colour;
        title = p.prop[index].name;
        price = "Price $" + p.prop[index].price;
        if (p.prop[index].rent2 == 0) {
            rent1 = p.prop[index].desc1;
            rent2 = p.prop[index].desc2;
            mortgage = "Mortgage value $" + p.prop[index].price / 2;
        }
        if (p.prop[index].rent2 != 0) {
            baseRent = "RENT $" + p.prop[index].rent1;
            rent1 = "With 1 House $" + p.prop[index].rent2;
            rent2 = "With 2 House $" + p.prop[index].rent3;
            rent3 = "With 3 House $" + p.prop[index].rent4;
            rentHotel = "With Hotel $" + p.prop[index].rentH;
            mortgage = "Mortgage value $" + p.prop[index].price / 2;
            house = "Houses cost $" + p.prop[index].priceHouse;
            hotel = "Hotel costs $" + ((p.prop[index].priceHouse * 1.5) + 50);
        }
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblRent = new javax.swing.JLabel();
        lblRent1 = new javax.swing.JLabel(price);
        lblRent2 = new javax.swing.JLabel();
        lblRent3 = new javax.swing.JLabel();
        lblRent4 = new javax.swing.JLabel();
        lblRent5 = new javax.swing.JLabel();
        lblRent6 = new javax.swing.JLabel();
        lblRent7 = new javax.swing.JLabel();
        lblRent8 = new javax.swing.JLabel(baseRent);
        jPanel3 = new javax.swing.JPanel();
        lblDeed = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel(title);
        lblIcon = new javax.swing.JLabel(ic);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setFocusable(false);
        setUndecorated(true);

        jPanel1.setBackground(background);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        lblRent.setFont(new java.awt.Font("KabaleMedium", 0, 14)); // NOI18N
        lblRent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRent.setText(hotel);
        jPanel2.add(lblRent);
        lblRent.setBounds(0, 280, 240, 30);

        lblRent1.setFont(new java.awt.Font("KabobBlack", 0, 18)); // NOI18N
        lblRent1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblRent1);
        lblRent1.setBounds(0, 60, 240, 30);

        lblRent2.setFont(new java.awt.Font("KabaleMedium", 0, 14)); // NOI18N
        lblRent2.setText(rent1);
        jPanel2.add(lblRent2);
        lblRent2.setBounds(30, 110, 210, 30);

        lblRent3.setFont(new java.awt.Font("KabaleMedium", 0, 14)); // NOI18N
        lblRent3.setText(rent2);
        jPanel2.add(lblRent3);
        lblRent3.setBounds(30, 140, 210, 30);

        lblRent4.setFont(new java.awt.Font("KabaleMedium", 0, 14)); // NOI18N
        lblRent4.setText(rent3);
        jPanel2.add(lblRent4);
        lblRent4.setBounds(30, 170, 210, 30);

        lblRent5.setFont(new java.awt.Font("KabaleMedium", 0, 14)); // NOI18N
        lblRent5.setText(rentHotel);
        jPanel2.add(lblRent5);
        lblRent5.setBounds(30, 200, 210, 30);

        lblRent6.setFont(new java.awt.Font("KabaleMedium", 0, 14)); // NOI18N
        lblRent6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRent6.setText(mortgage);
        jPanel2.add(lblRent6);
        lblRent6.setBounds(0, 230, 240, 30);

        lblRent7.setFont(new java.awt.Font("KabaleMedium", 0, 14)); // NOI18N
        lblRent7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRent7.setText(house);
        jPanel2.add(lblRent7);
        lblRent7.setBounds(0, 255, 240, 30);

        lblRent8.setFont(new java.awt.Font("KabaleMedium", 0, 14)); // NOI18N
        lblRent8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblRent8);
        lblRent8.setBounds(0, 90, 240, 30);

        jPanel3.setBackground(new Color(0, 0, 0, 64));

        lblDeed.setFont(new java.awt.Font("Kabel Bk BT", 1, 12)); // NOI18N
        lblDeed.setForeground(new java.awt.Color(255, 255, 255));
        lblDeed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeed.setText("TITLE DEED");

        lblTitle.setFont(new java.awt.Font("Kabel Bk BT", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(lblDeed, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblDeed)
                    .addGap(5, 5, 5)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 240, 62);
        jPanel2.add(lblIcon);
        lblIcon.setBounds(0, 0, 240, 60);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Card().setVisible(true);
//            }
//        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDeed;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblRent;
    private javax.swing.JLabel lblRent1;
    private javax.swing.JLabel lblRent2;
    private javax.swing.JLabel lblRent3;
    private javax.swing.JLabel lblRent4;
    private javax.swing.JLabel lblRent5;
    private javax.swing.JLabel lblRent6;
    private javax.swing.JLabel lblRent7;
    private javax.swing.JLabel lblRent8;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
