
import java.sql.Connection;
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
public class Admin {
    public int tempid;
    private String Name;
    private String Address;
    private String position;
    private String blood;
    private String phone;
    private String station;
    private int presence;
    private int Age;
    private int AdminID;
    private String username;
    private String password;
    private static Admin instance;
    private Admin()
    {
//        try{
//            
//            Connection conn = DBConnectivity.getConnection();
//            Statement stat;
//            ResultSet res;
//            stat=conn.createStatement();
//            res= stat.executeQuery("SELECT Name from admin where AdminID=20");
//            if (res.next()) {
//            this.Name = res.getString("Name");
//            }
//            res= stat.executeQuery("SELECT Age from admin where AdminID=20");
//            if (res.next()) {
//            this.Age = res.getInt("Age");
//            }
//            res= stat.executeQuery("SELECT Username from admin where AdminID=20");
//            if (res.next()) {
//            this.username = res.getString("Username");
//            }
//            res= stat.executeQuery("SELECT Bloodgroup from admin where AdminID=20");
//            if (res.next()) {
//            this.blood = res.getString("Bloodgroup");
//            }
//            res= stat.executeQuery("SELECT Address from admin where AdminID=20");
//            if (res.next()) {
//            this.Address = res.getString("Address");
//            }
//            res= stat.executeQuery("SELECT Position from admin where AdminID=20");
//            if (res.next()) {
//            this.position = res.getString("Position");
//            }
//            res= stat.executeQuery("SELECT Station from admin where AdminID=20");
//            if (res.next()) {
//            this.station = res.getString("Station");
//            }
//            res= stat.executeQuery("SELECT Attendance from admin where AdminID=20");
//            if (res.next()) {
//            this.presence = res.getInt("Attendance");
//            }
//            res= stat.executeQuery("SELECT Bloodgroup from admin where AdminID=20");
//            if (res.next()) {
//            this.blood = res.getString("Bloodgroup");
//            }
//            res= stat.executeQuery("SELECT Phone from admin where AdminID=20");
//            if (res.next()) {
//            this.phone = res.getString("Phone");
//            }
//            res= stat.executeQuery("SELECT Password from admin where AdminID=20");
//            if (res.next()) {
//            this.password = res.getString("Password");
//            }
//            res.close();
//            stat.close();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public void loadData(int adminID) {
        try {
            Connection conn = DBConnectivity.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM admin WHERE AdminID = " + adminID);

            if (res.next()) {
                this.AdminID = adminID;
                this.Name = res.getString("Name");
                this.Age = res.getInt("Age");
                this.username = res.getString("Username");
                this.blood = res.getString("Bloodgroup");
                this.Address = res.getString("Address");
                this.position = res.getString("Position");
                this.station = res.getString("Station");
                this.presence = res.getInt("Attendance");
                this.blood = res.getString("Bloodgroup");
                this.phone = res.getString("Phone");
                this.password = res.getString("Password");
            }

            res.close();
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Admin getinstance()
    {
         if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }
    public String getUsername() {
        return username;
    }
    public String getname() {
        return Name;
    }
    public int getAge() {
        return Age;
    }
    public String getBlood() {
        return blood;
    }
    public String getStation() {
        return station;
    }
    public int getPresence() {
        return presence;
    }
    public String getPosition() {
        return position;
    }
    public String getAddress() {
        return Address;
    }
    public String getphone() {
        return phone;
    }
    public String getPass() {
        return password;
    }
}
