package ass2.models;

import ass2.command.MakeTrain;
import ass2.command.MakeWagon;

public class Commands
{
	/**
	 * Parse stuff
	 *
	 * @param input String
	 */
	public void parse(String input)
	{
		System.out.println("[DEBUG] Parsing: " + input);
		String[] args = input.split("\\s+");
		String action = args[0];
		String type;
		switch (action)
		{
			case "new":
				type = args[1];
				// new train tr1
				if (args.length == 3)
				{
					this.makeNew(type, args[2]);
					break;
				}
				// new wagon wg2 numseats 15
				else if (args.length == 5 && args[3].equals("numseats"))
				{
					this.makeNew(type, args[2], Integer.parseInt(args[4]));
					break;
				}
				break;
			case "add":
				if (!args[2].equals("to") || args.length != 4)
					break;
				this.add(args[1], args[3]);
				break;
			case "delete":
				type = args[1];
				this.delete(type, args[2]);
				break;
			case "getnumseats":
				type = args[1];
				this.getNumseats(type, args[2]);
				break;
			case "remove":
				if (!args[2].equals("from"))
					break;
				this.remove(args[1], args[3]);
				break;
		}
	}

	private void remove(String from, String fromWhat)
	{
		System.out.println("[DEBUG] from = [" + from + "], fromWhat = [" + fromWhat + "]");
	}

	/**
	 * Make a new thing
	 *
	 * @param type String
	 * @param name String
	 */
	private void makeNew(String type, String name)
	{
		if (type.equalsIgnoreCase("train"))
		{
			new Thread(new MakeTrain(name)).start();

		} else if (type.equalsIgnoreCase("wagon"))
		{
			new Thread(new MakeWagon(name, type, 20)).start();
		} else
		{
			throw new IllegalArgumentException("Argument \"type\" needs to be either train or wagon.");
		}
		System.out.println("[DEBUG] type = [" + type + "], name = [" + name + "]");
	}

	/**
	 * Make a new thing
	 *
	 * @param type     String
	 * @param name     String
	 * @param numSeats int
	 */
	private void makeNew(String type, String name, int numSeats)
	{
		new Thread(new MakeWagon(name, type, numSeats)).start();
		System.out.println("[DEBUG] type = [" + type + "], name = [" + name + "], numSeats = [" + numSeats + "]");
	}

	/**
	 * Delete things
	 *
	 * @param type String
	 * @param what String
	 */
	private void delete(String type, String what)
	{
		System.out.println("[DEBUG] type = [" + type + "], what = [" + what + "]");
	}

	/**
	 * Get the number of seats
	 *
	 * @param type String
	 * @param what String
	 */
	private void getNumseats(String type, String what)
	{
		System.out.println("[DEBUG] type = [" + type + "], what = [" + what + "]");
	}

	/**
	 * Add things to things
	 *
	 * @param addWhat String
	 * @param toWhat  String
	 */
	private void add(String addWhat, String toWhat)
	{
		System.out.println("[DEBUG] addWhat = [" + addWhat + "], toWhat = [" + toWhat + "]");
	}
}
