import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
	
	
	

	public static void main(String[] args) {
		RaceOrganizationManagement rom = new RaceOrganizationManagement();
		RaceParticipationManagement rpm = new RaceParticipationManagement();
		// I do a bunch of prints throughout to easier check the system state. No error handling is done. 
		// It is all manually created and made sure that it is consistent to the DMC. 
		///STATIC PART

		// Create a bunch of members with different attribute values
		Member julie = new Member("Julie@julie.com", "1234", 12);
		rpm.members.add(julie);
		Member ryan = new Member("ryan@ryan.com", "2335", 14);
		rpm.members.add(ryan);
		Member david = new Member("david@david.com", "3456", 9);
		rpm.members.add(david);
		Member jacob = new Member("jacob@jacob.com", "4567", 2);
		rpm.members.add(jacob);

		//		print the member data
		System.out.println("Print members");
		for (Member member : RaceParticipationManagement.members) {
			System.out.println(member.email);
			System.out.println("    " + member.password);
			System.out.println("    " + member.credit);
		}


		// Create a bunch of races with different attribute values
		Calendar time = Calendar.getInstance();
		time.set(2020, 9, 5);
		Race r0 = (new Race("Spartan", 8, 3, new Date(time.getTimeInMillis()), Type.OBSTACLE, rom.getOrg()));
		rom.getRaces().add(r0);

		time.set(2019, 11, 5);
		Race r1 = new Race("ToughestMudder", 20, 3, new Date(time.getTimeInMillis()), Type.OBSTACLE, rom.getOrg());
		rom.getRaces().add(r1);

		time.set(2020, 11, 7);
		Race r2 = new Race("ToughMudder", 9, 1, new Date(time.getTimeInMillis()), Type.OBSTACLE, rom.getOrg());
		rom.getRaces().add(r2);

		time.set(2020, 1, 1);
		Race r3 = new Race("ElephantMountain", 12, 5, new Date(time.getTimeInMillis()), Type.TRAIL, rom.getOrg());
		rom.getRaces().add(r3);

		//		print the race dates and names
		System.out.println("\n======================");
		System.out.println("Print races");
		for (Race race : rom.getRaces()) {
			System.out.println(race.getName());
			System.out.println("    " + race.getDate());
			System.out.println("    " + race.distance);
			System.out.println("    " + race.raceType);
		}

		// Now we create some registrations, I will create Racers and Volunteers. Volunteers did not need to be created by students. 
		// I am making the association bi-directional, since I want to 
		// 1) look at a member and see all registration
		// 2) look at a race and find all registrations
		// 3) look at a registration and see who it is for
		// ALL this will later on of course happen in our method and not have to be done manually
		Racer reg1 = new Racer(1, r0, julie); //create registration with member and race
		r0.registration.add(reg1); // add registration to race
		julie.registration.add(reg1); // add registration to member

		Racer reg2 = new Racer(2, r0, ryan); //create registration with member and race
		r0.registration.add(reg2); // add registration to race
		ryan.registration.add(reg2); // add registration to member

		Volunteer reg3  = new Volunteer(3, r2, julie);
		reg3.startime = 1;
		reg3.endtime = 5;
		r2.registration.add(reg3); // add registration to race
		julie.registration.add(reg3); // add registration to member

		Racer reg4 = new Racer(4, r1, ryan);
		reg4.startime = 10; 
		reg4.endtime = 13;
		r1.registration.add(reg4); // add registration to race
		ryan.registration.add(reg4); // add registration to member

		Volunteer reg5  = new Volunteer(5, r2, david);
		reg5.startime = 3;
		reg5.endtime = 7;
		System.out.println(reg5.startime);
		r2.registration.add(reg5); // add registration to race
		david.registration.add(reg5); // add registration to member


		Racer reg6 = new Racer(6, r2, jacob);
		r2.registration.add(reg6); // add registration to race
		jacob.registration.add(reg6); // add registration to member

		Racer reg7 = new Racer(7, r3, jacob);
		r3.registration.add(reg7); // add registration to race
		jacob.registration.add(reg7); // add registration to member

		// create a teama and add members to it (make sure to only create them for where members already registered a race)
		Team t1 = new Team("CodeDevils",rom.getRaces().get(0), rpm.members.get(0));
		r0.getTeams().add(t1);
		//julie.teams.add(t1);
		//t1.members.add(ryan); // add a team member to team 
		rpm.join_team("ryan@ryan.com", r0.getDate(), "CodeDevils", rom); //adding member to team
		rpm.join_team("Julie@julie.com", r0.getDate(), "CodeDevils", rom); //adding member to team
		rpm.join_team("Julie@julie.com", r0.getDate(), "sfdsfsddf", rom); //test case, team does not exist
		//ryan.teams.add(t1); // add team to member

		// iterate through members print their registrations and teams
		System.out.println("\n======================");
		System.out.println("Print members and their races and teams");
		for (Member member : rpm.members) {
			System.out.println(member.email);
			if (member.teams.size() > 0) {
				System.out.println("Teams:");
				for (Team team: member.teams) {
					System.out.println("  " + team.name);
				}
			}

			if (member.registration.size() > 0) {
				System.out.println("Registrations:");
				for (Registration reg : member.registration) {
					System.out.println("    " + reg.getClass());
					System.out.println("        Starttime: " + reg.startime);	
				}
			}
		}

		//		print the race and their registrations
		System.out.println("\n======================");
		System.out.println("Print race registrations");
		for (Race race : rom.getRaces()) {
			System.out.println(race.getName());
			if (race.registration.size() > 0) {
				for (Registration reg : race.registration) {
					System.out.println("    " + reg.member.email);
					System.out.println("      " + reg.getClass());
				}
			}
		}

		System.out.println("\n======================");
		System.out.println("Left return value, right what was expected");
		System.out.println(rpm.register_for_race("david@david.com", r2.getDate()) + " == race_already_full"); // I am reusing the date directly from the race, so this is a bit of a cheat to not have to define it again
		System.out.println(rpm.register_for_race("jacob@jacob.com", r1.getDate()) + " == insufficient_credits"); // I am reusing the date directly from the race, so this is a bit of a cheat to not have to define it again
		System.out.println(rpm.register_for_race("ryan@ryan.com", r1.getDate()) + " == already_registered"); // I am reusing the date directly from the race, so this is a bit of a cheat to not have to define it again
		System.out.println(rpm.register_for_race("Julie@julie.com", r0.getDate()) + " == already_registered"); // I am reusing the date directly from the race, so this is a bit of a cheat to not have to define it again
		System.out.println(rpm.register_for_race("Julie@julie.com", r1.getDate()) + " == registration_successful"); // I am reusing the date directly from the race, so this is a bit of a cheat to not have to define it again

	}
	
	
}
