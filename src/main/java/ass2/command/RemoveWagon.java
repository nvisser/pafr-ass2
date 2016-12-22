package ass2.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveWagon extends AbstractCommand
{
	@Override
	protected Pattern getPattern()
	{
		return null;
	}

	@Override
	protected boolean executeCommand(Matcher matcher)
	{
		return false;
	}
}
