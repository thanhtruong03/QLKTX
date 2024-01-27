/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author hoang
 */
import database.DatabaseHelpper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAOImpl implements ThongKeDAO {

    @Override
    public List<Student> getListByStudent() {
        Connection cons = DatabaseHelpper.getConnection();
        String sql = "SELECT Room.block AS BlockName, COUNT(Student.id) AS NumberOfStudents FROM Room LEFT JOIN Student ON Room.name = Student.room GROUP BY Room.block ORDER BY Room.block;";
        List<Student> list = new ArrayList<>();
        try {
            PreparedStatement st = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setRoom(rs.getString("BlockName"));
                student.setId(rs.getString("NumberOfStudents"));
                list.add(student);
            }
            st.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /*@Override
    public List<Student> getListByStudentForPie() {
        Connection cons = DatabaseHelpper.getConnection();
        String sql = "SELECT block AS BlockName, COUNT(id) AS NumberOfStudents FROM Student JOIN Room ON Student.room = Room.name WHERE Student.room IS NOT NULL GROUP BY block ORDER BY block;";
        List<Student> list = new ArrayList<>();
        try {
            try (PreparedStatement st = (PreparedStatement) cons.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setRoom(rs.getString("BlockName"));
                    student.setId(rs.getString("NumberOfStudents"));
                    list.add(student);
                }
            }
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
}