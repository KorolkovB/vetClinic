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

public class SpecializationDAO extends AbstractDAO {
    private static SpecializationDAO instance;

    public SpecializationDAO() {
    }

    public static SpecializationDAO getInstance() {
        if (instance == null) {
            instance = new SpecializationDAO();
        }
        return instance;
    }

    public List<Specialization> getAllSpecializations(Veterinarian vet) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Specialization> specializations = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Specialization/" +
                    "getSpecializationOfVet.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setInt(1, vet.getId());
            ResultSet rs = statement.executeQuery();

            specializations = new ArrayList<>();
            while (rs.next()) {
                Specialization specialization = new Specialization();
                specialization.setName(rs.getString("name"));
                specializations.add(specialization);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return specializations;
    }
}
