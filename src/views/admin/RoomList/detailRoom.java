/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views.admin.RoomList;

import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Room;
import models.Student;
import models.StudentDAO;

/**
 *
 * @author LUUTHANH
 */
public class detailRoom extends javax.swing.JDialog {
    private Room roomRef;
    StudentDAO daoS = new StudentDAO();
    public detailRoom(java.awt.Frame parent, boolean modal,Room room) {
        super(parent, modal);
        this.roomRef = room;
        initComponents();
        setLocationRelativeTo(null);
        init();
        loadTable();
        fitContentOfTable(jTable1);
    }
    private void init(){
        nameLabel.setText(roomRef.getName());
        int total = daoS.getStudentsByRoom(roomRef.getName()).size();
        List<Student> ls = daoS.getStudentsByRoom(roomRef.getName());
        int emtyNumber = 0;
        
        if(roomRef.getType()){
            totalMen.setText("12");
            emtyNumber = 12 - total;
        }else{
            totalMen.setText("8");
            emtyNumber = 8 - total;
        }
        totalBed.setText(Integer.toString(emtyNumber));
        if(roomRef.getRoomGender()){
            lblType.setText("Nam");
        }else{
            lblType.setText("Nữ");
        }
    }
    
    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTable1.setCellSelectionEnabled(false);
        jTable1.setRowSelectionAllowed(false);
        List<Student> students = daoS.getStudentsByRoom(roomRef.getName());

        // Populate the table model with student information
        if(students.size()>0){
            int stt = 1;
            for (Student student : students) {
                String Gender ;
                if(student.getGender()){
                    Gender = "Nam";
                }else{
                    Gender = "Nữ";
                }
                model.addRow(new Object[] {
                    stt++,
                    student.getName(),
                    student.getId(),
                    student.getClassName(),
                    Gender,
                    student.getBirthday(),
                    student.getAddress(),
                    student.getEmail(),
                    student.getPhoneNumber()
                });
            }
        }

        jTable1.setModel(model);
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
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound8 = new Handle.PanelRound();
        panelRound7 = new Handle.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        panelRound6 = new Handle.PanelRound();
        panelRound2 = new Handle.PanelRound();
        panelRound10 = new Handle.PanelRound();
        panelRound9 = new Handle.PanelRound();
        nameLabel = new javax.swing.JLabel();
        panelRound3 = new Handle.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        totalMen = new javax.swing.JLabel();
        panelRound5 = new Handle.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        totalBed = new javax.swing.JLabel();
        panelRound4 = new Handle.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        panelRound11 = new Handle.PanelRound();
        panelRound1 = new Handle.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(810, 400));
        getContentPane().setLayout(new java.awt.CardLayout());

        panelRound8.setBackground(new java.awt.Color(35, 45, 63));
        panelRound8.setLayout(new java.awt.CardLayout(5, 5));

        panelRound7.setBackground(new java.awt.Color(35, 45, 63));
        panelRound7.setLayout(new java.awt.BorderLayout(0, 10));

        jLabel4.setBackground(new java.awt.Color(35, 45, 63));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("THÔNG TIN VỀ PHÒNG");
        panelRound7.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        panelRound6.setBackground(new java.awt.Color(35, 45, 63));
        panelRound6.setLayout(new java.awt.BorderLayout(0, 10));

        panelRound2.setBackground(new java.awt.Color(35, 45, 63));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        panelRound10.setBackground(new java.awt.Color(35, 45, 63));
        panelRound10.setRoundBottomLeft(20);
        panelRound10.setRoundBottomRight(20);
        panelRound10.setRoundTopLeft(20);
        panelRound10.setRoundTopRight(20);

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelRound2.add(panelRound10);

        panelRound9.setBackground(new java.awt.Color(255, 255, 255));
        panelRound9.setMinimumSize(new java.awt.Dimension(800, 51));
        panelRound9.setPreferredSize(new java.awt.Dimension(640, 50));
        panelRound9.setRoundBottomLeft(20);
        panelRound9.setRoundBottomRight(20);
        panelRound9.setRoundTopLeft(20);
        panelRound9.setRoundTopRight(20);

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        nameLabel.setText("2A16");
        panelRound9.add(nameLabel);

        panelRound3.setBackground(new java.awt.Color(35, 45, 63));
        panelRound3.setRoundBottomLeft(10);
        panelRound3.setRoundBottomRight(10);
        panelRound3.setRoundTopLeft(10);
        panelRound3.setRoundTopRight(10);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tổng số giường:");
        panelRound3.add(jLabel2);

        totalMen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalMen.setForeground(new java.awt.Color(255, 255, 255));
        totalMen.setText("10");
        panelRound3.add(totalMen);

        panelRound9.add(panelRound3);

        panelRound5.setBackground(new java.awt.Color(35, 45, 63));
        panelRound5.setRoundBottomLeft(10);
        panelRound5.setRoundBottomRight(10);
        panelRound5.setRoundTopLeft(10);
        panelRound5.setRoundTopRight(10);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Số giường trống: ");
        panelRound5.add(jLabel3);

        totalBed.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalBed.setForeground(new java.awt.Color(255, 255, 255));
        totalBed.setText("3");
        panelRound5.add(totalBed);

        panelRound9.add(panelRound5);

        panelRound4.setBackground(new java.awt.Color(35, 45, 63));
        panelRound4.setRoundBottomLeft(10);
        panelRound4.setRoundBottomRight(10);
        panelRound4.setRoundTopLeft(10);
        panelRound4.setRoundTopRight(10);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phòng dành cho:");
        panelRound4.add(jLabel1);

        lblType.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblType.setForeground(new java.awt.Color(255, 255, 255));
        lblType.setText("Nam");
        panelRound4.add(lblType);

        panelRound9.add(panelRound4);

        panelRound2.add(panelRound9);

        panelRound11.setBackground(new java.awt.Color(35, 45, 63));
        panelRound11.setRoundBottomLeft(20);
        panelRound11.setRoundBottomRight(20);
        panelRound11.setRoundTopLeft(20);
        panelRound11.setRoundTopRight(20);

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelRound2.add(panelRound11);

        panelRound6.add(panelRound2, java.awt.BorderLayout.PAGE_START);

        panelRound1.setBackground(new java.awt.Color(35, 45, 63));
        panelRound1.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DANH SÁCH SINH VIÊN TRONG PHÒNG");
        panelRound1.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ tên", "Mã sinh viên", "Lớp", "Giới tính", "Ngày sinh", "Địa chỉ", "Email", "Sô điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAlignmentX(0.0F);
        jTable1.setAlignmentY(0.0F);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setEnabled(false);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        panelRound1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelRound6.add(panelRound1, java.awt.BorderLayout.CENTER);

        panelRound7.add(panelRound6, java.awt.BorderLayout.CENTER);

        panelRound8.add(panelRound7, "card2");

        getContentPane().add(panelRound8, "card2");

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
            java.util.logging.Logger.getLogger(detailRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detailRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detailRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detailRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                detailRoom dialog = new detailRoom(new javax.swing.JFrame(), true,null);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel nameLabel;
    private Handle.PanelRound panelRound1;
    private Handle.PanelRound panelRound10;
    private Handle.PanelRound panelRound11;
    private Handle.PanelRound panelRound2;
    private Handle.PanelRound panelRound3;
    private Handle.PanelRound panelRound4;
    private Handle.PanelRound panelRound5;
    private Handle.PanelRound panelRound6;
    private Handle.PanelRound panelRound7;
    private Handle.PanelRound panelRound8;
    private Handle.PanelRound panelRound9;
    private javax.swing.JLabel totalBed;
    private javax.swing.JLabel totalMen;
    // End of variables declaration//GEN-END:variables
}
