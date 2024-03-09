
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
public class Trains {
    
     private String src;
    private String dst;
    private int cap;
    private String Name;
    private int trainid;
    Trains(){}
    Trains(int num){
        try{
            this.trainid=num;
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            ResultSet res;
            String selectQuery = "SELECT TrName FROM Train WHERE TrainID IN (?)";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, num);
            res = preparedStatement.executeQuery();    
            if (res.next()) {
            this.Name = res.getString("TrName"); }
            
            
            selectQuery = "SELECT dstCity FROM Train WHERE TrainID IN (?)";
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, num);
            res = preparedStatement.executeQuery();    
            if (res.next()) {
            this.dst = res.getString("dstCity"); }
            
            
            selectQuery = "SELECT srcCity FROM Train WHERE TrainID IN (?)";
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, num);
            res = preparedStatement.executeQuery();    
            if (res.next()) {
            this.src = res.getString("srcCity"); }
            
            
            selectQuery = "SELECT totalSeats FROM Train WHERE TrainID IN (?)";
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, num);
            res = preparedStatement.executeQuery();    
            if (res.next()) {
            this.cap = res.getInt("totalSeats"); }
            
            } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public void updateTrain(String name,String src,String dst,int seats)
    {
            
                if (!name.equals("")){
                    this.Name= name;
                }
                if (!src.equals("")) {
                    this.src=src;
                }
                if (!dst.equals("")) {
                    this.dst=dst;
                }
                if(seats!=0) {
                    this.cap=seats;
                }
                System.out.print(name);
           if (!name.equals("undeclared")) {
                 this.updateinDB();
            }        
    }
    public void addTrain(String name,String src,String dst,int seats)
    {
        if (!name.equals("")){
            this.Name= name;
        }
        if (!src.equals("")) {
            this.src=src;
        }
        if (!dst.equals("")) {
            this.dst=dst;
        }
        if(seats!=0) {
            this.cap=seats;
        }
        System.out.print(name);
        this.addinDB();
                 
    
    }
    private void updateinDB(){
            try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            stat=conn.createStatement();
            String insertQ="UPDATE Train SET TrName=?, srcCity=?, dstCity=?, totalSeats=? WHERE TrainID=?";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQ);
            preparedStatement.setString(1, this.Name);
            preparedStatement.setString(2, this.src);
            preparedStatement.setString(3, this.dst);
            preparedStatement.setInt(4, this.cap);
            preparedStatement.setInt(5,this.trainid );
            int rowsAffected = preparedStatement.executeUpdate();
             }catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);}

    }
    private void addinDB(){
            try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            stat=conn.createStatement();
            String insertQ="insert into Train (TrName, srcCity, dstCity, totalSeats) values (?,?,?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQ);
            preparedStatement.setString(1, this.Name);
            preparedStatement.setString(2, this.src);
            preparedStatement.setString(3, this.dst);
            preparedStatement.setInt(4, this.cap);
            int rowsAffected = preparedStatement.executeUpdate();
             }catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);}

    }
    public int SearchTrain(String name )
    {
        int id=0;
        try{
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            ResultSet res;
            String selectQuery = "SELECT TrainID FROM Train WHERE TrName =(?)";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, name);
            res = preparedStatement.executeQuery();   
           
            if (res.next()) {
                id = res.getInt("TrainID");
               
               
            }
         }catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);}
        return id;
    }
     public String getName()
    {
        return Name;
    }
    public String getDst()
    {
        return dst;
    }
    public String getSrc()
    {
        return src;
    }
    public int getCap()
    {
        return cap;
    }
    public int getTrid()
    {
        return trainid;
    }
     public void setName(String NAme)
    {
        this.Name=NAme;
    }
    public void setDst(String dst)
    {
        this.dst=dst;
    }
    public void setSrc(String src)
    {
        this.src=src;
    }
    public void setCap(int set)
    {
        this.cap=set;
    }
    public void setTrid(int trid)
    {
        this.trainid=trid;
    }
}
