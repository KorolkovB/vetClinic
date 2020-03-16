package dao;

import dao.entitiesDAO.*;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static synchronized DAOFactory getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }
        return factory;
    }

    public ClientDAO getClientDAO() {
        return ClientDAO.getInstance();
    }

    public DiseaseDAO getDiseaseDAO() {
        return DiseaseDAO.getInstance();
    }

    public KindDAO getKindDAO() {
        return KindDAO.getInstance();
    }

    public PetDAO getPetDAO() {
        return PetDAO.getInstance();
    }

    public RoomDAO getRoomDAO() {
        return RoomDAO.getInstance();
    }

    public SpecializationDAO getSpecializationDAO() {
        return SpecializationDAO.getInstance();
    }

    public VeterinarianDAO getVeterinarianDAO() {
        return VeterinarianDAO.getInstance();
    }

    public VisitDAO getVisitDAO() {
        return VisitDAO.getInstance();
    }
}
