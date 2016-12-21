package ass2.command;

import java.util.regex.Pattern;

/**
 * Created by Brian on 19-12-2016 at 15:11.
 */
public class AddWagon implements ICommand
{
	private static final Pattern regex = Pattern.compile("add ([a-z][a-z0-9]*) to ([a-z][a-z0-9]*);");

	public static Pattern getRegex()
	{
		return regex;
	}

	@Override
	public void run()
	{
	}
}
