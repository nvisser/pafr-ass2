package ass2.command;

import ass2.models.Trainstation;
import ass2.models.Wagon;

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
		Wagon w = new Wagon();
		w.setId(name);
		w.setType(type);
		w.setSeats(seats);
		Trainstation.getInstance().addWagon(w);
	}
}
