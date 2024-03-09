
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
public class Applicant {
    public ResultSet Applicants(){
        ResultSet res=null; 
        try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            stat=conn.createStatement();
            String FetchTable = "SELECT applicant_id,full_name,email,institution,field_of_study,graduation_year from applicants";
            PreparedStatement preparedStatement= conn.prepareStatement(FetchTable);
            res = preparedStatement.executeQuery();
           
            
            } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        return res;
    }
    public void setInterview(int Aid,String Time, String date, String place, String Mes,String iname, String iemail, String iphone)
    {
        try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            stat=conn.createStatement();
            String insertQ="INSERT INTO interview (applicant_id, date, time, place, message, interviewer_name, interviewer_email, interviewer_phone) values (?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQ);
            preparedStatement.setInt(1, Aid);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, Time);
            preparedStatement.setString(4, place);
            preparedStatement.setString(5, Mes);
            preparedStatement.setString(6, iname);
            preparedStatement.setString(7, iemail);
            preparedStatement.setString(8, iphone);
            int rowsAffected = preparedStatement.executeUpdate();
             }catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);}

    }
}
