import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character char1 = new Orc("Grumlin");
        Character char2 = new Elf("Therae");
        
        int prevRes = char1.resilience;
        System.out.println(char1.name + " has found some armour");
       StrongDecorator helmet =  new StrongDecorator(new Helmet());
        char1.strongSlot = helmet;
        char1.resilience += helmet.boost;
        System.out.println("Resilience for " + char1.name + " has increased from " + prevRes + " to " + char1.resilience);
        
        prevRes = char2.resilience;
        System.out.println(char2.name + " has found some armour");
       WeakDecorator bodyArmour =  new WeakDecorator(new BodyArmour());
        char2.weakSlot = bodyArmour;
        char2.resilience += bodyArmour.boost;
        
        System.out.println("Resilience for " + char2.name + " has increased from " + prevRes + " to " + char2.resilience);
        

        int damageDealt = char1.attackEnemy();
        System.out.println(char1.name + " has attacked an enemy " +
                "and dealt " + damageDealt + " damage");

        char1.hasCastSpellSkill = true;

        damageDealt = char1.attackEnemy();
        System.out.println(char1.name + " has attacked an enemy " +
                "and dealt " + damageDealt + " damage");

        int damageTaken = char2.takeHit();
        System.out.println(char2.name + " has taken a hit and " +
                "been dealt " + damageTaken + " damage");

        char2.hasDodgeAttackSkill = true;

        damageTaken = char2.takeHit();
        System.out.println(char2.name + " has taken a hit and " +
                "been dealt " + damageTaken + " damage");
    }
}
