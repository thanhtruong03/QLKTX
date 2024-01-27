/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author hoang
 */
import java.util.List;

public class ThongKeServiceImpl implements ThongKeService {

    private ThongKeDAO thongKeDAO = null;

    public ThongKeServiceImpl() {
        this.thongKeDAO = new ThongKeDAOImpl();
    }

    @Override
    public List<Student> getListByStudent() {
        return thongKeDAO.getListByStudent();
    }
    
    /*public List<Student> getListByStudentForPie() {
        return thongKeDAO.getListByStudent();
    }*/

}
