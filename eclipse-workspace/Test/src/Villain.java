import java.util.ArrayList;

public class Villain extends Character{
	private Lair lair;
	double percentWins = 0;
	int wins = 0;
	int total = 0;
	
	public Villain(String name, ArrayList<Skill> skills, Lair lair) {
		super(name, skills);
		this.lair = lair;
	}
	
	public Villain(String name, Skill skill, Lair lair) {
	        super(name, skill);
	        this.lair = lair;
	}
	
	public Villain spawn(String name) {
		Villain vill = new Villain(name, this.skills, this.lair);	
		if (lair.getSize() < 50) {
			lair.addVillain(vill);
		}
		else {
			Lair newLair = new Lair(name+"leir");
			newLair.addVillain(vill);
		}
		return vill;
		
		
	}
	
    public int getWins() {
        calculateTotals();
        return wins;
    }
    
    public int getTotal() {
        return total;
    }
    
    public double getRank() {
        return percentWins;
    }
	
	public Lair getLair() {
	    return lair;
	}
	
    private void calculateTotals() {
        wins = 0;
        total = super.getFights().size();
        for (int i = 0; i < super.getFights().size(); i++) {
            if (this.getFights().get(i).villainResult() == true) 
                wins++;
        }
        if (total != 0)
            percentWins = (double)wins/total;
    }


}
