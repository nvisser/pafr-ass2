package ass2.models;

public class Commands
{
	public static void parse(String input)
	{
		String[] args = input.split("\\s+");
		if (args.length < 3)
			return;
		String action = args[0];
		switch (action)
		{
			case "new":
				String what = args[1];
				switch (what)
				{
					case "train":
						// todo stuff
						break;
					case "wagon":
						// todo stuff
						break;
				}
				break;
		}
	}
}
