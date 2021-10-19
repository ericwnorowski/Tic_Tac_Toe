/**
 * A class that implements Move object, initliazes a new Move, 
 * and passes through row and col
 *
 * @author Eric Wnorowski
 * @version HW2
 */
public class Move extends Object{
    /**
     * represents player's column input
     */
    int col;
    
    /**
     * represents player's row input
     */
    int row;
    
    /**
     * Constructor of Move objects
     * 
     * @param row - user/cpu generated row
     * @param col - user/cpu generated column
     */
    Move(int row, int col){
         this.row = row;
         this.col = col;
        }
}