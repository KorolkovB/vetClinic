package dao.entitiesDAO;


import dao.AbstractDAO;

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


}
