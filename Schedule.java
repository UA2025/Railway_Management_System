/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hp
 */
public class Schedule {
    private String date; 
    private String Time;
    private int Trid;
    private String Status;
    private int Schid;
    public void makeSch(String date, String Time, int id,String Stat)
    {
        this.Time=Time;
        this.Trid=id;
        this.date=date;
        this.Status=Stat;
        try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            stat=conn.createStatement();
            String insertQ="insert into Schedule (trainid, Date, Time, Status) values (?,?,?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQ);
            preparedStatement.setInt(1, this.Trid);
            preparedStatement.setString(2, this.date);
            preparedStatement.setString(3, this.Time);
            preparedStatement.setString(4, this.Status);
            int rowsAffected = preparedStatement.executeUpdate();
             }catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);}


    }
    public void updateSch(int Schid,String date, String Time, int id,String Stat)
    {
        this.Schid=Schid;
        this.Time=Time;
        this.Trid=id;
        this.date=date;
        this.Status=Stat;
        
        try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            stat=conn.createStatement();
            if(!((this.Time).equals("")))
            {
                String insertQ="update Schedule set Time = (?) where SchID IN(?);";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQ);
                preparedStatement.setString(1, this.Time);
                preparedStatement.setInt(2, this.Schid);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.print(rowsAffected);
            
            }
            if(!((this.date).equals("")))
            {
                String insertQ="update Schedule set Date = (?) where SchID IN(?);";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQ);
                preparedStatement.setString(1, this.date);
                preparedStatement.setInt(2, this.Schid);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.print(rowsAffected);
            
            }    
            if(!((this.Status).equals("")))
            {
                String insertQ="update Schedule set Status = (?) where SchID IN(?);";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQ);
                preparedStatement.setString(1, this.Status);
                preparedStatement.setInt(2, this.Schid);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.print(rowsAffected);
            
            }
            if(id!=0)
            {
                String insertQ="update Schedule set trainid = (?) where SchID IN(?);";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQ);
                preparedStatement.setInt(1, this.Trid);
                preparedStatement.setInt(2, this.Schid);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.print(rowsAffected);
            
            }
             }catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);}
    }
    public ResultSet Schdules(){
        ResultSet res=null; 
        try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            stat=conn.createStatement();
            String FetchTable = "SELECT * from Schedule";
            PreparedStatement preparedStatement= conn.prepareStatement(FetchTable);
            res = preparedStatement.executeQuery();
           
            
            } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        return res;
    }
};
