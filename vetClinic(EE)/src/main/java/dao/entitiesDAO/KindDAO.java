package dao.entitiesDAO;

import dao.AbstractDAO;
import entities.Client;
import entities.Kind;
import entities.Pet;
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

public class KindDAO extends AbstractDAO {
    private static KindDAO instance;

    public KindDAO() {
    }

    public static KindDAO getInstance() {
        if (instance == null) {
            instance = new KindDAO();
        }
        return instance;
    }

    public List<Kind> getAllKinds() {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Kind> kinds = null;
        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Kind/" +
                    "getAllKinds.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            ResultSet rs = statement.executeQuery();
            kinds = new ArrayList<>();
            while (rs.next()) {
                Kind kind = new Kind();
                kind.setName(rs.getString("name"));
                kinds.add(kind);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return kinds;
    }

    public Kind getKindByName(String kindName) {
        Kind kind = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String absolutePath = PathConverter.getAbsolutePathOfResource("DML_DAO_Scripts/Kind/" +
                    "getKindByName.sql");
            String text = Files.readString(Paths.get(absolutePath));
            connection = getConnection();
            statement = connection.prepareStatement(text);
            statement.setString(1, kindName);
            ResultSet rs = statement.executeQuery();
            rs.next();
            kind = new Kind();
            kind.setId(rs.getInt("id"));
            kind.setName(rs.getString("name"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndStatement(connection, statement);
        }
        return kind;
    }
}
