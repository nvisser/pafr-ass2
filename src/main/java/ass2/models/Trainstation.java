package ass2.models;

import java.util.ArrayList;

public class Trainstation
{
	private static Trainstation instance = new Trainstation();
	private ArrayList<Train> trainList = new ArrayList<Train>();
	private ArrayList<Wagon> wagonList = new ArrayList<Wagon>();

	private Trainstation()
	{
		// Don't make me bro
	}

	public static Trainstation getInstance()
	{
		if (instance == null)
		{
			instance = new Trainstation();
		}
		return instance;
	}

	public ArrayList<Train> getTrainList()
	{
		return trainList;
	}

	public ArrayList<Wagon> getWagonList()
	{
		return wagonList;
	}

	public void addTrain(Train t)
	{
		trainList.add(t);
	}

	public void removeTrain(Train t)
	{
		int i = this.trainList.indexOf(t);
		if (i > 0)
		{
			trainList.remove(i);
		}

	}


	public void addWagon(Wagon w)
	{
		wagonList.add(w);
	}

	public void removeWagon(Wagon w)
	{
		int i = this.wagonList.indexOf(w);
		if (i > 0)
		{
			wagonList.remove(i);
		}
	}

	public void addWagonToTrain(Wagon x, Train y){

		y.addWagon(x);
	}

	public Wagon findWagon(String xd){
		for (  Wagon t : wagonList){
			if (t.getId().equals(xd)){
				return t;
			}
		}
		return null;

	}

	public Train findTrain(String xdddd){
		for (Train n : trainList){
			if (n.getId().equals(xdddd))
				return n;

		}

		return null;

	}
}
