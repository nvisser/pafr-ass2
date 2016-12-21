package ass2.models;

import ass2.ControllerFX;

import java.util.ArrayList;

public class Logger {
    private ArrayList<String> logcommands = new ArrayList<>();

    public void addLogcommand(String logcommand){
        logcommands.add(logcommand);
        ControllerFX controllerFX = new ControllerFX();
        controllerFX.addLog(logcommand);
    }
    public void removeLogcommand(String logcommand){
        if (logcommands.contains(logcommand)){
            logcommands.remove(logcommand);
        }
    }
}
