package dao.entitiesDAO;

import dao.AbstractDAO;

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

}
