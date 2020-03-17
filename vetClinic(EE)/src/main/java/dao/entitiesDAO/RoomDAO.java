package dao.entitiesDAO;

import dao.AbstractDAO;

public class RoomDAO extends AbstractDAO {
    private static RoomDAO instance;

    public RoomDAO() {
    }

    public static RoomDAO getInstance() {
        if (instance == null) {
            instance = new RoomDAO();
        }
        return instance;
    }
}
