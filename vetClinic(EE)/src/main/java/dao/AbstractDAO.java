package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO implements InterfaceDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/vetclinic?useUnicode=true&serverTimezone" +
            "=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "ZXuhaha11ha";

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void closeConnectionAndStatement(Connection connection, Statement statement) {
        try {
            if (connection != null && statement != null) {
                connection.close();
                statement.close();
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
}
