package ass2.models;

import java.util.ArrayList;

public class Train
{
    private String id;
    private ArrayList<Wagon> wagonList = new ArrayList<Wagon>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addWagon(Wagon wa){
        wagonList.add(wa);
    }
}
