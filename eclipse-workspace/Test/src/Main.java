import java.util.ArrayList;
import java.util.Random;
import java.text.DecimalFormat;

public class Main {
	
	public static ArrayList<Hero> heroes;
	public static ArrayList<Villain> villains;
	public static ArrayList<Skill> skills;
	public static ArrayList<Fight> matches;
	
	
	public static void main(String[] args) {
		heroes = new ArrayList<Hero>();
		villains = new ArrayList<Villain>();
		skills = new ArrayList<Skill>();
		matches = new ArrayList<Fight>();
		Random rand = new Random();
        DecimalFormat df = new DecimalFormat("#.##%");



//      SKILLS		
		skills.add(new Skill("ice"));
		skills.add(new Skill("fire"));
		skills.add(new Skill("electricity"));
		skills.add(new Skill("psychic"));
		skills.add(new Skill("rage"));
		
		
//      LAIRS
		Lair volcano = new Lair("volcano");
		Lair swamp = new Lair("swamp");
		Lair cave = new Lair("cave");
		Lair slum = new Lair("slum");
		
//      VILLAGES
		Village geilenkirchen = new Village("Geilenkirchen");
		Village manhattan = new Village("Manhattan");
		Village tokyo = new Village("Tokyo");
		Village tlaquepaque = new Village("Tlaquepaque");
		
		
//      HEROES
        heroes.add(new Hero("Alexandra Mehlhase", skills.get(rand.nextInt(skills.size()))));
        heroes.add(new Hero("Julie Hudson", skills.get(rand.nextInt(skills.size()))));
        heroes.add(new Hero("Jacob Labrec", skills.get(rand.nextInt(skills.size()))));
        heroes.add(new Hero("David Welborn", skills.get(rand.nextInt(skills.size()))));
        heroes.add(new Hero("Ryan Schumacher", skills.get(rand.nextInt(skills.size()))));
        
//      VILLAINS
        villains.add(new Villain("Sauron", skills.get(rand.nextInt(skills.size())), volcano));
        villains.add(new Villain("Barracuda", skills.get(rand.nextInt(skills.size())), swamp));
        villains.add(new Villain("Lord Voldermort", skills.get(rand.nextInt(skills.size())), cave));
        villains.add(new Villain("Lady Death", skills.get(rand.nextInt(skills.size())), volcano));
        villains.add(new Villain("Norman Bates", skills.get(rand.nextInt(skills.size())), slum));

        String format0 = "%-20s%-20s%-20s%-20s%-20s%n";
        String format = "%-20s%-20s%-20s%-20s%n";
        String format2 = "%-46s%-8s%-30s%n%s%n";
        String format3 = "%-35s%-11s%-30s%n%s%n";
        String format4 = "%-20s%-20s%n";
        String format5 = "%-44s%-11s%-30s%n%s%n";


        
        System.out.printf(format3,"===============================", "FIGHTS", "================================",
                "==============================================================================");
        Hero randomHero;
        Villain randomVillain;        
        
        for (int i = 0; i < rand.nextInt(100); i++) {
            randomHero = heroes.get(rand.nextInt(heroes.size()));
            randomVillain = villains.get(rand.nextInt(heroes.size()));
            matches.add(new Fight(randomHero, randomVillain));
            randomHero.addFight(matches.get(i));
            randomVillain.addFight(matches.get(i));
        }
        
        System.out.printf(format, "HEROES", "RESULT", "VILLAINS", "RESULT");
        
        for (int i = 0; i < matches.size(); i++) {
            System.out.printf(format, matches.get(i).results[0].getPerson().name, matches.get(i).results[0].getWin(),
                    matches.get(i).results[1].getPerson().name, matches.get(i).results[1].getWin());
        }
        
        System.out.printf(format2, "\n\n===========================================","HEROS", "===========================================",
                "===============================================================================================");
        for(int i = 0; i < heroes.size(); i++) {
            heroes.get(i).addSkill(skills.get(rand.nextInt(skills.size())));
            System.out.printf(format0, "Hero's Name:", "Skills:", "Number of Fights:", "Number of Wins:", "Rank");
            System.out.printf(format0, heroes.get(i).name, heroes.get(i).skills.get(0).name, heroes.get(i).getWins(),
                    heroes.get(i).getTotal(), df.format(heroes.get(i).getRank()));
            for (int j = 1; j < heroes.get(i).skills.size(); j++) {
                System.out.printf(format4, "", heroes.get(i).skills.get(j).name + "\n");
            }
        }
        
          System.out.printf(format5,"=========================================", "VILLAINS", "==========================================",
                  "=================================================================================================");
        
        for(int i = 0; i < villains.size(); i++) {
            villains.get(i).addSkill(skills.get(rand.nextInt(skills.size())));
            System.out.printf(format0, "Villain's Name:", "Skills:", "Number of Wins:", "Number of Fights:", "Rank");
            System.out.printf(format0, villains.get(i).name, villains.get(i).skills.get(0).name, villains.get(i).getWins(),
                    villains.get(i).getTotal(), df.format(villains.get(i).getRank()));
            for (int j = 1; j < villains.get(i).skills.size(); j++) {
                System.out.printf(format4, "", villains.get(i).skills.get(j).name + "\n");
            }
        }
                
		
	}

}
