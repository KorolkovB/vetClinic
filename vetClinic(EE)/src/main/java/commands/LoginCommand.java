package commands;

import dao.DAOFactory;
import dao.entitiesDAO.*;
import entities.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        User user = userDAO.getUser(login, password);
        VeterinarianDAO veterinarianDAO = daoFactory.getVeterinarianDAO();

        if (user != null) {
            request.getSession().setAttribute("user", user);
            if (user.isVet()) {
                Veterinarian vet = veterinarianDAO.getVetById(user.getVeterinarianId());
                user.setVeterinarian(vet);
            } else if (user.isClientt() && user.getClientId() != 0) {
                ClientDAO clientDAO = daoFactory.getClientDAO();
                Client client = clientDAO.getClientById(user.getClientId());
                PetDAO petDAO = daoFactory.getPetDAO();
                List<Pet> pets = petDAO.getAllPets(client);
                DiseaseDAO diseaseDAO = daoFactory.getDiseaseDAO();
                for (Pet pet : pets) {
                    pet.setDiseases(diseaseDAO.getAllDiseases(pet));
                }
                client.setPets(pets);
                user.setClient(client);
                KindDAO kindDAO = daoFactory.getKindDAO();
                request.getSession().setAttribute("kinds", kindDAO.getAllKinds());

                List<Veterinarian> veterinarians = veterinarianDAO.getAllVets();
                SpecializationDAO specializationDAO = daoFactory.getSpecializationDAO();
                for (Veterinarian vet :
                        veterinarians) {
                    List<Specialization> specializations = specializationDAO.getAllSpecializations(vet);
                    vet.setSpecializations(specializations);
                }
                request.getSession().setAttribute("vets", veterinarians);

                RoomDAO roomDAO = daoFactory.getRoomDAO();
                request.getSession().setAttribute("rooms",roomDAO.getAllRooms());
                request.getSession().setAttribute("diseases",diseaseDAO.getAllDiseases());
            }
            return "controller?action=main";
        } else {
            request.setAttribute("notFound", "There is no user with such username and password.");
            return "login.jsp";
        }
    }
}
