/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hp
 */
public class DBConnectivity {
    public static Connection getConnection()  {
          
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/rmsdata?zeroDateTimeBehavior=CONVERT_TO_NULL","root","root");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
}
