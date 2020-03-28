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

    public List<Pet> getAllPets(Client client) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Pet> pets = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Pet/" +
                    "getAllPetsByClient.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setInt(1, client.getId());

            ResultSet rs = statement.executeQuery();

            pets = new ArrayList<>();
            while (rs.next()) {
                Pet pet = new Pet();
                Kind kind = new Kind();

                pet.setId(rs.getInt("petId"));
                pet.setNickname(rs.getString("nickname"));
                pet.setAge(rs.getInt("age"));

                kind.setName(rs.getString("kindName"));
                pet.setKind(kind);
                pets.add(pet);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return pets;
    }

    public void removePet(int petId){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Pet/" +
                    "removePetById.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setInt(1, petId);
            statement.executeUpdate();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
    }

    public void addPet(Pet pet) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Pet/addNewPet.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);

            statement.setInt(1, pet.getKind().getId());
            statement.setString(2, pet.getNickname());
            statement.setInt(3, pet.getAge());
            statement.setInt(4, pet.getClient().getId());
            statement.executeUpdate();

            ResultSet rs = statement.executeQuery("SELECT MAX(id) FROM `pet`");
            rs.next();
            int petId = rs.getInt(1);
            pet.setId(petId);

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
    }
}
