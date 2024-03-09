
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.Statement;
import javax.swing.JFrame;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException; 
import java.sql.*; 
import java.sql.Statement; 
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends LoginForm{
    
    public void LoginFunctionality(String usernames, String passwords, boolean isAdmins) {
        // Validation checks
        if (usernames.isEmpty() || passwords.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Username and Password cannot be empty");
            return;
        }

        // Check credentials against the database
        String query = "SELECT * FROM User WHERE Username = ? AND Password = ?";
        if (isAdmins) {
            query = "SELECT AdminID FROM Admin WHERE Username = ? AND Password = ?";
        }

        try {
            Connection conn = DBConnectivity.getConnection();
            Statement stat;
            ResultSet res;
            stat=conn.createStatement();
            PreparedStatement preparedStatement= conn.prepareStatement(query);
            preparedStatement.setString(1, usernames);
            preparedStatement.setString(2, passwords);
            res = preparedStatement.executeQuery();
           
            // If the credentials are valid
            if (res.next()) {
                if (isAdmins) {
                    // Open Admin Dashboard
                    int adminid;
                    Admin ad=Admin.getinstance();
                    adminid = res.getInt("AdminID");
                    ad.loadData(adminid);
                    AdminGUI pd = new AdminGUI(); 
               
                    pd.setVisible(true); 
                    
                } else {
//                    PassengerDash pd = new PassengerDash();  //here PassengerDash class will be added  
//                    pd.setVisible(true); 
//                    
                    // Open User Dashboard with user's credentials
                    //openUserDashboard(rs.getString("Username"), rs.getString("Email"));
                }
            } else {
                // Invalid credentials
                JOptionPane.showMessageDialog(new JFrame(), "Invalid username or password");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Error during login");
        }
    }
}
