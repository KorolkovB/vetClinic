package dao.entitiesDAO;

import dao.AbstractDAO;
import entities.Client;
import entities.Kind;
import entities.Pet;
import entities.Room;
import utilities.PathConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO extends AbstractDAO {
    private static RoomDAO instance;

    public RoomDAO() {
    }

    public static RoomDAO getInstance() {
        if (instance == null) {
            instance = new RoomDAO();
        }
        return instance;
    }

    public List<Room> getAllRooms() {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Room> rooms = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Room/" +
                    "getAllRooms.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            ResultSet rs = statement.executeQuery();

            rooms = new ArrayList<>();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                rooms.add(room);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return rooms;
    }
}
