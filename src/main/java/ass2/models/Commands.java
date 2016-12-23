package ass2.models;

import ass2.command.*;

import java.util.ArrayList;


public class Commands
{
	private ArrayList<ICommand> commands = new ArrayList<>();

	public Commands()
	{
		commands.add(new MakeTrain());
		commands.add(new MakeWagon());
		commands.add(new DeleteTrain());
		commands.add(new DeleteWagon());
		commands.add(new AddWagon());
		commands.add(new RemoveWagon());
		commands.add(new WagonSeats());
		commands.add(new TrainSeats());
	}

	/**
	 * Parse stuff
	 *
	 * @param input String
	 */
	public void parse(String input)
	{
		System.out.println("[DEBUG] Parsing: " + input);
		for (ICommand c : this.commands)
		{
			if (c.canProcess(input))
			{
				System.out.println("[DEBUG] Parsed " + c.getClass().getName());
				Trainstation.getInstance().getLogger().addLogcommand(input);
				c.process(input);
				return;
			}
		}
		System.out.println("Unknown command");
	}
}
