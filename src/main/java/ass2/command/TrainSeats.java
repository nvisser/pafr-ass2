package ass2.command;

import ass2.models.Train;
import ass2.models.Trainstation;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainSeats extends AbstractCommand {

    private static final Pattern pattern = Pattern.compile("getnumseats train ([a-z][a-z0-9]*);");

    @Override
    protected Pattern getPattern(){
        return pattern;
    }

    @Override
    public boolean executeCommand(Matcher matcher){
        ArrayList<Train> a = Trainstation.getInstance().getTrainList();
        Optional<Train> found = a.stream().filter((t) -> t.getId().equals(matcher.group(1))).findFirst();
        found.ifPresent(train -> {
            Trainstation.getInstance().addOutputCommand("Number of seats in train " + train.getId() + ": " + train.getSeats());
            Trainstation.getInstance().getWagonSeats(train);
        });

        return true;
    }
}
