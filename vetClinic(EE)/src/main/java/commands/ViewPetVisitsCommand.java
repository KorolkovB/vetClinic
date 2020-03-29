package commands;

import dao.DAOFactory;
import dao.entitiesDAO.VisitDAO;
import entities.Visit;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewPetVisitsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int petId = Integer.parseInt(request.getParameter("petId"));
        String removedVisitId = request.getParameter("removedVisitId");

        DAOFactory daoFactory = DAOFactory.getInstance();
        VisitDAO visitDAO = daoFactory.getVisitDAO();

        if (removedVisitId!=null){
            visitDAO.removeVisit(Integer.parseInt(removedVisitId));
        }
        List<Visit> visits = visitDAO.getAllVisits(petId);
        request.setAttribute("visits", visits);
        return "petVisits.jsp";
    }
}
