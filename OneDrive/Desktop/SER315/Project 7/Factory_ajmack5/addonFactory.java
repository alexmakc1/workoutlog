
public class addonFactory {

	public static AddOns getAddon(String addonType) {
		
		if(addonType.equalsIgnoreCase("fuzzydice")){
			return new FuzzyDice();
		}else if(addonType.equalsIgnoreCase("heatedseats")){
			return new HeatedSeats();
		}else if(addonType.equalsIgnoreCase("hydraulics")){
			return new Hydraulics();
		}else if(addonType.equalsIgnoreCase("spinnerrims")){
			return new SpinnerRims();
		}else if(addonType.equalsIgnoreCase("SunRoof")){
			return new SunRoof();
		}else if(addonType.equalsIgnoreCase("heatedseats")){
			return new HeatedSeats();
		
	}else {
		return null;
	}
		
	}
}
