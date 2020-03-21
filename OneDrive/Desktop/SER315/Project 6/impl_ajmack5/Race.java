import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Race {
	private String name;

	public double distance; // seen as km

	public int maxParticipants;

	private Date date;

	public Type raceType;

	public Organizer organizer; // will probably not be important later on, could also be just one organizer who creates it since we do not consider editing the race

	private List<Team> teams = new ArrayList<Team>();

	public List<Registration> registration = new ArrayList<Registration>();

	// private Guest[] guest; could be included but does not really make much sense, we will later on not really implement this class anyhow, since this is not a registered member
	
	
	public Race(String name, int distance, int max, Date date, Type type, Organizer organizer) {
		this.name = name;
		this.distance = distance;
		this.maxParticipants = max;
		this.date = date;
		this.raceType = type;
		this.organizer = organizer;
	}

	public Date get_date() {
		
		return date;
	}

	public Team get_team(String team_name) {
		boolean team_exists = false;
		System.out.println("Current size of teams : " + teams.size());
		Team current_team = null;
		for(int i = 0; i < teams.size(); i++) {
			if(teams.get(i).get_team_name().equals(team_name)) {
				current_team = teams.get(i);
				team_exists = true;
				break;
			}
		}
		if(team_exists == false) {
			System.out.println("Team does not exist");
			return null;
		}else {
		
		return current_team;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public List<Team> getTeams() {
		return teams;
	}
}
