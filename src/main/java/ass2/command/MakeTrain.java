package ass2.command;

/**
 * Created by Brian on 19-12-2016 at 15:09.
 */
public class MakeTrain implements ICommand
{
	private String name;

	public MakeTrain(String name)
	{
		this.name = name;
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

	}
}
