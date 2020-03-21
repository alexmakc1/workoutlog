import java.util.Random;

public class Fight {
    Score[] results = new Score[2];
    
    public Fight(Hero hero, Villain villain) {
        boolean[] fight = new boolean[2]; 
        fight = match();
        results[0] = new Score(hero, fight[0]);
        results[1] = new Score(villain, fight[1]);
    }
    
    private boolean[] match() {
        boolean[] result = new boolean[2];
        Random rand = new Random();
        boolean score = rand.nextBoolean();
        result[0] = score;
        result[1] = !score;
        return result;        
    }
    
    public boolean heroResult() {
        return results[0].getWin();
    }
    
    public boolean villainResult() {
        return results[1].getWin();
    }
    
    
     
}
