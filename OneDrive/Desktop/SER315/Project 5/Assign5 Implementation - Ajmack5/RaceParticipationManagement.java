import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class RaceParticipationManagement {
	static List<Member> members = new ArrayList<Member>(); // create a list of members that the system knows
	
	
	
	static public String register_for_race(String email, Date date) { // sometimes I called it register_in_race -- both are ok
		Member m = null; // be assume we can always find the member with that email, so we do not do error handling of the wrong email 
		for (Member mem : members) {
			if (mem.email == email) {
				m = mem;
			}
		}

		Race r = null; // we assume we can always find the race with that date, so we do not do error handling of the wrong date 
		for (Race ro : RaceOrganizationManagement.races) {
			if (ro.date == date) {
				r = ro;
			}
		}

		/* since I did not distinguish between racer and volunteer arrays I need to 
		 * sort through them to see how many actually registered. This could have been done differently 
		 * and you can do so if you like. EG. have an attribute counting the registrations, having an racer
		 * and a volunteer array. Just to name two options. 
		 */

		int reg_counter = 0;
		boolean registered = false; // loop checks also if member is already registered
		for (Registration reg: r.registration) {
			if (reg.getClass()==(Racer.class)) {
				reg_counter += 1;
			}
			if (reg.member == m) { // member already registered in race
				registered = true; 
			}
		}

		if (r.maxParticipants > reg_counter) {

			if (m.credit >= 10) {
				if(!registered) {
					Registration reg = new Registration(450, r, m);
					r.registration.add(reg);
					System.out.print("Currently registered members in race " + r.name + ": \n");
					for(int i = 0; i < r.registration.size(); i++) {
						System.out.print(r.registration.get(i).member.email + ", \n");
					}
					return "registration_successful";
				}
				else {
					return "already_registered";
				}
			}
			else {
				return "insufficient_credits";
			}
		}
		else {
			return "race_already_full";
		}
	}
}
