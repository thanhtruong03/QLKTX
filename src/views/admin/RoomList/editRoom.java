/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views.admin.RoomList;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import models.Room;
import models.RoomDAO;

/**
 *
 * @author LUUTHANH
 */
public class editRoom extends javax.swing.JDialog {
    private roomList roomListRef;
    private Room roomR;
    
    public editRoom(java.awt.Frame parent, boolean modal, Room room, roomList roomListRef) {       
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.roomListRef = roomListRef;
        this.roomR = room;
        getContentPane().setBackground(new Color(255, 255, 255, 0));
        if(room.getRoomGender() == false){
            genderComboBox.setSelectedItem("Nữ");
        }else{
            genderComboBox.setSelectedItem("Nam");
        }
        if(room.getType() == false){
            cbType.setSelectedItem("Vip");
        }else{
            cbType.setSelectedItem("Thường");
        }
        txtName.setText(room.getName().toUpperCase());
        cbBlock.setSelectedItem(room.getBlock().toUpperCase());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound5 = new Handle.PanelRound();
        panelRound1 = new Handle.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        panelRound3 = new Handle.PanelRound();
        editBtn = new Handle.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        exitBtn = new Handle.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        panelRound4 = new Handle.PanelRound();
        panelRound2 = new Handle.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbBlock = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(280, 265));
        getContentPane().setLayout(new java.awt.CardLayout());

        panelRound5.setBackground(new java.awt.Color(35, 45, 63));
        panelRound5.setLayout(new java.awt.CardLayout(5, 5));

        panelRound1.setBackground(new java.awt.Color(35, 45, 63));
        panelRound1.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHỈNH SỬA THÔNG TIN PHÒNG");
        panelRound1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        panelRound3.setBackground(new java.awt.Color(35, 45, 63));
        panelRound3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 25, 5));

        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.setForeground(new java.awt.Color(35, 45, 63));
        editBtn.setPreferredSize(new java.awt.Dimension(80, 40));
        editBtn.setRoundBottomLeft(15);
        editBtn.setRoundBottomRight(15);
        editBtn.setRoundTopLeft(15);
        editBtn.setRoundTopRight(15);
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editBtnMouseEntered(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Thêm");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout editBtnLayout = new javax.swing.GroupLayout(editBtn);
        editBtn.setLayout(editBtnLayout);
        editBtnLayout.setHorizontalGroup(
            editBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        editBtnLayout.setVerticalGroup(
            editBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRound3.add(editBtn);

        exitBtn.setBackground(new java.awt.Color(210, 210, 219));
        exitBtn.setForeground(new java.awt.Color(35, 45, 63));
        exitBtn.setPreferredSize(new java.awt.Dimension(80, 40));
        exitBtn.setRoundBottomLeft(15);
        exitBtn.setRoundBottomRight(15);
        exitBtn.setRoundTopLeft(15);
        exitBtn.setRoundTopRight(15);
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Hủy");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRound3.add(exitBtn);

        panelRound1.add(panelRound3, java.awt.BorderLayout.PAGE_END);

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);
        panelRound4.setLayout(new java.awt.CardLayout(10, 10));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(10);
        panelRound2.setRoundBottomRight(10);
        panelRound2.setRoundTopLeft(10);
        panelRound2.setRoundTopRight(10);
        panelRound2.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 65));
        jPanel2.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tên phòng");
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtName.setPreferredSize(new java.awt.Dimension(72, 35));
        jPanel2.add(txtName, java.awt.BorderLayout.CENTER);

        panelRound2.add(jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Phòng dành cho");
        jPanel1.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        genderComboBox.setEnabled(false);
        jPanel1.add(genderComboBox, java.awt.BorderLayout.CENTER);

        panelRound2.add(jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 59));
        jPanel4.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Dãy");
        jPanel4.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        cbBlock.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbBlock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));
        cbBlock.setBorder(null);
        cbBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBlockActionPerformed(evt);
            }
        });
        jPanel4.add(cbBlock, java.awt.BorderLayout.CENTER);

        panelRound2.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(120, 59));
        jPanel5.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Loại phòng");
        jPanel5.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        cbType.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thường", "Vip" }));
        cbType.setBorder(null);
        cbType.setEnabled(false);
        cbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeActionPerformed(evt);
            }
        });
        jPanel5.add(cbType, java.awt.BorderLayout.CENTER);

        panelRound2.add(jPanel5);

        panelRound4.add(panelRound2, "card2");

        panelRound1.add(panelRound4, java.awt.BorderLayout.CENTER);

        panelRound5.add(panelRound1, "card2");

        getContentPane().add(panelRound5, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTypeActionPerformed

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_exitBtnMouseClicked

    private void cbBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBlockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBlockActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Room room = new Room();
        RoomDAO daoR = new RoomDAO();
        room.setName(txtName.getText().toUpperCase());
        room.setBlock(cbBlock.getSelectedItem().toString());
        room.setRoomGender(roomR.getRoomGender()); 
        String msgString;
        String type;
        if(cbType.getSelectedItem().toString().equals("Vip")){
            room.setType(false);
        }else{
            room.setType(true);
        }
        if(room.getName().contains(room.getBlock())){

            if(daoR.update(room, roomR.getName())>0){
                roomListRef.loadingRoom(daoR.getAll());
                this.dispose();
                msgString = "Thành công";
                type = "succes";
                Message msg = new Message(null, true, msgString,type);
                msg.setVisible(true);
            }else{
                this.dispose();
                msgString = "Thất bại";
                type ="err";
                Message msg = new Message(null, true, msgString, type);
                msg.setVisible(true);
            }
        }else{
            this.dispose();
            msgString = "Tên phòng không thuộc dãy";
            type ="err";
            Message msg = new Message(null, true, msgString, type);
            msg.setVisible(true);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
        
    }//GEN-LAST:event_editBtnMouseClicked

    private void editBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseEntered
       
    }//GEN-LAST:event_editBtnMouseEntered

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
            java.util.logging.Logger.getLogger(editRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            editRoom dialog = new editRoom(new javax.swing.JFrame(), true, null, null);
            dialog.setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cbBlock;
    public javax.swing.JComboBox<String> cbType;
    private Handle.PanelRound editBtn;
    private Handle.PanelRound exitBtn;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private Handle.PanelRound panelRound1;
    private Handle.PanelRound panelRound2;
    private Handle.PanelRound panelRound3;
    private Handle.PanelRound panelRound4;
    private Handle.PanelRound panelRound5;
    public javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
