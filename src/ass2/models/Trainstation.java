package ass2.models;

import java.util.ArrayList;

public class Trainstation
{
    private ArrayList<Train> trainList = new ArrayList<Train>();

    public void addTrain(Train t){
        trainList.add(t);
    }

}
