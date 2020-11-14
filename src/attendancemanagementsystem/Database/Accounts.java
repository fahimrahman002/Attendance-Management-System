/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancemanagementsystem.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Accounts {

    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private Statement st;
    public Connection conn = null;

    public Accounts() {
    }

    public Accounts(Connection conn) {
        this.conn = conn;
    }

    public StudentDatabase studentLogin(String id, String pass) {
        final JPanel panel = new JPanel();

        String sql = "select name,id,pass,email,phone,address,blood_group from student_data where id=\'" + id + "\' and pass=\'" + pass + "\'";
        try {
            st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return new StudentDatabase(conn, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            } else {
                JOptionPane.showMessageDialog(panel, "User not valid", "Warning", JOptionPane.WARNING_MESSAGE);
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Database Error", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public AdminDatabase adminLogin(String username, String pass) {
        final JPanel panel = new JPanel();

        String sql = "select name,username,pass,email,phone from admin_data where username=\'" + username + "\' and pass=\'" + pass + "\'";
        try {
            st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return new AdminDatabase(conn, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(panel, "User not valid", "Warning", JOptionPane.WARNING_MESSAGE);
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Database Error", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

}
