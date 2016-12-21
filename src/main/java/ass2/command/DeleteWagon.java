package ass2.command;

import ass2.models.Train;
import ass2.models.Trainstation;
import ass2.models.Wagon;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Brian on 19-12-2016 at 15:14.
 */
public class DeleteWagon extends AbstractCommand {
	private static final Pattern pattern = Pattern.compile("delete wagon ([a-z][a-z0-9]*);");

	@Override
	protected Pattern getPattern(){
		return pattern;
	}

	@Override
	public boolean executeCommand(Matcher matcher){
		ArrayList<Wagon> w = Trainstation.getInstance().getWagonList();
		for(Wagon z : w){
			if(z.getId().equals(matcher.group(1))){
				Trainstation.getInstance().removeWagon(z);
			}
		}
		return true;
	}
}
