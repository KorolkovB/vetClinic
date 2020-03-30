package commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();
    private Map<String, Command> commands = new HashMap<>();

    public CommandFactory() {
    }

    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    {
        commands.put("main", new MainCommand());
        commands.put("login", new LoginCommand());
        commands.put("register", new RegisterCommand());
        commands.put("changeClientData", new ChangeClientDataCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("removePet", new RemovePetFromClientCommand());
        commands.put("addNewPet", new AddPetToClientCommand());
        commands.put("viewPetVisits", new ViewPetVisitsCommand());
        commands.put("addVisitToPet", new AddVisitToPetCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        Command command = commands.get(action);
        return command;
    }

}
