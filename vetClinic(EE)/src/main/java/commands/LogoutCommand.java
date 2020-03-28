package commands;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "controller?action=main";
    }
}
