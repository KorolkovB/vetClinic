package commands;

import dao.DAOFactory;
import dao.entitiesDAO.UserDAO;
import entities.User;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        User user = userDAO.getUser(login);
        if (user == null) {
            user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setClientt(true);
            userDAO.addUser(user);
            request.setAttribute("registrationOk", "Registration was successful. Now you can log in!");
            return "login.jsp";
        } else {
            request.setAttribute("userExist", "A user with the same name already exists.");
            return "register.jsp";
        }
    }
}
