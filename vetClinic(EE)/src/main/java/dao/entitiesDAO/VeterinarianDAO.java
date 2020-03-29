package dao.entitiesDAO;

import dao.AbstractDAO;
import entities.*;
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

public class VeterinarianDAO extends AbstractDAO {
    private static VeterinarianDAO instance;

    public VeterinarianDAO() {
    }

    public static VeterinarianDAO getInstance() {
        if (instance == null) {
            instance = new VeterinarianDAO();
        }
        return instance;
    }

    public Veterinarian getVetById(int vetId) {
        Veterinarian vet = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Veterinarian/" +
                    "getVetById.sql");
            String text = Files.readString(Paths.get(absolutePath));

            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setInt(1, vetId);

            ResultSet rs = statement.executeQuery();
            rs.next();
            vet = new Veterinarian();

            vet.setId(rs.getInt("id"));
            vet.setFirstName(rs.getString("firstName"));
            vet.setLastName(rs.getString("lastName"));

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return vet;
    }

    public List<Veterinarian> getAllVets() {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Veterinarian> vets = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Veterinarian/" +
                    "getAllWorkingVets.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            ResultSet rs = statement.executeQuery();

            vets = new ArrayList<>();
            while (rs.next()) {
                Veterinarian vet = new Veterinarian();

                vet.setId(rs.getInt("id"));
                vet.setFirstName(rs.getString("firstName"));
                vet.setLastName(rs.getString("lastName"));
                vets.add(vet);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return vets;
    }
}
