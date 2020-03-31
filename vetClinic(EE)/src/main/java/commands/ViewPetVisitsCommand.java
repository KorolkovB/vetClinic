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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(request.getParameter("vet"));
            matcher.find();
            vet.setId(Integer.parseInt(matcher.group()));

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
