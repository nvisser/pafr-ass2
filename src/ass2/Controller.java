package ass2;

import ass2.models.Observer;

import java.util.ArrayList;
import java.util.List;

public class Controller
{
	private List<Observer> observers;

	public Controller()
	{
		this.observers = new ArrayList<>();
	}

	public void registerObserver(Observer o)
	{
		this.observers.add(o);
	}

	public void removeObserver(Observer o)
	{
		int i = this.observers.indexOf(o);
		if (i < 0)
			return;
		observers.remove(i);
	}

	public void notifyObservers()
	{
		this.observers.forEach((o) ->
		{
			o.update(null);
		});
	}

	public void dataChanged()
	{
		this.notifyObservers();
	}

	public void setData(Class data)
	{
		// this.data = whatever
		this.dataChanged();
	}


}
