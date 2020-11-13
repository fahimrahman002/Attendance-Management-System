package attendancemanagementsystem.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fuads
 */
public class JConnection {

    public static Connection connectdb() {
        String url = "jdbc:mysql://localhost/";
        String dbName = "attendance_management_system";
        String username = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url + dbName, username, pass);
//            System.out.println("Connected");
            return connection;
        } catch (ClassNotFoundException | SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Connection failed");
            return null;
        }

    }
}
