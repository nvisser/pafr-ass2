package ass2.models;

public class Commands
{
	/**
	 * Parse stuff
	 *
	 * @param input String
	 */
	public void parse(String input)
	{
		String[] args = input.split("\\s+");
		if (args.length < 3)
			return;
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
				} else if (args.length == 5)
				{
					this.makeNew(type, args[2], Integer.parseInt(args[4]));
					break;
				}
				break;
			case "add":
				if (!args[2].equals("to"))
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
		}
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
			this.makeNew(type, name, 0);

		} else if (type.equalsIgnoreCase("wagon"))
		{
			this.makeNew(type, name, 20);
		}
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
	}

	/**
	 * Delete things
	 *
	 * @param type String
	 * @param what String
	 */
	private void delete(String type, String what)
	{
		// todo stuff
	}

	/**
	 * Get the number of seats
	 *
	 * @param type String
	 * @param what String
	 */
	private void getNumseats(String type, String what)
	{
		// todo stuff
	}

	/**
	 * Add things to things
	 *
	 * @param addWhat String
	 * @param toWhat  String
	 */
	private void add(String addWhat, String toWhat)
	{
		// todo stuff
	}
}
