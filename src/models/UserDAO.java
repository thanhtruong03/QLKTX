/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import database.DatabaseHelpper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class UserDAO {
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
    public User getUser(String username){
        ResultSet re = null;
        User user = new User();
        try {
            String ssQL = "SELECT * FROM [User] WHERE username = ?";
            conn = DatabaseHelpper.getConnection();
            sttm= conn.prepareStatement(ssQL);
            sttm.setString(1, username);
            re = sttm.executeQuery();
            while(re.next()){
                user.setUsername(re.getString(1));
                user.setPassword(re.getString(2));
                user.setIsAdmin(re.getBoolean(3));
                return user;
            }
        } catch (Exception e) {
            System.err.println("Error: "+e.toString());
        }finally{
            closeResources();
        }
        return null;
    }
    public int checkLogin(String username, String password){
        User user = getUser(username);
        if(user != null){
            if(user.getPassword().equalsIgnoreCase(password)){
                return 1;
            }else{
                return 2;
            }
        }
        return 0;
    }
    public boolean exitUser(User us){
        ResultSet re = null;
         try {
            String ssQL = "SELECT * FROM [User] WHERE [User].username = ?";
            conn = DatabaseHelpper.getConnection();
            sttm= conn.prepareStatement(ssQL);
            sttm.setString(1, us.getUsername());
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
    public int createUser(User us){
        int re = 0;
        try {
        String ssQL = "INSERT INTO [User] (username, password, isAdmin) VALUES(?,?,?)" ;
        conn = DatabaseHelpper.getConnection();
        sttm= conn.prepareStatement(ssQL);
        sttm.setString(1, us.getUsername());
        sttm.setString(2, us.getPassword());
        sttm.setBoolean(3, us.isIsAdmin());

        re = sttm.executeUpdate();
        if(re > 0){
            System.out.println("Create new User successful");
            return 1;
        }
        }catch (Exception e) {
        System.err.println("Error: "+e.toString());
        }finally{
            closeResources();
        }
        System.out.println("Create new User fail");
        return 0;
    }
    
    public boolean updateUser(User us){
        try {
            String SQL = "UPDATE [USER] SET password = ?, isAdmin = ? WHERE username = ?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(SQL);
            //sttm.setString(1, us.getUsername());
            sttm.setString(1, us.getPassword());
            sttm.setBoolean(2, us.isIsAdmin());
            sttm.setString(3, us.getUsername());
            System.out.println("Cập nhật User thành công !");
            return sttm.executeUpdate() >  0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Student getUserProfile(String id){
        Student st = new Student();
        ResultSet rs = null;
        try {
            String SQL = "SELECT [Student].name, [Student].id, [Student].class, [Student].birthday, [Student].address, [Student].email, [Student].gender, [Student].phoneNumber " +
                        "FROM [Student] JOIN [User] ON Student.id = [USER].username " +
                        "WHERE [USER].username =  " + "'" + id + "'" ;
            
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(SQL);
            rs = sttm.executeQuery();
            while(rs.next()){
                st.setName(rs.getString("name"));
                st.setId(rs.getString("id"));
                st.setClassName(rs.getString("class"));
                st.setBirthday(rs.getString("birthday"));
                st.setAddress(rs.getString("address"));
                st.setEmail(rs.getString("email"));
                st.setGender(rs.getBoolean("gender"));
                st.setPhoneNumber(rs.getString("phoneNumber"));
            }
            
        } catch (Exception e) {
        }
        return st;
    }
}
