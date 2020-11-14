/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancemanagementsystem.Database;

import java.awt.HeadlessException;
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

    public boolean userLogin(String id, String pass) {
        final JPanel panel = new JPanel();
        String sql = "select id from 'admin_data' where id=\'" + id + "\' and pass=\'" + pass + "\'";
        try {
            st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(panel, "User not valid", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(panel, "Database Error", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    public boolean adminLogin(String username, String pass) {
        final JPanel panel = new JPanel();
        String sql = "select username from admin_data where username=\'" + username + "\' and pass=\'" + pass + "\'";
        try {
            st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(panel, "User not valid", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Database Error", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

}
