import java.util.ArrayList;
import java.util.List;

public class Member extends User {
	public int credit;
	public int id;
	//private String email;
	public CreditCard creditCard;

	public List<Team> teams = new ArrayList<Team>();
	public List<Registration> registration = new ArrayList<Registration>();


	public Member(String email, String password) {
		super(email, password);
		
		this.credit = 0;
		this.creditCard = null; // we do not need the credit card so we do not set it, member would later have a method that can set the credit card
	}
	public Member(String email, String password, int credit) { // so I can add credits when creating the member
		super(email, password);
		this.credit = credit;
		this.creditCard = null;
	}
	public String get_email() {
		// TODO Auto-generated method stub
		return email;
	}
	

	
}
