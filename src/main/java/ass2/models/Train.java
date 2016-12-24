package ass2.models;

import java.util.ArrayList;

public class Train implements Subject
{
	private String id;
	private ArrayList<Wagon> wagonList = new ArrayList<>();
	private ArrayList<Observer> observers = new ArrayList<>();

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	ArrayList<Wagon> getWagonList()
	{
		return wagonList;
	}

	void addWagon(Wagon wa)
	{
		wagonList.add(wa);
	}

	void removeWagon(Wagon w)
	{
		int i = this.wagonList.indexOf(w);
		if (i >= 0)
			wagonList.remove(i);
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(Observer::update);
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Train && ((Train) obj).getId().equals(this.getId()) && ((Train) obj).getWagonList().equals(this.getWagonList());
	}
}
