package commands;

import dao.DAOFactory;
import dao.entitiesDAO.UserDAO;
import entities.User;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUser();
        User user = userDAO.getUser(login, password);

    }
}
