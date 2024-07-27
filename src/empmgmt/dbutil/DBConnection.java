/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class DBConnection {
    private static Connection conn;
    static
    {
        try
        {
           Class.forName("com.mysql.cj.jdbc.Driver"); //  com.mysql.jdbc.Driver
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "rohit@8873");
           JOptionPane.showMessageDialog(null,"Connection open Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,"Erro the loading the driver!","Driver Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        catch(SQLException ex)
        {
             JOptionPane.showMessageDialog(null,"Erro opening Connecting!","DB Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null,"Connection close Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
        }
         catch(SQLException ex)
        {
             JOptionPane.showMessageDialog(null,"Erro closeing Connecting!","DB Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            
        }
    }
}
