package ass2.command;

import ass2.models.Train;
import ass2.models.Trainstation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Brian on 19-12-2016 at 15:10.
 */
public class DeleteTrain extends AbstractCommand
{
    private static final Pattern pattern = Pattern.compile("delete train ([a-z][a-z0-9]*);");

    @Override
    protected Pattern getPattern(){
        return pattern;
    }

    @Override
    protected Boolean executeCommand(Matcher matcher){
    }

}
