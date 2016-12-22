package ass2.command;

import ass2.models.Trainstation;
import ass2.models.Wagon;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WagonSeats extends AbstractCommand {
    private static final Pattern pattern = Pattern.compile("getnumseats wagon ([a-z][a-z0-9]*);");

    @Override
    protected Pattern getPattern(){
        return pattern;
    }

    @Override
    public boolean executeCommand(Matcher matcher){
        ArrayList<Wagon> w = Trainstation.getInstance().getWagonList();
        Optional<Wagon> found = w.stream().filter((z) -> z.getId().equals(matcher.group(1))).findFirst();
        found.ifPresent(wagon -> Trainstation.getInstance().getWagonSeats(wagon));
        return true;
    }
}
