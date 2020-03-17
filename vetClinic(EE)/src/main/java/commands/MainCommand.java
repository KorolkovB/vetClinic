package commands;

import dao.DAOFactory;
import dao.entitiesDAO.PetDAO;
import entities.Pet;
import entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MainCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        DAOFactory factory = DAOFactory.getInstance();
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            PetDAO petDAO = factory.getPetDAO();
            List<Pet> pets = petDAO.getAllPets(user);
            request.setAttribute("pets",pets);
        }
        return "main.jsp";
    }
}
