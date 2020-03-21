import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Race {
	public String name;

	public double distance; // seen as km

	public int maxParticipants;

	public Date date;

	public Type raceType;

	public Organizer organizer; // will probably not be important later on, could also be just one organizer who creates it since we do not consider editing the race

	public List<Team> teams = new ArrayList<Team>();

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
}
