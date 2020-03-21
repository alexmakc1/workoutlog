import java.util.ArrayList;
import java.util.List;

public class Team {

	public String name;

	public Race race;

	public List<Member> members = new ArrayList<Member>();
	
	public Team (String name, Race race, Member member) {
		this.name = name; 
		this.race = race;
		this.members.add(member);
	}

}
