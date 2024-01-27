/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.admin;
import models.StudentDAO;
import models.Student;
import models.User;
import models.UserDAO;
import models.*;

import Handle.PanelRound;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 *
 * @author ADMIN
 */
public class studentList extends javax.swing.JPanel {
    private ArrayList<Student> list, listOfOrderedStudentsByName;
    private ArrayList<String> listOfRoom, listOfClass;
    private List<Room> roomList;
    DefaultTableModel model;
    private JDialog fileChooserDialog;
    

    /**
     * Creates new form studentList
     */
    public studentList() {
        initComponents();
        list = new StudentDAO().getListStudents();      
        model = (DefaultTableModel) studentsTable.getModel();
        listOfClass = new StudentDAO().getListOfClass();
        showListStudent(list);
        fitContentOfTable(); 
        handleRoomComboBox();
        handleClassComboBox(listOfClass);
    }
  
    public void showListStudent(ArrayList<Student> tmplist) {
        model.setRowCount(0);
        int index = 1;
        for (Student s: tmplist) {
            if (s.isHavingRoom() == true){
                model.addRow(new Object[]{
                    index++,
                    s.getName(),
                    s.getId(),
                    s.getClassName(),
                    s.getEmail(),
                    s.getRoom(),
                    s.getAddress(),
                    s.getBirthday(),
                    s.whichGender(),
                    s.getPhoneNumber()
                });
            }
        }
    }
    
    public void fitContentOfTable(){
        for (int col = 0; col < studentsTable.getColumnCount(); col++){
            int maxWid = 0;
            for (int row = 0; row < studentsTable.getRowCount(); row++){
                int cellWid = studentsTable.prepareRenderer(studentsTable.getCellRenderer(row, col), row, col).getPreferredSize().width;
                maxWid = Math.max(maxWid, cellWid);
            }
            studentsTable.getColumnModel().getColumn(col).setPreferredWidth(maxWid);
        }
        studentsTable.setBackground(Color.white);
        studentsTable.setPreferredScrollableViewportSize(studentsTable.getPreferredSize());
        studentsTable.setFillsViewportHeight(true);
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) studentsTable.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        int[] column = {0,2,3,5,7,8,9};
        for (int i = 0; i < column.length; i++) {
            studentsTable.getColumnModel().getColumn(column[i]).setCellRenderer(centerRenderer);
        }        
    }
    
    public void orderByName() {
        
        Comparator<Student> com = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.onlyName(o1.getName()).compareTo(o2.onlyName(o2.getName()));
            }
        };
        Collections.sort(listOfOrderedStudentsByName, com);
    }
    
    public void orderByID(){
        ArrayList<Student> listOfOrderedStudentsByID = new ArrayList<>();
        listOfOrderedStudentsByID = (ArrayList < Student >) list.clone();
        Comparator<Student> comparatorID = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        Collections.sort(listOfOrderedStudentsByID, comparatorID);
        showListStudent(listOfOrderedStudentsByID);
    }
    
    public void orderByRoom() {
        ArrayList<Student> listOfOrderedStudentsByRoom = new ArrayList<>();
        listOfOrderedStudentsByRoom = (ArrayList<Student>) list.clone();
        Comparator<Student> comparatorRoom = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getRoom().compareTo(o2.getRoom());
            }
        };
        Collections.sort(listOfOrderedStudentsByRoom, comparatorRoom);
        showListStudent(listOfOrderedStudentsByRoom);
    }
    
    public void orderByClass() {
        ArrayList<Student> listOfOrderedStudentByClass = new ArrayList<>();
        listOfOrderedStudentByClass = (ArrayList<Student>) list.clone();
        Comparator<Student> comparatorClass = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getClassName().compareTo(o2.getClassName());
            }
        };
        Collections.sort(listOfOrderedStudentByClass, comparatorClass);
        showListStudent(listOfOrderedStudentByClass);
    }
    
    public void orderedStudentsList() {
        model.setRowCount(0);
        if (filterComboBox.getSelectedItem().equals("Phòng")){
            orderByRoom();
        } else if (filterComboBox.getSelectedItem().equals("Mã lớp")) {
           orderByClass();
        } else if (filterComboBox.getSelectedItem().equals("Mã sinh viên")) {
            orderByID();
        } else if (filterComboBox.getSelectedItem().equals("Tên")) {
            listOfOrderedStudentsByName = new StudentDAO().getListStudents();
            orderByName();
            showListStudent(listOfOrderedStudentsByName);
        } else {
            showListStudent(list);
        }
    }
      
    public ArrayList<Student> getResultSearchingName (String condition) {
        ArrayList<Student> resultList = new ArrayList<>();
        for (Student std : list){
            if (std.getName().toUpperCase().contains(condition.toUpperCase())){
                resultList.add(std);
            }
        }
        return resultList;
    }
    
    public ArrayList<Student> getResultSearchingID(String condition) {
        ArrayList<Student> resultList = new ArrayList<>();
        for (Student std : list){
            if (std.getId().toUpperCase().contains(condition.toUpperCase())){
                resultList.add(std);
            }
        }
        return resultList;
    }
    
    public void exportExcelFile () {
        try {
            XSSFWorkbook excelFile = new XSSFWorkbook();
            XSSFSheet sheet = excelFile.createSheet("DANH SÁCH SINH VIÊN");
            
            XSSFRow row = null;
            Cell cell = null;
            
            row = sheet.createRow(0);
            cell = row.createCell(0,CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue("Họ tên");
            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue("Mã sinh viên");
            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue("Lớp");
            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue("Email");
            cell = row.createCell(5,CellType.STRING);
            cell.setCellValue("Phòng");
            cell = row.createCell(6,CellType.STRING);
            cell.setCellValue("Địa chỉ");
//            cell = row.createCell(7,CellType.STRING);
//            cell.setCellValue("Có phòng ?");
            cell = row.createCell(7,CellType.STRING);
            cell.setCellValue("Ngày sinh");
            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue("Giới tính");
            cell = row.createCell(9,CellType.STRING);
            cell.setCellValue("SĐT");
            
            int i = 1;
            for (Student sv : list){
                row = sheet.createRow(i);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(sv.getName());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(sv.getId());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(sv.getClassName());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(sv.getEmail());
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(sv.getRoom());
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(sv.getAddress());
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(sv.getBirthday());
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(sv.whichGender());
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(sv.getPhoneNumber()); 
                i++;
            }
            
            File file = new File("C:\\Users\\ADMIN\\Downloads\\DSSV.xlsx");
            try {
                FileOutputStream exportedFile = new FileOutputStream(file);
                excelFile.write(exportedFile);
                exportedFile.close();
                successfulExportAndImport showDialog = new successfulExportAndImport(null, true, "Xuất ra file Excel thành công !");
                showDialog.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean whichGender(String gender) {
        if(gender.equalsIgnoreCase("Nam")){
            return true;
        }
        return false;
    }
    
    public boolean havingARoom(String havingRoom) {
        if(havingRoom.equalsIgnoreCase("Có")) {
            return true;
        }
        return false;
    }
    
    public  boolean checkUnavalibleRoom(String room){
        roomList = new RoomDAO().getAll();
        for (int i = 0; i < roomList.size(); i++){
            if (room.equalsIgnoreCase(roomList.get(i).getName())){
                System.out.println(roomList.get(i).getName() + " " + room);
                return true;
            }
        }
        return false;
    }  
    
    
    public void importExcelFile() {
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImport = null;
        String directoryPath = "C:\\Users\\ADMIN\\OneDrive\\Máy tính";
        fileChooserDialog = new JDialog();
        JFileChooser excelFileChooser = new JFileChooser(directoryPath);

        fileChooserDialog.add(excelFileChooser);

        // Set the file chooser dialog to always stay on top
        fileChooserDialog.setAlwaysOnTop(true);

        int excelChooser = excelFileChooser.showOpenDialog(fileChooserDialog);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                File excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImport = new XSSFWorkbook(excelBIS);
                XSSFSheet sheet = excelImport.getSheetAt(0);
                
                for (int i = 0; i < sheet.getLastRowNum(); i++) {
                    XSSFRow row = sheet.getRow(i + 1);
                    
                    XSSFCell name = row.getCell(1);
                    XSSFCell msv = row.getCell(2);
                    XSSFCell password = row.getCell(3);
                    XSSFCell svClass = row.getCell(4);
                    XSSFCell email = row.getCell(5);
                    XSSFCell room = row.getCell(6);
                    XSSFCell address = row.getCell(7);
                    XSSFCell date = row.getCell(8);
                    XSSFCell havingRoom = row.getCell(9);
                    XSSFCell gender = row.getCell(10);
                    XSSFCell numberPhone = row.getCell(11);
                    
                    Student student = new Student();
                    StudentDAO std = new StudentDAO();
                    User user = new User();
                    UserDAO userDAO = new UserDAO();
                    
                    //SET CAC THUOC TINH CHO DOI TUONG SINHV VIEN
                    student.setName(String.valueOf(name));
                    student.setId(String.valueOf(msv));
                    student.setEmail(String.valueOf(email));
                    student.setClassName(String.valueOf(svClass));
                    student.setRoom(String.valueOf(room));
                    student.setAddress(String.valueOf(address));
                    student.setBirthday(String.valueOf(date));
                    student.setHavingRoom(havingARoom(String.valueOf(havingRoom)));
                    student.setGender(whichGender(String.valueOf(gender)));
                    student.setPhoneNumber(String.valueOf(numberPhone));
                    
                    // SET CAC THUOC TINH CHO DOI TUONG USER
                    user.setUsername(String.valueOf(msv));
                    user.setPassword(String.valueOf(password));
                    user.setIsAdmin(false);
                    
                    //KIEM TRA PHONG CUA SV CO HOP LE HAY KHONG
                    if (!(checkUnavalibleRoom(student.getRoom()))){
                        successfulExportAndImport andefineRoom = new successfulExportAndImport(null, true, "Phòng " + student.getRoom() + " không hợp lệ");
                        andefineRoom.setVisible(true);
                        continue;
                    }
                    System.out.println(listOfRoom);
                    //KIEM TRA XEM USER DA TON TAI HAY CHUA
                    User getUser = new UserDAO().getUser(user.getUsername());
                    if (getUser == null){
                        userDAO.createUser(user);
                        list.add(student);
                        std.setStudentIntoDatabase(student);
                    } else {
                        updateStudent udStudent = new updateStudent(null, true, "Trùng mã sinh viên " + String.valueOf(msv));
                        udStudent.setVisible(true);
                        StudentDAO stdDAO = new StudentDAO();
                        if (udStudent.getChoice()){
                            try {
                                userDAO.updateUser(user);
                                stdDAO.updateStudent(student);
                                
                                } catch (Exception e) {
                            }
                        }
                    }
                }
                
                //CẬP NHẬT LẠI DANH SÁCH LỚP
                listOfClass = new StudentDAO().getListOfClass();
                handleClassComboBox(listOfClass);
                System.out.println(listOfClass);
                
                //THÔNG BÁO IMPORT THÀNH CÔNG
                successfulExportAndImport showSucessFullImport = new successfulExportAndImport(null, true, "Nhập từ file Excel thành công !");
                showSucessFullImport.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        list = new StudentDAO().refreshDB();
        showListStudent(list);
    }
    
    public void animationClick (PanelRound panel, String beforeColor) {
        panel.setBackground(new Color(221, 242, 253, 128));
        Timer timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.decode(beforeColor));
                ((Timer) e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    public void handleRoomComboBox() {
        roomList = new RoomDAO().getAll();
        comboBoxRoom.addItem("");
        for (int i = 0; i < roomList.size(); i++){
            comboBoxRoom.addItem(roomList.get(i).getName());
        }
    }
    
    public void handleClassComboBox(ArrayList<String> li){
        comboBoxClass.removeAllItems();
        comboBoxClass.addItem("");
        for (int i = 0; i < li.size(); i++){
            comboBoxClass.addItem(li.get(i));
        }
    }
    
    public ArrayList<Student> getListFilter() {
        ArrayList<Student> resultFilter = new ArrayList<>();
        String  selectedRoom = String.valueOf(comboBoxRoom.getSelectedItem());
        String selectedClass = String.valueOf(comboBoxClass.getSelectedItem());
        for (Student std : list) {
            if (std.isHavingRoom() == true){
                if (selectedRoom.equalsIgnoreCase("")&& !selectedClass.equalsIgnoreCase("")){
                    if (std.getClassName().equalsIgnoreCase(selectedClass)){
                        resultFilter.add(std);
                    }
                } else if (!selectedRoom.equalsIgnoreCase("")&& selectedClass.equalsIgnoreCase("")){
                    if (std.getRoom().equalsIgnoreCase(selectedRoom)){
                        resultFilter.add(std);
                    }
                } else {
                    if (std.getClassName().contains(selectedClass) && std.getRoom().equalsIgnoreCase(selectedRoom)){
                        resultFilter.add(std);
                    }
                }
            }
        }
        return resultFilter;
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollBar1 = new javax.swing.JScrollBar();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        panelRound9 = new Handle.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        arrangePanel = new Handle.PanelRound();
        panelRound5 = new Handle.PanelRound();
        borderArrange = new Handle.PanelRound();
        arrangeButton = new javax.swing.JLabel();
        panelRound8 = new Handle.PanelRound();
        filterComboBox = new javax.swing.JComboBox<>();
        panelRound10 = new Handle.PanelRound();
        panelRound1 = new Handle.PanelRound();
        borderPanel = new Handle.PanelRound();
        filterButton = new javax.swing.JLabel();
        panelRound16 = new Handle.PanelRound();
        panelRound15 = new Handle.PanelRound();
        panelRound6 = new Handle.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        comboBoxClass = new javax.swing.JComboBox<>();
        panelRound14 = new Handle.PanelRound();
        panelRound2 = new Handle.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        comboBoxRoom = new javax.swing.JComboBox<>();
        exportPanel = new Handle.PanelRound();
        exportExcelFile = new Handle.PanelRound();
        roundExportIcon = new Handle.PanelRound();
        exportFile = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRound4 = new Handle.PanelRound();
        importExcelFile = new Handle.PanelRound();
        roundImportIcon = new Handle.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelRound3 = new Handle.PanelRound();
        panelRound7 = new Handle.PanelRound();
        panelRound11 = new Handle.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        titleForShowList = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);
        setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout(10, 20));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout(10, 10));

        panelRound9.setBackground(new java.awt.Color(35, 45, 63));
        panelRound9.setRoundBottomLeft(20);
        panelRound9.setRoundBottomRight(20);
        panelRound9.setRoundTopLeft(20);
        panelRound9.setRoundTopRight(20);
        panelRound9.setLayout(new java.awt.CardLayout(20, 7));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("QUẢN LÍ SINH VIÊN");
        panelRound9.add(jLabel8, "card2");

        jPanel5.add(panelRound9, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        arrangePanel.setBackground(new java.awt.Color(35, 45, 63));
        arrangePanel.setPreferredSize(new java.awt.Dimension(173, 50));
        arrangePanel.setRoundBottomLeft(50);
        arrangePanel.setRoundBottomRight(20);
        arrangePanel.setRoundTopLeft(50);
        arrangePanel.setRoundTopRight(20);
        arrangePanel.setLayout(new java.awt.CardLayout(5, 5));

        panelRound5.setBackground(new java.awt.Color(35, 45, 63));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(20);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(20);
        panelRound5.setLayout(new java.awt.BorderLayout(5, 5));

        borderArrange.setBackground(new java.awt.Color(35, 45, 63));
        borderArrange.setRoundBottomLeft(50);
        borderArrange.setRoundBottomRight(50);
        borderArrange.setRoundTopLeft(50);
        borderArrange.setRoundTopRight(50);
        borderArrange.setLayout(new java.awt.CardLayout(1, 1));

        arrangeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrangeIcon.png"))); // NOI18N
        arrangeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrangeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrangeButtonMouseClicked(evt);
            }
        });
        borderArrange.add(arrangeButton, "card2");

        panelRound5.add(borderArrange, java.awt.BorderLayout.LINE_START);

        panelRound8.setBackground(new java.awt.Color(255, 255, 255));
        panelRound8.setRoundBottomLeft(10);
        panelRound8.setRoundBottomRight(10);
        panelRound8.setRoundTopLeft(10);
        panelRound8.setRoundTopRight(10);
        panelRound8.setLayout(new java.awt.CardLayout(5, 5));

        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Tên", "Phòng", "Mã sinh viên", "Mã lớp" }));
        filterComboBox.setBorder(null);
        filterComboBox.setPreferredSize(new java.awt.Dimension(100, 40));
        panelRound8.add(filterComboBox, "card2");

        panelRound5.add(panelRound8, java.awt.BorderLayout.CENTER);

        arrangePanel.add(panelRound5, "card2");

        jPanel8.add(arrangePanel);

        panelRound10.setBackground(new java.awt.Color(35, 45, 63));
        panelRound10.setPreferredSize(new java.awt.Dimension(360, 50));
        panelRound10.setRoundBottomLeft(50);
        panelRound10.setRoundBottomRight(20);
        panelRound10.setRoundTopLeft(50);
        panelRound10.setRoundTopRight(20);
        panelRound10.setLayout(new java.awt.CardLayout(5, 5));

        panelRound1.setBackground(new java.awt.Color(35, 45, 63));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setLayout(new java.awt.BorderLayout(5, 0));

        borderPanel.setBackground(new java.awt.Color(35, 45, 63));
        borderPanel.setRoundBottomLeft(50);
        borderPanel.setRoundBottomRight(50);
        borderPanel.setRoundTopLeft(50);
        borderPanel.setRoundTopRight(50);
        borderPanel.setLayout(new java.awt.CardLayout(1, 1));

        filterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/filterIcon.png"))); // NOI18N
        filterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterButtonMouseClicked(evt);
            }
        });
        borderPanel.add(filterButton, "card2");

        panelRound1.add(borderPanel, java.awt.BorderLayout.LINE_START);

        panelRound16.setBackground(new java.awt.Color(35, 45, 63));
        panelRound16.setRoundBottomLeft(10);
        panelRound16.setRoundBottomRight(10);
        panelRound16.setRoundTopLeft(10);
        panelRound16.setRoundTopRight(10);
        panelRound16.setLayout(new java.awt.BorderLayout(5, 0));

        panelRound15.setBackground(new java.awt.Color(255, 255, 255));
        panelRound15.setRoundBottomLeft(10);
        panelRound15.setRoundBottomRight(10);
        panelRound15.setRoundTopLeft(10);
        panelRound15.setRoundTopRight(10);
        panelRound15.setLayout(new java.awt.CardLayout(5, 3));

        panelRound6.setBackground(new java.awt.Color(255, 255, 255));
        panelRound6.setMinimumSize(new java.awt.Dimension(92, 36));
        panelRound6.setPreferredSize(new java.awt.Dimension(159, 40));
        panelRound6.setRoundBottomLeft(10);
        panelRound6.setRoundBottomRight(10);
        panelRound6.setRoundTopLeft(10);
        panelRound6.setRoundTopRight(10);
        panelRound6.setLayout(new java.awt.BorderLayout(10, 5));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Lớp");
        panelRound6.add(jLabel7, java.awt.BorderLayout.LINE_START);

        comboBoxClass.setBorder(null);
        comboBoxClass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxClass.setPreferredSize(new java.awt.Dimension(50, 23));
        panelRound6.add(comboBoxClass, java.awt.BorderLayout.CENTER);

        panelRound15.add(panelRound6, "card2");

        panelRound16.add(panelRound15, java.awt.BorderLayout.LINE_START);

        panelRound14.setBackground(new java.awt.Color(255, 255, 255));
        panelRound14.setRoundBottomLeft(10);
        panelRound14.setRoundBottomRight(10);
        panelRound14.setRoundTopLeft(10);
        panelRound14.setRoundTopRight(10);
        panelRound14.setLayout(new java.awt.CardLayout(5, 2));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setPreferredSize(new java.awt.Dimension(140, 40));
        panelRound2.setRoundBottomLeft(10);
        panelRound2.setRoundBottomRight(10);
        panelRound2.setRoundTopLeft(10);
        panelRound2.setRoundTopRight(10);
        panelRound2.setLayout(new java.awt.BorderLayout(10, 5));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Phòng");
        panelRound2.add(jLabel6, java.awt.BorderLayout.LINE_START);

        comboBoxRoom.setBorder(null);
        comboBoxRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxRoom.setPreferredSize(new java.awt.Dimension(70, 23));
        panelRound2.add(comboBoxRoom, java.awt.BorderLayout.CENTER);

        panelRound14.add(panelRound2, "card2");

        panelRound16.add(panelRound14, java.awt.BorderLayout.CENTER);

        panelRound1.add(panelRound16, java.awt.BorderLayout.CENTER);

        panelRound10.add(panelRound1, "card2");

        jPanel8.add(panelRound10);

        exportPanel.setBackground(new java.awt.Color(35, 45, 63));
        exportPanel.setPreferredSize(new java.awt.Dimension(160, 50));
        exportPanel.setRoundBottomLeft(50);
        exportPanel.setRoundBottomRight(50);
        exportPanel.setRoundTopLeft(50);
        exportPanel.setRoundTopRight(50);
        exportPanel.setLayout(new java.awt.CardLayout(5, 5));

        exportExcelFile.setBackground(new java.awt.Color(255, 255, 255));
        exportExcelFile.setEnabled(false);
        exportExcelFile.setRoundBottomLeft(40);
        exportExcelFile.setRoundBottomRight(40);
        exportExcelFile.setRoundTopLeft(40);
        exportExcelFile.setRoundTopRight(40);
        exportExcelFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportExcelFileMouseClicked(evt);
            }
        });
        exportExcelFile.setLayout(new java.awt.BorderLayout());

        roundExportIcon.setBackground(new java.awt.Color(255, 255, 255));
        roundExportIcon.setRoundBottomLeft(40);
        roundExportIcon.setRoundBottomRight(40);
        roundExportIcon.setRoundTopLeft(40);
        roundExportIcon.setRoundTopRight(40);
        roundExportIcon.setLayout(new java.awt.CardLayout(4, 4));

        exportFile.setForeground(new java.awt.Color(255, 255, 255));
        exportFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exportIcon.png"))); // NOI18N
        exportFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roundExportIcon.add(exportFile, "card2");

        exportExcelFile.add(roundExportIcon, java.awt.BorderLayout.LINE_START);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 45, 63));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Xuất file Excel");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportExcelFile.add(jLabel2, java.awt.BorderLayout.CENTER);

        exportPanel.add(exportExcelFile, "card2");

        jPanel8.add(exportPanel);

        panelRound4.setBackground(new java.awt.Color(35, 45, 63));
        panelRound4.setPreferredSize(new java.awt.Dimension(158, 50));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);
        panelRound4.setLayout(new java.awt.CardLayout(5, 5));

        importExcelFile.setBackground(new java.awt.Color(255, 255, 255));
        importExcelFile.setRoundBottomLeft(40);
        importExcelFile.setRoundBottomRight(40);
        importExcelFile.setRoundTopLeft(40);
        importExcelFile.setRoundTopRight(40);
        importExcelFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importExcelFileMouseClicked(evt);
            }
        });
        importExcelFile.setLayout(new java.awt.BorderLayout());

        roundImportIcon.setBackground(new java.awt.Color(255, 255, 255));
        roundImportIcon.setRoundBottomLeft(40);
        roundImportIcon.setRoundBottomRight(40);
        roundImportIcon.setRoundTopLeft(40);
        roundImportIcon.setRoundTopRight(40);
        roundImportIcon.setLayout(new java.awt.CardLayout(5, 4));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/importIcon.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roundImportIcon.add(jLabel1, "card2");

        importExcelFile.add(roundImportIcon, java.awt.BorderLayout.LINE_START);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nhập file Excel");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        importExcelFile.add(jLabel4, java.awt.BorderLayout.CENTER);

        panelRound4.add(importExcelFile, "card2");

        jPanel8.add(panelRound4);

        panelRound3.setBackground(new java.awt.Color(35, 45, 63));
        panelRound3.setPreferredSize(new java.awt.Dimension(258, 50));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);
        panelRound3.setLayout(new java.awt.CardLayout(6, 6));

        panelRound7.setBackground(new java.awt.Color(255, 255, 255));
        panelRound7.setRoundBottomLeft(40);
        panelRound7.setRoundBottomRight(40);
        panelRound7.setRoundTopLeft(40);
        panelRound7.setRoundTopRight(40);
        panelRound7.setLayout(new java.awt.BorderLayout());

        panelRound11.setBackground(new java.awt.Color(255, 255, 255));
        panelRound11.setRoundBottomLeft(40);
        panelRound11.setRoundBottomRight(40);
        panelRound11.setRoundTopLeft(40);
        panelRound11.setRoundTopRight(40);

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        panelRound7.add(panelRound11, java.awt.BorderLayout.LINE_END);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/searchingIcon.png"))); // NOI18N
        panelRound7.add(jLabel3, java.awt.BorderLayout.LINE_START);

        searchTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTextField.setBorder(null);
        searchTextField.setPreferredSize(new java.awt.Dimension(175, 18));
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyTyped(evt);
            }
        });
        panelRound7.add(searchTextField, java.awt.BorderLayout.CENTER);

        panelRound3.add(panelRound7, "card2");

        jPanel8.add(panelRound3);

        jPanel4.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, "card2");

        jPanel3.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.CardLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.CardLayout(10, 10));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jScrollPane1.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        studentsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ho tên", "Mã sinh viên", "Lớp", "Email", "Phòng", "Đia chỉ", "Ngày sinh", "Giới tính", "Số điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentsTable.setAutoscrolls(false);
        studentsTable.setFocusable(false);
        studentsTable.setGridColor(new java.awt.Color(35, 45, 63));
        studentsTable.setRowHeight(25);
        studentsTable.setRowSelectionAllowed(false);
        studentsTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        studentsTable.setShowGrid(true);
        studentsTable.getTableHeader().setResizingAllowed(false);
        studentsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(studentsTable);
        if (studentsTable.getColumnModel().getColumnCount() > 0) {
            studentsTable.getColumnModel().getColumn(0).setResizable(false);
            studentsTable.getColumnModel().getColumn(1).setResizable(false);
            studentsTable.getColumnModel().getColumn(2).setResizable(false);
            studentsTable.getColumnModel().getColumn(3).setResizable(false);
            studentsTable.getColumnModel().getColumn(4).setResizable(false);
            studentsTable.getColumnModel().getColumn(5).setResizable(false);
            studentsTable.getColumnModel().getColumn(6).setResizable(false);
            studentsTable.getColumnModel().getColumn(7).setResizable(false);
            studentsTable.getColumnModel().getColumn(8).setResizable(false);
            studentsTable.getColumnModel().getColumn(9).setResizable(false);
        }

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        titleForShowList.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titleForShowList.setText("DANH SÁCH SINH VIÊN");
        jPanel6.add(titleForShowList, java.awt.BorderLayout.PAGE_START);

        jPanel7.add(jPanel6, "card2");

        jPanel2.add(jPanel7, "card2");

        jPanel3.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
        if (searchTextField.getText().equals("")) {
            showListStudent(list);
        }
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void exportExcelFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportExcelFileMouseClicked
        // TODO add your handling code here:
        animationClick(roundExportIcon, "#ffffff");
        animationClick(exportExcelFile, "#ffffff");
        if (list.isEmpty()){
            successfulExportAndImport emptyList = new successfulExportAndImport(null, true, "Danh sách sinh viên trống!");
            emptyList.setVisible(true);
        } else {
            exportExcelFile();
        }
    }//GEN-LAST:event_exportExcelFileMouseClicked

    private void importExcelFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importExcelFileMouseClicked
        // TODO add your handling code here:
        animationClick(roundImportIcon, "#ffffff");
        animationClick(importExcelFile, "#ffffff");
        importExcelFile();
        showListStudent(list);
    }//GEN-LAST:event_importExcelFileMouseClicked

    private void filterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterButtonMouseClicked
       // TODO add your handling code here:
        animationClick(borderPanel,"#232D3F");
        if (getListFilter().isEmpty()) {
            successfulExportAndImport notFound = new successfulExportAndImport(null, true, "Không tìm thấy kết quả phù hợp!");
            notFound.setVisible(true);
            showListStudent(list);
        } else {
            showListStudent(getListFilter());
        }
    }//GEN-LAST:event_filterButtonMouseClicked

    private void searchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchTextFieldKeyTyped

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        // TODO add your handling code here:
        if (searchTextField.getText().toUpperCase().startsWith("N".toUpperCase()) && searchTextField.getText().toUpperCase().contains("DC".toUpperCase())){
            showListStudent(getResultSearchingID(searchTextField.getText()));
        } else {
            showListStudent(getResultSearchingName(searchTextField.getText()));
        }       
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void arrangeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrangeButtonMouseClicked
        // TODO add your handling code here:
        animationClick(borderArrange, "#232D3F");
        if (list.isEmpty()){
            successfulExportAndImport emptyList = new successfulExportAndImport(null, true, "Danh sách sinh viên trống!");
            emptyList.setVisible(true);
        } else {
            orderedStudentsList();
        }
    }//GEN-LAST:event_arrangeButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arrangeButton;
    private Handle.PanelRound arrangePanel;
    private Handle.PanelRound borderArrange;
    private Handle.PanelRound borderPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboBoxClass;
    private javax.swing.JComboBox<String> comboBoxRoom;
    private Handle.PanelRound exportExcelFile;
    private javax.swing.JLabel exportFile;
    private Handle.PanelRound exportPanel;
    private javax.swing.JLabel filterButton;
    private javax.swing.JComboBox<String> filterComboBox;
    private Handle.PanelRound importExcelFile;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private Handle.PanelRound panelRound1;
    private Handle.PanelRound panelRound10;
    private Handle.PanelRound panelRound11;
    private Handle.PanelRound panelRound14;
    private Handle.PanelRound panelRound15;
    private Handle.PanelRound panelRound16;
    private Handle.PanelRound panelRound2;
    private Handle.PanelRound panelRound3;
    private Handle.PanelRound panelRound4;
    private Handle.PanelRound panelRound5;
    private Handle.PanelRound panelRound6;
    private Handle.PanelRound panelRound7;
    private Handle.PanelRound panelRound8;
    private Handle.PanelRound panelRound9;
    private Handle.PanelRound roundExportIcon;
    private Handle.PanelRound roundImportIcon;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable studentsTable;
    private javax.swing.JLabel titleForShowList;
    // End of variables declaration//GEN-END:variables
}
