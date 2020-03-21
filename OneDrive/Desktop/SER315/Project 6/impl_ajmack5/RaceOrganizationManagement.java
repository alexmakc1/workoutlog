import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RaceOrganizationManagement {
	private static Organizer organizer = new Organizer("mehlhase@mehlhase.de","555"); // only one organizer, could create more though
	private static List<Race> races = new ArrayList<Race>(); // create a list of members that the system knows
	
	public Race find_race(Date date) {
		Race current_race = null;
		for(int i = 0; i < races.size(); i++) {
			current_race = races.get(i);
			if(current_race.get_date() == date) {
				break;
			}
		}
		return current_race;
	}
	
	public Organizer getOrg(){
		return organizer;
	}
	
	public static List<Race> getRaces(){
		return races;
	}
	
	
}

