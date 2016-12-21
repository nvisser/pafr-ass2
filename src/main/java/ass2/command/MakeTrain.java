package ass2.command;

import ass2.models.Train;
import ass2.models.Trainstation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Brian on 19-12-2016 at 15:09.
 */
public class MakeTrain extends AbstractCommand
{
	private static final Pattern pattern = Pattern.compile("new train ([a-z][a-z0-9]*);");

	@Override
	protected Pattern getPattern()
	{
		return pattern;
	}

	@Override
	protected boolean executeCommand(Matcher matcher)
	{
		Train x = new Train();
		x.setId(matcher.group(1));
		Trainstation.getInstance().addTrain(x);
		return true;
	}
}
