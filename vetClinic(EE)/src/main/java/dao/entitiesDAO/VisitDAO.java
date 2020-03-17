package dao.entitiesDAO;

import dao.AbstractDAO;

public class VisitDAO extends AbstractDAO {
    private static VisitDAO instance;

    public VisitDAO() {
    }

    public static VisitDAO getInstance() {
        if (instance == null) {
            instance = new VisitDAO();
        }
        return instance;
    }
}
