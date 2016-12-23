package ass2.models;

import java.util.ArrayList;

public class Trainstation implements Subject
{
	private static Trainstation instance;
	private CommandInputDisplay commandInputDisplay = new CommandInputDisplay();
	private Logger logger = new Logger();
	private LoggerDisplay loggerDisplay = new LoggerDisplay();
	private TrainDisplay trainDisplay = new TrainDisplay();
	private ArrayList<Train> trainList = new ArrayList<Train>();
	private ArrayList<Wagon> wagonList = new ArrayList<Wagon>();
	private ArrayList<Observer> observers = new ArrayList<>();

	private Trainstation()
	{
		// Don't make me bro
	}

	public Logger getLogger() {
		return logger;
	}

	public LoggerDisplay getLoggerDisplay() {
		return loggerDisplay;
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

	/**
	 * Return seats for a wagon
	 *
	 * @param w Wagon
	 * @return int
	 */
	public int getWagonSeats(Wagon w)
	{
		int wagonLoc = this.wagonList.indexOf(w);
		if (wagonLoc >= 0)
			return w.getSeats();
		return 0;
	}

	/**
	 * Return seats for a train
	 *
	 * @param t Train
	 * @return int
	 */
	public int getWagonSeats(Train t)
	{
		int trainLoc = this.trainList.indexOf(t);
		if (trainLoc >= 0 && t.getWagonList().size() > 0)
		{
			return t.getWagonList().stream().mapToInt(Wagon::getSeats).sum();
		}
		return 0;
	}

	/**
	 * Add a train
	 *
	 * @param t Train
	 */
	public void addTrain(Train t)
	{
		if (trainList.contains(t))
			return;
		trainList.add(t);
		t.registerObserver(loggerDisplay);
		this.notifyObservers();
		t.notifyObservers();
	}

	/**
	 * Remove a train
	 *
	 * @param t Train
	 */
	public void removeTrain(Train t)
	{
		int i = this.trainList.indexOf(t);
		if (i > 0)
		{
			trainList.remove(i);
		}

	}


	/**
	 * Add a wagon
	 *
	 * @param w Wagon
	 */
	public void addWagon(Wagon w)
	{
		if (wagonList.contains(w))
			return;
		wagonList.add(w);
	}

	/**
	 * Remove a wagon
	 *
	 * @param w Wagon
	 */
	public void removeWagon(Wagon w)
	{
		int i = this.wagonList.indexOf(w);
		if (i > 0)
		{
			wagonList.remove(i);
		}
	}

	/**
	 * Add a wagon to train
	 *
	 * @param wagon Wagon
	 * @param train Train
	 */
	public void addWagonToTrain(Wagon wagon, Train train)
	{
		int trainLoc = this.trainList.indexOf(train);
		int wagonLoc = this.wagonList.indexOf(wagon);


		if (!train.getWagonList().contains(wagon) && trainLoc >= 0 && wagonLoc >= 0)
		{
			// Combine
			train.addWagon(wagon);

			// Replace in list
			this.trainList.set(trainLoc, train);
		}
	}

	/**
	 * Remove wagon from trian
	 *
	 * @param wagon Wagon
	 * @param train Train
	 */
	public void removeWagonFromTrain(Wagon wagon, Train train)
	{
		int trainLoc = this.trainList.indexOf(train);
		int wagonLoc = this.wagonList.indexOf(wagon);
		if (train.getWagonList().contains(wagon) && trainLoc >= 0 && wagonLoc >= 0)
		{
			// Unlink
			train.removeWagon(wagon);

			// Replace in list
			this.trainList.set(trainLoc, train);
		}
	}

	/**
	 * Find a wagon
	 *
	 * @param id String
	 * @return Wagon
	 */
	public Wagon findWagon(String id)
	{
		for (Wagon t : wagonList)
		{
			if (t.getId().equals(id))
			{
				return t;
			}
		}
		return null;
	}

	/**
	 * Find a train
	 *
	 * @param id String
	 * @return Train
	 */
	public Train findTrain(String id)
	{
		for (Train n : trainList)
		{
			if (n.getId().equals(id))
			{
				return n;
			}
		}
		return null;
	}

	@Override
	public void registerObserver(Observer o)
	{
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o)
	{
		observers.remove(o);
	}

	@Override
	public void notifyObservers()
	{
		observers.forEach(Observer::update);
	}
}
