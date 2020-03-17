package commands;

import dao.DAOFactory;
import dao.entitiesDAO.PetDAO;
import entities.Client;
import entities.Pet;
import entities.User;
import entities.Veterinarian;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MainCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        DAOFactory factory = DAOFactory.getInstance();
        //User user = (User) request.getSession().getAttribute("user");
        //
        Client client = new Client();
        client.setId(4);
        User user = new User();
        user.setId(10);
        user.setLogin("Green");
        user.setPassword("Green");
        user.setAdmin(false);
        user.setVet(false);
        user.setClient(client);
        request.getSession().setAttribute("user", user);

        if (user != null) {
            PetDAO petDAO = factory.getPetDAO();
            List<Pet> pets = petDAO.getAllPets(user);
            request.setAttribute("pets", pets);
        }
        return "main.jsp";
    }
}
