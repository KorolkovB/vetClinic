package dao.entitiesDAO;

import dao.AbstractDAO;

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
}
