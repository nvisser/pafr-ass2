package ass2.command;

import ass2.models.Train;
import ass2.models.Trainstation;
import ass2.models.Wagon;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddWagon
{
	private static final Pattern regex = Pattern.compile("add ([a-z][a-z0-9]*) to ([a-z][a-z0-9]*);");

	@Override
	protected Pattern getPattern()
	{
		return pattern;
	}

	@Override
	protected boolean executeCommand(Matcher matcher)
	{




	}
}
