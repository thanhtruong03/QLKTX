/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LUUTHANH
 */
public class DatabaseHelpper {
    public static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLKTX;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println("Chưa có driver!"+e.toString());
        }
        try {
            conn = DriverManager.getConnection(connectionUrl);
            return conn;
        } catch (Exception e) {
            System.out.println("Lỗi connect "+e.toString());
        }
        return null;
    }
}

