package dao.entitiesDAO;

import dao.AbstractDAO;

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
}
