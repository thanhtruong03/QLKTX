/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views.user;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import models.Room;
import models.RoomDAO;
import views.admin.RoomList.Message;
import views.admin.RoomList.roomList;

/**
 *
 * @author Vu Nguyen
 */
public class fillRoom extends javax.swing.JDialog {
    private registerRoom roomListRef;
    RoomDAO daoR = new RoomDAO();
    private List<Room> dataList;
    /**
     * Creates new form fillRoom
     */
    public fillRoom(java.awt.Frame parent, boolean modal,List<Room> dataList, registerRoom roomListRef) {
        super(parent, modal);
        this.roomListRef = roomListRef;
        this.dataList = dataList;
        //setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        //setBackground(new Color(255, 255, 255, 0));
        
    }
    
    public List<Room> getDataList() {
        

        String dayPhongNhap = "all";
        if (jRadioButton3.isSelected()) {
            dayPhongNhap = "A";
        }
        if (jRadioButton4.isSelected()) {
            dayPhongNhap = "B";
        }
        if (jRadioButton5.isSelected()) {
            dayPhongNhap = "C";
        }
        if (jRadioButton6.isSelected()) {
            dayPhongNhap = "D";
        }
        if (jRadioButton1.isSelected()) {
            dayPhongNhap = "E";
        }

        String loaiPhongNhap = "all";
        if (jRadioButton7.isSelected()) {
            loaiPhongNhap = "vip";
        }
        if (jRadioButton8.isSelected()) {
            loaiPhongNhap = "thuong";
        }
        
        
        List<Room> danhSachDaLoc = new ArrayList<>();

        for (Room room : this.dataList) {
            boolean phongDuocChon = true;


            // Kiểm tra điều kiện loại phòng
            if (!loaiPhongNhap.equals("all") && room.getType() != loaiPhongNhap.equals("thuong")) {
                phongDuocChon = false;
            }

            // Kiểm tra điều kiện dãy phòng
            if (!dayPhongNhap.equals("all") && !room.getBlock().toUpperCase().equals(dayPhongNhap)) {
                phongDuocChon = false;
            }

            // Nếu phòng thỏa mãn các điều kiện, thêm vào danh sách đã lọc
            if (phongDuocChon) {
                danhSachDaLoc.add(room);
            }
        }

        return danhSachDaLoc;
        
        
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        panelRound1 = new Handle.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        panelRound4 = new Handle.PanelRound();
        panelRound5 = new Handle.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        panelRound6 = new Handle.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        panelRound7 = new Handle.PanelRound();
        panelRound2 = new Handle.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(300, 200));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(35, 45, 63));
        jPanel3.setLayout(new java.awt.CardLayout(5, 5));

        panelRound1.setBackground(new java.awt.Color(35, 45, 63));
        panelRound1.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chọn điều kiện cần lọc:");
        panelRound1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        panelRound4.setBackground(new java.awt.Color(35, 45, 63));
        panelRound4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 25, 5));

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));
        panelRound5.setPreferredSize(new java.awt.Dimension(80, 40));
        panelRound5.setRoundBottomLeft(20);
        panelRound5.setRoundBottomRight(20);
        panelRound5.setRoundTopLeft(20);
        panelRound5.setRoundTopRight(20);
        panelRound5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound5MouseClicked(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("LỌC");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRound4.add(panelRound5);

        panelRound6.setBackground(new java.awt.Color(204, 204, 204));
        panelRound6.setPreferredSize(new java.awt.Dimension(80, 40));
        panelRound6.setRoundBottomLeft(20);
        panelRound6.setRoundBottomRight(20);
        panelRound6.setRoundTopLeft(20);
        panelRound6.setRoundTopRight(20);
        panelRound6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound6MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("HỦY");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRound4.add(panelRound6);

        panelRound1.add(panelRound4, java.awt.BorderLayout.PAGE_END);

        panelRound7.setBackground(new java.awt.Color(255, 255, 255));
        panelRound7.setRoundBottomLeft(20);
        panelRound7.setRoundBottomRight(20);
        panelRound7.setRoundTopLeft(20);
        panelRound7.setRoundTopRight(20);
        panelRound7.setLayout(new java.awt.CardLayout(5, 5));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(10);
        panelRound2.setRoundBottomRight(10);
        panelRound2.setRoundTopLeft(10);
        panelRound2.setRoundTopRight(10);
        panelRound2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Loại Phòng: ");
        jPanel2.add(jLabel5);

        jRadioButton7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton7.setText("VIP");
        jRadioButton7.setBorder(null);
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton7);

        jRadioButton8.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton8.setText("Thường");
        jRadioButton8.setBorder(null);
        jPanel2.add(jRadioButton8);

        panelRound2.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Dãy Phòng: ");
        jPanel1.add(jLabel4);

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton3.setText("A");
        jRadioButton3.setBorder(null);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3);

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton4.setText("B");
        jRadioButton4.setBorder(null);
        jPanel1.add(jRadioButton4);

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton5.setText("C");
        jRadioButton5.setBorder(null);
        jPanel1.add(jRadioButton5);

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton6.setText("D");
        jRadioButton6.setBorder(null);
        jPanel1.add(jRadioButton6);

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setText("E");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1);

        panelRound2.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        panelRound7.add(panelRound2, "card2");

        panelRound1.add(panelRound7, java.awt.BorderLayout.CENTER);

        jPanel3.add(panelRound1, "card2");

        getContentPane().add(jPanel3, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelRound6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound6MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_panelRound6MouseClicked

    private void panelRound5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound5MouseClicked
        // TODO add your handling code here:
        List<Room> rooms = getDataList();
        roomListRef.loadingRoom(rooms);
        this.dispose();
    }//GEN-LAST:event_panelRound5MouseClicked

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(fillRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(fillRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(fillRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(fillRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                fillRoom dialog = new fillRoom(new javax.swing.JFrame(), true, null);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private Handle.PanelRound panelRound1;
    private Handle.PanelRound panelRound2;
    private Handle.PanelRound panelRound4;
    private Handle.PanelRound panelRound5;
    private Handle.PanelRound panelRound6;
    private Handle.PanelRound panelRound7;
    // End of variables declaration//GEN-END:variables
}