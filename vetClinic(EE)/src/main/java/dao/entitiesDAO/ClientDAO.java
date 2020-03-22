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
                    "getClientByUd.txt");
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
            client.setPassportSeries(rs.getInt("passportSerie"));
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


}
