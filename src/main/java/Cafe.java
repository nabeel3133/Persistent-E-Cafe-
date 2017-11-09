/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Nabeel Hussain Syed
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cafe extends javax.swing.JFrame {
public int totalOrderPrice;
public int totalTimeTaken;
public int pickup_time;


public int actual_time;

String query;
Signup Customer = new Signup();

public Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/e-cafe", "root",""); 
public Statement statement = connection.createStatement();
public static ResultSet rs;
CallableStatement cstmt = null;

String orderDetails = "Insert into order_info(Order_num,dish_id,time,count) values(?,?,?,?)";
PreparedStatement orderDetailsStatement = connection.prepareStatement(orderDetails);

//String orderStatus = "Insert into order_status(Customer_ID) values(?) ";
//PreparedStatement orderStatusStatement = connection.prepareStatement(orderStatus);

String setDishes = "SELECT Name FROM dishes WHERE D_Num = ?";             
PreparedStatement setDishesStatement = connection.prepareStatement(setDishes);
     /*
     *Creates new form Cafe
     */
    public Cafe() throws SQLException {
        initComponents();
        totalOrderPrice = 0;
        totalTimeTaken = 0;
        pickup_time = 0;
        pickUpPanel.setVisible(false);
        DeliveryPanel.setVisible(false);
            Date date = new Date();
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(date);
            actual_time = calendar.get(Calendar.HOUR_OF_DAY);
        
         try{
                setDishesStatement.setInt(1,1);
                rs = setDishesStatement.executeQuery();
                rs.next();
                jButton2.setText(rs.getString(1));
             
                setDishesStatement.setInt(1,2);
                rs = setDishesStatement.executeQuery();
                rs.next();
                jButton3.setText(rs.getString(1));

                setDishesStatement.setInt(1,3);
                rs = setDishesStatement.executeQuery();
                rs.next();
                jButton4.setText(rs.getString(1));

                setDishesStatement.setInt(1,4);
                rs = setDishesStatement.executeQuery();
                rs.next();
                jButton5.setText(rs.getString(1));

                setDishesStatement.setInt(1,5);
                rs = setDishesStatement.executeQuery();
                rs.next();
                jButton6.setText(rs.getString(1));

                
            query = "SELECT * FROM user WHERE username = '"+Customer.getUser()+"' AND password = '"+Customer.getPass()+"' ";

            ResultSet rs = statement.executeQuery(query); 
            rs.next();

            String SQL = "{call addOrder (?)}"; 
            cstmt = connection.prepareCall (SQL); 
            cstmt.setInt(1, rs.getInt(1));
            cstmt.execute();
            
            SQL = "{call getCustName (?,?)}"; 
            cstmt = connection.prepareCall (SQL); 
            cstmt.setInt(1, rs.getInt(1));
            cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
            cstmt.execute();
            String custName = cstmt.getString(2);
            System.out.println("Customer Name with ID:" + 
            rs.getInt(1) + " is " + custName+ " and you are logged in to order!");            
            
            //rs.next();
            
            //orderStatusStatement.setInt(1,rs.getInt(1));
            //orderStatusStatement.executeUpdate();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
      
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
        label2 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        label3 = new java.awt.Label();
        jRadioButton2 = new javax.swing.JRadioButton();
        pickUpPanel = new javax.swing.JPanel();
        label4 = new java.awt.Label();
        jTextField1 = new javax.swing.JTextField();
        DeliveryPanel = new javax.swing.JPanel();
        deliveryAddress = new javax.swing.JTextField();
        label5 = new java.awt.Label();
        totalCookingTime = new java.awt.Label();
        OrderPrice = new java.awt.Label();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setEnabled(false);
        label1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label1.setText("E-Cafe Management System");

        label2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label2.setText("Do you want pickup or delivery?");

        jButton2.setText("Buffalo Chicken Dip");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pepper Poppers");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Avacado Salsa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Glazed Chicken Wings");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Smoky Vegan Black Bean Soup");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Thai Chicken Basil Soup");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton15.setText("Roasted Asparagus & Bacon");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton8.setText("Brocolli Saute");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Parmesan Peas");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Spicy Chipotle Lasagna ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Spicy Thai Basil Chicken");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Green Goodness Spaghetti");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Paleo Stuffed Cabbage");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Chicken Pasta with Artichoke Hearts");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setText("Dijon Pork with Apples and Cabbage");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton16)
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Pickup");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label3.setText("Select dishes you want to order:");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Delivery");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        label4.setText("Enter time for pickup(24 hour format): ");

        javax.swing.GroupLayout pickUpPanelLayout = new javax.swing.GroupLayout(pickUpPanel);
        pickUpPanel.setLayout(pickUpPanelLayout);
        pickUpPanelLayout.setHorizontalGroup(
            pickUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pickUpPanelLayout.createSequentialGroup()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pickUpPanelLayout.setVerticalGroup(
            pickUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pickUpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pickUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        label5.setText("Enter delivery address:");

        javax.swing.GroupLayout DeliveryPanelLayout = new javax.swing.GroupLayout(DeliveryPanel);
        DeliveryPanel.setLayout(DeliveryPanelLayout);
        DeliveryPanelLayout.setHorizontalGroup(
            DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveryPanelLayout.createSequentialGroup()
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deliveryAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
        );
        DeliveryPanelLayout.setVerticalGroup(
            DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeliveryPanelLayout.createSequentialGroup()
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(deliveryAddress)))
        );

        totalCookingTime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        totalCookingTime.setText("Total Cooking Time:");

        OrderPrice.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        OrderPrice.setText("Order Price:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Order now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(111, 111, 111)
                                .addComponent(jRadioButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pickUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DeliveryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(OrderPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalCookingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 282, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeliveryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pickUpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OrderPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(totalCookingTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
            pickUpPanel.setVisible(true);
            DeliveryPanel.setVisible(false);
            
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
            pickUpPanel.setVisible(false);
            DeliveryPanel.setVisible(true);   
            
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        totalOrderPrice = totalOrderPrice + 5;
        totalTimeTaken = totalTimeTaken + 3;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");     
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        totalOrderPrice = totalOrderPrice + 5;
        totalTimeTaken = totalTimeTaken + 3;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        totalOrderPrice = totalOrderPrice + 5;
        totalTimeTaken = totalTimeTaken + 3;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        totalOrderPrice = totalOrderPrice + 3;
        totalTimeTaken = totalTimeTaken + 2;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");     
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        totalOrderPrice = totalOrderPrice + 3;
        totalTimeTaken = totalTimeTaken + 2;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");     
     }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        totalOrderPrice = totalOrderPrice + 10;
        totalTimeTaken = totalTimeTaken + 7;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");     
     }//GEN-LAST:event_jButton8ActionPerformed


    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        totalOrderPrice = totalOrderPrice + 10;
        totalTimeTaken = totalTimeTaken + 7;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);     
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");     
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        totalOrderPrice = totalOrderPrice + 15;
        totalTimeTaken = totalTimeTaken + 9;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);     
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        totalOrderPrice = totalOrderPrice + 15;
        totalTimeTaken = totalTimeTaken + 9;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);     
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");        }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        totalOrderPrice = totalOrderPrice + 15;
        totalTimeTaken = totalTimeTaken + 9;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);     
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");        }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        totalOrderPrice = totalOrderPrice + 15;
        totalTimeTaken = totalTimeTaken + 9;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);     
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");        }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        totalOrderPrice = totalOrderPrice + 15;
        totalTimeTaken = totalTimeTaken + 9;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);     
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");        }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        totalOrderPrice = totalOrderPrice + 10;
        totalTimeTaken = totalTimeTaken + 7;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");     }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        totalOrderPrice = totalOrderPrice + 10;
        totalTimeTaken = totalTimeTaken + 7;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");      }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        totalOrderPrice = totalOrderPrice + 5;
        totalTimeTaken = totalTimeTaken + 3;
        OrderPrice.setText("Order Price: $"+totalOrderPrice);
        totalCookingTime.setText("Total Cooking Time: "+totalTimeTaken+"minutes");  
            try{
            query = "SELECT D_Num FROM dishes WHERE D_Num = 1";
            rs = statement.executeQuery(query);
            rs.next();
            System.out.println("Dish Num: "+rs.getInt(1));
            orderDetailsStatement.setInt(2, rs.getInt(1));

            query = "SELECT customer_num FROM user WHERE username = '"+Customer.getUser()+"'";
            rs = statement.executeQuery(query); 
            rs.next();
            System.out.println("Customer ID: "+rs.getInt(1));
            
            query = "SELECT order_ID FROM order_status WHERE customer_ID = '"+rs.getInt(1)+"'";
            rs = statement.executeQuery(query);  
            rs.afterLast();
            rs.previous();            
            System.out.println("Order ID: "+rs.getInt(1));
            orderDetailsStatement.setInt(1, rs.getInt(1));


            System.out.println("Time: "+actual_time);
            orderDetailsStatement.setInt(3, actual_time);            
            String query2 = "SELECT count FROM order_info WHERE order_num = '"+rs.getInt(1)+"'";
             
            rs = statement.executeQuery(query2);  
            rs.next();
            if(rs.absolute(1) == false)
            {
              System.out.println("If");
              orderDetailsStatement.setInt(4, 1); 
              System.out.println("Dish_Count: 1\n");              
              orderDetailsStatement.executeUpdate();
            }
            else
            {
              System.out.println("Else");                
              orderDetailsStatement.setInt(4, rs.getInt(1)+1); 
              System.out.println("Dish_Count: "+rs.getInt(1)+1+"\n");
              orderDetailsStatement.executeUpdate();
            }

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    public int CheckOrderPrice()
    {
        return totalOrderPrice;
    }
    
    public int CheckTotalTime()
    {
        return totalTimeTaken;
    }
    
    public void OrderNow()
    {

    if(actual_time>22 || actual_time < 11)
    {
        JOptionPane.showMessageDialog(null,"We are closed at the moment. Please come back in between 11 to 22hours","Error",JOptionPane.ERROR_MESSAGE);                              
        System.exit(0);
    }
    else
    {
        if(jRadioButton2.isSelected())
        {  
        JOptionPane.showMessageDialog(null,"Total Cooking time: "+totalTimeTaken+"minutes\nOrder Price: $"+totalOrderPrice+"\nDelivery address: "+deliveryAddress.getText(),"Order Details",JOptionPane.INFORMATION_MESSAGE);                       
        System.exit(0);        
        }
        else if(jRadioButton1.isSelected())
        {
        pickup_time = Integer.parseInt(jTextField1.getText());
            if(pickup_time>22 || pickup_time < 11)
            {
            JOptionPane.showMessageDialog(null,"We are closed at this moment. Please pickup in between 11 to 22hours","Error",JOptionPane.ERROR_MESSAGE);                              
            }
            else
            {
            JOptionPane.showMessageDialog(null,"Total Cooking time: "+totalTimeTaken+"minutes\nOrder Price: $"+totalOrderPrice+"\nPick up time: "+jTextField1.getText(),"Order Details",JOptionPane.INFORMATION_MESSAGE);                           
            System.exit(0);            
            }
        }
    }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       OrderNow();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//       
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run(){
//                try {
//                    new Cafe().setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(Cafe.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DeliveryPanel;
    private java.awt.Label OrderPrice;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField deliveryAddress;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private javax.swing.JPanel pickUpPanel;
    private java.awt.Label totalCookingTime;
    // End of variables declaration//GEN-END:variables
}
