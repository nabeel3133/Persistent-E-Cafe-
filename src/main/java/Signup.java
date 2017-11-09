


import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nabeel Hussain Syed
 */
public class Signup extends javax.swing.JFrame {
public static String user;
public static String pass;
public Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/e-cafe", "root",""); 
public Statement statement = connection.createStatement();
public static ResultSet rs;

String userDetails = "Insert into user(username,password) values(?,?)";
PreparedStatement userDetailsStatement = connection.prepareStatement(userDetails);
    /**
     * Creates new form Signup
     */
    public Signup() throws SQLException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        label1 = new java.awt.Label();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Signup = new javax.swing.JButton();
        Signin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        label1.setName(""); // NOI18N
        label1.setText("Sign Up/Login");

        username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Password");

        Signup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Signup.setText("Sign up");
        Signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupActionPerformed(evt);
            }
        });

        Signin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Signin.setText("Sign in");
        Signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SigninActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Signup)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Signin))
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(214, 214, 214))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Signup)
                    .addComponent(Signin))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        label1.getAccessibleContext().setAccessibleName("Sign up");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void SignupCustomer() throws SQLException
    {
        setUser(username.getText());
        setPass(password.getText());    
        if(user.isEmpty() || pass.isEmpty())
        {
            if(user.isEmpty()&& !pass.isEmpty())
            JOptionPane.showMessageDialog(null,"Username empty","Sign up Error",JOptionPane.ERROR_MESSAGE);
            else if(!user.isEmpty() && pass.isEmpty())
            JOptionPane.showMessageDialog(null,"Password empty","Sign in Error",JOptionPane.ERROR_MESSAGE);
            else if(user.isEmpty() && pass.isEmpty())
            JOptionPane.showMessageDialog(null,"Both fields empty","Sign in Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try {  
                String query = "SELECT * FROM user WHERE username = '"+user+"'";
                ResultSet rs = statement.executeQuery(query);
                if(rs.absolute(1)==true)
                {
                JOptionPane.showMessageDialog(null,"Username already exists","Username taken",JOptionPane.ERROR_MESSAGE);                     
                username.setText("");
                password.setText("");
                }
                else
                {
                userDetailsStatement.setString(1,user);
                userDetailsStatement.setString(2,pass);
                userDetailsStatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Successfully signed up","Signed up",JOptionPane.INFORMATION_MESSAGE); 
                username.setText("");
                password.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }     
    }
    
    private void SignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignupActionPerformed
    try {          
        SignupCustomer();
    } catch (SQLException ex) {
        Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_SignupActionPerformed

    public void setUser(String username1)
    {
        user = username1;

    }
    
    public void setPass(String password1)
    {
        pass = password1;  
    }   
    
    public String getUser()
    {
        return user;
    }
    
    public String getPass()
    {
        return pass;
    }
    public void SigninCustomer() throws SQLException
    {
        setUser(username.getText());
        setPass(password.getText());  
        
        if(user.isEmpty() || pass.isEmpty())
        {
            if(user.isEmpty()&& !pass.isEmpty())
            JOptionPane.showMessageDialog(null,"Username empty","Sign in Error",JOptionPane.ERROR_MESSAGE);
            else if(!user.isEmpty() && pass.isEmpty())
            JOptionPane.showMessageDialog(null,"Password empty","Sign up Error",JOptionPane.ERROR_MESSAGE);
            else if(user.isEmpty() && pass.isEmpty())
            JOptionPane.showMessageDialog(null,"Both fields empty","Sign up Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String query = "SELECT * FROM user WHERE username = '"+user+"' AND password = '"+pass+"' ";
            try {
                ResultSet rs = statement.executeQuery(query);
                if(rs.absolute(1) == false)
            JOptionPane.showMessageDialog(null,"Invalid login details","Error",JOptionPane.ERROR_MESSAGE);                    
                else
                {
                JOptionPane.showMessageDialog(null,"Successfully signed in","Signed in",JOptionPane.INFORMATION_MESSAGE);
            Cafe theCafe  = new Cafe();
                theCafe.setVisible(true);
                this.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        } 
    }
    
    private void SigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigninActionPerformed
    try {
        SigninCustomer();
    } catch (SQLException ex) {
        Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_SigninActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Signup().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Signin;
    private javax.swing.JButton Signup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.Label label1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
