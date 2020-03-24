package commands;

import dao.DAOFactory;
import dao.entitiesDAO.ClientDAO;
import entities.Client;

import javax.servlet.http.HttpServletRequest;

public class ChangeClientDataCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Client currentClient = (Client) request.getSession().getAttribute("client");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int passportSeries = Integer.parseInt(request.getParameter("passportSeries"));
        int passportNumber = Integer.parseInt(request.getParameter("passportNumber"));
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String email = request.getParameter("email");

        Client newClient = new Client();
        newClient.setId(currentClient.getId());
        newClient.setFirstName(firstName);
        newClient.setLastName(lastName);
        newClient.setPassportSeries(passportSeries);
        newClient.setPassportNumber(passportNumber);
        newClient.setPhoneNumber(phoneNumber);
        newClient.setEmail(email);

        DAOFactory daoFactory = DAOFactory.getInstance();
        ClientDAO clientDAO = daoFactory.getClientDAO();
        int result = clientDAO.updateClient(newClient);
        if (result==1) {
            request.getSession().setAttribute("client", newClient);
        }
        request.setAttribute("updated", "Your personal data successfully updated! At the moment, they are as" +
                " follows:");
        return "controller?action=main";
    }
}
