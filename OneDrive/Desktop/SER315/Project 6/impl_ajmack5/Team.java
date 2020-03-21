import java.util.ArrayList;
import java.util.List;

public class Team {

	public String name;

	public Race race;

	private List<Member> members = new ArrayList<Member>();
	
	public Team (String name, Race race, Member member) {
		this.name = name; 
		this.race = race;
		//this.members.add(member);
	}

	public String get_team_name() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public void add(Member new_member) {
		members.add(new_member);
		
	}
	
	public List<Member> getTeam() {
		return members;
	}

}
