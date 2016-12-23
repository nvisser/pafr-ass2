package ass2.models;

import java.util.ArrayList;

public class Train implements Subject
{
	private String id;
	private ArrayList<Wagon> wagonList = new ArrayList<Wagon>();
	private ArrayList<Observer> observers = new ArrayList<>();

	public ArrayList<Wagon> getWagonList()
	{
		return wagonList;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}


	public void addWagon(Wagon wa)
	{
		wagonList.add(wa);
	}

	public void removeWagon(Wagon w)
	{
		int i = this.wagonList.indexOf(w);
		if (i > 0)
			wagonList.remove(i);
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(Observer::update);
	}
}
