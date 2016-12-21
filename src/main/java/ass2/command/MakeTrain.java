package ass2.command;

import ass2.models.Train;
import ass2.models.Trainstation;

import java.util.regex.Pattern;

/**
 * Created by Brian on 19-12-2016 at 15:09.
 */
public class MakeTrain implements ICommand
{
	private static final Pattern regex = Pattern.compile("new train [a-z][a-z0-9]*;");
	private String name;

	public MakeTrain(String name)
	{
		this.name = name;
	}

	public static Pattern getRegex()
	{
		return regex;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public void run()
	{
		Train x = new Train();
		x.setId(name);
		Trainstation.getInstance().addTrain(x);
	}
}
