package commands;

import dao.DAOFactory;
import dao.entitiesDAO.ClientDAO;
import dao.entitiesDAO.UserDAO;
import dao.entitiesDAO.VeterinarianDAO;
import entities.Client;
import entities.User;
import entities.Veterinarian;

import javax.servlet.http.HttpServletRequest;

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
                request.getSession().setAttribute("client", client);
                page = "controller?action=main";
            } else if (user.isAdmin()){
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
