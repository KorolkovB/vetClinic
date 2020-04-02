package commands;

import dao.DAOFactory;
import dao.entitiesDAO.VisitDAO;
import entities.User;
import entities.Veterinarian;
import entities.Visit;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OpenVetPanelCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Veterinarian vet = user.getVeterinarian();

        DAOFactory daoFactory = DAOFactory.getInstance();
        VisitDAO visitDAO = daoFactory.getVisitDAO();
        List<Visit> visits = visitDAO.getVisits(vet);
        vet.setVisits(visits);
        user.setVeterinarian(vet);
        request.getSession().setAttribute("user", user);
        return "vetPanel.jsp";
    }
}
