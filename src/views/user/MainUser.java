/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.user;

import Handle.PanelRound;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;
import models.Room;
import models.RoomDAO;
import models.Student;
import models.StudentDAO;
import views.Login.Logout;
import views.user.myRoom;

/**
 *
 * @author LUUTHANH
 */
public class MainUser extends javax.swing.JFrame {
    StudentDAO daoS = new StudentDAO();
    RoomDAO daoR = new RoomDAO();
    Student student ;
    myRoom myRoom = null;
    registerRoom registerRoom = null;
      
    public MainUser(Student student) {
        this.student = student;
        myRoom = new myRoom(this.student);
        registerRoom = new registerRoom(this.student);
        initComponents();
        setForm();
        setLocationRelativeTo(null);
    }

    
    private void setForm(){
        String[] splitedName = student.getName().split(" ");
        String name;
        if(splitedName.length > 1){
            name = splitedName[splitedName.length - 2] + " " + splitedName[splitedName.length - 1];
        }else{
            name = splitedName[splitedName.length - 1];
        }
        lblUsername.setText(name);
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

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pnActive4 = new Handle.PanelRound();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnActive2 = new Handle.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pnActive3 = new Handle.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelRound4 = new Handle.PanelRound();
        panelRound3 = new Handle.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        panelRound2 = new Handle.PanelRound();
        lblUsername = new javax.swing.JLabel();
        panelRound1 = new Handle.PanelRound();
        panelRound5 = new Handle.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        profileButton = new javax.swing.JLabel();
        pnContainer = new javax.swing.JPanel();
        pnHome = new Handle.PanelRound();
        jPanel6 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        body.setLayout(new java.awt.BorderLayout());

        pnMenu.setBackground(new java.awt.Color(35, 45, 63));
        pnMenu.setPreferredSize(new java.awt.Dimension(238, 656));

        jPanel3.setBackground(new java.awt.Color(35, 45, 63));
        jPanel3.setPreferredSize(new java.awt.Dimension(238, 656));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tổng quan");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quản lí");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        pnActive4.setBackground(new java.awt.Color(35, 45, 63));
        pnActive4.setPreferredSize(new java.awt.Dimension(151, 48));
        pnActive4.setRoundBottomLeft(15);
        pnActive4.setRoundBottomRight(15);
        pnActive4.setRoundTopLeft(15);
        pnActive4.setRoundTopRight(15);
        pnActive4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnActive4MouseClicked(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/roomIcon.png"))); // NOI18N
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnActive4.add(jLabel17);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Đăng kí phòng");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnActive4.add(jLabel6);

        pnActive2.setBackground(new java.awt.Color(129, 143, 180));
        pnActive2.setPreferredSize(new java.awt.Dimension(151, 48));
        pnActive2.setRoundBottomLeft(15);
        pnActive2.setRoundBottomRight(15);
        pnActive2.setRoundTopLeft(15);
        pnActive2.setRoundTopRight(15);
        pnActive2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnActive2MouseClicked(evt);
            }
        });
        pnActive2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homeIcon_1.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnActive2.add(jLabel1);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Trang chủ");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnActive2.add(jLabel15);

        pnActive3.setBackground(new java.awt.Color(35, 45, 63));
        pnActive3.setPreferredSize(new java.awt.Dimension(151, 48));
        pnActive3.setRoundBottomLeft(15);
        pnActive3.setRoundBottomRight(15);
        pnActive3.setRoundTopLeft(15);
        pnActive3.setRoundTopRight(15);
        pnActive3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnActive3MouseClicked(evt);
            }
        });
        pnActive3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/myRoomIcon.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnActive3.add(jLabel10);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Phòng của tôi");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnActive3.add(jLabel7);

        jPanel1.setBackground(new java.awt.Color(35, 45, 63));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout1);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log_outIcon.png"))); // NOI18N
        jPanel1.add(jLabel4);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Đăng xuất");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel8);

        panelRound4.setBackground(new java.awt.Color(129, 143, 180));
        panelRound4.setPreferredSize(new java.awt.Dimension(180, 80));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);
        panelRound4.setLayout(new java.awt.CardLayout(10, 10));

        panelRound3.setBackground(new java.awt.Color(129, 143, 180));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);
        panelRound3.setLayout(new java.awt.BorderLayout(3, 0));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/userIcon.png"))); // NOI18N
        panelRound3.add(jLabel9, java.awt.BorderLayout.LINE_START);

        panelRound2.setBackground(new java.awt.Color(129, 143, 180));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new java.awt.BorderLayout(0, 3));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("Thanh Trường");
        panelRound2.add(lblUsername, java.awt.BorderLayout.PAGE_START);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setPreferredSize(new java.awt.Dimension(35, 32));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);
        panelRound1.setLayout(new java.awt.BorderLayout());

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));
        panelRound5.setRoundBottomLeft(10);
        panelRound5.setRoundBottomRight(10);
        panelRound5.setRoundTopLeft(10);
        panelRound5.setRoundTopRight(10);
        panelRound5.setLayout(new java.awt.CardLayout(3, 3));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profileIcon (1).png"))); // NOI18N
        panelRound5.add(jLabel2, "card2");

        panelRound1.add(panelRound5, java.awt.BorderLayout.LINE_START);

        profileButton.setBackground(new java.awt.Color(255, 255, 255));
        profileButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileButton.setText("Hồ sơ");
        profileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileButtonMouseClicked(evt);
            }
        });
        panelRound1.add(profileButton, java.awt.BorderLayout.CENTER);

        panelRound2.add(panelRound1, java.awt.BorderLayout.PAGE_END);

        panelRound3.add(panelRound2, java.awt.BorderLayout.CENTER);

        panelRound4.add(panelRound3, "card2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(pnActive2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnActive4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnActive3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnActive2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(25, 25, 25)
                .addComponent(pnActive4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnActive3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        body.add(pnMenu, java.awt.BorderLayout.LINE_START);

        pnContainer.setLayout(new java.awt.BorderLayout());

        pnHome.setBackground(new java.awt.Color(255, 255, 255));
        pnHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnHome.setLayout(new java.awt.CardLayout(20, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PTITTitle (1).png"))); // NOI18N
        jLabel33.setPreferredSize(new java.awt.Dimension(700, 60));
        jPanel6.add(jLabel33);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(3, 1, 0, -30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel25.setText("Học viện Công nghệ Bưu chính Viễn thông được thành lập vào năm 1997 trên cơ sở sắp xếp lại 4 đơn vị thành viên thuộc Tổng Công ty Bưu chính Viễn thông Việt Nam. ");
        jPanel7.add(jLabel25);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel26.setText("Đơn vị tiền thân của Học viện là Trường Đại học Bưu điện – Vô tuyến điện thành lập năm 1953. Với ưu thế về chuyên môn, kinh nghiệm, cơ sở vật chất, Học viện Công");
        jPanel7.add(jLabel26);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel28.setText("nghệ Bưu chính Viễn thông là trường đại học trọng điểm quốc gia trong lĩnh vực ICT,có nhiều thành tựu trong gắn kết giữa Nghiên cứu – Đào tạo – Sản xuất kinh doanh.");
        jPanel7.add(jLabel28);

        jPanel6.add(jPanel7);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(3, 1, 0, -30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel22.setText("Nhằm phục vụ người học, tạo điều kiện tốt nhất trong ăn ở, sinh hoạt và học tập cho sinh viên ở nội trú. Bổ sung cho các hoạt động chính của Trường");
        jPanel5.add(jLabel22);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel23.setText("góp phần thực hiện tốt mục tiêu và nhiệm vụ đào tạo của Nhà trường. Công trình Ký túc xá được xây dựng với thiết kế kiến trúc đẹp, hiện đại,");
        jPanel5.add(jLabel23);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel24.setText(" hài hòa, phù hợp với kiến trúc tổng thể của Học Viện. Bên trong Ký túc xá các hạng mục công trình tiện ích được đưa vào sử dụng như: siêu thị mini, phòng giặt, canteen.");
        jPanel5.add(jLabel24);

        jPanel6.add(jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(3, 1, 0, -30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setText("Địa chỉ:");
        jPanel4.add(jLabel19);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel20.setText("- 11 Nguyễn Đình Chiểu, Phường Đa Kao, Quận 1, TP. Hồ Chí Minh");
        jPanel4.add(jLabel20);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setText("- 97 Man Thiện, P. Hiệp Phú, TP. Thủ Đức, TP. Hồ Chí Minh Đa Kao, Quận 1, TP. Hồ Chí Minh");
        jPanel4.add(jLabel21);

        jPanel6.add(jPanel4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 5, -20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Thông tin ban quản lí");
        jPanel2.add(jLabel12);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Số điện thoại: (028) 38.295.258 ");
        jPanel2.add(jLabel14);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setText("Số điện thoại: (028) 38.105.510");
        jPanel2.add(jLabel16);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setText("Email: hvbcvthcm@ptithcm.edu.vn");
        jPanel2.add(jLabel18);

        jPanel6.add(jPanel2);

        pnHome.add(jPanel6, "card2");

        pnContainer.add(pnHome, java.awt.BorderLayout.CENTER);

        body.add(pnContainer, java.awt.BorderLayout.CENTER);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnActive2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnActive2MouseClicked
        // TODO add your handling code here:
        pnActive2.setBackground(new Color(129,143,180));
        pnActive3.setBackground(new Color(35,45,63));
        pnActive4.setBackground(new Color(35,45,63));
        pnContainer.removeAll();
        pnContainer.add(pnHome);
        pnContainer.revalidate();
        pnContainer.repaint();
    }//GEN-LAST:event_pnActive2MouseClicked

    private void pnActive4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnActive4MouseClicked
        // TODO add your handling code here:
        pnActive4.setBackground(new Color(129,143,180));
        pnActive3.setBackground(new Color(35,45,63));
        pnActive2.setBackground(new Color(35,45,63));
        pnContainer.removeAll();
        Student st = new StudentDAO().getStudentById(student.getId());
        registerRoom = new registerRoom(st);
        pnContainer.add(registerRoom);
        List<Room> lr = daoR.getRoomByGender(this.student.getGender());
        registerRoom.loadingRoom(lr);
        pnContainer.revalidate();
        pnContainer.repaint();
    }//GEN-LAST:event_pnActive4MouseClicked

    private void pnActive3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnActive3MouseClicked
        // TODO add your handling code here:
        pnActive3.setBackground(new Color(129,143,180));
        pnActive2.setBackground(new Color(35,45,63));
        pnActive4.setBackground(new Color(35,45,63));
        pnContainer.removeAll();
        Student st = new StudentDAO().getStudentById(student.getId());
        myRoom = new myRoom(st);        
        pnContainer.add(myRoom);
        pnContainer.revalidate();
        pnContainer.repaint();
    }//GEN-LAST:event_pnActive3MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        Logout logout = new Logout();
        logout.setMainJFrame(this);
        logout.setVisible(true);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void profileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseClicked
        // TODO add your handling code here:
        animationClick(panelRound1, "#ffffff");
        myProfile handleProfile = new myProfile(this, true, this.student);
        handleProfile.setVisible(true);
    }//GEN-LAST:event_profileButtonMouseClicked

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
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUser(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblUsername;
    private Handle.PanelRound panelRound1;
    private Handle.PanelRound panelRound2;
    private Handle.PanelRound panelRound3;
    private Handle.PanelRound panelRound4;
    private Handle.PanelRound panelRound5;
    private Handle.PanelRound pnActive2;
    private Handle.PanelRound pnActive3;
    private Handle.PanelRound pnActive4;
    private javax.swing.JPanel pnContainer;
    private Handle.PanelRound pnHome;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JLabel profileButton;
    // End of variables declaration//GEN-END:variables

}
