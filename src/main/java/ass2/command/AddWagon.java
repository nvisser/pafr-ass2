package ass2.command;

import ass2.models.Train;
import ass2.models.Trainstation;
import ass2.models.Wagon;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddWagon extends AbstractCommand {
    private static final Pattern pattern = Pattern.compile("add ([a-z][a-z0-9]*) to ([a-z][a-z0-9]*);");

    @Override
    protected Pattern getPattern() {
        return pattern;
    }

    @Override
    protected boolean executeCommand(Matcher matcher) {


        Wagon x = Trainstation.getInstance().findWagon(matcher.group(1));
        Train y = Trainstation.getInstance().findTrain(matcher.group(2));
        y.addWagon(x);
        return true;

    }
}

