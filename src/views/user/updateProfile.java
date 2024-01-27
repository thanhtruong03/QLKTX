/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views.user;
import Handle.PanelRound;
import java.awt.Color;
import models.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class updateProfile extends javax.swing.JDialog {
    private Student student;
    
    
    /**
     * Creates new form updateProfile
     */
    public updateProfile(java.awt.Frame parent, boolean modal, Student std) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        student = std;
        fillToTextFields();
    }
    
    public updateProfile(java.awt.Frame parent, boolean modal) {
    }
    
    public void handleJDateChooser(){
        GregorianCalendar cal = (GregorianCalendar)GregorianCalendar.getInstance();
        // set the min date
        cal.set(1999, 1, 1);
        GregorianCalendar calmax = (GregorianCalendar)GregorianCalendar.getInstance();
        // set the max date
        calmax.set(2005, 12, 18);
        birthdayChooser.setSelectableDateRange( cal.getTime(),calmax.getTime());
        birthdayChooser.setDateFormatString("dd/MM/yyyy");
    }
    
    public Date handleDateTime(){
        SimpleDateFormat simppDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        try {
            birthday = simppDateFormat.parse(student.getBirthday());
        } catch (Exception e) {
        }
        return birthday;
    }
    
    public void fillToTextFields() {
        handleJDateChooser();
        showName.setText(student.getName());
        showID.setText(student.getId());
        showClass.setText(student.getClassName());
        if (student.getGender()){
            maleRadio.setSelected(true);
        } else {
            femaleRadio.setSelected(true);
        }
        showAddress.setText(student.getAddress());
        birthdayChooser.setDate(handleDateTime());
        showEmail.setText(student.getEmail());
        showPhoneNumber.setText(student.getPhoneNumber());
    }
    
    public boolean convertGender(){
        if (maleRadio.isSelected()){
            return true;
        }
        return false;
    }
    
    public void updateProfile(){
       StudentDAO stdDAO = new StudentDAO();
       Student updatedStudent = new Student();
       updatedStudent.setId(showID.getText());
       updatedStudent.setName(showName.getText());
       updatedStudent.setClassName(showClass.getText());
       updatedStudent.setGender(convertGender());
       updatedStudent.setAddress(showAddress.getText());
       updatedStudent.setRoom(student.getRoom());
       Date choseDate = birthdayChooser.getDate();
       String stringOfDate = new SimpleDateFormat("dd/MM/yyyy").format(choseDate);
       updatedStudent.setBirthday(stringOfDate);
       updatedStudent.setEmail(showEmail.getText());
       updatedStudent.setHavingRoom(student.isHavingRoom());
       updatedStudent.setChangingRoom(student.getChangingRoom());
       updatedStudent.setPhoneNumber(showPhoneNumber.getText());
       int res = stdDAO.updateStudent(updatedStudent);
       if (res == 1){
            statusLabel.setText("Cập nhật thành công!");
            statusLabel.setForeground(Color.decode("#219C90"));
       } else {
           statusLabel.setText("Cập nhật thất bại!");
           statusLabel.setForeground(Color.decode("#F05941"));
       }
    }
    
    public static boolean isNumeric(String str) {
    if (str == null)
        return false;
    for (char c : str.toCharArray())
        if (c < '0' || c > '9')
            return false;
    return true;
    }
   
    private boolean existedEmail(List<Student> li, String email){
        String id = showID.getText();
        boolean check = true;
        int count = 0;
        for (int j = 0; j < li.size(); j++){
            if (email.equalsIgnoreCase(li.get(j).getEmail()) && !(li.get(j).getId().equalsIgnoreCase(id))){
                return false;
            }
        }
        System.out.println("Count email: " + count);
        return check;
    }
    
    private boolean existedPhone(List<Student> li, String phone){
        String id = showID.getText();
        boolean check = true;
        int count = 0;
        for (int j = 0; j < li.size(); j++){
            if (phone.equalsIgnoreCase(li.get(j).getPhoneNumber()) && !(li.get(j).getId().equalsIgnoreCase(id))){
                return false;
            }
        }
        System.out.println("Count phone: " + count);
        return check;
    }
    
    public boolean validateFields(){
        if(showName.getText().strip() == "" || showID.getText().strip() == "" 
                || birthdayChooser.getDate() == null ||buttonGroup1.getSelection() == null 
                ||showClass.getText().strip() == "" || showAddress.getText().strip() == "" 
                ||showEmail.getText().strip() == "" || showPhoneNumber.getText().strip() == ""){
            statusLabel.setText("Vui lòng nhập đầy đủ thông tin!");
            statusLabel.setForeground(Color.decode("#F05941"));
            return false;
        }
        if(showName.getText().length() < 5){
            statusLabel.setText("Họ tên phải trên 5 kí tự!");
            statusLabel.setForeground(Color.decode("#F05941"));
            return false;
        }
        if(!(showEmail.getText().strip().contains("@gmail.com"))){
            if (!(showEmail.getText().strip().contains("@student.ptithcm.edu.vn"))){
                {
                statusLabel.setText("Email không hợp lệ!");
                statusLabel.setForeground(Color.decode("#F05941"));
                return false;
                }
            }
        }
        if (showPhoneNumber.getText().length() != 10 || !isNumeric(showPhoneNumber.getText())){
            statusLabel.setText("Số điện thoại không hợp lệ!");
            statusLabel.setForeground(Color.decode("#F05941"));
            return false;
        }
        StudentDAO studentDAO = new StudentDAO();
        List<Student> liStudent = studentDAO.getAll();
        if(!(existedEmail(liStudent, showEmail.getText().strip()))){
            statusLabel.setText("Email đã được sử dụng!");
            statusLabel.setForeground(Color.decode("#F05941"));
            return false;
        }
        if(!(existedPhone(liStudent, showPhoneNumber.getText().strip()))){
            statusLabel.setText("Số điện thoại đã được sử dụng!");
            statusLabel.setForeground(Color.decode("#F05941"));
            return false;
        }
        return true;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        updateProfileButton = new Handle.PanelRound();
        panelRound5 = new Handle.PanelRound();
        okLabel = new javax.swing.JLabel();
        cancelButton = new Handle.PanelRound();
        panelRound8 = new Handle.PanelRound();
        jLabel11 = new javax.swing.JLabel();
        panelRound3 = new Handle.PanelRound();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        showName = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        showID = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        showClass = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        maleRadio = new javax.swing.JRadioButton();
        femaleRadio = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        birthdayChooser = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        showAddress = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        showEmail = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        showPhoneNumber = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(35, 45, 63));
        jPanel1.setLayout(new java.awt.CardLayout(5, 5));

        jPanel5.setBackground(new java.awt.Color(35, 45, 63));
        jPanel5.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CẬP NHẬP THÔNG TIN");
        jPanel5.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(35, 45, 63));

        updateProfileButton.setRoundBottomLeft(20);
        updateProfileButton.setRoundBottomRight(20);
        updateProfileButton.setRoundTopLeft(20);
        updateProfileButton.setRoundTopRight(20);
        updateProfileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateProfileButtonMouseClicked(evt);
            }
        });
        updateProfileButton.setLayout(new java.awt.CardLayout(5, 5));

        panelRound5.setBackground(new java.awt.Color(35, 45, 63));
        panelRound5.setRoundBottomLeft(10);
        panelRound5.setRoundBottomRight(10);
        panelRound5.setRoundTopLeft(10);
        panelRound5.setRoundTopRight(10);

        okLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        okLabel.setForeground(new java.awt.Color(255, 255, 255));
        okLabel.setText("OK");
        okLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelRound5.add(okLabel);

        updateProfileButton.add(panelRound5, "card2");

        cancelButton.setRoundBottomLeft(20);
        cancelButton.setRoundBottomRight(20);
        cancelButton.setRoundTopLeft(20);
        cancelButton.setRoundTopRight(20);
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });
        cancelButton.setLayout(new java.awt.CardLayout(5, 5));

        panelRound8.setBackground(new java.awt.Color(204, 204, 204));
        panelRound8.setRoundBottomLeft(10);
        panelRound8.setRoundBottomRight(10);
        panelRound8.setRoundTopLeft(10);
        panelRound8.setRoundTopRight(10);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Hủy");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelRound8.add(jLabel11);

        cancelButton.add(panelRound8, "card2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(updateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout(20, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Họ tên:");
        jPanel6.add(jLabel2, java.awt.BorderLayout.LINE_START);

        showName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        showName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        showName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        showName.setPreferredSize(new java.awt.Dimension(250, 31));
        jPanel6.add(showName, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.BorderLayout(20, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("MSSV:");
        jPanel7.add(jLabel3, java.awt.BorderLayout.LINE_START);

        showID.setEditable(false);
        showID.setBackground(new java.awt.Color(255, 255, 255));
        showID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        showID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        showID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        showID.setPreferredSize(new java.awt.Dimension(250, 31));
        jPanel7.add(showID, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.BorderLayout(20, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Lớp:");
        jPanel8.add(jLabel4, java.awt.BorderLayout.LINE_START);

        showClass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        showClass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        showClass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        showClass.setPreferredSize(new java.awt.Dimension(250, 31));
        jPanel8.add(showClass, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new java.awt.BorderLayout(5, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Giới tính:");
        jPanel15.add(jLabel6, java.awt.BorderLayout.LINE_START);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        maleRadio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(maleRadio);
        maleRadio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maleRadio.setText("Nam");
        maleRadio.setBorder(null);
        jPanel14.add(maleRadio);

        femaleRadio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(femaleRadio);
        femaleRadio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        femaleRadio.setText("Nữ");
        femaleRadio.setBorder(null);
        jPanel14.add(femaleRadio);

        jPanel15.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new java.awt.BorderLayout(10, 2));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Ngày sinh:");
        jPanel16.add(jLabel10, java.awt.BorderLayout.LINE_START);

        birthdayChooser.setBackground(new java.awt.Color(255, 255, 255));
        birthdayChooser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel16.add(birthdayChooser, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.BorderLayout(20, 5));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Địa chỉ:");
        jPanel10.add(jLabel7, java.awt.BorderLayout.LINE_START);

        showAddress.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        showAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        showAddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        showAddress.setPreferredSize(new java.awt.Dimension(250, 31));
        jPanel10.add(showAddress, java.awt.BorderLayout.CENTER);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.BorderLayout(20, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Email:");
        jPanel12.add(jLabel8, java.awt.BorderLayout.LINE_START);

        showEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        showEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        showEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        showEmail.setPreferredSize(new java.awt.Dimension(250, 31));
        jPanel12.add(showEmail, java.awt.BorderLayout.CENTER);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.BorderLayout(20, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("SĐT:");
        jPanel13.add(jLabel9, java.awt.BorderLayout.LINE_START);

        showPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        showPhoneNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        showPhoneNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        showPhoneNumber.setPreferredSize(new java.awt.Dimension(250, 31));
        jPanel13.add(showPhoneNumber, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("*Trạng thái: ");
        jPanel3.add(jLabel12);

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel3.add(statusLabel);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound3Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound3Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound3Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound3Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound3Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(panelRound3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, "card2");

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateProfileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateProfileButtonMouseClicked
        // TODO add your handling code here:
        animationClick(panelRound5, "#232d3f");
        if(validateFields()){
            updateProfile();
            student.setId(showID.getText());
            student.setName(showName.getText());
            student.setClassName(showClass.getText());
            student.setGender(convertGender());
            student.setAddress(showAddress.getText());
            Date choseDate = birthdayChooser.getDate();
            String stringOfDate = new SimpleDateFormat("dd/MM/yyyy").format(choseDate);
            student.setBirthday(stringOfDate);
            student.setEmail(showEmail.getText());
            student.setPhoneNumber(showPhoneNumber.getText());
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            timer.start();
            okLabel.setEnabled(false);
        }
    }//GEN-LAST:event_updateProfileButtonMouseClicked

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        // TODO add your handling code here:
        animationClick(panelRound8, "#cccccc");
        dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(updateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                updateProfile dialog = new updateProfile(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser birthdayChooser;
    private javax.swing.ButtonGroup buttonGroup1;
    private Handle.PanelRound cancelButton;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JLabel okLabel;
    private Handle.PanelRound panelRound3;
    private Handle.PanelRound panelRound5;
    private Handle.PanelRound panelRound8;
    private javax.swing.JTextField showAddress;
    private javax.swing.JTextField showClass;
    private javax.swing.JTextField showEmail;
    private javax.swing.JTextField showID;
    private javax.swing.JTextField showName;
    private javax.swing.JTextField showPhoneNumber;
    private javax.swing.JLabel statusLabel;
    private Handle.PanelRound updateProfileButton;
    // End of variables declaration//GEN-END:variables
}
