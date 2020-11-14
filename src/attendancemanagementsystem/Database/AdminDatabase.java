/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancemanagementsystem.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminDatabase {

    final JPanel panel = new JPanel();
    private Connection conn;
    private String adminName, adminUsername, adminPass, adminEmail, adminPhone;
    private PreparedStatement pst;

    //Constructor
    public AdminDatabase() {
    }

    //Constructor (Polymorphism - Method Overloading)
    public AdminDatabase(Connection conn, String adminName, String adminUsername, String adminPass, String adminEmail, String adminPhone) {
        this.conn = conn;
        this.adminName = adminName;
        this.adminUsername = adminUsername;
        this.adminPass = adminPass;
        this.adminEmail = adminEmail;
        this.adminPhone = adminPhone;
    }

    public void createStudentAccount(String studentLogId, String studentLogInPass) {
        try {
            String sql = "insert into student_data(id,pass) values(?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, studentLogId);
            pst.setString(2, studentLogInPass);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Student account has been created successfully");
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(panel, "Student ID should be unique.", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Database Error", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean deleteStudentAccount(String studentLogInId) {
        String sql = "DELETE FROM student_data WHERE id=" + "\'" + studentLogInId + "\'";
        int DialogResult = JOptionPane.showConfirmDialog(null, "Do you really want to delete the account?", "Delete", JOptionPane.YES_NO_OPTION);
        if (DialogResult == 0) {
            try {
                pst = conn.prepareStatement(sql);
                pst.execute();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Database Error.", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        return false;
    }

    public boolean updateProfile(String adminPass, String adminName, String adminEmail, String adminPhone) {

        try {
            pst = conn.prepareStatement("update admin_data set pass =?,name=?,email=?,phone=?  where username = \'" + adminUsername + "\'");
            pst.setString(1, adminPass);
            pst.setString(2, adminName);
            pst.setString(3, adminEmail);
            pst.setString(4, adminPhone);
            int updateDone = pst.executeUpdate();

            if (updateDone == 1) {
                this.adminName = adminName;
                this.adminPass = adminPass;
                this.adminEmail = adminEmail;
                this.adminPhone = adminPhone;
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Database Error", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

}
