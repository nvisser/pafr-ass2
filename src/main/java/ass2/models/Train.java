package ass2.models;

import java.util.ArrayList;

public class Train
{
	private String id;
	private ArrayList<Wagon> wagonList = new ArrayList<Wagon>();

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
}
