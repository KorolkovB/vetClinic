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
        return "main.jsp";
    }
}
