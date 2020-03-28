package dao.entitiesDAO;


import dao.AbstractDAO;
import entities.Client;
import entities.Veterinarian;
import utilities.PathConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends AbstractDAO {
    private static ClientDAO instance;

    public ClientDAO() {
    }

    public static ClientDAO getInstance() {
        if (instance == null) {
            instance = new ClientDAO();
        }
        return instance;
    }

    public Client getClientById(int clientId) {
        Client client = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Client/" +
                    "getClientById.sql");
            String text = Files.readString(Paths.get(absolutePath));

            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setInt(1, clientId);

            ResultSet rs = statement.executeQuery();
            rs.next();
            client = new Client();

            client.setId(rs.getInt("id"));
            client.setFirstName(rs.getString("firstName"));
            client.setLastName(rs.getString("lastName"));
            client.setPassportSeries(rs.getInt("passportSeries"));
            client.setPassportNumber(rs.getInt("passportNumber"));
            client.setPhoneNumber(rs.getInt("phoneNumber"));
            client.setEmail(rs.getString("email"));

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return client;
    }

    public int updateClient(Client client) {
        int result = 0;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Client/" +
                    "updateClientById.sql");
            String text = Files.readString(Paths.get(absolutePath));

            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setInt(3, client.getPassportSeries());
            statement.setInt(4, client.getPassportNumber());
            statement.setInt(5, client.getPhoneNumber());
            statement.setString(6, client.getEmail());
            statement.setInt(7, client.getId());

            result = statement.executeUpdate();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }

        return result;
    }


}
