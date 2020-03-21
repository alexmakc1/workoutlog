
public class MemberFactory {
	
	public Member setMemberType(String input) {
		
		
		
		if(input.equalsIgnoreCase("b")) {
			return new BeginnerMember();
		}else if(input.equalsIgnoreCase("i")) {
			return new IntermediateMember();
		}else if(input.equalsIgnoreCase("p")) {
			return new ProfessionalMember();
		}else
		{
		
		return null;
		}
		
	}

}
