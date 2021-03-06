package ass2.command;

import ass2.models.Trainstation;
import ass2.models.Wagon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakeWagon extends AbstractCommand
{
	private static final Pattern pattern = Pattern.compile("new wagon ([a-z][a-z0-9]*)(?: numseats ([0-9]+))?;");

	@Override
	protected Pattern getPattern()
	{
		return pattern;
	}

	@Override
	protected boolean executeCommand(Matcher matcher)
	{
		final Wagon w = new Wagon();
		w.setId(matcher.group(1));
		final int seats = matcher.group(2) == null ? 20 : Integer.parseInt(matcher.group(2));
		w.setSeats(seats);
		Trainstation.getInstance().addWagon(w);
		Trainstation.getInstance().addOutputCommand("wagon " + w.getId() + " created with " + w.getSeats() + " seats");
		return true;
	}
}
