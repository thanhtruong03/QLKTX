/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.admin;

import Handle.Button.TableActionCellEditor;
import Handle.Button.TableActionCellRender;
import Handle.Button.TableActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import models.Student;
import models.StudentDAO;
import models.UserDAO;
import views.admin.MainAdmin;

/**
 *
 * @author ADMIN
 */
public class ApprovingMoveAndRegister extends javax.swing.JPanel {
    private  List<Student> liRegister;
    private  List<Student> liApprov;
    /**
     * Creates new form approvingMoveAndRegister
     */
    public class CenteredTableCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Đặt căn giữa cho nội dung trong ô
        setHorizontalAlignment(SwingConstants.CENTER);

        return c;
    }
    }
    
    private TableActionEvent createTableActionRegistEvent() {
        return new TableActionEvent() {
            @Override
            public void onAccept(int row) {
                ConfirmAcceptRegisterRoom confirmAcceptRegist = new ConfirmAcceptRegisterRoom();
                confirmAcceptRegist.setSt(liRegister.get(row));
                confirmAcceptRegist.setVisible(true);
                confirmAcceptRegist.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        fillToRegistTable(); // Làm mới bảng sau khi dialog được đóng
                    }
                }); // Làm mới bảng sau khi thực hiện sự kiện
            }

            @Override
            public void onRefuse(int row) {
                ConfirmRefuseRegisterRoom confirmRefuseRegisterRoom = new ConfirmRefuseRegisterRoom();
                confirmRefuseRegisterRoom.setSt(liRegister.get(row));
                confirmRefuseRegisterRoom.setVisible(true);
                confirmRefuseRegisterRoom.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        fillToRegistTable(); // Làm mới bảng sau khi dialog được đóng
                    }
                }); // Làm mới bảng sau khi thực hiện sự kiện
            }
        };
    }
    private TableActionEvent createTableActionMovingEvent() {
        return new TableActionEvent() {
            @Override
            public void onAccept(int row) {
                ConfirmAcceptMovingRoom confirmAcceptMovingRoom = new ConfirmAcceptMovingRoom();
                confirmAcceptMovingRoom.setSt(liApprov.get(row));
                confirmAcceptMovingRoom.setVisible(true);
                confirmAcceptMovingRoom.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        fillToApproving(); // Làm mới bảng sau khi dialog được đóng
                    }
                }); // Làm mới bảng sau khi thực hiện sự kiện
            }

            @Override
            public void onRefuse(int row) {
                ConfirmRefuseMovingRoom confirmRefuseMovingRoom = new ConfirmRefuseMovingRoom();
                confirmRefuseMovingRoom.setSt(liApprov.get(row));
                confirmRefuseMovingRoom.setVisible(true);
                confirmRefuseMovingRoom.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        fillToApproving(); // Làm mới bảng sau khi dialog được đóng
                    }
                }); // Làm mới bảng sau khi thực hiện sự kiện
            }
        };
    }
        
    public void fillToRegistTable(){
        
        liRegister = (new StudentDAO()).getStudentsRegist();
        DefaultTableModel model = (DefaultTableModel) registerTable.getModel();
        model.setRowCount(0);
        int index = 1;
        for(Student sv: liRegister){
             Object[] row = new Object[]{index, sv.getName(), sv.getId(), sv.getPhoneNumber(), sv.getRoom(),null};
            

             model.addRow(row);
             index++;
        }
        registerTable.getColumn("Xử lí").setCellRenderer(new TableActionCellRender());
        registerTable.getColumn("Xử lí").setCellEditor(new TableActionCellEditor(createTableActionRegistEvent()));
        
        
        // Lấy số lượng cột
        int columnCount = registerTable.getColumnCount();

        // Tạo một mảng để lưu trữ tên của các cột
        String[] columns = new String[columnCount];
        CenteredTableCellRenderer centeredRenderer = new CenteredTableCellRenderer();
            for (int i = 0; i < columns.length -1; i++) {
                registerTable.getColumnModel().getColumn(i).setCellRenderer(centeredRenderer);
            }
    }

    public void fillToApproving(){
        liApprov = (new StudentDAO()).getStudentsMoveAnother();
        DefaultTableModel model = (DefaultTableModel) approvingTable.getModel();
        model.setRowCount(0);
        int index = 1;
        for(Student sv: liApprov){
             Object[] row = new Object[]{index, sv.getName(), sv.getId(), sv.getPhoneNumber(), sv.getRoom(),sv.getChangingRoom(), null};
           
             model.addRow(row);
             index++;
        }
        approvingTable.getColumn("Xử lí").setCellRenderer(new TableActionCellRender());
        approvingTable.getColumn("Xử lí").setCellEditor(new TableActionCellEditor(createTableActionMovingEvent()));
        
       
        int columnCount = approvingTable.getColumnCount();

        // Tạo một mảng để lưu trữ tên của các cột
        String[] columns = new String[columnCount];
        CenteredTableCellRenderer centeredRenderer = new CenteredTableCellRenderer();
            for (int i = 0; i < columns.length -1; i++) {
                approvingTable.getColumnModel().getColumn(i).setCellRenderer(centeredRenderer);
            }
    }

    public ApprovingMoveAndRegister() {
        initComponents();
        fillToRegistTable();
        fillToApproving();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        panelRound4 = new Handle.PanelRound();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        registerTable = new javax.swing.JTable();
        panelRound2 = new Handle.PanelRound();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        approvingTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(995, 837));
        setLayout(new java.awt.CardLayout(10, 10));

        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(1006, 50));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 973, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(1006, 50));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 973, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.GridLayout(2, 1, 5, 40));

        panelRound4.setBackground(new java.awt.Color(35, 45, 63));
        panelRound4.setPreferredSize(new java.awt.Dimension(330, 890));
        panelRound4.setRoundBottomLeft(10);
        panelRound4.setRoundBottomRight(10);
        panelRound4.setRoundTopLeft(10);
        panelRound4.setRoundTopRight(10);
        panelRound4.setLayout(new java.awt.CardLayout(5, 5));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(35, 45, 63));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setBackground(new java.awt.Color(35, 45, 63));
        jPanel6.setPreferredSize(new java.awt.Dimension(30, 104));
        jPanel6.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6);

        jPanel2.setBackground(new java.awt.Color(35, 45, 63));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DUYỆT");
        jPanel2.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ĐĂNG KÍ");
        jPanel2.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PHÒNG");
        jPanel2.add(jLabel6);

        jPanel5.add(jPanel2);

        jPanel7.setBackground(new java.awt.Color(35, 45, 63));
        jPanel7.setPreferredSize(new java.awt.Dimension(30, 104));
        jPanel7.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7);

        jPanel4.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jScrollPane2.setBorder(null);

        registerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, ""},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Họ tên", "MSSV", "SĐT", "Phòng đăng kí", "Xử lí"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        registerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registerTable.setGridColor(new java.awt.Color(0, 0, 0));
        registerTable.setRowHeight(32);
        registerTable.setShowGrid(true);
        registerTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(registerTable);
        if (registerTable.getColumnModel().getColumnCount() > 0) {
            registerTable.getColumnModel().getColumn(0).setResizable(false);
            registerTable.getColumnModel().getColumn(1).setResizable(false);
            registerTable.getColumnModel().getColumn(2).setResizable(false);
            registerTable.getColumnModel().getColumn(3).setResizable(false);
            registerTable.getColumnModel().getColumn(4).setResizable(false);
            registerTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelRound4.add(jPanel4, "card2");

        jPanel14.add(panelRound4);

        panelRound2.setBackground(new java.awt.Color(35, 45, 63));
        panelRound2.setPreferredSize(new java.awt.Dimension(330, 890));
        panelRound2.setRoundBottomLeft(10);
        panelRound2.setRoundBottomRight(10);
        panelRound2.setRoundTopLeft(10);
        panelRound2.setRoundTopRight(10);
        panelRound2.setLayout(new java.awt.CardLayout(5, 5));

        jPanel1.setBackground(new java.awt.Color(35, 45, 63));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(35, 45, 63));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setBackground(new java.awt.Color(35, 45, 63));
        jPanel9.setPreferredSize(new java.awt.Dimension(30, 71));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel9);

        jPanel3.setBackground(new java.awt.Color(35, 45, 63));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DUYỆT");
        jPanel3.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CHUYỂN");
        jPanel3.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PHÒNG");
        jPanel3.add(jLabel9);

        jPanel8.add(jPanel3);

        jPanel10.setBackground(new java.awt.Color(35, 45, 63));
        jPanel10.setPreferredSize(new java.awt.Dimension(30, 55));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel10);

        jPanel1.add(jPanel8, java.awt.BorderLayout.LINE_START);

        jScrollPane1.setBorder(null);

        approvingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Họ tên", "MSSV", "SĐT", "Phòng đang ở", "Phòng chuyển đến", "Xử lí"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        approvingTable.setColumnSelectionAllowed(true);
        approvingTable.setGridColor(new java.awt.Color(0, 0, 0));
        approvingTable.setRowHeight(32);
        approvingTable.setShowGrid(true);
        approvingTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(approvingTable);
        approvingTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (approvingTable.getColumnModel().getColumnCount() > 0) {
            approvingTable.getColumnModel().getColumn(0).setResizable(false);
            approvingTable.getColumnModel().getColumn(1).setResizable(false);
            approvingTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            approvingTable.getColumnModel().getColumn(2).setResizable(false);
            approvingTable.getColumnModel().getColumn(3).setResizable(false);
            approvingTable.getColumnModel().getColumn(4).setResizable(false);
            approvingTable.getColumnModel().getColumn(5).setResizable(false);
            approvingTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelRound2.add(jPanel1, "card2");

        jPanel14.add(panelRound2);

        jPanel11.add(jPanel14, java.awt.BorderLayout.CENTER);

        add(jPanel11, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable approvingTable;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Handle.PanelRound panelRound2;
    private Handle.PanelRound panelRound4;
    private javax.swing.JTable registerTable;
    // End of variables declaration//GEN-END:variables
}
