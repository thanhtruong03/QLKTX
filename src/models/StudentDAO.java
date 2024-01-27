/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.DatabaseHelpper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class StudentDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
    private void closeResources() {
        try {
            if (sttm != null) {
                sttm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.toString());
        }
    }
    
    public boolean exitEmailAndPhone(String email, String phone){
        ResultSet re = null;
         try {
            String ssQL = "SELECT * FROM [Student] WHERE [Student].email = ? OR [Student].phoenNumber = ?";
            conn = DatabaseHelpper.getConnection();
            sttm= conn.prepareStatement(ssQL);
            sttm.setString(1, email);
            sttm.setString(2, phone);
            re = sttm.executeQuery();
            while(re.next()){
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error: "+e.toString());
        }finally{
            closeResources();
        }
         return false;
    }
    public int createStudent(Student st){
        
        int re = 0;
            try {
            String ssQL = "INSERT INTO [Student] ( id, name, class, birthday, address, email, gender, phoneNumber, room, havingRoom, changingRoom) VALUES(?,?,?,?,?,?,?,?,?,?,?)" ;
            conn = DatabaseHelpper.getConnection();
            sttm= conn.prepareStatement(ssQL);
            sttm.setString(1, st.getId());
            sttm.setString(2, st.getName());
            sttm.setString(3, st.getClassName());
            sttm.setString(4, st.getBirthday());
            sttm.setString(5, st.getAddress());
            sttm.setString(6, st.getEmail());
            sttm.setBoolean(7, st.getGender());
            sttm.setString(8, st.getPhoneNumber());
            sttm.setString(9, st.getRoom());
            sttm.setBoolean(10, st.isHavingRoom());
            sttm.setString(11, st.getChangingRoom());

            re = sttm.executeUpdate();
            if(re > 0){
                System.out.println("Create new Student successful");
                return 1;
            }else{
                return 0;
            }
            }catch (Exception e) {
            System.err.println("Error: "+e.toString());
            }finally{
                closeResources();
            }
        System.out.println("Create new Student failed");
        return 2;
    }
    public int updateStudent(Student st) {
        try {
            String sSQL = "UPDATE [student] SET name=?, class=?, birthday=?, address=?, email=?, gender=?, phoneNumber=?, room=?, havingRoom=?, changingRoom=? WHERE id=?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, st.getName());
            sttm.setString(2, st.getClassName());
            sttm.setString(3, st.getBirthday());
            sttm.setString(4, st.getAddress());
            sttm.setString(5, st.getEmail());
            sttm.setBoolean(6, st.getGender());
            sttm.setString(7, st.getPhoneNumber());
            sttm.setString(8, st.getRoom());
            sttm.setBoolean(9, st.isHavingRoom());
            sttm.setString(10, st.getChangingRoom());
            sttm.setString(11, st.getId());

            if (sttm.executeUpdate() > 0) {
                System.out.println("Update successful");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        System.out.println("Update failed");
        return 0;
    }

    public List<Student> getAll() {
        List<Student> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "SELECT * FROM Student";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Student st = new Student();
                st.setId(rs.getString("id"));
                st.setName(rs.getString("name"));
                st.setClassName(rs.getString("class"));
                st.setEmail(rs.getString("email"));
                st.setAddress(rs.getString("address"));
                st.setBirthday(rs.getString("birthday"));
                st.setRoom(rs.getString("room"));
                st.setHavingRoom(rs.getBoolean("havingRoom"));
                st.setGender(rs.getBoolean("gender"));
                st.setChangingRoom(rs.getString("changingRoom"));
                st.setPhoneNumber(rs.getString("phoneNumber"));
                ls.add(st);
            }
            return ls;
        } catch (Exception e) {
            System.out.println("loi " + e.toString());
        } finally {
            closeResources();
        }
        return ls;
    }
    public List<Student> getStudentsRegist() {
        List<Student> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "SELECT *FROM Student WHERE Student.havingRoom = 0 AND Student.room IS NOT NULL;";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Student st = new Student();
                st.setId(rs.getString("id"));
                st.setName(rs.getString("name"));
                st.setClassName(rs.getString("class"));
                st.setBirthday(rs.getString("birthday"));
                st.setAddress(rs.getString("address"));
                st.setEmail(rs.getString("email"));
                st.setGender(rs.getBoolean("gender"));
                st.setPhoneNumber(rs.getString("phoneNumber"));
                st.setRoom(rs.getString("room"));
                st.setHavingRoom(rs.getBoolean("havingRoom"));
                st.setChangingRoom(rs.getString("changingRoom"));
                
                ls.add(st);
            }
            return ls;
        } catch (Exception e) {
            System.out.println("loi " + e.toString());
        } finally {
            closeResources();
        }
        return ls;
    }
    public int acceptRegist(Student st) {
        try {
            String sSQL = "UPDATE student SET havingRoom = 1 WHERE id=?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, st.getId());
            
            if (sttm.executeUpdate() > 0) {
                System.out.println("Cập nhật dữ liệu thành công");
                return 1;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return -1;
    }
    public int refuseRegist(Student st) {
        try {
            String sSQL = "UPDATE student SET room = NULL WHERE id=?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, st.getId());
            
            if (sttm.executeUpdate() > 0) {
                System.out.println("Cập nhật dữ liệu thành công");
                return 1;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return -1;
    }
    
    
    public List<Student> getStudentsMoveAnother() {
        List<Student> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "SELECT *FROM Student WHERE Student.changingRoom IS NOT NULL;";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Student st = new Student();
                st.setId(rs.getString("id"));
                st.setName(rs.getString("name"));
                st.setClassName(rs.getString("class"));
                st.setBirthday(rs.getString("birthday"));
                st.setAddress(rs.getString("address"));
                st.setEmail(rs.getString("email"));
                st.setGender(rs.getBoolean("gender"));
                st.setPhoneNumber(rs.getString("phoneNumber"));
                st.setRoom(rs.getString("room"));
                st.setHavingRoom(rs.getBoolean("havingRoom"));
                st.setChangingRoom(rs.getString("changingRoom"));
                
                ls.add(st);
            }
            return ls;
        } catch (Exception e) {
            System.out.println("loi " + e.toString());
        } finally {
            closeResources();
        }
        return ls;
    }
    public int acceptMovingRoom(Student st) {
        try {
            String sSQL = "UPDATE student SET room = changingRoom, changingRoom = NULL WHERE id=?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, st.getId());
            
            if (sttm.executeUpdate() > 0) {
                System.out.println("Cập nhật dữ liệu thành công");
                return 1;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return -1;
    }
    public int refuseMovingRoom(Student st) {
        try {
            String sSQL = "UPDATE student SET changingRoom = NULL WHERE id=?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, st.getId());
            
            if (sttm.executeUpdate() > 0) {
                System.out.println("Cập nhật dữ liệu thành công");
                return 1;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return -1;
    }
    
    public List<Student> getStudentsByRoom(String nameRoom){
        List<Student> students = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM student WHERE room=? and havingRoom = 1";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, nameRoom);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Student st = new Student();
                st.setId(rs.getString("id"));
                st.setName(rs.getString("name"));
                st.setClassName(rs.getString("class"));
                st.setBirthday(rs.getString("birthday"));
                st.setAddress(rs.getString("address"));
                st.setEmail(rs.getString("email"));
                st.setGender(rs.getBoolean("gender"));
                st.setPhoneNumber(rs.getString("phoneNumber"));
                st.setRoom(rs.getString("room"));
                st.setHavingRoom(rs.getBoolean("havingRoom"));
                st.setChangingRoom(rs.getString("changingRoom"));
                
                students.add(st);
            }
            return students;
        } catch (Exception e) {
        } finally {
        }
        return students;
    }
    
    public Student getStudentById(String id) {
        Student student = null;
        ResultSet rs = null;

        try {
            String sSQL = "SELECT * FROM student WHERE id=?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, id);
            rs = sttm.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setClassName(rs.getString("class"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                student.setBirthday(rs.getString("birthday"));
                student.setRoom(rs.getString("room"));
                student.setHavingRoom(rs.getBoolean("havingRoom"));
                student.setGender(rs.getBoolean("gender"));
                student.setChangingRoom(rs.getString("changingRoom"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }

        return student;
    }
    public ArrayList<Student> getStudentFromDatabase(String queryStatement) {
        ArrayList<Student> listStudents = new ArrayList<>();
        try {
            Connection conn = DatabaseHelpper.getConnection();  // Assuming you have a method like DatabaseHelpper.getConnection()
            PreparedStatement ps = conn.prepareStatement(queryStatement);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setId(resultSet.getString("id"));
                student.setClassName(resultSet.getString("class"));
                student.setEmail(resultSet.getString("email"));
                student.setRoom(resultSet.getString("room"));
                student.setAddress(resultSet.getString("address"));
                student.setBirthday(resultSet.getString("birthday"));
                student.setHavingRoom(resultSet.getBoolean("havingRoom"));
                student.setGender(resultSet.getBoolean("gender"));
                student.setPhoneNumber(resultSet.getString("phoneNumber"));
                listStudents.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }

    public boolean setStudentIntoDatabase(Student sv) {
        String queryStatement = "INSERT INTO [STUDENT] (name, id, class, email, room, address, birthday, havingRoom, gender, phoneNumber)"
                                + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DatabaseHelpper.getConnection();  // Assuming you have a method like DatabaseHelpper.getConnection()
            PreparedStatement ps = conn.prepareStatement(queryStatement);
            ps.setString(1, sv.getName());
            ps.setString(2, sv.getId());
            ps.setString(3, sv.getClassName());
            ps.setString(4, sv.getEmail());
            ps.setString(5, sv.getRoom());
            ps.setString(6, sv.getAddress());
            ps.setString(7, sv.getBirthday());
            ps.setBoolean(8, sv.isHavingRoom());
            ps.setBoolean(9, sv.getGender());
            ps.setString(10, sv.getPhoneNumber());

            return ps.executeUpdate()> 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Student> getListStudents() {
        String query = "SELECT name, id, class, email, room, address, birthday, havingRoom, gender, phoneNumber FROM STUDENT";
        return getStudentFromDatabase(query);
    }

    public ArrayList<Student> refreshDB() {
        return getStudentFromDatabase("SELECT name, id, class, email, room, address, birthday, havingRoom, gender, phoneNumber FROM STUDENT");
    }
    
    public ArrayList<String> getListOfRoom() {
        String queryStatement = "SELECT ROOM FROM STUDENT GROUP BY ROOM";
        ArrayList<String> listOfRoom = new ArrayList<>();
        try {
            conn = DatabaseHelpper.getConnection(); // Assuming you have a method like DatabaseHelpper.getConnection()
            PreparedStatement ps = conn.prepareStatement(queryStatement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfRoom.add(rs.getString("room"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return listOfRoom;
    }

    public ArrayList<String> getListOfClass() {
        String queryStatement = "SELECT CLASS FROM STUDENT GROUP BY CLASS";
        ArrayList<String> listOfClass = new ArrayList<>();
        try {
            conn = DatabaseHelpper.getConnection(); // Assuming you have a method like DatabaseHelpper.getConnection()
            PreparedStatement ps = conn.prepareStatement(queryStatement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfClass.add(rs.getString("class"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return listOfClass;
    }

    public ArrayList<String> getlistOfID() {
        String queryStatement = "SELECT id FROM STUDENT GROUP BY id";
        ArrayList<String> listOfID = new ArrayList<>();
        try {
            conn = DatabaseHelpper.getConnection(); // Assuming you have a method like DatabaseHelpper.getConnection()
            PreparedStatement ps = conn.prepareStatement(queryStatement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfID.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return listOfID;
    }
    
    public List<Student> getStudentByNameRoom(String name){
        List<Student> students = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM student WHERE room LIKE ?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, "%" + name + "%");
            rs = sttm.executeQuery();
            while (rs.next()) {                
                Student st = new Student();
                st.setId(rs.getString("id"));
                st.setName(rs.getString("name"));
                st.setClassName(rs.getString("class"));
                st.setEmail(rs.getString("email"));
                st.setAddress(rs.getString("address"));
                st.setBirthday(rs.getString("birthday"));
                st.setRoom(rs.getString("room"));
                st.setHavingRoom(rs.getBoolean("havingRoom"));
                st.setGender(rs.getBoolean("gender"));
                st.setChangingRoom(rs.getString("changingRoom"));
                st.setPhoneNumber(rs.getString("phoneNumber"));
                students.add(st);
            }
            return students;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeResources();
        }
        return students;
    }


}
