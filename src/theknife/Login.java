/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Alefr davim antoPar
 */
public class Login extends javax.swing.JFrame {
    private final ImageIcon showPass;
    private final ImageIcon hidePass;
    private GestoreArchivi gestore;
    
    public Login(GestoreArchivi gestore) {
        this.gestore = gestore;
        initComponents();
                
        //Immagine per mostrare la password ridimensionata ed applicata.
        ImageIcon spIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\show_pass.png"));
        Image sp1 = spIcon.getImage();
        Image sp2 = sp1.getScaledInstance(eyePass.getWidth(), eyePass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sp3 = new ImageIcon(sp2);
        eyePass.setIcon(sp3);
        this.showPass = sp3;  
        
         //Immagine per nascondere la password ridimensionata.
        ImageIcon hpIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src\\hide_pass.png"));
        Image hp1 = hpIcon.getImage();
        Image hp2 = hp1.getScaledInstance(eyePass.getWidth(), eyePass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon hp3 = new ImageIcon(hp2); 
        this.hidePass = hp3;
    }
    
    
    
    //Generated code
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        Logo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Dati = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        logPass = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        guestButton = new javax.swing.JButton();
        eyePass = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TheKnife");

        Login.setBackground(new java.awt.Color(204, 204, 204));
        Login.setPreferredSize(new java.awt.Dimension(800, 500));
        Login.setLayout(null);

        Logo.setBackground(new java.awt.Color(0, 102, 102));
        Logo.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel6.setText("jLabel6");
        jLabel6.setPreferredSize(new java.awt.Dimension(761, 721));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TheKnife.png"))); // NOI18N
        jLabel7.setText("jLabel7");

        jLabel5.setBackground(new java.awt.Color(51, 255, 51));
        jLabel5.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TheKnife");

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        Logo.setLayout(LogoLayout);
        LogoLayout.setHorizontalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoLayout.createSequentialGroup()
                .addGroup(LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogoLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)))
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        LogoLayout.setVerticalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoLayout.createSequentialGroup()
                .addGroup(LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogoLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LogoLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Login.add(Logo);
        Logo.setBounds(0, 0, 400, 500);

        Dati.setBackground(new java.awt.Color(255, 255, 255));
        Dati.setPreferredSize(new java.awt.Dimension(400, 500));
        Dati.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        Dati.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 55, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Username:");
        Dati.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 154, 113, -1));

        logUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        logUser.setMargin(new java.awt.Insets(6, 6, 6, 6));
        logUser.setSelectionStart(6);
        Dati.add(logUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 183, 340, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Password:");
        Dati.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 237, 113, -1));

        logPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        logPass.setPreferredSize(new java.awt.Dimension(73, 22));
        Dati.add(logPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 268, 340, 30));

        LoginButton.setBackground(new java.awt.Color(0, 102, 102));
        LoginButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Login");
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        Dati.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 81, 29));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Non hai un account?");
        Dati.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 325, 130, -1));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Registrati!");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Dati.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, 30));

        guestButton.setBackground(new java.awt.Color(0, 102, 102));
        guestButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        guestButton.setForeground(new java.awt.Color(255, 255, 255));
        guestButton.setText("Accedi come ospite");
        guestButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestButtonActionPerformed(evt);
            }
        });
        Dati.add(guestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        eyePass.setBorder(null);
        eyePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyePassActionPerformed(evt);
            }
        });
        Dati.add(eyePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 25, 25));

        jLabel8.setText("Oppure:");
        Dati.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 90, -1));

        Login.add(Dati);
        Dati.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        if (gestore.getArchivioUtenti().esisteUtente(logUser.getText(), logPass.getText())) {
            MainPage RisListFrame = new MainPage();
            RisListFrame.setVisible(true);
            RisListFrame.pack();
            RisListFrame.setLocationRelativeTo(null);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Username o password errati");
            logPass.setText("");
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void guestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestButtonActionPerformed
        gestore.getArchivioUtenti().setUtenteAttuale(0);
        MainPage RisListFrame = new MainPage();
        RisListFrame.setVisible(true);
        RisListFrame.pack();
        RisListFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_guestButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Reg1 Reg1Frame = new Reg1(gestore);
        Reg1Frame.setVisible(true);
        Reg1Frame.pack();
        Reg1Frame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    //Toggle button per mostrare o nascondere la password.
    private void eyePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyePassActionPerformed
        if (eyePass.isSelected()) {
            eyePass.setIcon(hidePass);
            logPass.setEchoChar((char)0);
        } else {
            eyePass.setIcon(showPass);
            logPass.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyePassActionPerformed
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dati;
    private javax.swing.JPanel Login;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel Logo;
    private javax.swing.JToggleButton eyePass;
    private javax.swing.JButton guestButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField logPass;
    private javax.swing.JTextField logUser;
    // End of variables declaration//GEN-END:variables
}
