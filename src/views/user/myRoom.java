/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.user;

import java.awt.Label;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Room;
import models.RoomDAO;
import models.Student;
import models.StudentDAO;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Handle.PanelRound;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ADMIN
 */
public class myRoom extends javax.swing.JPanel {
    private Student studentRef;
    RoomDAO daoR = new RoomDAO();
    StudentDAO daoS = new StudentDAO();
    Room myR;
    List<Student> listSofR;
        
    public myRoom(Student student) {
        initComponents();
        this.studentRef = student; 
        if(studentRef.isHavingRoom()== true){
            myR = daoR.getRoomByName(studentRef.getRoom());
            System.out.println(myR.getName());
            listSofR = daoS.getStudentsByRoom(myR.getName().toLowerCase());
            loadTable(listSofR);
        }else{
            loadTable(null);
        }
        fillRoom();
        fitContentOfTable(table);
    }

    public void fillRoom(){
        if(studentRef.isHavingRoom()){
            lblName1.setText(myR.getName());
            int size;
            if(myR.getType()){
                size = 12;
                lblSizeRoom.setText("12");
            }else{
                size = 8;
                lblSizeRoom.setText("8");
            }
            int total = listSofR.size();
            int temp = size - total;
            lblMem.setText(""+ temp);
            if(studentRef.getChangingRoom() != null){
                btnChangingRoom.setEnabled(true);
            }
        }else{
            lblName1.setText("Vui lòng đăng kí phòng");
            lblSizeRoom.setText("");
            lblMem.setText("...");
            jLabel9.setText("");
            jLabel7.setText("");
            jLabel10.setText("");
            btnChangingRoom.setEnabled(false);
            btnMove.setEnabled(false);
        }
    }
    private void loadTable(List<Student> list){
        List<Room> lR = daoR.getAll();
        cbRooms.removeAllItems();
        for(Room r : lR){
            if(r.getRoomGender() == studentRef.getGender() && !r.getName().equalsIgnoreCase(studentRef.getRoom())){
                cbRooms.addItem(r.getName());
            }
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 
        
        int stt = 1;
        
        if(list != null){
            for (Student student : list) {
                Object[] rowData = {
                    stt,
                    student.getName(), 
                    student.getId(), 
                    student.getClassName(), 
                    student.getPhoneNumber()
                };

                model.addRow(rowData);
                stt++;
            }
        }else{
            Object[] rowData = {
                "",
                "",
                "Danh sách trống",
                "",
                ""
            };
            model.addRow(rowData);
        }
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
    
    public void fitContentOfTable(JTable table){
        for (int col = 0; col < table.getColumnCount(); col++){
            int maxWid = 0;
            for (int row = 0; row < table.getRowCount(); row++){
                int cellWid = table.prepareRenderer(table.getCellRenderer(row, col), row, col).getPreferredSize().width;
                maxWid = Math.max(maxWid, cellWid);
            }
            table.getColumnModel().getColumn(col).setPreferredWidth(maxWid + 10);
        }
        table.setBackground(Color.white);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        int[] column = {0,1,2,3,4};
        for (int i = 0; i < column.length; i++) {
            table.getColumnModel().getColumn(column[i]).setCellRenderer(centerRenderer);
        }   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        panelRound5 = new Handle.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        panelRound11 = new Handle.PanelRound();
        jPanel4 = new javax.swing.JPanel();
        panelRound1 = new Handle.PanelRound();
        panelRound9 = new Handle.PanelRound();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblMem = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblSizeRoom = new javax.swing.JLabel();
        panelRound12 = new Handle.PanelRound();
        panelRound4 = new Handle.PanelRound();
        cbRooms = new javax.swing.JComboBox<>();
        panelRound7 = new Handle.PanelRound();
        btnChangingRoom = new javax.swing.JLabel();
        panelRound10 = new Handle.PanelRound();
        panelRound2 = new Handle.PanelRound();
        panelRound8 = new Handle.PanelRound();
        panelRound6 = new Handle.PanelRound();
        btnMove = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelRound3 = new Handle.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout(30, 30));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.BorderLayout(0, 30));

        panelRound5.setBackground(new java.awt.Color(35, 45, 63));
        panelRound5.setRoundBottomLeft(20);
        panelRound5.setRoundBottomRight(20);
        panelRound5.setRoundTopLeft(20);
        panelRound5.setRoundTopRight(20);
        panelRound5.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN VỀ PHÒNG CỦA BẠN");
        jLabel1.setPreferredSize(new java.awt.Dimension(315, 35));
        panelRound5.add(jLabel1, "card2");

        jPanel9.add(panelRound5, java.awt.BorderLayout.PAGE_START);

        panelRound11.setBackground(new java.awt.Color(255, 255, 255));
        panelRound11.setLayout(new java.awt.BorderLayout(0, 20));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        panelRound1.setBackground(new java.awt.Color(35, 45, 63));
        panelRound1.setMinimumSize(new java.awt.Dimension(350, 78));
        panelRound1.setPreferredSize(new java.awt.Dimension(450, 70));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);
        panelRound1.setLayout(new java.awt.CardLayout(3, 3));

        panelRound9.setBackground(new java.awt.Color(35, 45, 63));
        panelRound9.setPreferredSize(new java.awt.Dimension(445, 80));
        panelRound9.setRoundBottomLeft(20);
        panelRound9.setRoundBottomRight(20);
        panelRound9.setRoundTopLeft(20);
        panelRound9.setRoundTopRight(20);
        panelRound9.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(35, 45, 63));
        jPanel8.setLayout(new java.awt.BorderLayout(0, 1));

        jPanel1.setBackground(new java.awt.Color(35, 45, 63));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên phòng:");
        jPanel1.add(jLabel5);

        lblName1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName1.setForeground(new java.awt.Color(255, 255, 255));
        lblName1.setText("2A16");
        jPanel1.add(lblName1);

        jPanel8.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(35, 45, 63));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số giường còn lại: ");
        jPanel6.add(jLabel8);

        lblMem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMem.setForeground(new java.awt.Color(255, 255, 255));
        lblMem.setText("3");
        jPanel6.add(lblMem);

        jPanel8.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        panelRound9.add(jPanel8, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(35, 45, 63));
        jPanel2.setLayout(new java.awt.BorderLayout(0, 1));

        jPanel7.setBackground(new java.awt.Color(35, 45, 63));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Thời gian đăng kí:");
        jPanel7.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("6 tháng");
        jPanel7.add(jLabel10);

        jPanel2.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(35, 45, 63));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tổng số giường: ");
        jPanel5.add(jLabel7);

        lblSizeRoom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSizeRoom.setForeground(new java.awt.Color(255, 255, 255));
        lblSizeRoom.setText("10");
        jPanel5.add(lblSizeRoom);

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        panelRound9.add(jPanel2, java.awt.BorderLayout.LINE_END);

        panelRound1.add(panelRound9, "card2");

        jPanel4.add(panelRound1);

        panelRound12.setBackground(new java.awt.Color(35, 45, 63));
        panelRound12.setRoundBottomLeft(20);
        panelRound12.setRoundBottomRight(20);
        panelRound12.setRoundTopLeft(20);
        panelRound12.setRoundTopRight(20);
        panelRound12.setLayout(new java.awt.CardLayout(5, 5));

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(10);
        panelRound4.setRoundBottomRight(10);
        panelRound4.setRoundTopLeft(10);
        panelRound4.setRoundTopRight(10);

        cbRooms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2A32", "2A08", "2E15", "2B32" }));
        cbRooms.setPreferredSize(new java.awt.Dimension(76, 35));
        panelRound4.add(cbRooms);

        panelRound7.setBackground(new java.awt.Color(35, 45, 63));
        panelRound7.setRoundBottomLeft(5);
        panelRound7.setRoundBottomRight(5);
        panelRound7.setRoundTopLeft(5);
        panelRound7.setRoundTopRight(5);

        btnChangingRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChangingRoom.setForeground(new java.awt.Color(255, 255, 255));
        btnChangingRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChangingRoom.setText("Chuyển");
        btnChangingRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChangingRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChangingRoomMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnChangingRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnChangingRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panelRound4.add(panelRound7);

        panelRound12.add(panelRound4, "card2");

        jPanel4.add(panelRound12);

        panelRound10.setBackground(new java.awt.Color(35, 45, 63));
        panelRound10.setRoundBottomLeft(20);
        panelRound10.setRoundBottomRight(20);
        panelRound10.setRoundTopLeft(20);
        panelRound10.setRoundTopRight(20);
        panelRound10.setLayout(new java.awt.CardLayout(5, 5));

        panelRound2.setBackground(new java.awt.Color(35, 45, 63));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new java.awt.CardLayout());

        panelRound8.setBackground(new java.awt.Color(255, 255, 255));
        panelRound8.setRoundBottomLeft(10);
        panelRound8.setRoundBottomRight(10);
        panelRound8.setRoundTopLeft(10);
        panelRound8.setRoundTopRight(10);
        panelRound8.setLayout(new java.awt.CardLayout(5, 5));

        panelRound6.setBackground(new java.awt.Color(35, 45, 63));
        panelRound6.setRoundBottomLeft(10);
        panelRound6.setRoundBottomRight(10);
        panelRound6.setRoundTopLeft(10);
        panelRound6.setRoundTopRight(10);

        btnMove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMove.setForeground(new java.awt.Color(255, 255, 255));
        btnMove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMove.setText("Rời phòng");
        btnMove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMoveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMove, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMove, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panelRound8.add(panelRound6, "card2");

        panelRound2.add(panelRound8, "card2");

        panelRound10.add(panelRound2, "card2");

        jPanel4.add(panelRound10);

        panelRound11.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout(0, 5));

        panelRound3.setBackground(new java.awt.Color(35, 45, 63));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);
        panelRound3.setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THÀNH VIÊN TRONG PHÒNG CỦA BẠN");
        jLabel2.setPreferredSize(new java.awt.Dimension(280, 30));
        panelRound3.add(jLabel2, "card2");

        jPanel3.add(panelRound3, java.awt.BorderLayout.PAGE_START);

        table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Họ tên", "MSSV", "Lớp", "SĐT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAlignmentY(0.0F);
        table.setColumnSelectionAllowed(true);
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setRowHeight(25);
        table.setRowSelectionAllowed(false);
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table.setShowGrid(true);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelRound11.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel9.add(panelRound11, java.awt.BorderLayout.CENTER);

        add(jPanel9, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangingRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangingRoomMouseClicked
        animationClick(panelRound7, "#232d3f");
        String nameRoom = cbRooms.getSelectedItem().toString();
        confirmRoom confirmationDialog = new confirmRoom(null, true, "Bạn có chắc chắn chuyển qua phòng này?");
        confirmationDialog.setVisible(true);

        // Check the result from the dialog
        boolean userConfirmed = confirmationDialog.isConfirmed();

        // Close the dialog
        confirmationDialog.dispose();

        if (userConfirmed) {
            System.out.println(nameRoom);
            studentRef.setChangingRoom(nameRoom);
            daoS.updateStudent(studentRef);
            System.out.println(studentRef.getChangingRoom());
            fillRoom();
            listSofR = daoS.getStudentsByRoom(studentRef.getRoom());
            loadTable(listSofR);
        } else {
            
        }
    }//GEN-LAST:event_btnChangingRoomMouseClicked

    private void btnMoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoveMouseClicked
        animationClick(panelRound6, "#232d3f");
        confirmRoom confirm = new confirmRoom(null, true,"Bạn có chắc chắn muốn rời phòng?");
        confirm.setVisible(true);
        Boolean isConfirm = confirm.isConfirmed();
        confirm.dispose();
        if(isConfirm){
            studentRef.setHavingRoom(false);
            studentRef.setRoom(null);
            daoS.updateStudent(studentRef);
            loadTable(null);
            fillRoom(); 
        }else{
        }
    }//GEN-LAST:event_btnMoveMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChangingRoom;
    private javax.swing.JLabel btnMove;
    private javax.swing.JComboBox<String> cbRooms;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMem;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblSizeRoom;
    private Handle.PanelRound panelRound1;
    private Handle.PanelRound panelRound10;
    private Handle.PanelRound panelRound11;
    private Handle.PanelRound panelRound12;
    private Handle.PanelRound panelRound2;
    private Handle.PanelRound panelRound3;
    private Handle.PanelRound panelRound4;
    private Handle.PanelRound panelRound5;
    private Handle.PanelRound panelRound6;
    private Handle.PanelRound panelRound7;
    private Handle.PanelRound panelRound8;
    private Handle.PanelRound panelRound9;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
