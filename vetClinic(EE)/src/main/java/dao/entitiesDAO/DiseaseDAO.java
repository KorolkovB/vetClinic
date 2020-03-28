package dao.entitiesDAO;

import dao.AbstractDAO;
import entities.Disease;
import entities.Kind;
import entities.Pet;
import entities.User;
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

public class DiseaseDAO extends AbstractDAO {
    private static DiseaseDAO instance;

    public DiseaseDAO() {
    }

    public static DiseaseDAO getInstance() {
        if (instance == null) {
            instance = new DiseaseDAO();
        }
        return instance;
    }

    public List<Disease> getAllDiseases(Pet pet) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Disease> diseases = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Disease/" +
                    "getAllDiseasesByPet.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setInt(1, pet.getId());

            ResultSet rs = statement.executeQuery();

            diseases = new ArrayList<>();
            while (rs.next()) {
                Disease disease = new Disease();
                disease.setName(rs.getString("name"));
                disease.setActive(rs.getBoolean("isActive"));
                diseases.add(disease);
            }

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return diseases;
    }
}
