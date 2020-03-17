package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface InterfaceDAO {
    Connection getConnection() throws ClassNotFoundException, SQLException;

    void closeConnectionAndStatement(Connection connection, Statement statement);
}
