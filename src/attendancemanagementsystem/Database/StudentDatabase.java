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

public class StudentDatabase {

    final JPanel panel = new JPanel();
    private Connection conn;
    private String studentName, studentId, studentPass, studentEmail, studentPhone, studentAddress, studentBloodGroup;
    private PreparedStatement pst;
    private Statement st;
    ResultSet rs = null;

    public StudentDatabase() {
    }

    public StudentDatabase(Connection conn, String studentName, String studentId, String studentPass, String studentEmail, String studentPhone, String studentAddress, String studentBloodGroup) {
        this.conn = conn;
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentPass = studentPass;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.studentAddress = studentAddress;
        this.studentBloodGroup = studentBloodGroup;
    }

    public StudentDatabase(String studentName, String studentId, String studentEmail, String studentPhone) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
    }

    public boolean[] getAttendance(int month) {
        String sql = "select * from attendance where month=\'" + month + "\' and id=\'" + getStudentId() + "\'";
        boolean[] attendance = new boolean[31];
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 1; i <= 30; i++) {
                    attendance[i] = rs.getBoolean("D" + i);
                }
            }
            return attendance;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can't get attendance from database.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public boolean updateProfile(String studentPass, String studentName, String studentEmail, String studentPhone, String studentAddress, String studentBloodGroup) {

        try {
            pst = conn.prepareStatement("update student_data set pass =?,name=?,email=?,phone=?,address=?,blood_group=?  where id = \'" + studentId + "\'");
            pst.setString(1, studentPass);
            pst.setString(2, studentName);
            pst.setString(3, studentEmail);
            pst.setString(4, studentPhone);
            pst.setString(5, studentAddress);
            pst.setString(6, studentBloodGroup);
            int updateDone = pst.executeUpdate();

            if (updateDone == 1) {
                this.studentName = studentName;
                this.studentPass = studentPass;
                this.studentEmail = studentEmail;
                this.studentPhone = studentPhone;
                this.studentAddress = studentAddress;
                this.studentBloodGroup = studentBloodGroup;
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Database Error.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public String getStudentBloodGroup() {
        return studentBloodGroup;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentPass() {
        return studentPass;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentPass(String studentPass) {
        this.studentPass = studentPass;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public void setStudentBloodGroup(String studentBloodGroup) {
        this.studentBloodGroup = studentBloodGroup;
    }

}
