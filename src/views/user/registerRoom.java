package views.user;

import Handle.PanelRound;
import java.awt.BorderLayout;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import models.Room;
import models.RoomDAO;
import models.Student;
import views.admin.RoomList.Message;
import views.admin.RoomList.detailRoom;
import views.admin.RoomList.editRoom;
import views.admin.RoomList.roomList;
import views.user.confirmRegisterRoom;

public class registerRoom extends javax.swing.JPanel {
    private Student studentRef; 
    RoomDAO daoR = new RoomDAO();
    private List<Room> lR;
    
    public registerRoom(Student student) {
        initComponents();
        this.studentRef = student;
        this.lR = daoR.getRoomByGender(studentRef.getGender());
        //loadingRoom(lR);
        JScrollPane scrollPane = new JScrollPane(roomContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        scrollPane.getVerticalScrollBar().setUI(new ThinnerScrollBarUI());
        add(scrollPane);
    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
    class ThinnerScrollBarUI extends BasicScrollBarUI {

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createButton();
        }

        private JButton createButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }

        @Override
        protected void configureScrollBarColors() {
            trackColor = Color.LIGHT_GRAY;
            setThumbBounds(0, 0, 0, 0);
            super.configureScrollBarColors();
        }

        @Override
        protected void installDefaults() {
            super.installDefaults();
            scrollBarWidth = 8; // Adjust the scrollbar width as needed
            scrollbar.setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            if (!thumbBounds.isEmpty() && this.scrollbar.isEnabled()) {
                g.setColor(Color.DARK_GRAY);
                g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
            }
        }
    }
    
    public void loadingRoom(List<Room> lR) {
        if(lR != null){
            roomContainer.removeAll();
            roomContainer.setLayout(new BoxLayout(roomContainer, BoxLayout.Y_AXIS));

            JPanel rowPanel = createRowPanel();

            for (Room r : lR) {
                JPanel roomPanel = createRoomPanel(r);
                roomPanel.setBackground(Color.white);
                rowPanel.add(roomPanel);
                if (rowPanel.getComponentCount() % 5 == 0) {
                    roomContainer.add(rowPanel); 
                    rowPanel = createRowPanel(); 
                }
            }
            if (rowPanel.getComponentCount() > 0) {
                roomContainer.add(rowPanel);
            }
            roomContainer.revalidate();
            roomContainer.repaint();
        }
    }
    
    public List<Room> timKiemPhongTheoTen(List<Room> danhSachPhong, String tenPhongCanTim) {
        List<Room> danhSachTimKiem = new ArrayList<>();
        for (Room phong : danhSachPhong) {
            if (phong.getName().equalsIgnoreCase(tenPhongCanTim)) {
                danhSachTimKiem.add(phong);
                return danhSachTimKiem;
            }
            
        }
        successfulRegisterRoom dialogRoom = new successfulRegisterRoom(null, true, "Không Tìm Thấy Phòng Bạn Đã Nhập !", null);
        dialogRoom.setVisible(true);
        return null;
    }
    
    
    
    
    private JPanel createRowPanel() {
    JPanel rowPanel = new JPanel();
    rowPanel.setBackground(Color.white);
    rowPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    return rowPanel;
    }
    private JPanel createRoomPanel(Room room) {
        JPanel roomPanel = new JPanel();
        JLabel iconRoom = new JLabel();
        PanelRound panelRound1 = new PanelRound();
        PanelRound panelRoundC = new PanelRound();
        JLabel nameRoom = new JLabel();
        JLabel DKRoom = new JLabel();
        DKRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                detailRoomAndRegister dialogRoom = new detailRoomAndRegister(null,true, room, studentRef);
                dialogRoom.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                DKRoom.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                DKRoom.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });   
        
        
        
        iconRoom.setIcon(new ImageIcon(getClass().getResource("/img/roomListIcon120x120.png")));
        panelRound1.setBackground(null);
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);
        panelRoundC.setBackground(new Color(35, 45, 63));
        panelRoundC.setRoundBottomLeft(15);
        panelRoundC.setRoundBottomRight(15);
        panelRoundC.setRoundTopLeft(15);
        panelRoundC.setRoundTopRight(15);
        nameRoom.setFont(new Font("Segoe UI", Font.BOLD, 18));
        nameRoom.setForeground(Color.BLACK);
        nameRoom.setText(room.getName().toUpperCase());
        DKRoom.setFont(new Font("Segoe UI", Font.BOLD, 18));
        DKRoom.setForeground(Color.WHITE);
        DKRoom.setText("Đăng ký".toUpperCase());
        
        GroupLayout panelCLayout = new GroupLayout(panelRoundC);
        panelRoundC.setLayout(panelCLayout);
        panelCLayout.setHorizontalGroup(
            panelCLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelCLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DKRoom)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCLayout.setVerticalGroup(
            panelCLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelCLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelCLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(DKRoom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
                    .addContainerGap())
        );
        
        GroupLayout panelRound1Layout = new GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelRound1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(nameRoom)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panelRoundC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelRound1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(nameRoom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(panelRound1Layout.createSequentialGroup()
                    .addComponent(panelRoundC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );

        GroupLayout roomPanelLayout = new GroupLayout(roomPanel);
        roomPanel.setLayout(roomPanelLayout);
        roomPanelLayout.setHorizontalGroup(
            roomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(roomPanelLayout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addGroup(roomPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(iconRoom)
                        .addComponent(panelRound1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        roomPanelLayout.setVerticalGroup(
            roomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(roomPanelLayout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addComponent(iconRoom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panelRound1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );

        return roomPanel;
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
    
    // ... Rest of your existing code


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        roomContainer = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelRound2 = new Handle.PanelRound();
        roundFilterButton = new Handle.PanelRound();
        panelRound6 = new Handle.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelRound5 = new Handle.PanelRound();
        panelRound1 = new Handle.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound3 = new Handle.PanelRound();
        jTextField1 = new javax.swing.JTextField();
        panelRound4 = new Handle.PanelRound();
        panelRound7 = new Handle.PanelRound();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/filterIcon.png"))); // NOI18N

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 230));
        setLayout(new java.awt.BorderLayout(10, 10));

        roomContainer.setBackground(new java.awt.Color(255, 255, 255));
        roomContainer.setForeground(new java.awt.Color(255, 255, 255));
        add(roomContainer, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout(10, 10));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 40, 5));

        panelRound2.setBackground(new java.awt.Color(35, 45, 63));
        panelRound2.setPreferredSize(new java.awt.Dimension(125, 50));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new java.awt.CardLayout(5, 5));

        roundFilterButton.setBackground(new java.awt.Color(255, 255, 255));
        roundFilterButton.setRoundBottomLeft(40);
        roundFilterButton.setRoundBottomRight(40);
        roundFilterButton.setRoundTopLeft(40);
        roundFilterButton.setRoundTopRight(40);
        roundFilterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundFilterButtonMouseClicked(evt);
            }
        });
        roundFilterButton.setLayout(new java.awt.BorderLayout(2, 0));

        panelRound6.setBackground(new java.awt.Color(255, 255, 255));
        panelRound6.setRoundBottomLeft(40);
        panelRound6.setRoundBottomRight(40);
        panelRound6.setRoundTopLeft(40);
        panelRound6.setRoundTopRight(40);
        panelRound6.setLayout(new java.awt.CardLayout(5, 5));

        jLabel5.setBackground(new java.awt.Color(35, 45, 63));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/filterIcon35x35.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        panelRound6.add(jLabel5, "card2");

        roundFilterButton.add(panelRound6, java.awt.BorderLayout.LINE_START);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lọc");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roundFilterButton.add(jLabel3, java.awt.BorderLayout.CENTER);

        panelRound2.add(roundFilterButton, "card2");

        jPanel2.add(panelRound2);

        panelRound5.setBackground(new java.awt.Color(35, 45, 63));
        panelRound5.setPreferredSize(new java.awt.Dimension(250, 50));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);
        panelRound5.setLayout(new java.awt.CardLayout(5, 5));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);
        panelRound1.setLayout(new java.awt.BorderLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/searchingIcon.png"))); // NOI18N
        panelRound1.add(jLabel2, java.awt.BorderLayout.LINE_START);

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setPreferredSize(new java.awt.Dimension(53, 35));
        panelRound3.setRoundBottomLeft(40);
        panelRound3.setRoundBottomRight(40);
        panelRound3.setRoundTopLeft(40);
        panelRound3.setRoundTopRight(40);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelRound1.add(panelRound3, java.awt.BorderLayout.LINE_END);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(null);
        jTextField1.setPreferredSize(new java.awt.Dimension(175, 20));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        panelRound1.add(jTextField1, java.awt.BorderLayout.CENTER);

        panelRound5.add(panelRound1, "card2");

        jPanel2.add(panelRound5);

        jPanel3.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);
        panelRound4.setLayout(new java.awt.CardLayout(10, 5));

        panelRound7.setBackground(new java.awt.Color(35, 45, 63));
        panelRound7.setRoundBottomLeft(20);
        panelRound7.setRoundBottomRight(20);
        panelRound7.setRoundTopLeft(20);
        panelRound7.setRoundTopRight(20);
        panelRound7.setLayout(new java.awt.CardLayout(5, 5));

        jLabel4.setBackground(new java.awt.Color(35, 45, 63));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DANH SÁCH PHÒNG");
        panelRound7.add(jLabel4, "card2");

        panelRound4.add(panelRound7, "card2");

        jPanel3.add(panelRound4, java.awt.BorderLayout.PAGE_END);

        add(jPanel3, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
//        fillRoom filter = new fillRoom(null, true,this.lR ,registerRoom.this);
//        filter.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void roundFilterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundFilterButtonMouseClicked
        // TODO add your handling code here:
        animationClick(roundFilterButton, "#ffffff");
        fillRoom filter = new fillRoom(null, true,this.lR ,registerRoom.this);
        filter.setVisible(true);    
    }//GEN-LAST:event_roundFilterButtonMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        List<Room> lRn;
        lRn = timKiemPhongTheoTen(this.lR, jTextField1.getText());
        loadingRoom(lRn);
        roomContainer.repaint();
    }//GEN-LAST:event_jTextField1ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private Handle.PanelRound panelRound1;
    private Handle.PanelRound panelRound2;
    private Handle.PanelRound panelRound3;
    private Handle.PanelRound panelRound4;
    private Handle.PanelRound panelRound5;
    private Handle.PanelRound panelRound6;
    private Handle.PanelRound panelRound7;
    private javax.swing.JPanel roomContainer;
    private Handle.PanelRound roundFilterButton;
    // End of variables declaration//GEN-END:variables
}
