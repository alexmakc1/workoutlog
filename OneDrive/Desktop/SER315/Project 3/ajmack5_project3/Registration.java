public class Registration {

	public int id;

	public Race race;

	public Member member;
	
	public int startime = 0;
	public int endtime = 0; 

	// id should be auto generated later on but for now we just give the id to the constructor
	public Registration(int id, Race race, Member member) { 
		this.id = id;
		this.race = race;
		this.member = member;
	}
}
