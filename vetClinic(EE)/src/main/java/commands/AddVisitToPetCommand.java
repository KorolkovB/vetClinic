package commands;

import javax.servlet.http.HttpServletRequest;

public class AddVisitToPetCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int petId = Integer.parseInt(request.getParameter("petId"));
        request.setAttribute("petId", petId);
        return "addingVisit.jsp";
    }
}
