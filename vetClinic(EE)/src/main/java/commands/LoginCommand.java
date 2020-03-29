package commands;

import dao.DAOFactory;
import dao.entitiesDAO.*;
import entities.Client;
import entities.Pet;
import entities.User;
import entities.Veterinarian;

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
            } else if (user.isClientt()) {
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
                request.getSession().setAttribute("kinds",kindDAO.getAllKinds());
                request.getSession().setAttribute("vets",veterinarianDAO.getAllVets());
            }
            return "controller?action=main";
        } else {
            request.setAttribute("notFound", "There is no user with such username and password.");
            return "login.jsp";
        }
    }
}
