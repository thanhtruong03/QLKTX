/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLKTX;

import database.DatabaseHelpper;
import java.sql.Connection;
import java.util.List;
import models.RoomDAO;
import models.Student;
import models.StudentDAO;
import models.User;
import models.UserDAO;

/**
 *
 * @author LUUTHANH
 */
public class testDb {
    public static void main(String[] args) {
        RoomDAO daoS = new RoomDAO();
        List<Student> ls = daoS.getStudentsByRoom("203");
        for( Student student: ls){
            System.out.println(student.getName());
        }
    }
}
