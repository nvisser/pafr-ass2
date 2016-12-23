package ass2.models;

import java.util.ArrayList;

public class Logger {
    private ArrayList<String> logcommands = new ArrayList<>();

    public void addLogcommand(String logcommand){
        logcommands.add(logcommand);
        Trainstation.getInstance().getLoggerDisplay().update();
    }
    public void removeLogcommand(String logcommand){
        if (logcommands.contains(logcommand)){
            logcommands.remove(logcommand);
        }
        Trainstation.getInstance().getLoggerDisplay().update();
    }

    public ArrayList<String> getLogcommands(){
        return logcommands;
    }
}
