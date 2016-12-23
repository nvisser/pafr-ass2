package ass2.models;

import java.util.ArrayList;

public class Trainstation implements Subject
{
	private static CommandInputDisplay commandInputDisplay;
	private static LoggerDisplay loggerDisplay;
	private static TrainDisplay trainDisplay;

	private static Trainstation instance;
	private ArrayList<Train> trainList = new ArrayList<Train>();
	private ArrayList<Wagon> wagonList = new ArrayList<Wagon>();
	private ArrayList<Observer> observers = new ArrayList<>();
	private ArrayList<String> logcommands = new ArrayList<>();
	private ArrayList<String> outputcommands = new ArrayList<>();

	public Trainstation(LoggerDisplay logdisplay, TrainDisplay td, CommandInputDisplay cid)
	{
		setLoggerDisplay(logdisplay);
		setCommandInputDisplay(cid);
		setTrainDisplay(td);
	}

	public static synchronized Trainstation getInstance(TrainDisplay imgdsply, CommandInputDisplay lstdsply, LoggerDisplay lgdsply){
		if (instance == null)
			instance = new Trainstation(lgdsply, imgdsply, lstdsply);
		return instance;
	}

	public static synchronized Trainstation getInstance(){
		return instance;
	}

	public static void setLoggerDisplay(LoggerDisplay loggerDisplay)
	{
		Trainstation.loggerDisplay = loggerDisplay;
	}

	public static void setCommandInputDisplay(CommandInputDisplay commandInputDisplay)
	{
		Trainstation.commandInputDisplay = commandInputDisplay;
	}

	public static void setTrainDisplay(TrainDisplay trainDisplay)
	{
		Trainstation.trainDisplay = trainDisplay;
	}

	public ArrayList<String> getLog()
	{
		return logcommands;
	}

	public ArrayList<String> getOutputcommands(){
		return outputcommands;
	}

	public void addOutputCommand(String command){
		outputcommands.add(command);
	}

	public void addLogcommand(String logcommand)
	{
		logcommands.add(logcommand);
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
		if (wagonLoc >= 0){
			this.notifyObservers();
			return w.getSeats();
		}
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
		this.notifyObservers();
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
			this.notifyObservers();
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
		this.notifyObservers();
	}

	/**
	 * Remove a wagon
	 *
	 * @param w Wagon
	 */
	public void removeWagon(Wagon w)
	{
		int i = this.wagonList.indexOf(w);
		if (i >= 0)
		{
			this.notifyObservers();
			wagonList.remove(i);
		}
		this.notifyObservers();
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
		this.notifyObservers();
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
			this.notifyObservers();
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
				this.notifyObservers();
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
				this.notifyObservers();
				return n;
			}
		}
		return null;
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer1 : observers) {
			observer1.update();
		}
	}

}
