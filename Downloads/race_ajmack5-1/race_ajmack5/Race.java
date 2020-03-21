package ajmack5.project2;

public class Race {
	int day;
	String Month;
	int year;
	int maxParticipants;
	int currentParticipants;
	
	boolean obstacleRace;
	String name;
	Organizer organizer;
	Team[] teams;
	Member[] members;
	
	public Race() {
		teams = new Team[15];
		maxParticipants = 30;
		
	}
	
	
	
	
}
