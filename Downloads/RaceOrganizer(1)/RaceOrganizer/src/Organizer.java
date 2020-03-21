public class Organizer extends User {

	public Organizer(String email, String password) {
		super(email, password);
	}

	//private Race[] races; // made this association uni-directional (only race knows organizer). Could include this in Organizer and add each race to the Organizer

}
