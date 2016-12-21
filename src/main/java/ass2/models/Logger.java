package ass2.models;

import java.util.ArrayList;

public class Logger {
    private ArrayList<String> logcommands = new ArrayList<>();

    public void addLogcommand(String logcommand){
        logcommands.add(logcommand);
    }
    public void removeLogcommand(String logcommand){
        if (logcommands.contains(logcommand)){
            logcommands.remove(logcommand);
        }
    }
}
