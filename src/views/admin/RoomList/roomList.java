package views.admin.RoomList;

import Handle.PanelRound;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import views.user.confirmRoom;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import Handle.PanelRound;

public class roomList extends javax.swing.JPanel {
    RoomDAO daoR = new RoomDAO();
    private List<Room> lR = daoR.getAll();
    public roomList() {
        initComponents();  
        loadingRoom(lR);
        JScrollPane scrollPane = new JScrollPane(roomContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        scrollPane.getVerticalScrollBar().setUI(new ThinnerScrollBarUI());
        add(scrollPane);
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
        JLabel deleteRoom = new JLabel();
        JLabel editRoom = new JLabel();
        editRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editRoom dialogRoom = new editRoom(null,true, room, roomList.this);
                dialogRoom.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                editRoom.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editRoom.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });   
        
        deleteRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String msgString;
                String type;
                confirmRoom confirm = new confirmRoom(null, true, "Bạn có chắc chắn muốn xóa phòng này?");
                confirm.setVisible(true);
                Boolean isConfirm = confirm.isConfirmed();
                confirm.dispose();
                if(isConfirm){
                    if (daoR.delete(room.getName()) > 0) {
                            loadingRoom(daoR.getAll());
                            msgString = "Thành công";
                            type = "succes";
                            Message msg = new Message(null, true, msgString, type);
                            msg.setVisible(true);
                        } else {
                            msgString = "Không thể xóa vì có người ở";
                            type = "err";
                            Message msg = new Message(null, true, msgString, type);
                            msg.setVisible(true);
                        }
                }
            }
             
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteRoom.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deleteRoom.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        
        
        iconRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                detailRoom dialogRoom = new detailRoom(null, true, room);
                dialogRoom.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                iconRoom.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                iconRoom.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        deleteRoom.setIcon(new ImageIcon(getClass().getResource("/img/deleteRoomIcon.png")));
        editRoom.setIcon(new ImageIcon(getClass().getResource("/img/editRoomIcon.png")));
        
        GroupLayout panelCLayout = new GroupLayout(panelRoundC);
        panelRoundC.setLayout(panelCLayout);
        panelCLayout.setHorizontalGroup(
            panelCLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelCLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(editRoom)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(deleteRoom)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCLayout.setVerticalGroup(
            panelCLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelCLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelCLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(editRoom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteRoom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        panelRound4 = new Handle.PanelRound();
        panelRound3 = new Handle.PanelRound();
        txtSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JLabel();
        panelRound5 = new Handle.PanelRound();
        addingRoomPanel = new Handle.PanelRound();
        addBtn = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelRound2 = new Handle.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        roomContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));

        panelRound4.setBackground(new java.awt.Color(35, 45, 63));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(40);
        panelRound3.setRoundBottomRight(40);
        panelRound3.setRoundTopLeft(40);
        panelRound3.setRoundTopRight(40);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setBorder(null);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        panelRound4.add(panelRound3);

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/findingIcon.png"))); // NOI18N
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });
        panelRound4.add(searchBtn);

        panelRound5.setBackground(new java.awt.Color(35, 45, 63));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);

        addingRoomPanel.setBackground(new java.awt.Color(255, 255, 255));
        addingRoomPanel.setRoundBottomLeft(40);
        addingRoomPanel.setRoundBottomRight(40);
        addingRoomPanel.setRoundTopLeft(40);
        addingRoomPanel.setRoundTopRight(40);
        addingRoomPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addingRoomPanelMouseClicked(evt);
            }
        });
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 2);
        flowLayout1.setAlignOnBaseline(true);
        addingRoomPanel.setLayout(flowLayout1);

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addingIcon.png"))); // NOI18N
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });
        addingRoomPanel.add(addBtn);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Thêm phòng");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addingRoomPanel.add(jLabel7);

        panelRound5.add(addingRoomPanel);

        panelRound2.setBackground(new java.awt.Color(35, 45, 63));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DANH SÁCH PHÒNG");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        add(header, java.awt.BorderLayout.PAGE_START);

        roomContainer.setBackground(new java.awt.Color(255, 255, 255));
        add(roomContainer, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        createRoom dialog = new createRoom(null, true, this);
        dialog.setVisible(true);
    }//GEN-LAST:event_addBtnMouseClicked

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        List<Room> lRn;
        lRn = daoR.getRoomsName(txtSearch.getText().toLowerCase());
        roomContainer.removeAll();
        roomContainer.revalidate();
        loadingRoom(lRn);
        roomContainer.repaint();
    }//GEN-LAST:event_searchBtnMouseClicked

    private void addingRoomPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addingRoomPanelMouseClicked
        // TODO add your handling code here:
        animationClick(addingRoomPanel, "#ffffff");
        createRoom dialog = new createRoom(null, true, this);
        dialog.setVisible(true);
    }//GEN-LAST:event_addingRoomPanelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBtn;
    private Handle.PanelRound addingRoomPanel;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private Handle.PanelRound panelRound2;
    private Handle.PanelRound panelRound3;
    private Handle.PanelRound panelRound4;
    private Handle.PanelRound panelRound5;
    public javax.swing.JPanel roomContainer;
    private javax.swing.JLabel searchBtn;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
