import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class RaceParticipationManagement {
	static List<Member> members = new ArrayList<Member>(); // create a list of members that the system knows
	
	
	
	static public String register_for_race(String email, Date date) { // sometimes I called it register_in_race -- both are ok
		Member member = null; // be assume we can always find the member with that email, so we do not do error handling of the wrong email 
		for (Member mem : members) {
			if (mem.email == email) {
				member = mem;
			}
		}

		Race race = null; // we assume we can always find the race with that date, so we do not do error handling of the wrong date 
		for (Race ra : RaceOrganizationManagement.races) {
			if (ra.date == date) {
				race = ra;
			}
		}

		/* since I did not distinguish between racer and volunteer arrays I need to 
		 * sort through them to see how many actually registered. This could have been done differently 
		 * and you can do so if you like. EG. have an attribute counting the registrations, having an racer
		 * and a volunteer array. Just to name two options. 
		 */

		int reg_counter = 0;
		boolean registered = false; // loop checks also if member is already registered
		for (Registration reg: race.registration) {
			if (reg.getClass()==(Racer.class)) {
				reg_counter += 1;
			}
			if (reg.member == member) { // member already registered in race
				registered = true; 
			}
		}

		if (race.maxParticipants > reg_counter) {

			if (member.credit >= 10) {
				if(!registered) {
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
