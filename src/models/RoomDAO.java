package models;

import database.DatabaseHelpper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private Connection conn = null;
    private PreparedStatement sttm = null;

    public int add(Room room) {
        try {
            String sSQL = "INSERT INTO room(name, block, type, roomGender) VALUES (?, ?, ?,?)";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, room.getName());
            sttm.setString(2, room.getBlock());
            sttm.setBoolean(3, room.getType());
            sttm.setBoolean(4, room.getRoomGender());

            if (sttm.executeUpdate() > 0) {
                System.out.println("Thêm dữ liệu thành công");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return -1;
    }

    public int update(Room room, String name) {
        try {
            String sSQL = "UPDATE room SET name=?, block=?, type =?, roomGender = ? WHERE name =?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, room.getName());
            sttm.setString(2, room.getBlock());
            sttm.setBoolean(3, room.getType());
            sttm.setBoolean(4, room.getRoomGender());
            sttm.setString(5, name);

            if (sttm.executeUpdate() > 0) {
                System.out.println("Cập nhật dữ liệu thành công");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return -1;
    }

    public int delete(String name) {
        try {
            String sSQL = "DELETE FROM room WHERE name=?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, name);

            if (sttm.executeUpdate() > 0) {
                System.out.println("Xóa dữ liệu thành công");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return -1;
    }
    
    public List<Room> getRoomsName(String name) {
        List<Room> rooms = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM room WHERE name LIKE ?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, "%" + name.toLowerCase() + "%");
            rs = sttm.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setName(rs.getString("name"));
                room.setBlock(rs.getString("block"));
                room.setType(rs.getBoolean("type"));
                room.setRoomGender(rs.getBoolean("roomGender"));
                rooms.add(room);
            }
            return rooms;
        } catch (Exception e) {
            System.out.println("Loi" + e);
        } finally {
            closeResources();
        }
        return rooms;
    }
    
    public Room getRoomByName(String name) {
        ResultSet rs = null;
        Room room = new Room();

        try {
            String sSQL = "SELECT * FROM room WHERE name = ?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, name);

            rs = sttm.executeQuery();

            if (rs.next()) {
                room.setName(rs.getString("name"));
                room.setBlock(rs.getString("block"));
                room.setType(rs.getBoolean("type"));
                room.setRoomGender(rs.getBoolean("roomGender"));
            }
            return room;
        } catch (SQLException e) {
            // Log the exception or rethrow it after wrapping in a more specific exception type
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return room;
    }

    
    public List<Room> getRoomByGender(boolean gender) {
        List<Room> rooms = new ArrayList<>();
        ResultSet rs = null;

        try {
            String sSQL = "SELECT * FROM room WHERE roomGender = ?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setBoolean(1, gender);

            rs = sttm.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setName(rs.getString("name"));
                room.setBlock(rs.getString("block"));
                room.setType(rs.getBoolean("type"));
                room.setRoomGender(rs.getBoolean("roomGender"));
                rooms.add(room);
            }
            return rooms;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return rooms;
    }

    public List<Room> getAll() {
        List<Room> rooms = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM room order by block";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            rs = sttm.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setName(rs.getString("name"));
                room.setBlock(rs.getString("block"));
                room.setType(rs.getBoolean("type"));
                room.setRoomGender(rs.getBoolean("roomGender"));
                rooms.add(room);
            }
            return rooms;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return rooms;
    }

    private void closeResources() {
        try {
            if (sttm != null) {
                sttm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.toString());
        }
    }
    public List<Student> getStudentsByRoom(String name) {
        List<Student> students = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM student WHERE room = ?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, name);
            rs = sttm.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setClassName(rs.getString("class"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                student.setBirthday(rs.getString("birthday"));
                student.setGender(rs.getBoolean("gender"));
                student.setRoom(rs.getString("room"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return students;
    }
    public boolean isRoomExists(String name) {
        try {
            String sSQL = "SELECT COUNT(*) FROM room WHERE name=?";
            conn = DatabaseHelpper.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, name);
            ResultSet rs = sttm.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            closeResources();
        }
        return false;
    }
}
