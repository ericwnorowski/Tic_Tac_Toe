/**
 * Records Game statistcs, 
 * implements win, tie, and loss accumulation, and 
 * provides textual representation of statistics
 * 
 * @author Eric Wnorowski
 * @version HW2
 */
public class GameStats {
    int nwins;
    int nties;
    int nlosses;
    
    /**
     * Constructor for object GameStats
     * itializes all fields to zero
     * container for user's total statistics
     */
    public GameStats(){
        nwins = 0;
        nties = 0;
        nlosses = 0;
    }
    
    /**
     * Increments user's total number of wins by one
     */
    public void recordWin(){
        nwins++;
    }
    
    /**
     * Increments user's total number of ties by one
     */
    public void recordTie(){
        nties++;
    }
    
    /**
     * Increments user's total number of losses by one
     */
    public void recordLoss(){
        nlosses++;
    }
    
    /**
     * Provides a textual representation of user's number of wins, ties, and losses
     */
    public String toString(){
        String s = ("Number of Wins: " + nwins + "\n" + "Number of Ties: " + nties + "\n" + "Number of Losses: " + nlosses);
        return s;
    }
}