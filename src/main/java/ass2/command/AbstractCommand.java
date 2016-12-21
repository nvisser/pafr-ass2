package ass2.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractCommand implements ICommand
{
	@Override
	public boolean canProcess(String dsl)
	{
		return getPattern().matcher(dsl).matches();
	}

	@Override
	public boolean process(String dsl)
	{
		if (canProcess(dsl))
		{
			Matcher m = getPattern().matcher(dsl);

			// This is needed to get the groups. Nasty.
			m.matches();

			// Do it to him
			executeCommand(m);
			return true;
		}
		return false;
	}

	protected abstract Pattern getPattern();

	protected abstract boolean executeCommand(Matcher matcher);
}
