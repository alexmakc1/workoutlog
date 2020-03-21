package ajmack5.project2;
public class Main {


	
	public static void memberRegistersForRace(Member member, Race race) {
		if(race.currentParticipants < race.maxParticipants && member.credits >= 30 && member.isRace == false ) {
			System.out.println("you are successfully registered");
			//insert method to register member for race here
		}else if(race.currentParticipants >= race.maxParticipants){
			System.out.println("error: The race is full");
		}else if(member.credits < 30) {
			System.out.println("error: You do not have enough credits");
		}else {
			System.out.println("error: You are already registered for another race");
		}
	}
	
	public static void Main(String[] args) {
		// TODO Auto-generated method stub
		
		Race firstRace = new Race();
		Member joe = new Member();
		Member bob = new Member();
		Member sally = new Member();
		Team team1 = new Team();
		team1.membersOfTeam[0] = joe;
		team1.membersOfTeam[1] = sally;
		team1.membersOfTeam[2] = bob;
		firstRace.teams[0] = team1;
		joe.credits = 30;
		memberRegistersForRace(joe, firstRace);
		joe.isRace = true;
		memberRegistersForRace(joe, firstRace);
		joe.credits = 10;
		memberRegistersForRace(joe, firstRace);
		firstRace.currentParticipants = 30;
		memberRegistersForRace(joe,firstRace);
		
	}

}
