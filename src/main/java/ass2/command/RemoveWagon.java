package ass2.command;

import ass2.models.Train;
import ass2.models.Trainstation;
import ass2.models.Wagon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveWagon extends AbstractCommand
{
	private static final Pattern pattern = Pattern.compile("remove ([a-z][a-z0-9]*) from ([a-z][a-z0-9]*);");

	@Override
	protected Pattern getPattern()
	{
		return pattern;
	}

	@Override
	protected boolean executeCommand(Matcher matcher)
	{
		Trainstation t = Trainstation.getInstance();
		Wagon wagon = t.findWagon(matcher.group(1));
		if (wagon == null)
			return false;
		Train train = t.findTrain(matcher.group(2));
		if (train == null)
			return false;
		t.removeWagonFromTrain(wagon, train);
		return true;
	}
}
