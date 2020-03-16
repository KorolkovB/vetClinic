package commands;

import dao.DAOFactory;

import javax.servlet.http.HttpServletRequest;

public class MainCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        DAOFactory factory = DAOFactory.getInstance();
    }
}
