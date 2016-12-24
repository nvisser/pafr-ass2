package ass2.models;

import java.util.ArrayList;

public class Trainstation implements Subject
{
	private static CommandInputDisplay commandInputDisplay;
	private static LoggerDisplay loggerDisplay;
	private static TrainDisplay trainDisplay;

	private static Trainstation instance;
	private ArrayList<Train> trainList = new ArrayList<>();
	private ArrayList<Wagon> wagonList = new ArrayList<>();
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

	private static void setLoggerDisplay(LoggerDisplay loggerDisplay)
	{
		Trainstation.loggerDisplay = loggerDisplay;
	}

	private static void setCommandInputDisplay(CommandInputDisplay commandInputDisplay)
	{
		Trainstation.commandInputDisplay = commandInputDisplay;
	}

	private static void setTrainDisplay(TrainDisplay trainDisplay)
	{
		Trainstation.trainDisplay = trainDisplay;
	}

	public ArrayList<String> getLog()
	{
		return logcommands;
	}

	ArrayList<String> getOutputcommands(){
		return outputcommands;
	}

	public void addOutputCommand(String command){
		outputcommands.add(command);
	}

	void addLogcommand(String logcommand)
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
	}

	/**
	 * Remove a train
	 *
	 * @param t Train
	 */
	public void removeTrain(Train t)
	{
		int i = this.trainList.indexOf(t);
		if (i >= 0)
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
		if (i >= 0)
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


		if (!train.getWagonList().contains(wagon) && trainLoc >= 0 && wagonLoc >= 0) {
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
