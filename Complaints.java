
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class Complaints {
    
    public ResultSet Comp(){
        ResultSet res=null; 
        try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            stat=conn.createStatement();
            String FetchTable = "SELECT feedback_id,first_name,details,outcome_expectations,feedback_date from feedbacks;";
            PreparedStatement preparedStatement= conn.prepareStatement(FetchTable);
            res = preparedStatement.executeQuery();
           
            
            } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        return res;
    }
}
