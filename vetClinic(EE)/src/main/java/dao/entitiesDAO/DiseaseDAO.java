package dao.entitiesDAO;

import dao.AbstractDAO;

public class DiseaseDAO extends AbstractDAO {
    private static DiseaseDAO instance;

    public DiseaseDAO() {
    }

    public static DiseaseDAO getInstance() {
        if (instance == null) {
            instance = new DiseaseDAO();
        }
        return instance;
    }
}
