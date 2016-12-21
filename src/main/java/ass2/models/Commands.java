package ass2.models;

import ass2.command.ICommand;
import ass2.command.MakeTrain;
import ass2.command.MakeWagon;

import java.util.ArrayList;

public class Commands
{
	private ArrayList<ICommand> commands = new ArrayList<>();

	public Commands()
	{
		commands.add(new MakeTrain());
		commands.add(new MakeWagon());
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
				c.process(input);
				break;
			}
		}
		System.out.println("Unknown command");
	}
}
