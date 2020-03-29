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

public class VisitDAO extends AbstractDAO {
    private static VisitDAO instance;

    public VisitDAO() {
    }

    public static VisitDAO getInstance() {
        if (instance == null) {
            instance = new VisitDAO();
        }
        return instance;
    }

    public List<Visit> getAllVisits(int petId) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Visit> visits = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Visit/" +
                    "getActiveVisitsByPetId.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setInt(1, petId);

            ResultSet rs = statement.executeQuery();

            visits = new ArrayList<>();
            while (rs.next()) {
                Visit visit = new Visit();
                Veterinarian vet = new Veterinarian();
                Pet pet = new Pet();

                vet.setFirstName(rs.getString("firstName"));
                vet.setLastName(rs.getString("lastName"));

                pet.setId(petId);

                visit.setId(rs.getInt("id"));
                visit.setVisitDateTime(rs.getTimestamp("visitDateTime"));

                visit.setVet(vet);
                visit.setPet(pet);
                visits.add(visit);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return visits;
    }

    public void removeVisit(int visitId){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Visit/" +
                    "removeVisitById.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setInt(1, visitId);
            statement.executeUpdate();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
    }
}
