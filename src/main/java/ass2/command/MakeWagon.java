package ass2.command;

/**
 * Created by Brian on 19-12-2016 at 15:09.
 */
public class MakeWagon implements ICommand
{
	private String name;
	private String type;
	private int seats;

	public MakeWagon(String name, String type, int seats)
	{
		this.name = name;
		this.type = type;
		this.seats = seats;
	}

	@Override
	public void run()
	{

	}
}
