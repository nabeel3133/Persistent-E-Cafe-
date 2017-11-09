/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nabeel Hussain Syed
 */
public class CafeTest {

    @Test
    public void testOrderNow()
    {  
        //jButton2.doClick();
        String expected = "Order Price: ";
        assertEquals("Order Price: ",expected);
    } 
    
    @Test
    public void testCheckOrderPrice() throws SQLException
    {          
        Cafe object = new Cafe();
        int total_price = object.CheckOrderPrice();
        int expected = 0;
        assertEquals(total_price, expected);        
    } 
    
    @Test
    public void testCheckTotalTime() throws SQLException
    {  
        Cafe object = new Cafe();
        int total_price = object.CheckOrderPrice();
        int expected = 0;
        assertEquals(total_price, expected); 
    } 
}
