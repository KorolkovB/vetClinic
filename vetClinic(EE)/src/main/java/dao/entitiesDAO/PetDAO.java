package dao.entitiesDAO;

import dao.AbstractDAO;
import entities.*;
import utilities.PathConverter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO extends AbstractDAO {
    private static PetDAO instance;

    public PetDAO() {
    }

    public static PetDAO getInstance() {
        if (instance == null) {
            instance = new PetDAO();
        }
        return instance;
    }

    public List<Pet> getAllPets(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Pet> pets = null;
        List<Kind> kinds = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Pet/getAllPetsByUser.txt");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setInt(1, user.getId());

            ResultSet rs = statement.executeQuery();

            pets = new ArrayList<>();
            kinds = new ArrayList<>();
            while (rs.next()) {
                Pet pet = new Pet();
                Kind kind = new Kind();

                pet.setId(rs.getInt("petId"));
                pet.setNickname(rs.getString("nickname"));
                pet.setAge(rs.getInt("age"));

                kind.setId(rs.getInt("kindId"));
                kind.setName(rs.getString("kindName"));

                pet.setKind(kind);
                pets.add(pet);
            }
            user.getClient().setPets(pets);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return pets;
    }
}
