package ass2.models;

public interface Subject {
    public void registerObserver(Observer o);
    public void notifyObservers();
}
