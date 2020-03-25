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
        String page = null;

        if (user != null) {
            request.getSession().setAttribute("user", user);
            if (user.isVet()) {
                VeterinarianDAO veterinarianDAO = daoFactory.getVeterinarianDAO();
                Veterinarian vet = veterinarianDAO.getVetById(user.getVeterinarianId());
                user.setVeterinarian(vet);
                request.getSession().setAttribute("vet", vet);
                page = "controller?action=main";
            } else if (user.isClient()) {
                ClientDAO clientDAO = daoFactory.getClientDAO();
                Client client = clientDAO.getClientById(user.getClientId());
                user.setClient(client);
                request.getSession().setAttribute("client", client);

                PetDAO petDAO = daoFactory.getPetDAO();
                List<Pet> pets = petDAO.getAllPets(user);
                DiseaseDAO diseaseDAO = daoFactory.getDiseaseDAO();
                for (int i = 0; i < pets.size(); i++) {
                    pets.get(i).setDiseases(diseaseDAO.getAllDiseases(pets.get(i)));
                }
                client.setPets(pets);
                page = "controller?action=main";
            } else if (user.isAdmin()) {
                request.getSession().setAttribute("isAdmin", true);
                page = "controller?action=main";
            }
        } else {
            request.setAttribute("notFound", "There is no user with such username and password.");
            page = "login.jsp";
        }
        return page;
    }
}
