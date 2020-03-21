import java.util.ArrayList;

public class Hero extends Character{
    private Village village;
    private double percentWins = 0;
    private int wins = 0;
    private int total = 0;
	
	public Hero(String name, ArrayList<Skill> skills, Village village) {
		super(name, skills);
		this.village = village;
	}
	public Hero(String name, Skill skill) {
		super(name, skill);
	}
	
    public Hero make(String name) {
        Hero hero = new Hero(name, this.skills, this.village);   
        if (village.getSize() < 50) {
            village.addHero(hero);
        }
        else {
            Village newVillage = new Village(name+"ville");
            newVillage.addHero(hero);
        }
        return hero;   
        
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
    
    public Village getVillage() {
        return village;
    }
    
    private void calculateTotals() {
        wins = 0;
        total = super.getFights().size();
        for (int i = 0; i < super.getFights().size(); i++) {
            if (this.getFights().get(i).heroResult() == true) 
                wins++;
        }
        if (total != 0)
            percentWins = (double)wins/total;
    }
    
}
