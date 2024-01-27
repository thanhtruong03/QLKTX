/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.admin;

import views.admin.RoomList.roomList;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class MainAdmin extends javax.swing.JFrame {
    roomList roomList = new roomList();
    ApprovingMoveAndRegister approvingPn = new ApprovingMoveAndRegister();
    studentList studentList = new studentList();
    private String username;
    
    public MainAdmin() {
        initComponents();
        menuAdmin1.setHeaderAdmin(this);
        setMinimumSize(new Dimension(600, 600));
        setLocationRelativeTo(null);
        requestFocus();
    }
    public void addRoomListToBody() {
        body.removeAll();
        roomList = new roomList();
        body.add(roomList);
        body.revalidate();
        body.repaint();
    }
    public void addHomeToBody() {
        body.removeAll();
        body.add(pnHome);
        body.revalidate();
        body.repaint();
    }
    public void addApprovingToBody() {
        body.removeAll();
        approvingPn = new ApprovingMoveAndRegister();
        body.add(approvingPn);
        body.revalidate();
        body.repaint();
    }
    
    public void addStudentListToBody() {
        body.removeAll();
        studentList = new studentList();
        body.add(studentList);
        body.revalidate();
        body.repaint();
    }
    
    public void addThongKeToBody(){
        ThongKePanel thongKePanel = new ThongKePanel();
        body.removeAll();
        body.add(thongKePanel);
        body.revalidate();
        body.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        menuAdmin1 = new views.admin.MenuAdmin();
        body = new javax.swing.JPanel();
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
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(600, 400));

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(menuAdmin1, java.awt.BorderLayout.LINE_START);

        body.setBackground(new java.awt.Color(204, 0, 0));
        body.setLayout(new java.awt.BorderLayout());

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

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(4, 1, 5, -20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Thông tin ban quản lí");
        jPanel9.add(jLabel12);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Số điện thoại: (028) 38.295.258 ");
        jPanel9.add(jLabel14);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setText("Số điện thoại: (028) 38.105.510");
        jPanel9.add(jLabel16);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setText("Email: hvbcvthcm@ptithcm.edu.vn");
        jPanel9.add(jLabel18);

        jPanel6.add(jPanel9);

        pnHome.add(jPanel6, "card2");

        body.add(pnHome, java.awt.BorderLayout.CENTER);

        jPanel2.add(body, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private views.admin.MenuAdmin menuAdmin1;
    private Handle.PanelRound pnHome;
    // End of variables declaration//GEN-END:variables
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        
        this.username = username;
    }
}
