package ass2.command;

import ass2.models.Train;
import ass2.models.Trainstation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		final Train x = new Train();
		x.setId(matcher.group(1));
		Trainstation.getInstance().addTrain(x);
		Trainstation.getInstance().addOutputCommand("train  " + matcher.group(1) + " created");
		return true;
	}
}
