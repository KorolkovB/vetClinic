package commands;

import dao.DAOFactory;
import dao.entitiesDAO.PetDAO;
import entities.Pet;
import entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class RemovePetFromClientCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        int petId = Integer.parseInt(request.getParameter("petId"));
        DAOFactory daoFactory = DAOFactory.getInstance();
        PetDAO petDAO = daoFactory.getPetDAO();
        petDAO.removePet(petId);
        User user = (User) request.getSession().getAttribute("user");
        List<Pet> pets = user.getClient().getPets();
        List<Pet> actualPets = pets.stream().filter((x) -> (x.getId() != petId)).collect(Collectors.toList());
        user.getClient().setPets(actualPets);
        return "controller?action=main";
    }
}
