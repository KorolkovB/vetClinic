package commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();
    private Map<String, Command> commands = new HashMap<>();

    public CommandFactory() {
    }

    public static CommandFactory commandFactory(){
        if(factory == null){
            factory = new CommandFactory();
        }
        return factory;
    }

    {
        commands.put("main", new MainCommand());
    }

    public Command getCommand(HttpServletRequest request){
        String action = request.getParameter("action");
        Command command = commands.get(action);
        return command;
    }

}
