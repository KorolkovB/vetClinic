package commands;

import dao.DAOFactory;
import dao.entitiesDAO.VisitDAO;
import entities.Pet;
import entities.Veterinarian;
import entities.Visit;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ViewPetVisitsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int petId = Integer.parseInt(request.getParameter("petId"));
        String removedVisitId = request.getParameter("removedVisitId");
        String addVisit = request.getParameter("addVisit");

        DAOFactory daoFactory = DAOFactory.getInstance();
        VisitDAO visitDAO = daoFactory.getVisitDAO();

        if (removedVisitId!=null){
            visitDAO.removeVisit(Integer.parseInt(removedVisitId));
        } else if (addVisit!=null){
            Pet pet = new Pet();
            pet.setId(petId);

            Veterinarian vet = new Veterinarian();
            vet.setId(Integer.parseInt(request.getParameter("vetId")));

            Visit visit = new Visit();
            visit.setPet(pet);
            visit.setVet(vet);

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            try {
                visit.setVisitDateTime(formatter.parse(request.getParameter("visitDateTime")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            visitDAO.addVisit(visit);
        }
        List<Visit> visits = visitDAO.getAllVisits(petId);
        request.setAttribute("visits", visits);
        request.setAttribute("petId", petId);
        return "petVisits.jsp";
    }
}
