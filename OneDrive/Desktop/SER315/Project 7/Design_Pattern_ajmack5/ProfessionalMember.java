
public class ProfessionalMember implements Member {
	String username;
	String password;
	final char skillLevel = 'p';

	@Override
	public void create(String username, String password) {
		this.username = username;
		this.password = password;
		
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	public char getSkill() {
		return skillLevel;
		
	}

}
