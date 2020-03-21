import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static boolean quit = false;

	public static void main(String[] args) {
		List<Member> memberList = new ArrayList<>();
		MemberFactory factory = new MemberFactory();
		Member member;
		//Test cases//
		
		member = (factory.setMemberType("b"));
		member.create("bob", "password");
		memberList.add(member);
		
		member = (factory.setMemberType("i"));
		member.create("fred", "password");
		memberList.add(member);
		
		member = (factory.setMemberType("p"));
		member.create("sally", "password");
		memberList.add(member);
		
		member = (factory.setMemberType("b"));
		member.create("runner", "password");
		memberList.add(member);
		
		while(!quit) {
		System.out.println("Welcome to the account creation for the Race Runner Application.");
		System.out.println("Please enter a username");
		Scanner scan = new Scanner(System.in);
		String username = scan.next();
		System.out.println("Please enter your desired password");
		String password = scan.next();
		
		
		
		System.out.println("Please enter your skill level");
		System.out.println("Beginner = 'b', Intermediate = 'i', Professional = 'p");
		String input = scan.next();
		
		member = (factory.setMemberType(input));
		member.create(username, password);
		memberList.add(member);
		
		
		
		
		System.out.println("Beginner Member List: ");
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getSkill() == 'b') {
			System.out.println("Member: " + memberList.get(i).getUsername());
			}
		}
		
		System.out.println("Intermediate Member List: ");
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getSkill() == 'i') {
			System.out.println("Member: " + memberList.get(i).getUsername());
			}
		}
		
		System.out.println("Professional Member List: ");
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getSkill() == 'p') {
			System.out.println("Member: " + memberList.get(i).getUsername());
			}
		}
		
		System.out.println("Would you like to make another account? y? n?");
		if(scan.next().equalsIgnoreCase("n")) {
			quit = true;
		}
		
		}
	}

}
