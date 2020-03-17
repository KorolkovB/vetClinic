package dao.entitiesDAO;

import dao.AbstractDAO;
import entities.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractDAO {
    private static UserDAO instance;

    public UserDAO() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public void addUser(User user) {
    Connection connection = null;
    PreparedStatement statement = null;

        try {
            String text = Files.readString(Paths.get("src\\main\\resources\\DML_DAO_Scripts\\User\\addUser.txt"));
            connection = getConnection();
            statement = connection.prepareStatement(text);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, user.isAdmin());
            statement.setBoolean(4, user.isVet());
            statement.setBoolean(5, user.isClient());
            statement.executeUpdate();

            ResultSet rs = statement.executeQuery("SELECT MAX(id) FROM `user`");
            rs.next();
            int userId = rs.getInt(1);
            user.setId(userId);

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection,statement);
        }
    }
}
