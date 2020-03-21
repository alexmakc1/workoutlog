import java.util.ArrayList;

public class Villain extends Character {

	double percentWins = 0;

	int wins = 0;

	int total = 0;

	private Lair lair;

	public Villain(String name, ArrayList<Skill> skills, Lair lair) {

	}

	public Villain(String name, Skill skill, Lair lair) {

	}

	public Villain spawn(String name) {
		return null;
	}

	public int getWins() {
		return 0;
	}

	public int getTotal() {
		return 0;
	}

	public double getRank() {
		return 0;
	}

	public Lair getLair() {
		return null;
	}

	private void calculateTotals() {

	}

}
