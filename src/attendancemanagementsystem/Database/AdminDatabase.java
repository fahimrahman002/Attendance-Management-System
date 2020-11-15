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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminDatabase {

    final JPanel panel = new JPanel();
    private Connection conn;
    private String adminName, adminUsername, adminPass, adminEmail, adminPhone;
    private PreparedStatement pst;
    ResultSet rs = null;

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

    public void giveAttendance(String studentId, String dayColumn, int month) {
        String sql;
        try {
            pst = conn.prepareStatement("update attendance set " + dayColumn + " =?  where id = \'" + studentId + "\' and month=\'" + month + "\'");
            pst.setBoolean(1, true);
            int updateDone = pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(panel, "Can not store attendance in database.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void createStudentAccount(String studentLogId, String studentLogInPass) {
        String sql;
        try {
            sql = "insert into student_data(id,pass) values(?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, studentLogId);
            pst.setString(2, studentLogInPass);
            pst.execute();
            for (int i = 1; i <= 12; i++) {
                sql = "insert into attendance(id,month) values(?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, studentLogId);
                pst.setInt(2, i);
                pst.execute();
            }
            JOptionPane.showMessageDialog(null, "Student account has been created successfully");
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(panel, "Student ID should be unique.", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(panel, "Database Error.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

    public boolean deleteStudentAccount(String studentLogInId) {
        String sql = "DELETE FROM student_data WHERE id=" + "\'" + studentLogInId + "\'";
        int DialogResult = JOptionPane.showConfirmDialog(null, "Do you really want to delete the account?", "Delete", JOptionPane.YES_NO_OPTION);
        if (DialogResult == 0) {
            try {
                pst = conn.prepareStatement(sql);
                pst.execute();
                sql = "delete from attendance where id=" + "\'" + studentLogInId + "\'";
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

    public List<StudentDatabase> getStudentData() {
        String sql = "select * from student_data";
        List<StudentDatabase> list = new ArrayList<StudentDatabase>();

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                StudentDatabase student = new StudentDatabase(rs.getString("name"), rs.getString("id"), rs.getString("email"), rs.getString("phone"));
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can't get message from database.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
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
