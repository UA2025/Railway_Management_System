
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class Maintenance {
    private String Date;
    private String Time;
    private String Reason;
    private String Mechanic;
    private String AdminName;
    private String TrName;
    Maintenance(int num){
        try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            ResultSet res;
            String selectQuery = "SELECT Date FROM Maintenance WHERE MainID IN (?)";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, num);
            res = preparedStatement.executeQuery();    
            if (res.next()) {
            this.Date = res.getString("Date"); }
            
            
            selectQuery = "SELECT Time FROM Maintenance WHERE MainID IN (?)";
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, num);
            res = preparedStatement.executeQuery();    
            if (res.next()) {
            this.Time = res.getString("Time"); }
            
            
            selectQuery = "SELECT Reason FROM Maintenance WHERE MainID IN (?)";
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, num);
            res = preparedStatement.executeQuery();    
            if (res.next()) {
            this.Reason = res.getString("Reason"); }
            
            
            selectQuery = "SELECT Mechanic FROM Maintenance WHERE MainID IN (?)";
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, num);
            res = preparedStatement.executeQuery();    
            if (res.next()) {
            this.Mechanic = res.getString("Mechanic"); }
            
            
            selectQuery = "SELECT Name FROM Maintenance m, Admin a where m.Adminid = a.AdminID and MainID IN (?)";
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, num);
            res = preparedStatement.executeQuery();    
            if (res.next()) {
            this.AdminName = res.getString("Name"); }
            
            selectQuery = "SELECT TrName FROM Maintenance m, Train a where m.trainid = a.TrainID and MainID IN (?)";
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, num);
            res = preparedStatement.executeQuery();    
            if (res.next()) {
            this.TrName = res.getString("TrName"); }
            
            } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    Maintenance(String date,String time,String reason,String mechanic,String trname)
    {
        this.Date= date;
        this.Time=time;
        this.Reason=reason;
        this.Mechanic=mechanic;
        this.TrName=trname;
         try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            ResultSet res;
            stat=conn.createStatement();
            int Adminid=20;
//            res= stat.executeQuery("SELECT AdminID from admin where AdminID=20");
//            if (res.next()) {
//            this.AdminName = res.getString("Name");
//            }
            
            String selectQuery = "SELECT TrainID FROM Train WHERE TrName IN (?)";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, trname);
            res = preparedStatement.executeQuery(); 
            int trainid=0;
            if (res.next()) {
            trainid = res.getInt("TrainID");
            }
            else {System.out.print("INVALID TRAIN NAME");}
            String insertQ="insert into Maintenance (date,time,reason,Mechanic,Adminid,trainid) values (?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(insertQ);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, time);
            preparedStatement.setString(3, reason);
            preparedStatement.setString(4, mechanic);
            preparedStatement.setInt(5,Adminid );
            preparedStatement.setInt(6,trainid );
            int rowsAffected = preparedStatement.executeUpdate();
         }catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);}

    }
    public String getAdminName()
    {
        return AdminName;
    }
     public String getMechanic()
    {
        return Mechanic;
    }
    public String getReason()
    {
        return Reason;
    }
    public String getTime()
    {
        return Time;
    }
    public String getDate()
    {
        return Date;
    }
    public String getTrainName()
    {
        return TrName;
    }
    
}
