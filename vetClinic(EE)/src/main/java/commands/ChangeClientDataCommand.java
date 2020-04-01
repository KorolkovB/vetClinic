package commands;

import dao.DAOFactory;
import dao.entitiesDAO.ClientDAO;
import dao.entitiesDAO.UserDAO;
import entities.Client;
import entities.User;

import javax.servlet.http.HttpServletRequest;

public class ChangeClientDataCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int passportSeries = Integer.parseInt(request.getParameter("passportSeries"));
        int passportNumber = Integer.parseInt(request.getParameter("passportNumber"));
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String email = request.getParameter("email");

        Client newClient = new Client();
        newClient.setFirstName(firstName);
        newClient.setLastName(lastName);
        newClient.setPassportSeries(passportSeries);
        newClient.setPassportNumber(passportNumber);
        newClient.setPhoneNumber(phoneNumber);
        newClient.setEmail(email);

        DAOFactory daoFactory = DAOFactory.getInstance();
        ClientDAO clientDAO = daoFactory.getClientDAO();

        User user = (User) request.getSession().getAttribute("user");
        Client currentClient = user.getClient();
        if (currentClient != null) {
            newClient.setId(currentClient.getId());
            int result = clientDAO.updateClient(newClient);
            if (result == 1) {
                user.setClient(newClient);
            }
            request.setAttribute("updated", "Your personal data successfully updated! At the moment, they are as" +
                    " follows:");
        } else {
            int result = clientDAO.addClient(newClient);
            if (result == 1) {
                user.setClient(newClient);
                UserDAO userDAO = daoFactory.getUserDAO();
                userDAO.setClientToUser(user);
            }
            request.setAttribute("added", "Your personal data successfully added! At the moment, they are as" +
                    " follows:");
        }
        return "controller?action=main";
    }
}
