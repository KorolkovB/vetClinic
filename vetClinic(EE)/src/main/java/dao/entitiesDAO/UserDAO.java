package dao.entitiesDAO;

import dao.AbstractDAO;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            connection = getConnection();
            statement = connection.prepareStatement("INSERT INTO `vetclinic`.`user`" +
                    " (`login`,`password`,`isAdmin`,`isVet`,`isClient`,`vetId`,`clientId`) VALUES (?,?,?,?,?,?,?)");

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, user.isAdmin());
            statement.setBoolean(4, user.isVet());
            statement.setBoolean(5, user.isClient());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }



    }
}
