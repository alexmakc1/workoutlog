
public class Score {
    private boolean win;
    private Character c;
    
    public Score(Character c, boolean w) {
        this.win = w;
        this.c = c;
    }
    
    public boolean getWin() {
        return win;
    }
    
    public Character getPerson() {
        return c;
    }

}
