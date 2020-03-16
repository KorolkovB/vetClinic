package dao.entitiesDAO;

import dao.AbstractDAO;

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
}
