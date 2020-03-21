import java.util.ArrayList;

public class Lair {
	String name;
	private ArrayList<Villain> villains;
	
	public Lair(String name) {
		this.name = name;
	}
	
	public void addVillain(Villain villain) {
		villains.add(villain);
	}
	
	public int getSize() {
		return villains.size();
	}
	
}
