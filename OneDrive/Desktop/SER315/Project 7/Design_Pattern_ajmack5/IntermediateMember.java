
public class IntermediateMember implements Member {
	String username;
	String password;
	final char skillLevel = 'i';

	@Override
	public void create(String username, String password) {
		this.username = username;
		this.password = password;
		
	}

	@Override
	public String getUsername() {
		return username;
		
	}
	
	public char getSkill() {
		return skillLevel;
		
	}

}
