package commands;

import dao.DAOFactory;
import dao.entitiesDAO.KindDAO;
import dao.entitiesDAO.PetDAO;
import entities.Client;
import entities.Kind;
import entities.Pet;
import entities.User;

import javax.servlet.http.HttpServletRequest;

public class AddPetToClientCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Client client = user.getClient();

        DAOFactory daoFactory = DAOFactory.getInstance();
        KindDAO kindDAO = daoFactory.getKindDAO();
        Kind kind = kindDAO.getKindByName(request.getParameter("petKind"));

        Pet pet = new Pet();
        pet.setKind(kind);
        pet.setNickname(request.getParameter("nickName"));
        pet.setAge(Integer.parseInt(request.getParameter("age")));
        pet.setClient(client);
        client.getPets().add(pet);

        PetDAO petDAO = daoFactory.getPetDAO();
        petDAO.addPet(pet);
        return "controller?action=main";
    }
}
