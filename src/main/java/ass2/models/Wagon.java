package ass2.models;

import java.util.ArrayList;

public class Wagon implements Subject
{
	private String id;
	private int seats;
	private ArrayList<Observer> observers = new ArrayList<>();

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getSeats()
	{
		return seats;
	}

	public void setSeats(int seats)
	{
		this.seats = seats;
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
