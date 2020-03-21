import java.util.ArrayList;

public class Village {
    String name;
	private ArrayList<Hero> heroes;
	
	public Village(String name) {
	    this.name = name;
	}
	
	public void addHero(Hero hero) {
		heroes.add(hero);
	}
	
	public String getName() {
	    return name;
	}
	
	public int getSize() {
	    return heroes.size();
	}

}
