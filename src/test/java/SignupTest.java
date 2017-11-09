/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Nabeel Hussain Syed
 */
public class SignupTest {
public Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/e-cafe", "root",""); 
public Statement statement = connection.createStatement();
public static ResultSet rs;   
    public SignupTest() throws SQLException {
        
    }
    
    
    /**
     * Test of main method, of class Signup.
     */
    @Test
    public void SigninCustomer() throws SQLException  {
    String user = "nabeel3133";
    String pass = "123"; 
    String query = "SELECT * FROM user WHERE username = '"+user+"' AND password = '"+pass+"' ";
    ResultSet rs = statement.executeQuery(query);
    if(rs.absolute(1) == false)
    {
        System.out.println("Sign in Check: If username and password is not in database");
        assertTrue(false);   
    }
    else
    {
        System.out.println("Sign in Check: If username and password is in database");
        assertTrue(true);
  
    }
    }
    
    @Test
    public void SignupCustomer() throws SQLException {
        String user = "nabeel3133";
        String query = "SELECT * FROM user WHERE username = '"+user+"'";
                ResultSet rs = statement.executeQuery(query);
                if(rs.absolute(1)==true)
                {
                  System.out.println("Sign up Check: If username already exists in database");                    
                  assertTrue(true);    //If username already exists         
                }
                else
                {
                 System.out.println("Sign up Check: If username does not already exists in database");                    
                  assertTrue(false);  //If username does not exists
                }
    }
}
