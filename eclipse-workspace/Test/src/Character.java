import java.util.ArrayList;

public class Character {
	public String name;
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	private ArrayList<Fight> fights = new ArrayList<Fight>();
	
	public Character(String name, ArrayList<Skill> skills) {
		this.name = name;
		this.skills = skills;
	}
	public Character(String name, Skill skill) {
		this.name = name;
		this.skills.add(skill);
	}
	
	public void addSkill(Skill skill) {
		skills.add(skill);	
	}
	
	public void addFight(Fight fight) {
	    fights.add(fight);
	}
	
	public ArrayList<Skill> getSkills(){
		return skills;
	}
	
	public ArrayList<Fight> getFights(){
	    return fights;
	}
	
	public String getName() {
	    return name;
	}
}
